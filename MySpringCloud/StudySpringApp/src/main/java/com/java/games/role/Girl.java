package com.java.games.role;

import java.awt.Image;

import com.java.games.role.game.PressKey;
import com.java.games.role.util.ChangeImg;

public class Girl extends BaseRole {
	public static Image[] girlimage;
	/** 图片切换对象 */
	private ChangeImg a = new ChangeImg(3);

	public Girl() {
		super(100, 100, 70, 70);

	}

	@Override
	protected void move() {
		if (PressKey.isUp == true) {
			y -= 20;
		}
		if (PressKey.isDown == true) {
			y += 20;
		}
		if (PressKey.isLeft == true) {
			x -= 20;
		}
		if (PressKey.isRight == true) {
			x += 20;
		}
		this.img = a.change(girlimage);

	}

}