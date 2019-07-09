package com.java.games.role;

import java.awt.Image;

import com.java.games.role.game.GameFrame;



public class Bullet extends BaseRole{
	public static Image bulletimg;
public Bullet(int x,int y){
	super(x,y,50,30);
   this.img=bulletimg;
}
@Override
protected void move() {
	this.x+=15;
	for(int i=0;i<GameFrame.rolelist.size();i++){
		BaseRole b=GameFrame.rolelist.get(i);
		if(this.rect.intersects(b.rect)&&b instanceof EnemyRole){
			EnemyRole a=(EnemyRole) b;
			a.Hit(100);
			GameFrame.rolelist.remove(this);

		}
		
	}
	
}
}
