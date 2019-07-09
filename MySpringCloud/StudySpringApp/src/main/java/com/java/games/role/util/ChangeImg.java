package com.java.games.role.util;

import java.awt.Image;

public class ChangeImg {
	private int speed;
	private int index;
	private int count;
	private Image[] img;
 public ChangeImg(int speed){
	this.speed=speed;
}
public Image change(Image[] img){
	count++;
	if(count>speed){
		count=0;
		index++;
		if(index>img.length-1){
			index=0;
		}
	}
	return img[index];
}
}
