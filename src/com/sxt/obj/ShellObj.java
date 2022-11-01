package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class ShellObj extends GameObj {
    public ShellObj() {
        super();
    }

    public ShellObj(Image image, int x, int y, int width, int height, double speed, GameWin gameWin) {
        super(image, x, y, width, height, speed, gameWin);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        if (y < 0) {
            this.setX(-100);
            this.setY(-100);
            GameUtils.removeList.add(this);
        }
        y -= speed;
    }
}
