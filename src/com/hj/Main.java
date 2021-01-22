package com.hj;

/**
 * @author Huijun Zhu
 * 2020/12/5
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->new Audio("audio/war1.wav").loop()).start();
        TankFrame tankFrame = new TankFrame();
        while (true){
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
