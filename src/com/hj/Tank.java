package com.hj;

import sun.security.util.ResourcesMgr;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Huijun Zhu
 * @date 2020/12/7
 */
public class Tank {
    private int width = 50;
    private int height = 50;
    private int x = 200, y = 200;
    private Dir dir = Dir.DOWN;
    private final int speed = 10;
    private boolean moving = false;
    private TankFrame tf;

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    void paint(Graphics g) {
        BufferedImage img = null;
        switch (dir) {
            case DOWN:
                img = ResourceImageMgr.tankDown;
                break;
            case UP:
                img = ResourceImageMgr.tankUp;
                break;
            case LEFT:
                img = ResourceImageMgr.tankLeft;
                break;
            case RIGHT:
                img = ResourceImageMgr.tankRight;
                break;
            default:
                img = ResourceImageMgr.tankUp;
                break;
        }
        g.drawImage(img, x, y, null);
        move(dir);
    }

    private void move(Dir dir) {
        if (!moving) {
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
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void fire() {
        tf.bullets.add(new Bullet(this.dir, this.x, this.y, this.tf));
    }
}
