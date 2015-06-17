package action;

public class BusinessLogic {
    public int executeAdd(int parm1, int parm2) {
        return parm1 + parm2;
    }
    public static BusinessLogic getInstance() {
        return new BusinessLogic();
    }
}
