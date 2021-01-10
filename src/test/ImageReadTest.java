package test;


import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Huijun Zhu
 * 2021/1/10
 */

public class ImageReadTest {
    @Test
    public void testImageIo() throws IOException {
        BufferedImage image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/BadTank1.png"));
        Assert.assertNotNull(image);
    }

}
