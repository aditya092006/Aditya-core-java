class ExceptionHandling
{
	public static void main(String args[])
	{
		int num1=12;
		int num2 = args.length;
		
		try
		{
			int result = num1/num2;
			System.out.println("Divison of"+num1 + "and" + num2 + "=" + result);
		}
		catch(ArithmeticException e)
		{
			System.out.println("cannot divide by zero");
		}
		System.out.println("last lineof main..... bye bye");
	}
}