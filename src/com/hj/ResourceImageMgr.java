package com.hj;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

/**
 * @author Huijun Zhu
 * 2021/1/11
 */
public class ResourceImageMgr {
    public static BufferedImage goodTankUp, goodTankDown, goodTankLeft, goodTankRight;
    public static BufferedImage badTankUp, badTankDown, badTankLeft, badTankRight;
    public static BufferedImage bulletUp, bulletDown, bulletLeft, bulletRight;
    public static BufferedImage[] explosions = new BufferedImage[16];

    static {
        try {
            goodTankUp = ImageIO.read(ResourceImageMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            goodTankLeft = ImageUtil.rotateImage(goodTankUp, -90);
            goodTankRight= ImageUtil.rotateImage(goodTankUp, 90);
            goodTankDown = ImageUtil.rotateImage(goodTankUp, 180);
            badTankUp = ImageIO.read(ResourceImageMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            badTankLeft = ImageUtil.rotateImage(badTankUp, -90);
            badTankRight= ImageUtil.rotateImage(badTankUp, 90);
            badTankDown = ImageUtil.rotateImage(badTankUp, 180);
            bulletUp = ImageIO.read(ResourceImageMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletDown = ImageIO.read(ResourceImageMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            bulletLeft = ImageIO.read(ResourceImageMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletRight = ImageIO.read(ResourceImageMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            for (int i = 0; i < explosions.length; i++) {
                explosions[i] = ImageIO.read(
                        ResourceImageMgr.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
