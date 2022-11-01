package com.sxt.obj;

import java.awt.*;

/**
 * 背景的移动。飞机向上，背景向下
 */
public class BgObj extends GameObj{
    public BgObj(){
        super();
    }
    public BgObj(Image image, int x, int y, double speed) {
        super(image, x, y, speed);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        y += speed;
        if (y >= 0){
            y = -2000;
        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
