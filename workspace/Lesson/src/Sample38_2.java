import java.util.TreeSet;

public class Sample38_2 {

	public static void main(String[] args) {
		TreeSet<Member2> ts = new TreeSet<Member2>();
		ts.add(new Member2("山田", 9));
		ts.add(new Member2("田中", 4));
		ts.add(new Member2("佐藤", 6));
		ts.add(new Member2("加藤", 1));
		for (Member2 m : ts) {
			System.out.println(m.id + ":" + m.name);
		}
	}
}

class Member2 implements Comparable<Member2> {
	String name;
	int id;

	Member2(String name, int id) {
		this.name = name;
		this.id = id;
	}

	@Override
	public int compareTo(Member2 o) {
		return (id - o.id);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Member2) {
			return (id == ((Member2) o).id);
		}
		return (false);
	}
}
