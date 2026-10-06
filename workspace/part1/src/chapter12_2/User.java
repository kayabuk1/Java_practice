package chapter12_2;

import java.util.HashSet;
import java.util.Objects;

public record User(String id, String name) {
	
//	RecordでhasCode()やequals()を生成しようとすると
//	レコードではすでにそれらが自動生成されているので、
//	それらに上書きすることになりますが良いですか？
//	というメッセージが出るが構わずOKを押す。

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		 if (obj instanceof User other) {
			 return  Objects.equals(this.id, other.id);
//			 Objects.equals(a, b) は、
//			 java.util.Objects クラスの static メソッド
		}
		 return false;
	}

	public static void main(String[] args) {
		var set = new HashSet<User>();
		set.add(new User("ab123","田中宏"));
		set.add(new User("ab224","佐藤修"));
		set.add(new User("ab224","佐藤おさむ"));
		set.add(new User("ab123","佐藤修"));
//		Meiboレコードオブジェクトのequalsメソッドによって、
//		同じものと判定されると、setには追加されない。
		
		set.forEach(System.out::println);
	}
}
