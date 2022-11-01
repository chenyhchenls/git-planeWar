package com.sxt;

import com.sxt.obj.*;
import com.sxt.utils.GameUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.XMLFormatter;

public class GameWin extends JFrame {
    //    游戏状态 0未开始 1游戏中 2暂停 3通关失败 4通关成功
    public static int state = 0;
    public static int score = 0; //游戏得分
    public static int life = 20; //boss血量
    Image offScreenImage = null;
    int weight = 600;
    int height = 600;
    int count = 1; //重绘次数
    int bossCount = 1; //重绘次数
    //获取背景图的对象
    BgObj bgObj = new BgObj(GameUtils.bgImg, 0, -2000, 2);
    //获取飞机的对象
    public PlaneObj planeObj = new PlaneObj(GameUtils.myImg, 290, 550,
            20, 30, 0, this);
    public BossObj bossObj = null;

    void launch() {
        //是否可见
        this.setVisible(true);
        //窗口大小
        this.setSize(weight, height);
        //窗口位置
        this.setLocationRelativeTo(null);
        //窗口标题
        this.setTitle("飞机大战");
        GameUtils.gameObjList.add(bgObj);
        GameUtils.gameObjList.add(planeObj);
        //鼠标点击事件
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1 && state == 0) {
                    state = 1;
                    repaint();
                }
            }
        });
        //重复绘制
        while (true) {
            if (state == 1) {
                createObj();
            }
            repaint();
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (state == 3 || state == 4) {
                break;
            }
        }
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 32) {
                    switch (state) {
                        case 1:
                            state = 2;
                            break;
                        case 2:
                            state = 1;
                            break;
                        default:
                    }
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = createImage(weight, height);
        }
        Graphics gImage = offScreenImage.getGraphics();
        gImage.fillRect(0, 0, weight, height);
        if (state == 0) {
            gImage.drawImage(GameUtils.bgImg, 0, 0, null);
            gImage.drawImage(GameUtils.bossImg, 220, 120, null);
            gImage.drawImage(GameUtils.explodeImg, 270, 350, null);
//            gImage.setFont(new Font("仿宋", Font.BOLD, 40));
//            gImage.setColor(Color.yellow);
//            gImage.drawString("开始游戏", 220, 300);
            GameUtils.drawWord(gImage,  "开始游戏", Color.yellow, 40, 220, 300);
        }
        if (state == 1) {
            GameUtils.gameObjList.addAll(GameUtils.explodeObjs);
            for (int i = 0; i < GameUtils.gameObjList.size(); i++) {
                GameUtils.gameObjList.get(i).paintSelf(gImage);
            }
            GameUtils.gameObjList.removeAll(GameUtils.removeList);
            GameUtils.drawWord(gImage, "已击杀：" + score, Color.white, 20, 30, 100);
        }
        if (state == 3) {
            gImage.drawImage(GameUtils.explodeImg2, planeObj.getX() - 30, planeObj.getY() - 30, null);
            GameUtils.drawWord(gImage, "GAME OVER", Color.red, 50, 180, 300);
        }
        if (state == 4) {//通关
            gImage.drawImage(GameUtils.explodeImg2, bossObj.getX() , bossObj.getY() , null);
            GameUtils.drawWord(gImage, "游戏通关", Color.GREEN, 50, 180, 300);
        }
        g.drawImage(offScreenImage, 0, 0, weight, height, null);
        count++;
    }

    public void createObj() {
        if (count == 1 || count % 15 == 0) {
            //我方子弹
            GameUtils.shellObjList.add(new ShellObj(GameUtils.shellImg, planeObj.getX(), planeObj.getY() - 40,
                    14, 29, 5, this));
            GameUtils.gameObjList.add(GameUtils.shellObjList.get(GameUtils.shellObjList.size() - 1));
        }
        if (count == 1 || count % 15 == 0) {
            //敌方飞机
            GameUtils.enemyObjList.add(new EnemyObj(GameUtils.enemyObj, (int) (Math.random() * 12) * 50, 0,
                    49, 36, 5, this));
            GameUtils.gameObjList.add(GameUtils.enemyObjList.get(GameUtils.enemyObjList.size() - 1));
            bossCount++;
        }
        if (count % 15 == 0 && bossObj != null) {

            GameUtils.bulletObjList.add(new BulletObj(GameUtils.bulletImg, bossObj.x, bossObj.y,
                    14, 25, 4, this));
            GameUtils.gameObjList.add(GameUtils.bulletObjList.get(GameUtils.bulletObjList.size() - 1));
        }
        if (bossCount > 50 && bossObj == null) {
            bossObj = new BossObj(GameUtils.bossImg, 250, 35,
                    155, 100, 5, this);
            GameUtils.gameObjList.add(bossObj);
        }
    }

    public static void main(String[] args) {
        GameWin gameWin = new GameWin();
        gameWin.launch();
        System.out.println("修改了");

    }
}
