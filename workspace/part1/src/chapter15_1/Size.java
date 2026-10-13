package chapter15_1;

//public enum Size {SMALL, MEDIUM, LARGE}

////裏側のイメージ（実際にはコンパイラが自動生成）
//public final class Size extends java.lang.Enum<Size> {
//
// // ① static final なインスタンス定数として3つだけ生成！
// public static final Size SMALL  = new Size("SMALL", 0);
// public static final Size MEDIUM = new Size("MEDIUM", 1);
// public static final Size LARGE  = new Size("LARGE", 2);
//
// // ② コンストラクタは private に固定（外部から new させない）
// private Size(String name, int ordinal) {
//     super(name, ordinal); // 名前と番号（0, 1, 2）を保持
// }
//}