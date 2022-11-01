package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;

import static com.sxt.GameWin.life;

public class BossObj extends GameObj {
    public BossObj(Image image, int x, int y, int width, int height, double speed, GameWin gameWin) {
        super(image, x, y, width, height, speed, gameWin);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        if (x < -50 || x > 550) {
            speed = -speed;
        }
        x -= speed;
        for (ShellObj shellObj :
                GameUtils.shellObjList) {
            if (this.getRec().intersects(shellObj.getRec())) {
                shellObj.setY(-100);
                shellObj.setX(-100);
                GameUtils.removeList.add(shellObj);
                life--;
            }
            if (life <= 0) {
                GameWin.state = 4;
            }
        }
//血条白色背景
        gImage.setColor(Color.white);
        gImage.fillRect(20,40,100,10);
        //血条
        gImage.setColor(Color.red);
        gImage.fillRect(20,40,life*5,10);
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
