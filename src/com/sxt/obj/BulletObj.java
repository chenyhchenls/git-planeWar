package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class BulletObj extends GameObj{
    public BulletObj(Image image, int x, int y, double speed) {
        super(image, x, y, speed);
    }

    public BulletObj(Image image, int x, int y, int width, int height, double speed, GameWin gameWin) {
        super(image, x, y, width, height, speed, gameWin);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        if (y >600 ){
            this.setY(-300);
            this.setX(-300);
            GameUtils.removeList.add(this);
        }
        y +=speed;
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
