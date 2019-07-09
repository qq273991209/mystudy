package com.java.games.role.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JFrame;

import com.java.games.role.BaseRole;
import com.java.games.role.Boss;
import com.java.games.role.Bullet;
import com.java.games.role.Girl;
import com.java.games.role.util.CreatEnemy;


public class GameFrame extends JFrame implements Runnable {
	//@Fields serialVersionUID :  
	private static final long serialVersionUID = 1L;
	// 程序运行的标志
	private static boolean isRun = true;
	private Image memoryimage;
	private Graphics memorygraphics;
	Boss boss=new Boss();
	public static Girl girl=new Girl();
	Bullet bullet=new Bullet(girl.getX(),girl.getY());
	
	/**角色集合*/
	public static ArrayList<BaseRole> rolelist=new ArrayList<BaseRole>();
	/**玩家的得分*/
	public static int point;
	public GameFrame() {
		this.setSize(1000, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		// 创建大小为1000*700的内存画布
		memoryimage = this.createImage(1000, 700);
		// 从内存画布中得到内存画笔，内存画笔绘制的内容就在内存画布上
		this.memorygraphics = this.memoryimage.getGraphics();
	    new InitImage(this);
        rolelist.add(girl);
        
		Thread th = new Thread(this);
		th.start();
		this.addKeyListener(new PressKey());
	}

	public static void main(String[] args) {
		new GameFrame();

	}

	@Override
	public void run() {
		while (isRun) {
			this.drawFrame(this.getGraphics());
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	// 绘制图片
	public void drawFrame(Graphics g) {
		GameMap.drawMyself(memorygraphics);
		CreatEnemy.creatEnemy();
	    for(int i=0;i<rolelist.size();i++){
            rolelist.get(i).drawMyself(memorygraphics);
		}
	    this.drawInfo();
		g.drawImage(memoryimage, 0, 0, this);
	}
	/**绘制游戏得分等信息*/
	public void drawInfo(){
		memorygraphics.setColor(Color.BLUE);
		memorygraphics.setFont(new Font("宋体",Font.BOLD,30));
		memorygraphics.drawString("得分："+point, 50, 80);
	}
}
