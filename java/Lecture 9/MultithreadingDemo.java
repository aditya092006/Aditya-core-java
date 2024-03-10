class Account
{
	private int accountNumber;
	private double balance;

	Account(int accountNumber,double balance)
	{
		this.accountNumber = accountNumber;
		this.balance =  balance;
	}
	synchronized void deposit(double amount)
	{
		System.out.println("Going to deposit : "+amount);
		System.out.println("Current balance : Rs "+balance);
		double tempbalance;
		tempbalance = balance+amount;
		try
		{
			Thread.sleep(50);
		}
		catch(InterruptedException e)
		{}
		balance = tempbalance;
		System.out.println("Balance after deposit "+balance);
		notifyAll();
		
	}

	synchronized void withdraw(double amount)
	{
		System.out.println("Going to withdraw "+amount);
		System.out.println("Balance before withdraw : "+balance);
		while(balance<amount)
		{
			System.out.println("Going to wait.....");
			try
			{
				wait();	
			}
			catch(InterruptedException e){}
			
		}
		double tempbalance;
		tempbalance = balance-amount;
		try
		{
			Thread.sleep(50);
		}
		catch(InterruptedException e){}
		balance = tempbalance;
		System.out.println("Balance after Withdrawal : "+balance);

	}
	void display()
	{
		System.out.println("Account number : "+accountNumber);
		System.out.println("Balance : "+balance);
	}
}

class WithdrawTask implements Runnable
{
	private Account account;
	private double amount;
	Thread t;

	WithdrawTask(Account account,double amount)
	{
		this.account = account;
		this.amount = amount;
		t = new Thread(this,"withdraw thread");
		t.start();
	}
	public void run()
	{
		account.withdraw(amount);
	}
}


class DepositTask implements Runnable
{
	private Account account;
	private double amount;
	Thread t;

	DepositTask(Account account,double amount)
	{
		this.account = account;
		this.amount = amount;
		t = new Thread(this,"Deposit thread");
		t.start();
	}
	public void run()
	{
		account.deposit(amount);
	}
}
class MultithreadingDemo
{
	public static void main(String[] args) {
		Account acc1 = new Account(1,10000);
		WithdrawTask t2 = new WithdrawTask(acc1,17000);
		WithdrawTask t3 = new WithdrawTask(acc1,17000);
		DepositTask t1 = new DepositTask(acc1,150000);
		WithdrawTask t4 = new WithdrawTask(acc1,17000);
		
		acc1.display();
	}
}