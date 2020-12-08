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

    public TankFrame() throws HeadlessException {
        setSize(800, 600);
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

        private void  setMainTankDir(){
            if (!dUp && !dDown && !dLeft && !dRight) {
                t1.setMoving(false);
            } else{
                t1.setMoving(true);
            }
            if (dDown) t1.setDir(Dir.DOWN);
            if (dUp) t1.setDir(Dir.UP);
            if (dLeft) t1.setDir(Dir.LEFT);
            if (dRight) t1.setDir(Dir.RIGHT);
        }

    }
}
