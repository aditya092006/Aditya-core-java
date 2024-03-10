class FinallyDemo
{
	static void method()
	{
		try
		{
			System.out.println("Inside method()");
			return;
		}
		finally
		{
			System.out.println("Inside of fianlly");

		}

	}
	public static void main(String args[])
	{
		int num1 = 12;
		int num2 = args.length;
		System.out.println("Going to block");
		try
		{
			int result = num1/num2;
			System.out.println("Divison of"+num1 + "and" + num2 + "=" + result);
			System.out.println("going in inner try");
			int c[] = {10,20,30};
			method();
			c[num2] = 190;
			System.out.println("last line of inner try");
		}
		catch(ArithmeticException e)
		{
			System.out.println("cannot divide by zero");
		}
		finally
		{
			System.out.println("Inside of main()");
		}

		System.out.println("last lineof main..... bye bye");
	}
}