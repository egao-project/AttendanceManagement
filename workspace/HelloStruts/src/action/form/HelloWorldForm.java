package action.form;

import org.apache.struts.action.ActionForm;

public class HelloWorldForm extends ActionForm{
    private String name; //プロパティ

    public String getName() { //セッター
        return( name );
    }
    public void setName(String name) { //ゲッター
        this.name = name;
    }
}
