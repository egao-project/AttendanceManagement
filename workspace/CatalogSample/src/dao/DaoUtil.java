package dao;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import util.SettingUtil;

public class DaoUtil {
    private DataSource source;
    //シングルトンとして実装する
    private static DaoUtil inst = new DaoUtil();
    //設定ファイルの設定のキーを表す定数
    private static final String JDBC_URL = "jdbc.driver.url";
    private static final String JDBC_USER = "jdbc.driver.user";
    private static final String JDBC_PASS = "jdbc.driver.pass";
    private static final String JDBC_DRIVER = "jdbc.driver.classname";

    private DaoUtil() {
        source = createDataSource();
    }
    public static DataSource getSource() {
        return inst.source;
    }
    private DataSource createDataSource(){
        //Commns DBCPのBasicDataSourceを生成して、
        //設定ファイルからDriverクラス名、JDBCの接続URL、
        //DBのユーザ名、DBのパスワードを設定する
        BasicDataSource bds = new BasicDataSource();
        bds.setDriverClassName(SettingUtil.getProperty(JDBC_DRIVER));
        bds.setUsername(SettingUtil.getProperty(JDBC_USER));
        bds.setPassword(SettingUtil.getProperty(JDBC_PASS));
        bds.setUrl(SettingUtil.getProperty(JDBC_URL));
        return bds;
    }
}