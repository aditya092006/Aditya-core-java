class CallMe
{
	public /*synchronized*/ void call(String msg)
	{
		System.out.print("["+msg);
		try
		{
			Thread.sleep(500);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("]");
	}
}
class Caller implements Runnable
{
	String msg;
	CallMe target;
	Thread t;

	Caller(CallMe target,String msg)
	{
		this.target = target;
		this.msg = msg;
		t = new Thread(this);
		t.start();
	}

	public void run()
	{
		synchronized(target)
		{
			target.call(msg);
		}
	}
}

public class SynchDemo
{
	public static void main(String[] args) {
		CallMe c = new CallMe();
		CallMe c1 = new CallMe();

		Caller caller1 = new Caller(c,"Hello");
		Caller caller2 = new Caller(c,"Synchronized");
		Caller caller3 = new Caller(c,"World");
	}
}