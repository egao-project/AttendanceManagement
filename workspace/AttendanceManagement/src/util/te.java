package util;

public class te {

	public static void main(String[] args) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		String host = "localhost";
		String port = "3306";
		String dbname = "attendance_management";
		String user = "local";
		String pw = "abcd";
		String url = "jdbc:mysql://" + host + "/" + dbname;
		System.out.println(url);
	}

}
