package action.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

@SuppressWarnings("serial")
public class CheckAgeForm extends ActionForm {
    private int age;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest req) {
        ActionErrors errors = new ActionErrors();
        try {
            String ageString = req.getParameter("age");
            // 蜈･蜉帙ョ繝ｼ繧ｿ縺ｮ蠢�鬆医メ繧ｧ繝�繧ｯ
            if (ageString == null || "".equals(ageString)) {
                errors.add("age", new ActionMessage("error.age.required"));
                return errors;
            }
            int age = Integer.parseInt(ageString);
            // 蜈･蜉帙ョ繝ｼ繧ｿ縺ｮ謨ｰ蛟､縺ｮ遽�蝗ｲ繝√ぉ繝�繧ｯ
            if (age < 0 || age > 200) {
                // 讀懆ｨｼ螟ｱ謨�
                // age繝励Ο繝代ユ繧｣縺ｮ讀懆ｨｼ螟ｱ謨励↑縺ｮ縺ｧ縲�
                // age繝励Ο繝代ユ繧｣縺ｫ 繧ｨ繝ｩ繝ｼ繝｡繝�繧ｻ繝ｼ繧ｸ縺ｮ繧ｭ繝ｼ縺憩rror.age繧定ｨｭ螳壹☆繧九��
                errors.add("age", new ActionMessage("error.age.range"));
            }
        } catch (NumberFormatException ex) {
            // 蜈･蜉帙ョ繝ｼ繧ｿ縺ｮ蝙九メ繧ｧ繝�繧ｯ
            errors.add("age", new ActionMessage("error.age.notint"));
        }
        return errors;
    }
}
