import java.text.SimpleDateFormat;
import java.util.Calendar;


public class test {

	public static void main(String[] args) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		Calendar now = Calendar.getInstance();
		int nowYear = now.get(Calendar.YEAR); 	// ���� �N
		int nowMonth = now.get(Calendar.MONTH); // ���� ��
		int nowDay = now.get(Calendar.DATE); 	// ���� ��
		int nowHour = now.get(Calendar.HOUR_OF_DAY); // ���� ��
		int nowMinute = now.get(Calendar.MINUTE); // ���� ��

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(now.getTime());

		System.out.println(today);
	}

}
