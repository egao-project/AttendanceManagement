package action.form;

import org.apache.struts.validator.ValidatorForm;

public class AM_form extends ValidatorForm{

	private static final long serialVersionUID = 1L;

	private int empNum;		// �Ј��ԍ�
	private String name;	// ���O
	private String empPass;	// �p�X���[�h

	public AM_form(){
		name = null;
		empNum = 0;
	}

	// �Ј��ԍ�
	public int getEmpNum() {
		return (empNum);
	}
	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}

	// ���O
	public String getName() {
		return (name);
	}
	public void setName(String name) {
		this.name = name;
	}

	// �p�X���[�h
	public String getEmpPass() {
		return (empPass);
	}
	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}

}