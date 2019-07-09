package com.java.games.role;

import java.awt.Image;

import com.java.games.role.util.ChangeImg;

public class RedEnemy extends EnemyRole{
public static Image[] redenemy;
private ChangeImg a=new ChangeImg(3);

	public RedEnemy() 
	{
   super((int)(Math.random()*200+1000),(int)(Math.random()*400+100), 100,100,100,200);
		
	}
  public void move(){
	  this.img=a.change(redenemy);
	  this.x-=5;
  }
}
