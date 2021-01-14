package com.hj;

import javax.annotation.Resource;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author Huijun Zhu
 * 2020/12/8
 */
public class Explosion {
    private int x, y;
    private TankFrame tf = null;
    public static final int WEIGHT = ResourceImageMgr.explosions[0].getWidth();
    public static final int HEIGHT = ResourceImageMgr.explosions[0].getHeight();
    private int step = 0;

    public Explosion(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (step < ResourceImageMgr.explosions.length) {
            g.drawImage(ResourceImageMgr.explosions[step], x, y, null);
            step++;
            return;
        }
        tf.explosions.remove(this);
    }
}
