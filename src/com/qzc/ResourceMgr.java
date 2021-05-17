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
	public static BufferedImage bulletL,bulletR,bulletU,bulletD;
	public static BufferedImage[] explodes=new BufferedImage[16];
	static {
		try {
			tankU= ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png")));
			tankL= ImageUtil.rotateImage(tankU,-90);
			tankD= ImageUtil.rotateImage(tankU,180);
			tankR= ImageUtil.rotateImage(tankU,90);

			bulletU= ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif")));
			bulletL= ImageUtil.rotateImage(bulletU,-90);
			bulletR= ImageUtil.rotateImage(bulletU,90);
			bulletD= ImageUtil.rotateImage(bulletU,180);
			for (int i = 0; i < explodes.length; i++) {
				explodes[i]=ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
