package com.sxt.utils;

import com.sxt.GameWin;
import com.sxt.obj.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameUtils {
    //背景图片
//    public static Image bgImg = Toolkit.getDefaultToolkit().getImage("src/com/sxt/imgs/bg.jpg");
    public static Image bgImg = new ImageIcon("src/com/sxt/imgs/bg.jpg").getImage();
    //爆炸图片
    public static Image explodeImg = new ImageIcon("src/com/sxt/imgs/explode/e6.gif").getImage();
    public static Image explodeImg2 = new ImageIcon("src/com/sxt/imgs/explode/e9.gif").getImage();
    //boss图片
    public static Image bossImg = new ImageIcon("src/com/sxt/imgs/boss.png").getImage();
    //我方战斗机图片
    public static Image myImg = new ImageIcon("src/com/sxt/imgs/plane.png").getImage();
    //我方子弹图片
    public static Image shellImg = new ImageIcon("src/com/sxt/imgs/shell.png").getImage();
    //我方子弹集合
    public static List<ShellObj> shellObjList = new ArrayList<>();
    //物体集合
    public static List<GameObj> gameObjList = new ArrayList<>();
    //敌机集合
    public static List<EnemyObj> enemyObjList = new ArrayList<>();
    //敌方飞机图片
    public static Image enemyObj = new ImageIcon("src/com/sxt/imgs/enemy.png").getImage();
    //删除的集合
    public static List<GameObj> removeList = new ArrayList<>();
    //敌方子弹
    public static Image bulletImg = new ImageIcon("src/com/sxt/imgs/bullet.png").getImage();
    public static List<BulletObj> bulletObjList = new ArrayList<>();

    //绘制文字
    public static void drawWord(Graphics graphics, String str, Color color, Integer size, Integer x, Integer y) {
        graphics.setColor(color);
        graphics.setFont(new Font("仿宋", Font.BOLD, size));
        graphics.drawString(str, x, y);
    }
    //爆炸效果图
    public static List<ExplodeObj> explodeObjs = new ArrayList<>();
}
