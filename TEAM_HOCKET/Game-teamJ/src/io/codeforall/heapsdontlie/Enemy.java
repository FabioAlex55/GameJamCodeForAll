package io.codeforall.heapsdontlie;

public class Enemy extends GameObject{


   public int maxHealth;
    private int currentHealth;

    public Enemy() {
        super(MoveType.DOWN,3, new Position((int)(Math.random() * (Background.picture.getMaxX()-150)),0,"/barrel.png"));
    }

    @Override
    public void move() {
        if (super.getPosition().getPicture().getMaxY()>=Background.picture.getMaxY()){
            setGarbage(true);
            Game.enemies.remove(this);

            getPosition().hideVisual();

            return;
        }

        getPosition().moveDown(getSpeed());
    }


}

