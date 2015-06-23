import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Company{
	private List<Employee> employees;

	@XmlElementWrapper
	@XmlElement(name="employee")
	public List<Employee> getEmployees(){
		return employees;
	}

	public void setEmployees(List<Employee> employees){
		this.employees = employees;
	}
	@Override
	public String toString(){
		String str = "Company [\n";
		if(employees != null){
			for(Employee e : employees){
					str += " "  + e + "\n";
			}
		}
		str += "]";
		return str;
	}
}