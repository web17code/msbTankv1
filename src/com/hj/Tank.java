package com.hj;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author Huijun Zhu
 * 2020/12/7
 */
public class Tank {
    private int x = 200, y = 200;
    private Dir dir = Dir.DOWN;
    private int speed = 3;
    private boolean moving = false;
    private boolean live = true;
    private TankFrame tf;
    private Group group;
    private Random random = new Random();
    public static final int WEIGHT = ResourceImageMgr.tankUp.getWidth();
    public static final int HEIGHT = ResourceImageMgr.tankUp.getHeight();

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
    }

    void paint(Graphics g) {
        BufferedImage img = null;
        if (!this.live) {
            tf.badTanks.remove(this);
            return;
        }
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
        if (random.nextInt(100) > 95 && this.group != Group.GOOD) {
            this.fire();
        }

        if (random.nextInt(200) > 195 && this.group != Group.GOOD) {
            this.dir = Dir.values()[random.nextInt(4)];
        }
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
        int bY = this.y + HEIGHT / 2 - Bullet.HEIGHT / 2;
        int bX = this.x + WEIGHT / 2 - Bullet.WEIGHT / 2;
        tf.bullets.add(new Bullet(this.dir, bX, bY, this.group, this.tf));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Group getGroup() {
        return group;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void die() {
        this.live = false;
    }
}
