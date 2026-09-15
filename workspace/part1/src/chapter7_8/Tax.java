package chapter7_8;
//ﾌｨｰﾙﾄﾞにｵﾌﾞｼﾞｪｸﾄ(参照型変数)を持つイミュータブルなクラス
import java.util.Objects;

import part1.Id;

public final class Tax {
	private final Id id;
	private final int shotoku;
	private final int koujo;

	public Tax
	(Id id, int shotoku, int koujo)
	{
//		this.id = id;←この書き方では書き換えが可能になってしまう。
//		↓コピーを代入するように書き換えたもの。
		this.id = new Id(id.getNumber(), id.getName());
		this.shotoku = shotoku;
		this.koujo = koujo;
	}
	public Id getId() {
//		return id;↓ここもidをそのまま返すのでなく、コピーを返す。
		return new Id(id.getNumber(), id.getName());
	}
	public int getShotoku() {
		return shotoku;
	}
	public int getKoujo() {
		return koujo;
	}
	
	public int zeigaku() {
//		this.number = 10;←これをするとエラーになる。
//		ｺﾝｽﾄﾗｸﾀの中でのみかつ１度のみ初期値がセットできる。
		return (int)((this.shotoku - this.koujo)*0.1);
	}
	@Override
	public String toString() {
		return "Tax [id=" + id + ", shotoku=" + shotoku + ", koujo=" + koujo + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(this.id.getNumber()));
	}

	public static void main(String[] args) {
		Id id = new Id(100, "田中宏");
		Tax tax = new Tax(id, 300000, 100000);
		System.out.println(tax);
		System.out.println(tax.hashCode());
		tax.getId().setNumber(200);
//		tax.id.setNumber(200);クラスと同じﾌｧｲﾙならこの書き方もOK
//		■コピー渡しに変更後
//		このコードのセッターはどこに値を入れたの？
//		tax.getId().setNumber(200);
//		この1行が実行されたとき、裏では次のことが起きています。
//		tax.getId() が呼ばれる ➔ **新しい一時的な Id オブジェクト（コピー）
//		**がヒープ領域に作られて返される。
//		.setNumber(200) が呼ばれる ➔ その一時的なコピーの number が
//		200 に書き換わる。
//		処理が終わる ➔ この一時的なコピーは変数に代入されていないため
//		、誰からも参照されない宙ぶらりんの状態になり、直後に
//		Javaのガベージコレクションによって消去される。
		System.out.println(tax);
		System.out.println(tax.hashCode());
	}
}
//Tax [id=Id [number=100, name=田中宏], shotoku=300000, koujo=100000]
//131
//Tax [id=Id [number=200, name=田中宏], shotoku=300000, koujo=100000]
//231

//↓idのコピーを渡すように変えたコードの実行結果
//Tax [id=Id [number=100, name=田中宏], shotoku=300000, koujo=100000]
//131
//Tax [id=Id [number=100, name=田中宏], shotoku=300000, koujo=100000]
//131











