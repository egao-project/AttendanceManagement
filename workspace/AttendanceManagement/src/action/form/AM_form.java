package action.form;

import org.apache.struts.validator.ValidatorForm;

public class AM_form extends ValidatorForm{

	private static final long serialVersionUID = 1L;

	private String empNum;		// �Ј��ԍ�
	private String empName;		// ���O
	private String empPass;		// �p�X���[�h
	private String nowHour; 	// ���� ��
	private String nowMinute;	// ���� ��

	public AM_form(){
		empName = null;
		empNum = null;
	}

	// �Ј��ԍ�
	public String getEmpNum() {
		return (empNum);
	}
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}

	// ���O
	public String getEmpName() {
		return (empName);
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	// �p�X���[�h
	public String getEmpPass() {
		return (empPass);
	}
	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}

	// ���� ��
	public String getNowHour() {
		return (nowHour);
	}
	public void setNowHour(String nowHour) {
		this.nowHour = nowHour;
	}

	// ���� ��
	public String getNowMinute() {
		return (nowMinute);
	}
	public void setNowMinute(String nowMinute) {
		this.nowMinute = nowMinute;
	}
}