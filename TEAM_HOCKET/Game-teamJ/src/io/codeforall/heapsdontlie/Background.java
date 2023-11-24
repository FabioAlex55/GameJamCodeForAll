package io.codeforall.heapsdontlie;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

public static Picture picture = new Picture(10,10,"/background2.jpg");

    public Background () {

        picture.draw();
    }



    public static int getWidth () {

        return picture.getWidth();

    }

    public static int getHeight () {

        return picture.getHeight();
    }
}
