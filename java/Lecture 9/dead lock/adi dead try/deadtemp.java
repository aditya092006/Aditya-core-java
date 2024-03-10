class ImplementDeadLock
{
	int method1(int flag)
	{
		if(flag==0)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				System.out.println("Exception occured?");
			}
		}
		else
		{
			method2(0);
		}
		return 100;
	}
	int method2(int flag)
	{
		if(flag==0)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				System.out.println("Exception occured?");
			}
		}
		else
		{
			method1(0);
		}
		return 200;
	}
	
}
class ImplementMethod1 implements Runnable
{
	ImplementDeadLock target;
	ImplementMethod1(ImplementDeadLock target)
	{
		this.target = target;
		Thread t = new Thread(this);
		t.start();
	}
	public void run()
	{
		System.out.println(target.method1(1));
	}
}
class ImplementMethod2 implements Runnable
{
	ImplementDeadLock target;
	ImplementMethod2(ImplementDeadLock target)
	{
		this.target = target;
		Thread t = new Thread(this);
		t.start();
	}
	public void run()
	{
		System.out.println(target.method2(1));
	}
}
class DeadLock
{
	public static void main(String[] args) {
		ImplementDeadLock obj = new ImplementDeadLock();
		new ImplementMethod1(obj);
		new ImplementMethod2(obj);
	}
}