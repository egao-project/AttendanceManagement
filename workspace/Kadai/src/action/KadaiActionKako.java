package action;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import action.form.KadaiForm;

public class KadaiActionKako extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// アクションフォームにセット・ゲットする為に定義
		KadaiForm queryForm = (KadaiForm) form;

		//KadaiFormから名前を取得
		String userName = queryForm.getName();

		// DBにアクセス
		String host = "localhost";
		String port = "1521";
		String name = "XE";
		String user = "SYSTEM";
		String pwd = "abc";
		String url = "jdbc:oracle:thin:@" + host + ":" + port + "/" + name;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs0 = null;	//各nameの件数
		ResultSet rs1 = null;	//超大凶の件数
		ResultSet rs2 = null;	//最凶の件数
		ResultSet rs3 = null;	//凶の件数
		ResultSet rs4 = null;	//最強の件数
		ResultSet rs5 = null;	//末吉の件数

		try {
			con = DriverManager.getConnection(url, user, pwd);
			stmt = con.createStatement();

			// userlistテーブルの各nameの件数を取得
			String countUserResultTotal = "SELECT COUNT(name) AS name FROM userlist GROUP BY name HAVING name = '" + userName + "'";
			rs0 = stmt.executeQuery(countUserResultTotal);
			rs0.next();
			int userResultTotal = rs0.getInt("name");
			queryForm.setUserResultTotal(userResultTotal);

			// 超大凶の回数を取得しセット
			String countResultCount1 = "SELECT COUNT(*) AS userresult FROM userlist WHERE userresult= '超大凶' and name = '" + userName + "'";
			rs1 = stmt.executeQuery(countResultCount1);
			rs1.next();
			int userResult1 = rs1.getInt("userresult");
			queryForm.setResultCount1(userResult1);

			// 最凶の回数を取得しセット
			String countResultCount2 = "SELECT COUNT(*) AS userresult FROM userlist WHERE userresult= '最凶' and name = '" + userName + "'";
			rs2 = stmt.executeQuery(countResultCount2);
			rs2.next();
			int userResult2 = rs2.getInt("userresult");
			queryForm.setResultCount2(userResult2);

			// 凶の回数を取得しセット
			String countResultCount3 = "SELECT COUNT(*) AS userresult FROM userlist WHERE userresult= '凶' and name = '" + userName + "'";
			rs3 = stmt.executeQuery(countResultCount3);
			rs3.next();
			int userResult3 = rs3.getInt("userresult");
			queryForm.setResultCount3(userResult3);

			// 最強の回数を取得しセット
			String countResultCount4 = "SELECT COUNT(*) AS userresult FROM userlist WHERE userresult= '最強' and name = '" + userName + "'";
			rs4 = stmt.executeQuery(countResultCount4);
			rs4.next();
			int userResult4 = rs4.getInt("userresult");
			queryForm.setResultCount4(userResult4);

			// 末吉の回数を取得しセット
			String countResultCount5 = "SELECT COUNT(*) AS userresult FROM userlist WHERE userresult= '末吉' and name = '" + userName + "'";
			rs5 = stmt.executeQuery(countResultCount5);
			rs5.next();
			int userResult5 = rs5.getInt("userresult");
			queryForm.setResultCount5(userResult5);

			// 超大凶の%を出す
			int parm1a = queryForm.getResultCount1();
			int parm1b = queryForm.getUserResultTotal();
			double parm1c = ( ((double)parm1a) / parm1b )*100;
			BigDecimal bi1 = new BigDecimal(parm1c);
			double parm1d = bi1.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
			String parm1 =  parm1d + "%";
			queryForm.setResult1Percent(parm1);

			// 最凶の%を出す
			int parm2a = queryForm.getResultCount2();
			int parm2b = queryForm.getUserResultTotal();
			double parm2c = ( ((double)parm2a) / parm2b )*100;
			BigDecimal bi2 = new BigDecimal(parm2c);
			double parm2d = bi2.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
			String parm2 =  parm2d + "%";
			queryForm.setResult2Percent(parm2);

			// 凶の%を出す
			int parm3a = queryForm.getResultCount3();
			int parm3b = queryForm.getUserResultTotal();
			double parm3c =  ( ((double)parm3a) / parm3b )*100;
			BigDecimal bi3 = new BigDecimal(parm3c);
			double parm3d = bi3.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
			String parm3 =  parm3d + "%";
			queryForm.setResult3Percent(parm3);

			// 最強の%を出す
			int parm4a = queryForm.getResultCount4();
			int parm4b = queryForm.getUserResultTotal();
			double parm4c =  ( ((double)parm4a) / parm4b )*100;
			BigDecimal bi4 = new BigDecimal(parm4c);
			double parm4d = bi4.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
			String parm4 =  parm4d + "%";
			queryForm.setResult4Percent(parm4);

			// 末吉の%を出す
			int parm5a = queryForm.getResultCount5();
			int parm5b = queryForm.getUserResultTotal();
			double parm5c =  ( ((double)parm5a) / parm5b )*100;
			BigDecimal bi = new BigDecimal(parm5c);
			double parm5d = bi.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
			String parm5 =  parm5d + "%";
			queryForm.setResult5Percent(parm5);


		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			//rs0
			try {
				if (rs0 != null) {
					rs0.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			try {
				if (rs0 != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			try {
				if (rs0 != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}


			//rs1
			try {
				if (rs1 != null) {
					rs1.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			try {
				if (rs1 != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			try {
				if (rs1 != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			//rs2
			try {
				if (rs2 != null) {
					rs2.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			try {
				if (rs2 != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			try {
				if (rs2 != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			//rs3
			try {
				if (rs3 != null) {
					rs3.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			try {
				if (rs3 != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			try {
				if (rs3 != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			//rs4
			try {
				if (rs4 != null) {
					rs4.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			try {
				if (rs4 != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			try {
				if (rs4 != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			//rs5
			try {
				if (rs5 != null) {
					rs5.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			try {
				if (rs5 != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}

			try {
				if (rs5 != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.err.println(e);
			}
		}


		// マッピングに値を返す
		return (mapping.findForward("kako"));

	}
}
