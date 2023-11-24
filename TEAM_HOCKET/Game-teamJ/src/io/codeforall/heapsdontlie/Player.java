package io.codeforall.heapsdontlie;

public class Player extends GameObject {


    private Controls controls;

    private int lives = 3;

    private boolean isDead;

    public Player() {
        super(MoveType.STOP,8,new Position(Background.getWidth()/2,Background.getHeight()-81,"/gajinho.png"));
        controls = new Controls(this);

    }

    public int getLives() {

        return lives;
    }

    public void setDead() {

           isDead = true;


    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public boolean isDead() {
        return isDead;
    }
}
