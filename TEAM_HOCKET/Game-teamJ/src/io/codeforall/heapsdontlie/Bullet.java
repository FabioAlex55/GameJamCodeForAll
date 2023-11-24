package io.codeforall.heapsdontlie;

public class Bullet extends GameObject{

    public Bullet(Player player) {
        super(MoveType.UP,4,new Position(player.getX() + 15,player.getY()-7,"/bullet.png"));
    }
}
