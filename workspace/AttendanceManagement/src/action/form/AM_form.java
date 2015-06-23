package action.form;

import org.apache.struts.validator.ValidatorForm;

public class AM_form extends ValidatorForm{

	private static final long serialVersionUID = 1L;

	private String empNum;				// 社員番号
	private String empName;				// 社員名
	private String empPass;				// パスワード
	private String nowHour; 			// 現在 時
	private String nowMinute;			// 現在 分
	private String message1 = null;		// login.jsp用のメッセージ
	private String message2 = null;		// admin.jsp用のメッセージ
	private String errorMessage;		// エラーメッセージ
	private int output_year;			// Outputしたい年
	private int output_month;			// Outputしたい月

	// 社員番号
	public String getEmpNum() {
		return (empNum);
	}
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}

	// 社員名
	public String getEmpName() {
		return (empName);
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	// パスワード
	public String getEmpPass() {
		return (empPass);
	}
	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}

	// 現在 時
	public String getNowHour() {
		return (nowHour);
	}
	public void setNowHour(String nowHour) {
		this.nowHour = nowHour;
	}

	// 現在 分
	public String getNowMinute() {
		return (nowMinute);
	}
	public void setNowMinute(String nowMinute) {
		this.nowMinute = nowMinute;
	}

	// login.jsp用のメッセージ
	public String getMessage1() {
		return (message1);
	}
	public void setMessage1(String message1) {
		this.message1 = message1;
	}

	// admin.jsp用のメッセージ
	public String getMessage2() {
		return (message2);
	}
	public void setMessage2(String message2) {
		this.message2 = message2;
	}

	// エラーメッセージ
	public String getErrorMessage() {
		return (errorMessage);
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	// Outputしたい年
	public int getOutput_year() {
		return (output_year);
	}
	public void setOutput_year(int output_year) {
		this.output_year = output_year;
	}

	// Outputしたい月
	public int getOutput_month() {
		return (output_month);
	}
	public void setOutput_month(int output_month) {
		this.output_month = output_month;
	}
}