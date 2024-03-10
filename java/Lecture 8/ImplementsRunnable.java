class MeraRunnable implements Runnable
{

	MeraRunnable()
	{
		Thread t;
		t = new Thread(this);
		t.start();
	}
	public void run()
	{
		for(int i = 0;i<11;i++)
		{
			System.out.println("Mera Runnable : "+i);
			try
			{
				Thread.sleep(250);
			}
			catch(InterruptedException e)
			{
				System.out.println("Caught");
			}
		}
	}
}

public class ImplementsRunnable
{
	public static void main(String[] args) {
		new MeraRunnable();
		for(int i = 0;i<11;i++)
		{

			System.out.println("Main : "+i);
			try
			{
				Thread.sleep(250);
			}
			catch(InterruptedException e)
			{
				System.out.println("Caught");
			}
		}
	}
}