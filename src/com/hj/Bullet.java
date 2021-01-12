package com.hj;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Huijun Zhu
 * 2020/12/8
 */
public class Bullet {
    private final int speed = 10;

    private Dir dir;

    private int x, y;
    private TankFrame tf = null;
    private boolean live = true;
    public static final int WEIGHT = ResourceImageMgr.bulletUp.getWidth();
    public static final int HEIGHT = ResourceImageMgr.bulletUp.getHeight();


    public Bullet(Dir dir, int x, int y, TankFrame tf) {
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!this.live) {
            tf.bullets.remove(this);
            return;
        }
        if (dir == Dir.RIGHT) {
            x = x + speed;
        }
        if (dir == Dir.LEFT) {
            x = x - speed;
        }
        if (dir == Dir.UP) {
            y = y - speed;
        }
        if (dir == Dir.DOWN) {
            y = y + speed;
        }
        if (x < 0 || y < 0 || x > TankFrame.width || y > TankFrame.height) {
            this.live = false;
            tf.bullets.remove(this);
            return;
        }
        BufferedImage img = null;
        switch (dir) {
            case DOWN:
                img = ResourceImageMgr.bulletDown;
                break;
            case UP:
                img = ResourceImageMgr.bulletUp;
                break;
            case LEFT:
                img = ResourceImageMgr.bulletLeft;
                break;
            case RIGHT:
                img = ResourceImageMgr.bulletRight;
                break;
            default:
                img = ResourceImageMgr.bulletUp;
                break;
        }
        g.drawImage(img, x, y, null);
    }


    public void collideWith(Tank tank){
        Rectangle bulletRect = new Rectangle(x, y, WEIGHT, HEIGHT);
        Rectangle tankRect = new Rectangle(tank.getX(), tank.getY(), Tank.WEIGHT, Tank.HEIGHT);
        boolean dead = bulletRect.intersects(tankRect);
        if (dead){
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.live = false;
    }
}
