package io.codeforall.heapsdontlie;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameObject {

    MoveType moveType;

    private int speed;

    private boolean isGarbage;
    private Position position;

    public GameObject(MoveType moveType, int speed, Position movePosition) {
        this.moveType = moveType;

        this.position = movePosition;
        this.speed = speed;
    }


    public void move() {

        switch(moveType) {

            case UP:
                if (getY() <= 0) {

                    isGarbage = true;
                    Game.bullets.remove(this);
                    position.hideVisual();

                    return;
                }
                    position.moveUp(speed);
                    break;

                    case DOWN:

                        if (position.getPicture().getMaxY()>=Background.picture.getMaxY()){
                            isGarbage = true;
                            Game.enemies.remove(this);

                            position.hideVisual();

                            return;
                        }

                position.moveDown(speed);
                break;

            case LEFT:
                if (position.getX()- 5 >= 10) {


                    position.moveLeft(speed);
                }
                break;

            case RIGHT:

                if (position.getX() + position.getPicture().getWidth()+10 <= Background.picture.getMaxX()) {
                    position.moveRight(speed);
                }

                break;

            case STOP:

                break;

        }


    }

    public void setMoveType(MoveType moveType) {
        this.moveType = moveType;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public int getX() {
return position.getX();
    }

    public int getY() {

        return position.getY();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setGarbage(boolean garbage) {
        isGarbage = garbage;
    }
}
