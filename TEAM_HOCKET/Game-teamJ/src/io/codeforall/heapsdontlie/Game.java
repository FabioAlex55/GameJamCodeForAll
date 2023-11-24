package io.codeforall.heapsdontlie;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.ArrayList;
import java.io.File;
import javax.sound.sampled.*;
import java.io.IOException;
public class Game {

    private Player player;
    public static ArrayList<Bullet> bullets;
    public static ArrayList<Enemy> enemies;
    public  static Health_Icon health;
    public static int score;
    public static Text scoreVisual;
    public boolean isGameRunning;



    File soundFile;
    AudioInputStream audioStream;

    Clip audioClip;
    public Game() {

    }

    public static void main(String[] args) throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {

        Game game = new Game();
        game.init();

        scoreInit();
        game.start();
    }


    public static void scoreInit() {
        score = 0;
        scoreVisual = new Text(100,40,"Score: " + score);
        scoreVisual.grow(40,30);
        scoreVisual.setColor(Color.BLACK);
        scoreVisual.draw();
    }

    public static void scoreGrow() {
        score = score +10;
        scoreVisual.setText("Score: " + score);
    }
    private void init() throws InterruptedException, UnsupportedAudioFileException, IOException, LineUnavailableException {
        new Menu();
        isGameRunning = true;
        new Background();
        player = new Player();
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();
        health = new Health_Icon();
    }


    private void start() throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {

        GameMusicPlayer gameMusicPlayer = new GameMusicPlayer("/Sounds/Pizza2.wav");
        gameMusicPlayer.play();
        int counter = 0;

        while (isGameRunning) {
            try {

                Thread.sleep(9);
                counter++;

                if (counter % 65 == 0) {
                    enemies.add(new Enemy());
                }
                if (counter % 30 == 0) {
                    bullets.add(new Bullet(player));
                }

                for (Enemy enemy : enemies) {
                    enemy.move();
                }
                for (Bullet bullet : bullets) {
                    bullet.move();

                }
                CollisionDetector.checkCollision(bullets, enemies);

                player.move();
                CollisionDetector.checkCollision(player, enemies);

                CollisionDetector.enemiesCollector(enemies);

                CollisionDetector.bulletCollector(bullets);
                if (player.getLives() == 0){
                    isGameRunning = false;
                }

            } catch ( Exception e) {
                System.out.println(e);
            }
        }
        gameMusicPlayer.stop();
        ExitMenu exitMenu = new ExitMenu(score);


        for (Enemy enemy : enemies) {
            enemy.getPosition().getPicture().delete();
        }

        for (Bullet bullet : bullets) {
            bullet.getPosition().getPicture().delete();
        }

        exitMenu.scoreVisual1.delete();
        enemies.clear();

        bullets.clear();
        score = 0;
        scoreVisual.setText("Score: " + score);
        init();
        start();

    }

}
