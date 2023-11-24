package io.codeforall.heapsdontlie;

import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class CollisionDetector {
    private static int hitCounter = 0;

    public static void checkCollision(ArrayList<Bullet> bullets, ArrayList<Enemy> enemies) {

        for (Bullet bullet : bullets) {


            for (Enemy enemy : enemies) {

                int bulletMidX = bullet.getX() + bullet.getPosition().getPicture().getWidth() / 2;

                if (enemy.getPosition().getPicture().getMaxY() >= bullet.getPosition().getPicture().getY() && (enemy.getPosition().getPicture().getX() <= bulletMidX && bulletMidX <= enemy.getPosition().getPicture().getMaxX())) {
                    hitCounter++;
                    bullet.getPosition().getPicture().delete();
                    bullets.remove(bullet);


                    if (hitCounter % 2 == 0) {



                        bullets.remove(bullet);
                        bullet.getPosition().getPicture().delete();
                        Game.scoreGrow();
                        Picture explosion = new Picture(enemy.getPosition().getX(), enemy.getPosition().getY(), "beerexplosion.png") ;
                        explosion.draw();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        explosion.delete();
                        enemy.getPosition().getPicture().delete();
                        enemies.remove(enemy);
                    }
                }
            }
        }

    }

    public static void checkCollision(Player player, ArrayList<Enemy> enemies) throws InterruptedException {

        for (Enemy enemy : enemies) {
            int playerMidX = player.getX() + player.getPosition().getPicture().getWidth() / 2;

            if (enemy.getPosition().getPicture().getMaxY() >= player.getY() && (enemy.getPosition().getPicture().getX() <= playerMidX && playerMidX <= enemy.getPosition().getPicture().getMaxX())) {
                enemy.getPosition().getPicture().delete();
                enemies.remove(enemy);
                //TODO Explosion
                Picture explosion = new Picture(enemy.getPosition().getX(), enemy.getPosition().getY(), "beerexplosion.png") ;
                explosion.draw();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                explosion.delete();
                //TODO deixa de perder vidas quando a lata toca no jogador
                //*player.setLives(player.getLives() - 1);

            }

            if (enemy.getPosition().getPicture().getMaxY() >= Background.picture.getMaxY()) {

                player.setLives(player.getLives() - 1);

            }
            if (player.getLives() == 2) {

                Health_Icon.picture3.delete();
            }
            if (player.getLives() == 1) {

                Health_Icon.picture2.delete();
            }

            System.out.println(player.getLives());
            //TODO FAZER NASCER UM G A M E  O V E R
            if (player.getLives() <= 0) {
                player.setDead();
                player.getPosition().getPicture().delete(); //Isto provavelmente vai sair
            }
        }

    }


    public static void enemiesCollector(ArrayList<Enemy> enemies) {

        //TODO LOGICA TODA DE CHECK COLLISION PEOPLE


    }

    public static void bulletCollector(ArrayList<Bullet> bullets) {

        //TODO LOGICA TODA DE CHECK COLLISION PEOPLE
    }
}