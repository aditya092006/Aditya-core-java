package mypack;

public class ImportPackage
{
	private String msg;
	private int num;

	public ImportPackage()
	{
		msg = "default msg";
		num = -1;
	}

	public ImportPackage(String msg,int num)
	{
		this.msg = msg;
		this.num = num;
	}

	public void display()
	{
		System.out.println("Msg : "+msg);
		System.out.println("num : "+num);
	}
}