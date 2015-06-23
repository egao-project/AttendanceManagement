import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXB;


public class Sample1 {

	public static void main(String[] args) {
		// 会社
		Company c = new Company();

		// 2人の従業員
		List<Employee> employees = new ArrayList<Employee>();

		Employee e1 = new Employee();
		e1.setName("taro");
		e1.setSalary(1000);
		employees.add(e1);

		Employee e2 = new Employee();
		e2.setName("hanako");
		e2.setSalary(800);
		employees.add(e2);

		c.setEmployees(employees);

		// マーシャル
		JAXB.marshal(c, System.out);

	}

}
