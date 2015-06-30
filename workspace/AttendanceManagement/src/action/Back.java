package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import action.form.AM_form;

public class Back extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// アクションフォーム利用の為の定義
		AM_form queryForm = (AM_form) form;

		// メッセージを初期化
		queryForm.setMessage("");
		queryForm.setErrorMessage("");

		// マッピングに値を返す
		return (mapping.findForward("Back"));
	}
}