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
	public static BufferedImage goodTankL,goodTankD,goodTankR,goodTankU;
	public static BufferedImage badTankL,badTankD,badTankR,badTankU;
	public static BufferedImage bulletL,bulletR,bulletU,bulletD;
	public static BufferedImage[] explodes=new BufferedImage[16];
	static {
		try {
			goodTankU= ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png")));
			goodTankL= ImageUtil.rotateImage(goodTankU,-90);
			goodTankD= ImageUtil.rotateImage(goodTankU,180);
			goodTankR= ImageUtil.rotateImage(goodTankU,90);

			badTankU= ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png")));
			badTankL= ImageUtil.rotateImage(badTankU,-90);
			badTankD= ImageUtil.rotateImage(badTankU,180);
			badTankR= ImageUtil.rotateImage(badTankU,90);

			bulletU= ImageIO.read(Objects.requireNonNull(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png")));
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
