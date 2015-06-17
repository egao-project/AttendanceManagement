import java.util.TreeSet;

public class Sample38_2A {

	public static void main(String[] args) {
		TreeSet<Member2A> ts = new TreeSet<Member2A>();
		ts.add(new Member2A("山田", 9));
		ts.add(new Member2A("田中", 4));
		ts.add(new Member2A("佐藤", 6));
		ts.add(new Member2A("加藤", 1));
		for (Member2A m : ts) {
			System.out.println(m.id + ":" + m.name);
		}
	}
}

class Member2A implements Comparable<Member2A> {
	String name;
	int id;

	Member2A(String name, int id) {
		this.name = name;
		this.id = id;
	}

	@Override
	public int compareTo(Member2A o) {
		return (id - o.id);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Member2A) {
			return (id == ((Member2A) o).id);
		}
		return (false);
	}
}
