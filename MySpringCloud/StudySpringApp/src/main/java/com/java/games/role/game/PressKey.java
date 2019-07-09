package com.java.games.role.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.java.games.role.Bullet;

public class PressKey implements KeyListener {
	/** 玩家是否按下了上键 */
	public static boolean isUp;
	/** 玩家是否按下了下键 */
	public static boolean isDown;
	/** 玩家是否按下了左键 */
	public static boolean isLeft;
	/** 玩家是否按下了右键 */
	public static boolean isRight;

	// 键盘按下事件
	@Override
	public void keyPressed(KeyEvent arg0) {
		int code = arg0.getKeyCode();
		if (code == KeyEvent.VK_W) {
			isUp = true;
		}
		if (code == KeyEvent.VK_S) {
			isDown = true;
		}
		if (code == KeyEvent.VK_A) {
			isLeft = true;
		}
		if (code == KeyEvent.VK_D) {
			isRight = true;
		}

	}

	// 键盘释放事件
	@Override
	public void keyReleased(KeyEvent arg0) {
		int code = arg0.getKeyCode();
		if (code == KeyEvent.VK_W) {
			isUp = false;
		}
		if (code == KeyEvent.VK_S) {
			isDown = false;
		}
		if (code == KeyEvent.VK_A) {
			isLeft = false;
		}
		if (code == KeyEvent.VK_D) {
			isRight = false;
		}
		if (code == KeyEvent.VK_J) {
			GameFrame.rolelist.add(new Bullet(GameFrame.girl.getX(), GameFrame.girl.getY()));
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
