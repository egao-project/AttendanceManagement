import javax.xml.bind.annotation.XmlAttribute;


public class Employee {

	private String name;
	private int salary;

	@XmlAttribute
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	@XmlAttribute
	public int getSalary(){
		return salary;
	}

	public void setSalary(int salary){
		this.salary = salary;
	}

	@Override
	public String toString(){
		return "Employee [name = " + name + ", salary = " + salary + "]";
	}

}
