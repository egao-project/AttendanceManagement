package action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.CatalogDAO;

public class CatalogShowAction extends Action {
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        CatalogDAO dao = new CatalogDAO();
        try {
            // データベースの検索をDAOに委譲している
            List<Product> list = dao.getProductList();
            // セッションにProductオブジェクトのリストを格納している
            request.getSession().setAttribute("products", list);
            // 表示領域の設定
            request.setAttribute("offset","0");
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return mapping.findForward("show");
    }
}
