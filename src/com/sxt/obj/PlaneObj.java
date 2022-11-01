package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EnumMap;

public class PlaneObj extends GameObj {
    public PlaneObj() {
        super();
    }

    public PlaneObj(Image image, int x, int y, int width, int height, double speed, GameWin gameWin) {
        super(image, x, y, width, height, speed, gameWin);
        this.gameWin.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                PlaneObj.super.x = e.getX() - 11;
                PlaneObj.super.y = e.getY() - 16;
            }
        });
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        for (BulletObj bullet:GameUtils.bulletObjList
             ) {
            if (this.gameWin.bossObj != null && this.getRec().intersects(bullet.getRec()) ||
                    this.getRec().intersects(this.gameWin.bossObj.getRec())){
                GameWin.state = 3;
            }

        }
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
