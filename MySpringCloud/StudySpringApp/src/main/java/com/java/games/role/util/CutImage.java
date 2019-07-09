package com.java.games.role.util;

import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
/**
 * 图像切割类
 * @Title: CutImage.java 
 * @Package com.java.games.role.util 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author lys
 * @date 2019年6月13日 下午5:08:10 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public class CutImage {

	/**
	 *  切割多行图片
	 * 
	 * @param filePath            原始图片路径
	 * @param row	               图片切割行数
	 * @param col                 图片切割列数
	 * @param track               媒体追踪器
	 * @param groupId 			   分组ID
	 * @return Image[][]          切割完成后的图像数组
	 */
	public static  Image[][] cutManyImage(String filePath, int row, int col,MediaTracker track,int groupId) {
		
		Image[][] img = new Image[row][col];

		ImageIcon imIcon = new ImageIcon(filePath);// 创建图像数组对象

		Image imgTemp = imIcon.getImage();// 创建源图像
		
		int imageWidth = imgTemp.getWidth(null)/col;
		int imageHight = imgTemp.getHeight(null)/row;
		
		// 为源 图象获取ImageProducer源
		ImageProducer sourceProducer = imgTemp.getSource();

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				// 创建图片分割图像对象,第一、二个参数为分割图像起始坐标。后两个参数为图像大小
				CropImageFilter cropImg = new CropImageFilter(j * imageWidth, i * imageHight,imageWidth, imageHight);

				/* 获得图像生成器 */
				ImageProducer imgProducer = new FilteredImageSource(sourceProducer, cropImg);

				/* 获图像对象 */
				img[i][j] = new JFrame().createImage(imgProducer);
				track.addImage(img[i][j], groupId);
			}
		}

		return img;
	}
	
	/**
	 * 切割单行图片
	 * @param filePath 文件路径
	 * @param col 列数
	 * @param track 媒体追踪器
	 * @param groupId 分组ID
	 * @return 切割完成后的图像数组
	 */
	public static  Image[] cutOneImage(String filePath,int col,MediaTracker track,int groupId) {
		
		Image[] img = new Image[col];

		ImageIcon imIcon = new ImageIcon(filePath);// 创建图像数组对象

		Image imgTemp = imIcon.getImage();// 创建源图像
		int imageWidth = imgTemp.getWidth(null)/col;
		int imageHight = imgTemp.getHeight(null);
		// 为源 图象获取ImageProducer源
		ImageProducer sourceProducer = imgTemp.getSource();


			for (int j = 0; j < col; j++) {
				// 创建图片分割图像对象,第一、二个参数为分割图像起始坐标。后两个参数为图像大小
				CropImageFilter cropImg = new CropImageFilter(j * imageWidth, 0,imageWidth, imageHight);

				/* 获得图像生成器 */
				ImageProducer imgProducer = new FilteredImageSource(sourceProducer, cropImg);

				/* 获图像对象 */
				img[j] = new JFrame().createImage(imgProducer);
				track.addImage(img[j], groupId);
			}


		return img;
	}
	/**
	 * 得到单个图像
	 * @param filePath 文件路径
	 * @param track 媒体追踪器
	 * @param groupId 分组ID
	 * @return 图像对象
	 */
	public static  Image getSingleImage(String filePath,MediaTracker track,int groupId){
		Image img = new ImageIcon(filePath).getImage();
		track.addImage(img, groupId);
		
		return img;
	}
}
