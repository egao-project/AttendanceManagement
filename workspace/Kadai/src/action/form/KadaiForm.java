package action.form;

import org.apache.struts.validator.ValidatorForm;

public class KadaiForm extends ValidatorForm{
	private String name; 		// 名前
	private int fotuneValue; 	// ミリ秒からの下一桁
	private String result;		// 結果
	private String comment;		// 結果コメント

	private int userResultTotal; // userの占った回数
	private int resultCount1 = 0; // 超大凶の回数
	private int resultCount2 = 0; // 最凶の回数
	private int resultCount3 = 0; // 凶の回数
	private int resultCount4 = 0; // 最強の回数
	private int resultCount5 = 0; // 末吉の回数

	private String result1Percent = "0%";	// // 超大凶の%
	private String result2Percent = "0%";	// // 最凶の%
	private String result3Percent = "0%";	// // 凶の%
	private String result4Percent = "0%";	// // 最強の%
	private String result5Percent = "0%";	// // 末吉の%

	public KadaiForm(){
		name = null;
	}

	// 名前のセッター・ゲッター
	public String getName() {
		return (name);
	}
	public void setName(String name) {
		this.name = name;
	}

	// fotuneValueのセッター・ゲッター
	public int getFotuneValue() {
		return (fotuneValue);
	}
	public void setFotuneValue(int fotuneValue) {
		this.fotuneValue = fotuneValue;
	}

	// 結果のセッター・ゲッター
	public String getResult() {
		return (result);
	}
	public void setResult(String result) {
		this.result = result;
	}

	// 結果コメントのセッター・ゲッター
	public String getComment() {
		return (comment);
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	// 占った総回数のセッター・ゲッター
	public int getUserResultTotal() {
		return (userResultTotal);
	}
	public void setUserResultTotal(int userResultTotal) {
		this.userResultTotal = userResultTotal;
	}

	// 各項目(超大凶)の回数のセッター・ゲッター
	public int getResultCount1() {
		return (resultCount1);
	}
	public void setResultCount1(int resultCount1) {
		this.resultCount1 = resultCount1;
	}

	// 各項目(最凶)の回数のセッター・ゲッター
	public int getResultCount2() {
		return (resultCount2);
	}
	public void setResultCount2(int resultCount2) {
		this.resultCount2 = resultCount2;
	}

	// 各項目(凶)の回数のセッター・ゲッター
	public int getResultCount3() {
		return (resultCount3);
	}
	public void setResultCount3(int resultCount3) {
		this.resultCount3 = resultCount3;
	}

	// 各項目(最強)の回数のセッター・ゲッター
	public int getResultCount4() {
		return (resultCount4);
	}
	public void setResultCount4(int resultCount4) {
		this.resultCount4 = resultCount4;
	}

	// 各項目(末吉)の回数のセッター・ゲッター
	public int getResultCount5() {
		return (resultCount5);
	}
	public void setResultCount5(int resultCount5) {
		this.resultCount5 = resultCount5;
	}


	// 超大凶の％のセッター・ゲッター
	public String getResult1Percent() {
		return (result1Percent);
	}
	public void setResult1Percent(String result1Percent) {
		this.result1Percent = result1Percent;
	}

	// 最凶の％のセッター・ゲッター
	public String getResult2Percent() {
		return (result2Percent);
	}
	public void setResult2Percent(String result2Percent) {
		this.result2Percent = result2Percent;
	}

	// 凶の％のセッター・ゲッター
	public String getResult3Percent() {
		return (result3Percent);
	}
	public void setResult3Percent(String result3Percent) {
		this.result3Percent = result3Percent;
	}

	// 最強の％のセッター・ゲッター
	public String getResult4Percent() {
		return (result4Percent);
	}
	public void setResult4Percent(String result4Percent) {
		this.result4Percent = result4Percent;
	}

	// 末吉の％のセッター・ゲッター
	public String getResult5Percent() {
		return (result5Percent);
	}
	public void setResult5Percent(String result5Percent) {
		this.result5Percent = result5Percent;
	}

}