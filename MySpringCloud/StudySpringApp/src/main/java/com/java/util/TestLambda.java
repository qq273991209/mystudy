package com.java.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TestLambda {

	
	public static void main(String[] args) {
		// 1. 不需要参数。返回值为 5  
//		() -> 5  
//		  
//		// 2. 接收一个参数(数字类型)。返回其2倍的值  
//		x -> 2 * x  
//		  
//		// 3. 接受2个参数(数字)。并返回他们的差值  
//		(x。 y) -> x – y  
//		  
//		// 4. 接收2个int型整数。返回他们的和  
//		(int x。 int y) -> x + y  
//		  
//		// 5. 接受一个 string 对象。并在控制台打印。不返回任何值(看起来像是返回void)
//		如(String s) -> System.out.print(s);
		List<String> proNames = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
		List<String> lowercaseNames1 = proNames.stream()
				.map(name ->{return name.toLowerCase();})//将String数组里面的内容全部转换成小写字母
				.collect(Collectors.toList());//将String数组转换成List集
		System.out.println(lowercaseNames1);
		String[] atp = {"Rafael Nadal", "Novak Djokovic",  
			       "Stanislas Wawrinka",
			       "David Ferrer","Roger Federer",
			       "Andy Murray","Tomas Berdych", 
			       "Juan Martin Del Potro"};  
			List<String> players =  Arrays.asList(atp);  
			  
			// 以前的循环方式  
			for (String player : players) {  
			     System.out.print(player + "; ");  
			}  
			  
			// 使用 lambda 表达式以及函数操作(functional operation)  
			players.forEach((player) -> System.out.println(player + "; "));  
			   
			// 在 Java 8 中使用双冒号操作符(double colon operator)  
			players.forEach(System.out::println);
		
		List<String> proName2 = Arrays.asList(new String[]{"1","2","3"});
		
		proName2.forEach((proname)-> System.out.println(proname+"----proNames"));
		//字符List集合转换成Set集合
		Set<Long> set = proName2.stream().map(s -> Long.valueOf(s.trim())).collect(Collectors.toSet());
		String[] str = new String[]{"4","5","6"};
		//字符数组转换成List集合
		List<Long> list = Arrays.stream(str).map(s -> Long.valueOf(s.trim())).collect(Collectors.toList());
		//字符数组转换成Map集合
		Map<String,Long> map = Arrays.stream(str).map(s -> Long.valueOf(s.trim()))
				.collect(Collectors.toMap(key->String.valueOf(key+"key"),value->Long.valueOf(value)));
		System.out.println(set);
		System.out.println(list);
		System.out.println(map);
	}
}
