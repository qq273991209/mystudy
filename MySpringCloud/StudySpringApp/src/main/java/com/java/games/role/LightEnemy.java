package com.java.games.role;

import java.awt.Image;

import com.java.games.role.util.ChangeImg;

public class LightEnemy extends EnemyRole{
private ChangeImg a=new ChangeImg(3);
 public static Image[] lightenemy;
public LightEnemy() {
		super((int)(Math.random()*1001),700, 100, 100,100,200);
		
	}
  @Override
	protected void move() {
		this.img=a.change(lightenemy);
		this.y-=5;
		
	}

}
