package chapter10_1;
//インターフェース。
//継承関係の無いオブジェクト同士の規格化された共通機能

public interface Attendable {
	void writeAttendance();
	void readAttendance();
//	自動的に public,abstructになる。
	
}
