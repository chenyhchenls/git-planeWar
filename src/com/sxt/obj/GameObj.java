package com.sxt.obj;

import com.sxt.GameWin;

import java.awt.*;
import java.awt.event.HierarchyBoundsAdapter;

public class GameObj {
    public Image image;
    public int x;
    public int y;
    public int width;
    public int height;
    public double speed; //移动速度
    public GameWin gameWin;

    public GameObj() {
    }

    public GameObj(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public GameObj(Image image, int x, int y, double speed) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public GameObj(Image image, int x, int y, int width, int height, double speed, GameWin gameWin) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.gameWin = gameWin;
    }


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public GameWin getGameWin() {
        return gameWin;
    }

    public void setGameWin(GameWin gameWin) {
        this.gameWin = gameWin;
    }

    //  描绘自身
    public void paintSelf(Graphics gImage) {
        gImage.drawImage(image, x, y, null);
    }

    //获取自身矩形的方法，检测碰撞
    public Rectangle getRec() {
        return new Rectangle(x, y, width, height);
    }
}
