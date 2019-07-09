package com.java.games.role;

import com.java.games.role.game.GameFrame;

public abstract class EnemyRole extends BaseRole{
private int exp;
private int hp;
	public EnemyRole(int x, int y, int width, int height,int exp,int hp) {
		super(x, y, width, height);
		this.exp=exp;
		this.hp=hp;
	}
public void Hit(int a){
	this.hp-=a;
	if(this.hp<0){
		GameFrame.point+=this.exp;
		GameFrame.rolelist.remove(this);
		GameFrame.rolelist.add(new Boom(this.x,this.y));
	}
}
}
