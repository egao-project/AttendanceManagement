package action;

public final class Util {
    public static int atoi(String str) { //文字列を整数に変換す
        int ret = 0;
        try {
            ret = Integer.parseInt(str);
        } catch (Exception ex) {
            /* 整数に変換出来ない文字列は0とみなす */
        }
        return ret;
    }
}
