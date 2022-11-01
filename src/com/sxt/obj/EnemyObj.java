package com.sxt.obj;

import com.sxt.GameWin;
import com.sxt.utils.GameUtils;

import java.awt.*;

public class EnemyObj extends GameObj {
    public EnemyObj() {
        super();
    }

    public EnemyObj(Image image, int x, int y, int width, int height, double speed, GameWin gameWin) {
        super(image, x, y, width, height, speed, gameWin);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        super.paintSelf(gImage);
        if (this.getRec().intersects(gameWin.planeObj.getRec())) {
            GameWin.state = 3;
        }
        if (y > 600) {
            this.setY(-200);
            this.setX(-200);
            GameUtils.removeList.add(this);
        }
        for (ShellObj shellObj : GameUtils.shellObjList
        ) {
            if (this.getRec().intersects(shellObj.getRec())) {
                ExplodeObj explodeObj = new ExplodeObj(x, y);
                GameUtils.explodeObjs.add(explodeObj);
                GameUtils.removeList.add(explodeObj);
                shellObj.setX(-100);
                shellObj.setY(-100);
                this.setX(-200);
                this.setY(-200);
                GameUtils.removeList.add(shellObj);
                GameUtils.removeList.add(this);
                GameWin.score++;
            }

        }
        y += speed;
    }

    @Override
    public Rectangle getRec() {
        return super.getRec();
    }
}
