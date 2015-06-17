package form;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class AddSampleQueryForm extends ActionForm {
    private String parm1;
    private String parm2;
    private String result;

    public void setParm1(String parm1) {
        this.parm1 = parm1;
    }
    public void setParm2(String parm2) {
        this.parm2 = parm2;
    }
    public String getParm1() {
        return parm1;
    }
    public String getParm2() {
        return parm2;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
}
