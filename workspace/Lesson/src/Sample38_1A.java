import java.util.Comparator;
import java.util.TreeSet;

public class Sample38_1A {

	public static void main(String[] args) {
		// TreeSet<Member1> ts = new TreeSet<Member>(); 実行時に例外
		
		TreeSet<Member1> ts = new TreeSet<Member1>(new MemberSort1());
		ts.add(new Member1("山田", 9));
		ts.add(new Member1("田中", 4));
		ts.add(new Member1("佐藤", 6));
		ts.add(new Member1("加藤", 1));
		for (Member1 m : ts) {
			System.out.println(m.id + ":" + m.name);
		}
	}
}

// idの昇順にソート
class MemberSort1 implements Comparator<Member1> {
	@Override
	public int compare(Member1 o1, Member1 o2) {
		return (o1.id - o2.id);
	}
}

class Member1 {
	String name;
	int id;

	Member1(String name, int id) {
		this.name = name;
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Member1) {
			return (id == ((Member1) o).id);
		}
		return (false);
	}
}
