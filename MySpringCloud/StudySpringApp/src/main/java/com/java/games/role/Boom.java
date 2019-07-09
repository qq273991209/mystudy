package com.java.games.role;

import java.awt.Image;

import com.java.games.role.game.GameFrame;
import com.java.games.role.util.ChangeImg;


public class Boom extends BaseRole{
public static Image[] boomimg;
private int count;
private ChangeImg a=new ChangeImg(3);

	public Boom(int x,int y) {
		super(x, y,100, 100);
		
	}

	@Override
	protected void move() {
		this.img=a.change(boomimg);
		count++;
		if(count>30){
			GameFrame.rolelist.remove(this);
		}
	}

}
