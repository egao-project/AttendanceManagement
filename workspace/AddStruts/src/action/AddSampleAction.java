package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.AddSampleQueryForm;

public class AddSampleAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {

        AddSampleQueryForm queryForm = (AddSampleQueryForm) form;

        int parm1 = Util.atoi(queryForm.getParm1());
        int parm2 = Util.atoi(queryForm.getParm2());

        BusinessLogic businessLogic = BusinessLogic.getInstance();
        int result = businessLogic.executeAdd(parm1, parm2);

        queryForm.setParm1(String.valueOf(parm1));
        queryForm.setParm2(String.valueOf(parm2));
        queryForm.setResult(String.valueOf(result));

        return mapping.findForward("success");
    }
}
