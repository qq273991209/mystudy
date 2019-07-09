package com.java.games.role.util;

import com.java.games.role.LightEnemy;
import com.java.games.role.RedEnemy;
import com.java.games.role.game.GameFrame;

public class CreatEnemy {
	/** 产生红怪的计数器 */
	private static int redcount;
	/** 产生灯怪的计数器 */
	private static int lightcount;
    /** 产生红怪的方法 */
	public static void creatEnemy(){
		CreatRedEnemy();
		CreatLightEnemy();
	}
	public static void CreatRedEnemy() {
		redcount++;
		if (redcount > 80) {
			redcount=0;
			GameFrame.rolelist.add(new RedEnemy());
			
		}
	}
	
    /** 产生灯怪的方法 */
	public static void CreatLightEnemy() {
		lightcount++;
		if (lightcount > 80) {
			lightcount=0;
			GameFrame.rolelist.add(new LightEnemy());
			
		}
	}
}
