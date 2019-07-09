package com.java.games.role;

import java.awt.Image;

import com.java.games.role.util.ChangeImg;



public class Boss extends BaseRole{
	/** 获取boss图片组*/
		public static  Image[] bossimg;
		/**图片切换对象*/
		private ChangeImg a=new ChangeImg(3);
	public Boss(){
		super(300,300,150,150);
	}
		@Override
		protected void move() {
			this.img=a.change(bossimg);
		
		}
}
