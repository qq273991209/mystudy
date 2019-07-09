package com.java.games.role.game;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class GameMap {
	// 获取背景图片
	public static Image mapimage = new ImageIcon("image/map.jpg").getImage();
	// 背景图片x值
	public static int mapX;

	public static void drawMyself(Graphics memorygraphics) {
		if (mapX <= -17000) {
			mapX = -17000;
		}
		mapX -= 5;
		memorygraphics.drawImage(mapimage, mapX, 0, null);
	}

}
