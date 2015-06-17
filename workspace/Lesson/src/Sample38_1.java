import java.util.Comparator;
import java.util.TreeSet;

public class Sample38_1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		// TreeSet ts = new TreeSet(); 実行時に例外
		TreeSet ts = new TreeSet(new MemberSort());
		ts.add(new Member("山田", 9));
		ts.add(new Member("田中", 4));
		ts.add(new Member("佐藤", 6));
		ts.add(new Member("加藤", 1));
		for (Object obj : ts) {
			Member m = (Member) obj;
			System.out.println(m.id + ":" + m.name);
		}
	}
}

// idの昇順にソート
class MemberSort implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		return (((Member) o1).id - ((Member) o2).id);
	}
}

class Member {
	String name;
	int id;

	Member(String name, int id) {
		this.name = name;
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Member) {
			return (id == ((Member) o).id);
		}
		return (false);
	}
}
