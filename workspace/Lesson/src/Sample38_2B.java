import java.util.HashSet;

public class Sample38_2B {

	public static void main(String[] args) {
		HashSet<Member2B> ts = new HashSet<Member2B>();
		ts.add(new Member2B("山田", 9));
		ts.add(new Member2B("田中", 4));
		ts.add(new Member2B("佐藤", 6));
		ts.add(new Member2B("加藤", 1));
		for (Member2B m : ts) {
			System.out.println(m.id + ":" + m.name);
		}
		Member2B man = new Member2B("井上", 9);
		System.out.println(ts.contains(man));
	}
}

class Member2B implements Comparable<Member2B> {
	String name;
	int id;

	Member2B(String name, int id) {
		this.name = name;
		this.id = id;
	}

	@Override
	public int compareTo(Member2B o) {
		return (id - o.id);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Member2B) {
			return (id == ((Member2B) o).id);
		}
		return (false);
	}
}
