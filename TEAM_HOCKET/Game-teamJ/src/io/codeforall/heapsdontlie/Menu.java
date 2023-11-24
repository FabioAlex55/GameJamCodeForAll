package io.codeforall.heapsdontlie;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements KeyboardHandler {

    private boolean isMenu;
    private static Picture menu = new Picture(10, 10, "/startmenu.png");

    public Menu() throws InterruptedException {
        init();
    }

    public void init() throws InterruptedException {
        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent pressedSpace = new KeyboardEvent();
        pressedSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressedSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(pressedSpace);
        isMenu = true;
        menu.draw();
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
            case KeyboardEvent.KEY_SPACE:
                isMenu = false;
                menu.delete();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
