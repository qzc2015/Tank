package com.qzc.test;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static org.junit.Assert.*;

/**
 * @author qzc
 * @create 2021-05-14 11:04
 */
public class ImageTest {

	@Test
	public void test(){
		try {
			BufferedImage image = ImageIO.read(new File("F:\\ruicheng\\idea\\workspace\\Tank\\src\\images\\0.gif"));
			assertNotNull(image);
			BufferedImage image2 = ImageIO.read(Objects.requireNonNull(ImageTest.class.getClassLoader().getResourceAsStream("images/1.gif")));
			assertNotNull(image2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
