package com.sxt.obj;

import javax.swing.*;
import java.awt.*;

public class ExplodeObj extends GameObj{
    static Image[] pic = new Image[16];
    int explodeCount = 0;
    static {
        for (int i = 0; i < pic.length; i++) {
            pic[i] = new ImageIcon("src/com/sxt/imgs/explode/e"+(i+1)+".gif").getImage();
        }

    }
    public ExplodeObj(int x, int y) {
        super(x, y);
    }

    @Override
    public void paintSelf(Graphics gImage) {
        if (explodeCount < 16){
            image =  pic[explodeCount] ;
            super.paintSelf(gImage);
            explodeCount++;
        }
    }
}
