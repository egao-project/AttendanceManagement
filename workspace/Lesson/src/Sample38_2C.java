import java.util.HashSet;

public class Sample38_2C {

	public static void main(String[] args) {
		HashSet<Member2C> ts = new HashSet<Member2C>();
		ts.add(new Member2C("山田", 9));
		ts.add(new Member2C("田中", 4));
		ts.add(new Member2C("佐藤", 6));
		ts.add(new Member2C("加藤", 1));
		for (Member2C m : ts) {
			System.out.println(m.id + ":" + m.name);
		}
		Member2C man = new Member2C("井上", 9);
		System.out.println(ts.contains(man));
	}
}

class Member2C implements Comparable<Member2C> {
	String name;
	int id;

	Member2C(String name, int id) {
		this.name = name;
		this.id = id;
	}

	@Override
	public int compareTo(Member2C o) {
		return (id - o.id);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Member2C) {
			return (id == ((Member2C) o).id);
		}
		return (false);
	}

	@Override
	public int hashCode() {
		return (id);
	}
}