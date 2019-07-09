package com.java.util;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class TestDate {
	//节假日列表
	private static List<Calendar> holidayList = new ArrayList<Calendar>();  
	//周末为工作日
	private static List<Calendar> weekendList = new ArrayList<Calendar>();
	/** 
	 * @param args
	 * return void    返回类型 
	 * throws 
	 */
	public static void main(String[] args) {
//		try {
//			
//			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//			Calendar ca = Calendar.getInstance();
//			Date d = df.parse("2019-06-02");
//			ca.setTime(d);//设置当前时间
//			
//			TestDate ct = new TestDate();
////			ct.initHolidayList("2016-09-15");//初始节假日
////			ct.initHolidayList("2016-09-16");//初始节假日
////			ct.initHolidayList("2016-09-17");//初始节假日
////			ct.initWeekendList("2016-09-18");//初始周末为工作日
//			boolean k = checkHoliday(ca);
//			System.out.println(ct.checkHoliday(ca));
////			System.out.println(k);
//			
//		} catch ( Exception e) {
//			// TODO: handle exception
//			System.out.println(e.getClass());
//			e.printStackTrace();
//		}
		
		Date today = new Date();
        Calendar c=Calendar.getInstance();
        c.setTime(today);
        int weekday=c.get(Calendar.DAY_OF_WEEK);
//        System.out.println(weekday-1);
		
        Calendar now =Calendar.getInstance();  
		for (int index = 0; index < 30; index++) {
			now.setTime(new Date());  
			now.set(Calendar.DATE,now.get(Calendar.DATE)+index);
			if(now.get(Calendar.DAY_OF_WEEK)!=1&&now.get(Calendar.DAY_OF_WEEK)!=7) {
				System.err.println(now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.DATE));
			}else {
				System.out.println(now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.DATE));
			}
			
		}
	}
	
 
	
	 
	 /**
	  * 
	  * 验证日期是否是节假日
	  * @param calendar  传入需要验证的日期
	  * @return 
	  * return boolean    返回类型  返回true是节假日，返回false不是节假日
	  * throws 
	  */
	 public static boolean checkHoliday(Calendar calendar) throws Exception{
		 
		 //判断日期是否是周六周日
		 if(calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || 
				 calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
			 
			//判断日期是否是节假日
			 for (Calendar ca : weekendList) {
				if(ca.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
						ca.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)&&
						ca.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)){
					return false;
				}
			}
			 
			 return true;
		 }
		 //判断日期是否是节假日
		 for (Calendar ca : holidayList) {
			if(ca.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
					ca.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH)&&
					ca.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)){
				return true;
			}
		}
		  
		 return false;
	 }
	 
	 /**
	  * 
	  * 把所有节假日放入list
	  * @param date  从数据库查 查出来的格式2016-05-09
	  * return void    返回类型 
	  * throws 
	  */
	public void initHolidayList(String date){
		
			String [] da = date.split("-");
			
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, Integer.valueOf(da[0]));
			calendar.set(Calendar.MONTH, Integer.valueOf(da[1])-1);//月份比正常小1,0代表一月
			calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(da[2]));
			holidayList.add(calendar);
	}
	
	/**
	 * 初始化周末被调整为工作日的数据
	 */
	public void initWeekendList(String date){
		String [] da = date.split("-");
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.valueOf(da[0]));
		calendar.set(Calendar.MONTH, Integer.valueOf(da[1])-1);//月份比正常小1,0代表一月
		calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(da[2]));
		weekendList.add(calendar);
	}
 
}