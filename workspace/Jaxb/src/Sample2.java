import java.io.StringReader;

import javax.xml.bind.JAXB;

public class Sample2 {

	public static void main(String[] args) {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<company>"
				+ "    <employees>"
				+ "        <name>taro</name>"
				+ "        <salary>1000</salary>"
				+ "    </employees>"
				+ "    <employees>"
				+ "        <name>hanako</name>"
				+ "        <salary>800</salary>"
				+ "    </employees>"
				+ "</company>";

		// アンマーシャル
		Company c = JAXB.unmarshal(new StringReader(xml), Company.class);

		System.out.println(c);
	}
}