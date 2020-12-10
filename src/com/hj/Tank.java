package com.hj;

import java.awt.*;

/**
 * @author Huijun Zhu
 * @date 2020/12/7
 */
public class Tank {
    private int width = 50;
    private int height = 50;
    private int x=200, y = 200;
    private Dir dir = Dir.DOWN;
    private final int speed = 10;
    private boolean moving = false;
    private Bullet b = new Bullet(Dir.UP,300,300);


    void paint(Graphics g){
        calculateXy(dir);
        Color color = g.getColor();
        g.setColor(Color.CYAN);
        g.drawRect(x,y,width, height);
        g.setColor(color);
        b.paint(g);
    }

    private void calculateXy(Dir dir){
        if (!moving){
            return;
        }
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
        System.out.println("x: "+x);
        System.out.println(x+","+y);
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
        b = new Bullet(this.dir, this.x, this.y);
    }
}
