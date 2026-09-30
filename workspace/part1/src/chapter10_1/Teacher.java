package chapter10_1;

public class Teacher extends User
	implements Versionable
{
	
	private String url;
	public Teacher
	(int id, String name, String mail, int role, String url) 
	{
		super(id, name, mail, role);
		this.url = url;
	}
	public String getUrl() {
		return url;
	}
	@Override
	public String Version() {
		String msg = "Teacher ver 1.0";
		return msg;
	}
	
}
