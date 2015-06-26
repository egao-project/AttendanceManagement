package action.form;

import org.apache.struts.validator.ValidatorActionForm;

public class AM_form extends ValidatorActionForm{

	private static final long serialVersionUID = 1L;

	private String empNum;					// 社員番号
	private String empName;					// 社員名
	private String empPass;					// パスワード
	private String message = null;			// メッセージ
	private String errorMessage = null;		// エラーメッセージ
	private int output_year;				// Outputしたい年
	private int output_month;				// Outputしたい月

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

	// メッセージ
	public String getMessage() {
		return (message);
	}
	public void setMessage(String message) {
		this.message = message;
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