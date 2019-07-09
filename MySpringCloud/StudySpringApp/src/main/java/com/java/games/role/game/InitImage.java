package com.java.games.role.game;

import java.awt.MediaTracker;
import javax.swing.JFrame;

import com.java.games.role.Boom;
import com.java.games.role.Boss;
import com.java.games.role.Bullet;
import com.java.games.role.Girl;
import com.java.games.role.LightEnemy;
import com.java.games.role.RedEnemy;
import com.java.games.role.util.CutImage;


public class InitImage {
	public InitImage(JFrame jf) {
		MediaTracker tracker = new MediaTracker(jf);
		tracker.addImage(GameMap.mapimage, 1);
		// 切割背景图片
		Boss.bossimg = CutImage.cutOneImage("image/boss/playSpear.png", 18, tracker, 1);
		// 切割女孩主角图片
		Girl.girlimage = CutImage.cutOneImage("image/girl/forward.png", 4, tracker, 1);
		//子弹图片初始化
		Bullet.bulletimg=CutImage.getSingleImage("image/jbullet/dart.png",  tracker, 1);
		//红怪图片初始化
		RedEnemy.redenemy=CutImage.cutOneImage("image/enemy/redEnemy.png", 3, tracker,1);
		//灯怪图片初始化
		LightEnemy.lightenemy=CutImage.cutOneImage("image/enemy/lightEnemy.png", 2, tracker, 1);
		//爆炸图片初始化
		Boom.boomimg=CutImage.cutOneImage("image/bomb/detonate.png", 5, tracker, 1);
		try {
			tracker.waitForID(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}