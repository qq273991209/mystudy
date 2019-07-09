package com.java.games.role;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.java.games.role.game.GameFrame;
/**
 * 
 * @Title: BaseRole.java 
 * @Package com.java.games.role 
 * @Description: TODO(角色抽象类) 
 * @author lys
 * @date 2019年6月13日 下午5:02:41 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public abstract class BaseRole {
	/** 角色的x坐标 */
	protected int x;
	/** 角色的y坐标 */
	protected int y;
	/** 角色的宽度 */
	protected int width;
	/** 角色的高度 */
	protected int height;
	/** 角色需要绘制的图片 */
	protected Image img;
	/** 角色的碰撞区域 */
	protected Rectangle rect;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public BaseRole(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.rect = new Rectangle(x,y,width,height);
	}

	/** 将碰撞区域和角色重合 */
	public void setRect() {
		rect.x = this.x;
		rect.y = this.y;
		rect.width = this.width;
		rect.height = this.height;
	}

	/** 角色的绘制方法 */
	public void drawMyself(Graphics memorygraphics) {
		memorygraphics.drawImage(img, x, y, width, height, null);
		this.move();
		this.setRect();
		this.removeMyself();
	}

	/** 角色移除方法 角色到达屏幕以外 自动移除 */
	public void removeMyself() {
		if (this.x < -200 || this.x > 1200 || this.y < -200 || this.y > 900) {
			GameFrame.rolelist.remove(this);
		}
	}

	/** 角色的移动方法 */
	protected abstract void move();
}
