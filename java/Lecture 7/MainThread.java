class MyThread extends Thread
{
	private String threadName;
	MyThread(String threadName)
	{
		this.threadName = threadName;
		start();
	}

	public void run()
	{
		for(int i=1;i<11;i++)
		{
			System.out.println(threadName+ " : "+i);
		}
		try
		{
			Thread.sleep(250);
		}
		catch(InterruptedException e)
		{
			System.out.println("My Thread");
		}
	}
}

public class MainThread extends Thread
{
	public static void main(String[] args) {
		System.out.println("Inside main");
		new MyThread("Thread 1");

		for(int i=10;i>=1;i--)
		{
			System.out.println("Main Thread "+ i);
		}
		try
		{
			Thread.sleep(250);
		}
		catch(InterruptedException e)
		{
			System.out.println("CAUGHT IN MAIN");
		}
	}
}