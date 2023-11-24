package io.codeforall.heapsdontlie;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ExitMenu implements KeyboardHandler {

    private boolean isMenu;
    private static Picture menu = new Picture(10, 10, "/endmenu.png");
    private int score;

    public int getScore() {
        return score;
    }

    public Text scoreVisual1;


    public ExitMenu(int score) throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        exitSong();
        init(score);
        //     finalScore(score);


        //   this.score = score;

    }

    public void init(int score) throws InterruptedException {
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent pressedR = new KeyboardEvent();
        pressedR.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedR.setKey(KeyboardEvent.KEY_R);
        keyboard.addEventListener(pressedR);

        KeyboardEvent pressedEscape = new KeyboardEvent();
        pressedEscape.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedEscape.setKey(KeyboardEvent.KEY_ESC);
        keyboard.addEventListener(pressedEscape);

        isMenu = true;
        menu.draw();
        scoreVisual1 = new Text(320,365, " " + score + " " );
        scoreVisual1.grow(40,30);
        scoreVisual1.setColor(Color.WHITE);
        scoreVisual1.draw();
        //finalScore();
        while(isMenu){
            Thread.sleep(10);
        }
    }

    public static int getMenuWidth() {
        return menu.getWidth();
    }

    public static int getMenuHeight() {

        return getMenuHeight();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        int key = keyboardEvent.getKey();

        switch (key) {
            case KeyboardEvent.KEY_R:
                isMenu = false;
                menu.delete();
                break;
            case KeyboardEvent.KEY_ESC:
                System.exit(0);
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void exitSong() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        GameMusicPlayer gameMusicPlayer = new GameMusicPlayer("/Sounds/PizzaEnd.wav");

        gameMusicPlayer.play();

    }



   /* public void finalScore (int score) {

        Text scoreVisual1 = new Text(300,330,"Score: " + score);
        scoreVisual1.grow(40,30);
        scoreVisual1.setColor(Color.WHITE);
        scoreVisual1.draw();

    }*/


}