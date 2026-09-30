package chapter10_1;

public class AuditingStudent extends User 
	implements Attendable, Versionable 
{
	private int subjectId;
	
	public AuditingStudent
	(int id, String name, String mail,
			int role, int subjectId) 
	{
		super(id, name, mail, role);
		this.subjectId = subjectId;
	}
	
	public int getSubjectId() {
		return subjectId;
	}

	@Override
	public String Version() {
		String msg = "Student ver 1.0";
		return msg;
	}

	@Override
	public void writeAttendance() {
		System.out.println("聴講科目出席報告完了");

	}

	@Override
	public void readAttendance() {
		System.out.println("聴講科目出席情報読み込み完了");

	}

}
