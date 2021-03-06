package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Item {

	public static int nowYear = 0; 				// 現在 年
	public static int nowMonth = 0; 			// 現在 月（+1することで、1～12の月に対応）
	public static int nowDay = 0; 				// 現在 日
	public static int nowHour = 0; 				// 現在 時
	public static int nowMinute = 0; 			// 現在 分
	public static String nowMinute_S = null;	// 現在 分（String）
	public String success = "OK";				// 条件がtrueの際に使用
	public String fault = "NG";					// 条件がfalseの際に使用

	public Item() {
		Calendar now = Calendar.getInstance();
		nowYear = now.get(Calendar.YEAR);
		nowMonth = now.get(Calendar.MONTH) + 1;
		nowDay = now.get(Calendar.DATE);
		nowHour = now.get(Calendar.HOUR_OF_DAY);
		nowMinute = now.get(Calendar.MINUTE);
		nowMinute_S = String.valueOf(nowMinute);
		// nowMinuteが10以下の際、頭に0を付ける
		if (nowMinute < 10) {
			nowMinute_S = "0" + nowMinute;
		}
	}

	// 現在の年月日を指定書式に変換 例)2015-06-17
	public String getToday() {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return (sdf.format(now.getTime()));
	}

	// 現在の時間を指定書式に変換 例)23:59
	public String getNowTime() {
		return (nowHour + ":" + nowMinute_S);
	}

	// 現在の時間を15分単位に繰上げし、指定書式に変換 例)18:47 → 19:00
	public String getWorkTime() {
		int hour = Item.nowHour;
		String minute;

		if (nowMinute == 0) {
			minute = "00";
		} else if (nowMinute <= 15) {
			minute = "15";
		} else if (nowMinute <= 30) {
			minute = "30";
		} else if (nowMinute <= 45) {
			minute = "45";
		} else {
			minute = "00";
			hour = nowHour + 1;
		}

		return (String.valueOf(hour) + ":" + minute);
	}

	// 条件がtrueの際に使用
	public String getSuccess() {
		return this.success;
	}

	// 条件がfalseの際に使用
	public String getFault() {
		return this.fault;
	}

}