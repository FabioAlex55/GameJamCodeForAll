package io.codeforall.heapsdontlie;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Position {
//class responsible for moving the objects
    private final Picture picture;

    public Position(int x, int y, String filePath) {

        this.picture = new Picture(x,y,filePath);
        picture.draw();
    }

    public void moveUp(int speed) {

        picture.translate(0,-speed);
    }

    public void moveDown(int speed) {

        picture.translate(0,speed);
    }
    public void moveLeft(int speed) {

        picture.translate(-speed,0);
    }
    public void moveRight(int speed) {

        picture.translate(speed,0);
    }
    public void hideVisual () {
        picture.delete();
    }

    //x and y inherent of picture class
    public int getY() {
        return picture.getY();
    }

    public int getX() {
        return picture.getX();
    }

    public Picture getPicture() {
        return picture;
    }
}


