package com.hj;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Huijun Zhu
 * 2020/12/8
 */
public class Bullet {
    private final int speed = 10;
    private final Group group;
    private Dir dir;
    private int x, y;
    private TankFrame tf = null;
    private boolean live = true;
    public static final int WEIGHT = ResourceImageMgr.bulletUp.getWidth();
    public static final int HEIGHT = ResourceImageMgr.bulletUp.getHeight();
    private Rectangle rect;

    public Bullet(Dir dir, int x, int y, Group group, TankFrame tf) {
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.tf = tf;
        this.group = group;
        this.rect = new Rectangle(x,y,WEIGHT,HEIGHT);
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
        this.rect.x = this.x;
        this.rect.y = this.y;
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


    public void collideWith(Tank tank) {
        boolean dead = false;
        if (group != tank.getGroup()) {
            dead = this.rect.intersects(tank.getRect());
        }
        if (dead) {
            tank.die();
            this.die();
            int eX = tank.getX() + Tank.WEIGHT / 2 - Explosion.WEIGHT / 2;
            int eY = tank.getY() + Tank.HEIGHT / 2 - Explosion.HEIGHT / 2;
            tf.explosions.add(new Explosion(eX, eY, tf));
        }
    }

    private void die() {
        this.live = false;
    }
}
