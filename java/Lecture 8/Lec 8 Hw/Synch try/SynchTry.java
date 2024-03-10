class Prints
{
	private int i;
	private long t1=0;
	private long t2=1;

	void printOdd(int i)
	{
		if(i%2!=0)
		{
			System.out.println("Odd number : "+i);
		}
	}
	void printEven(int i)
	{
		if(i%2==0)
		{
			System.out.println("Even Number : "+i);
		}
	}
	void printPrime(int end)
	{
		for(int i=2;i<end;i++)
		{
			if(end%i==0)
			{
				return;
			}
		}
		System.out.println("Prime Number "+ end);
	}
	void printFibonacci()
	{
		long sum;
		sum = t1+t2;
		System.out.println("Fibbonacci Number : "+sum);
		t1=t2;
		t2=sum;

	}
}

class ImplementOddThread extends Prints implements Runnable
{
	//Prints target;
	Thread t;
	ImplementOddThread(Prints target)
	{
		//this.target = target;
		t = new Thread(this);
		t.start();

	}
	public void run()
	{
		for(int i =1;i<101;i++)
		{
			printOdd(i);
			try
			{
				Thread.sleep(250);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
class ImplementEvenThread extends Prints implements Runnable
{
	//Prints target;
	Thread t;
	ImplementEvenThread(Prints target)
	{
		//this.target = target;
		t = new Thread(this);
		t.start();

	}
	public void run()
	{
		for(int i =1;i<101;i++)
		{
			printEven(i);
			try
			{
				Thread.sleep(250);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
class ImplementPrimeThread extends Prints implements Runnable
{
	//Prints target;
	Thread t;
	ImplementPrimeThread(Prints target)
	{
		//this.target = target;
		t = new Thread(this);
		t.start();

	}
	public void run()
	{
		for(int i =2;i<101;i++)
		{
			printPrime(i);
			try
			{
				Thread.sleep(250);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
class ImplementFibonacciThread extends Prints implements Runnable
{
	//Prints target;
	Thread t;
	ImplementFibonacciThread(Prints target)
	{
		//this.target = target;
		t = new Thread(this);
		t.start();

	}
	public void run()
	{
		System.out.println("Fibbonacci Number : "+0);
		System.out.println("Fibbonacci Number : "+1);
		
		synchronized((super.))
		{
			for(int i =2;i<50;i++)
			{
				printFibonacci();
				try
				{
					Thread.sleep(250);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}


class SynchTry
{
	public static void main(String[] args) {
		Prints obj = new Prints();
		new ImplementOddThread(obj);
		new ImplementEvenThread(obj);
		new ImplementPrimeThread(obj);
		new ImplementFibonacciThread(obj);
	}
}
