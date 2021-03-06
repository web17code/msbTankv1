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
    public static final int WEIGHT = ResourceImageMgr.goodTankUp.getWidth();
    public static final int HEIGHT = ResourceImageMgr.goodTankUp.getHeight();
    private Rectangle rect;

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
        this.rect = new Rectangle(x,y,WEIGHT,HEIGHT);
    }

    void paint(Graphics g) {
        BufferedImage img = null;
        if (!this.live) {
            tf.badTanks.remove(this);
            return;
        }
        switch (dir) {
            case DOWN:
                img = this.group==Group.GOOD?ResourceImageMgr.goodTankDown:ResourceImageMgr.badTankDown;
                break;
            case UP:
                img = this.group==Group.GOOD?ResourceImageMgr.goodTankUp:ResourceImageMgr.badTankUp;
                break;
            case LEFT:
                img = this.group==Group.GOOD?ResourceImageMgr.goodTankLeft:ResourceImageMgr.badTankLeft;
                break;
            case RIGHT:
                img = this.group==Group.GOOD?ResourceImageMgr.goodTankRight:ResourceImageMgr.badTankRight;
                break;
            default:
                img = ResourceImageMgr.goodTankUp;
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
        int padding = 2;
        if (dir == Dir.RIGHT) {
            x = x + speed > TankFrame.width - Tank.WEIGHT - padding ? x : x + speed;
        }
        if (dir == Dir.LEFT) {
            x = x - speed < padding ? x : (x - speed);
        }
        if (dir == Dir.UP) {
            y = y - speed < padding+10 ? y : (y - speed);
        }
        if (dir == Dir.DOWN) {
            y = y + speed > TankFrame.height - Tank.HEIGHT - padding ? y : y + speed;
        }
        this.rect.x = this.x;
        this.rect.y = this.y;
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

    public Rectangle getRect() {
        return this.rect;
    }
}
