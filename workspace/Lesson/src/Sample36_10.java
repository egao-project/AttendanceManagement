import java.util.Properties;

public class Sample36_10 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Properties prop = new Properties();
		String out;
		prop.setProperty("Property 1", "Value 1");
		prop.setProperty("Property 2", "Value 2");
		prop.setProperty("Property 3", "Value 3");
		prop.setProperty("Property 4", "Value 4");
		prop.setProperty("Property 5", "Value 5");
		out = prop.getProperty("Property 3", "Missing");
		System.out.println(out);
		out = prop.getProperty("Property 7", "Missing");
		System.out.println(out);
	}

}
