package chapter19_2;

public class CookingRoom {
	
	private boolean flag;
	private String dish;
	
	public 
//	synchronized 
	void cooksJob(String dish)
	{
		while(flag) 
		{
			try 
			{
				wait();
			}
			catch (Exception e)
			{
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		this.dish = dish;
		flag = true;
		notifyAll();
	}
	
	public 
//	synchronized 
	String waitersJob()
	{
		while(!flag) 
		{
			try 
			{
				wait();
			}
			catch (Exception e)
			{
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		flag = false;
		notifyAll();
		return dish;
	}
}
