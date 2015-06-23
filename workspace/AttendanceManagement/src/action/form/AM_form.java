package action.form;

import org.apache.struts.validator.ValidatorForm;

public class AM_form extends ValidatorForm{

	private static final long serialVersionUID = 1L;

	private String empNum;				// 社員番号
	private String empName;				// 名前
	private String empPass;				// パスワード
	private String nowHour; 			// 現在 時
	private String nowMinute;			// 現在 分
	private String message;				// 成功時のメッセージ
	private String errorMessage;		// 失敗時のメッセージ
	private int output_year;			// Output時の指定年
	private int output_month;			// Output時の指定月

	// 社員番号
	public String getEmpNum() {
		return (empNum);
	}
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}

	// 名前
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

	// 成功時のメッセージ
	public String getMessage() {
		return (message);
	}
	public void setMessage(String message) {
		this.message = message;
	}

	// 失敗時のメッセージ
	public String getErrorMessage() {
		return (errorMessage);
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	// Output時の指定年
	public int getOutput_year() {
		return (output_year);
	}
	public void setOutput_yeare(int output_year) {
		this.output_year = output_year;
	}

	// Output時の指定月
	public int getOutput_month() {
		return (output_month);
	}
	public void setOutput_month(int output_month) {
		this.output_month = output_month;
	}
}