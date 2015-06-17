import java.text.SimpleDateFormat;
import java.util.Calendar;


public class test {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Calendar now = Calendar.getInstance();
		int nowYear = now.get(Calendar.YEAR); 	// 現在 年
		int nowMonth = now.get(Calendar.MONTH); // 現在 月
		int nowDay = now.get(Calendar.DATE); 	// 現在 日
		int nowHour = now.get(Calendar.HOUR_OF_DAY); // 現在 時
		int nowMinute = now.get(Calendar.MINUTE); // 現在 分

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(now.getTime());

		System.out.println(today);
	}

}
