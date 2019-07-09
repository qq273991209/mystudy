/**
 * Project Name:StudySpringApp
 * File Name:StackX.java
 * Package Name:com.java.JvmTest
 * Date:2019年5月24日下午5:24:10
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.JvmTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.java.util.ArithUtil;

/**
 * @Title: StackX.java
 * @Package com.java.JvmTest
 * @Description: TODO(堆栈信息测试类)
 * @author 刘云升
 * @date 2019年5月24日 下午5:24:10 Copyright (c) ©1994-2019 Scjydz.com All Rights
 *       Reserved.
 */
public class StackX {

	private int maxSize;

	private int top;

	private Long[] stackArray;

	public StackX(int s) {
		top = -1;
		maxSize = s;
		stackArray = new Long[maxSize];
	}

	public void push(long l) {
		stackArray[++top] = l;
	}

	public long pop() {

		return stackArray[top--];
	}

	public long peek() {

		return stackArray[top];
	}

	public boolean isEmpty() {

		return (top == -1);
	}

	public boolean isFull() {

		return (top == maxSize - 1);
	}
}

class StackXApp {

	public static void main(String[] args) {
//		StackX stackx = new StackX(10);
//		stackx.push(20);
//		stackx.push(40);
//		stackx.push(60);
//		stackx.push(80);
//		String str = "";
//		while (!stackx.isEmpty()) {
//			long value = stackx.pop();
//			str +=value+"  ";
//			//System.out.print(value);
//			//System.out.print("  ");
//		}
//		System.out.print(str);
		
		//字符串处理不丢失精度
//		String a = "12.55";
//		String b = String.valueOf(ArithUtil.convertsToInt(new Double(a)*100));
//		System.out.println(b);
//		//去掉字符串两端引号
//		String c = "\"22_F4lNZywWtVEW73NHHkz0_hA2Gueoo_pzHER1Tugp6rWvqZPsmvX72ohsCmIGoMLsfm6FWp2DQhMNJHPQL-ORY1JFtLAvNga5lTRJs2Hv4d5F8j7JvozOqtItRHzGWxV7qnAaiZ5VpRQk9V21JOMhABACHF\"";
//		//System.out.println(c.replace("\"",""));
//		System.out.println(c.subSequence(1, c.length()-1));
		
		// 注意：一定要使用创建对象的格式创建数组
//		Integer[] a = new Integer[] { 6, 3, 9, 3, 2, 4, 5, 7 };
//		Integer[] b = new Integer[] { 5, 8, 6, 2, 1, 9 };
//		List _a = Arrays.asList(a);
//		List _b = Arrays.asList(b);
//		// 创建集合
//		Collection realA = new ArrayList<Integer>(_a);
//		Collection realB = new ArrayList<Integer>(_b);
//		// 求交集
//		realA.retainAll(realB);
//		System.out.println("交集结果：" + realA);
//		Set result = new HashSet();
//		// 求全集
//		result.addAll(_a);
//		result.addAll(_b);
//		System.out.println("全集结果：" + result);
//		// 求差集：结果
//		Collection aa = new ArrayList(realA);
//		Collection bb = new ArrayList(result);
//		bb.removeAll(aa);
//		System.out.println("最终结果：" + bb);
		
		String str = "##白细胞数&&5.33&&无&&10`9/L&&3.5-9.5&&无&&##中性粒细胞数&&2.16&&无&&10`9/L&&1.8-6.3&&无&&##淋巴细胞数&&2.82&&无&&10`9/L&&1.1-3.2&&无&&##单核细胞数&&0.26&&无&&10`9/L&&0.1-0.6&&无&&##嗜酸性粒细胞数&&0.08&&无&&10`9/L&&0.02-0.52&&无&&##嗜碱性粒细胞数&&0.01&&无&&10`9/L&&0-0.06&&无&&##中性粒细胞率&&40.50&&无&&%&&40-75&&无&&##淋巴细胞率&&53.00&&无&&%&&20-50&&↑&&##单核细胞率&&4.80&&无&&%&&3-10&&无&&##嗜酸性粒细胞率&&1.50&&无&&%&&0.4-8&&无&&##嗜碱性粒细胞率&&0.20&&无&&%&&0-1&&无&&##红细胞数&&4.21&&无&&10`12/L&&3.8-5.1&&无&&##血红蛋白&&128&&无&&g/L&&115-150&&无&&##红细胞压积&&0.40&&无&&无&&0.35-0.45&&无&&##红细胞平均体积&&95.00&&无&&fl&&82-100&&无&&##红细胞平均血红蛋白量&&30.30&&无&&pg&&27-34&&无&&##红细胞平均血红蛋白浓度&&319&&无&&g/L&&316-354&&无&&##红细胞体积分布宽度标准差&&40.20&&无&&fl&&35-56&&无&&##红细胞体积分布宽度变异系数&&12.00&&无&&%&&11-16&&无&&##血小板数&&231&&无&&10`9/L&&125-350&&无&&##血小板平均体积&&8.50&&无&&fl&&9.4-12.5&&↓&&##血小板压积&&0.20&&无&&无&&0.10-0.28&&无&&##血小板体积分布宽度&&15.70&&无&&%&&15.1-18.1&&无&&##大血小板比例&&15.60&&无&&%&&13.0-43.0&&无&&";
		String[] strs = str.split("##");
		for (int index = 1; index < strs.length; index++) {
			String[] sb  = strs[index].split("&&");
//			System.out.println(sb[0]);
//			System.out.println(sb[1]);
//			System.out.println(sb[2]);
//			System.out.println(sb[3]);
			System.out.println(sb[4]);
			System.out.println(sb[5]);
		}
	
	}
}

