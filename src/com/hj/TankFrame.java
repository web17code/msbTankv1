package com.hj;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author Huijun Zhu
 * @date 2020/12/5
 */
public class TankFrame extends Frame {

    private final MyKeyAdapter myKeyAdapter = new MyKeyAdapter();
    private Tank t1 = new Tank();
    private int width = 800;
    private int height = 600;

    public TankFrame() throws HeadlessException {
        setSize(width, height);
        setResizable(false);
        setTitle("tank-v1.0");
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        addKeyListener(myKeyAdapter);
    }

    Image offScreenImage = null;

    /**
     * 防闪烁:将东西统统画到内存中的图片上，然后一次性把图片画出来;对屏幕而言，只画了一次；将所有绘画都往内存中画
     *
     * @param g
     */
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(width, height);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, width, height);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        t1.paint(g);
    }

    private class MyKeyAdapter implements KeyListener {
        boolean dUp = false;
        boolean dDown = false;
        boolean dLeft = false;
        boolean dRight = false;

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_DOWN:
                    dDown = true;
                    break;
                case KeyEvent.VK_UP:
                    dUp = true;
                    break;
                case KeyEvent.VK_LEFT:
                    dLeft = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    dRight = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    t1.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_DOWN:
                    dDown = false;
                    break;
                case KeyEvent.VK_UP:
                    dUp = false;
                    break;
                case KeyEvent.VK_LEFT:
                    dLeft = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    dRight = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!dUp && !dDown && !dLeft && !dRight) {
                t1.setMoving(false);
            } else {
                t1.setMoving(true);
            }
            if (dDown) t1.setDir(Dir.DOWN);
            if (dUp) t1.setDir(Dir.UP);
            if (dLeft) t1.setDir(Dir.LEFT);
            if (dRight) t1.setDir(Dir.RIGHT);
        }

    }
}
