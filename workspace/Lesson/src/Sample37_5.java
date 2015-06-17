public class Sample37_5 {

	Box3<String> obj1 = new Box3<String>("abc");
	Box3 obj2 = obj1; 		  // ok
	Box3<String> obj3 = obj1; // ok 同じString
	Box3<Object> obj4 = obj1; // NG(型が異なる) obj1は<String>
	Box3<Object> obj5 = obj2; // ok obj2はObject型
}

class Box3<T> {
	public Box3(T obj) {
	}
}