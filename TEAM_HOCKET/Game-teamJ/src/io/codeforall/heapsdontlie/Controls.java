package io.codeforall.heapsdontlie;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Controls implements KeyboardHandler {

    Player player;

    public Controls(Player pic) {
        this.player = pic;
        init();
    }

    private void init(){

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent pressedRight = new KeyboardEvent();
        pressedRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(pressedRight);


        KeyboardEvent pressedLeft = new KeyboardEvent();
        pressedLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(pressedLeft);

        KeyboardEvent releaseRight = new KeyboardEvent();
        releaseRight.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releaseRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(releaseRight);

        KeyboardEvent releaseLeft = new KeyboardEvent();
        releaseLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releaseLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(releaseLeft);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int key = keyboardEvent.getKey();

        switch (key){
            case KeyboardEvent.KEY_RIGHT:
                player.setMoveType(MoveType.RIGHT);
                break;
            case KeyboardEvent.KEY_LEFT:
                player.setMoveType(MoveType.LEFT);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        player.setMoveType(MoveType.STOP);
    }
}
