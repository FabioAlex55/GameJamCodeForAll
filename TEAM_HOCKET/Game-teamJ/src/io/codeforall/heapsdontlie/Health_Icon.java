package io.codeforall.heapsdontlie;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Health_Icon {


    public static Picture picture1;

    public static Picture picture2;

    public static Picture picture3;

    public Health_Icon() {

        picture1 = new Picture(Background.picture.getMaxX()-200, 20,"/lives1.png");
        picture1.draw();

        picture2 = new Picture(Background.picture.getMaxX()-200,20,"/lives2.png");
        picture2.draw();

        picture3 = new Picture(Background.picture.getMaxX()-200,20,"/lives3.png");
        picture3.draw();
    }
}
