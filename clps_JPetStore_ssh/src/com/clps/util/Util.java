package com.clps.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

public class Util {
	// 生成随机数字，1-9999999999之间，用于订单号
	public static int getRollnumber() {
		int id1 = (int) (Math.random() * 99 + 1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String str = sdf.format(new Date());
		Integer integerid=id1;
		String ord=integerid.toString();
		String neword=str+ord;
		Integer id=Integer.parseInt(neword);
		return id;
	}
}
