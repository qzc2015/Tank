package com.qzc;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

/**
 * @author qzc
 * @create 2021-05-14 11:41
 */
public class ResourceMgr {
	public static BufferedImage tankL,tankD,tankR,tankU;
	static {
		try {
			tankL= ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif")));
			tankD= ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif")));
			tankR= ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif")));
			tankU= ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif")));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
