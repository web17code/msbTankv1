package com.hj;

import java.awt.*;

/**
 * @author Huijun Zhu
 * @date 2020/12/8
 */
public class Bullet {
    private final int speed = 10;

    private Dir dir;

    private int x, y;
    private int width = 5;
    private int height = 10;
    private TankFrame tf = null;
    private boolean live = true;


    public Bullet(Dir dir, int x, int y ,TankFrame tf) {
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g) {
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
        Color color = g.getColor();
        g.setColor(Color.ORANGE);
        g.fillOval(x, y, width, height);
        g.setColor(color);
    }


}
