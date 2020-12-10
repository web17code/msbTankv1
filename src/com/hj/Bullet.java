package com.hj;

import java.awt.*;

/**
 * @author Huijun Zhu
 * @date 2020/12/8
 */
public class Bullet {
    private final int speed = 10;

    private Dir dir;

    private int x,y;
    private int width  = 5;
    private int height = 10;


    public Bullet(Dir dir, int x, int y) {
        this.dir = dir;
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g){
        if (dir==Dir.RIGHT) {
            x = x + speed;
        }
        if (dir==Dir.LEFT) {
            x = x - speed;
        }
        if (dir==Dir.UP) {
            y = y - speed;
        }
        if (dir==Dir.DOWN) {
            y = y + speed;
        }
        Color color = g.getColor();
        g.setColor(Color.ORANGE);
        g.fillOval(x,y,width,height);
        g.setColor(color);
    }


}
