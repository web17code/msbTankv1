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
    public static BufferedImage tankUp, tankDown, tankLeft, tankRight;
    public static BufferedImage bulletUp, bulletDown, bulletLeft, bulletRight;

    static {
        try {
            tankDown = ImageIO.read(ResourceImageMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            tankUp = ImageIO.read(ResourceImageMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankLeft = ImageIO.read(ResourceImageMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankRight = ImageIO.read(ResourceImageMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));

            bulletUp = ImageIO.read(ResourceImageMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletDown = ImageIO.read(ResourceImageMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            bulletLeft = ImageIO.read(ResourceImageMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletRight = ImageIO.read(ResourceImageMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}