class ThrowDemo
{
	static int divide(int num1,int num2)throws ArithmeticException
	{
		int result;
		try
		{
			result = num1/num2;
			return result;
		}
		catch(ArithmeticException e)
		{
			System.out.println("cannot divide by zero");
			throw e;
		}
	}
	public static void main(String[] args) {
		int a=12;
		int b=args.length;
		int res;

		try
		{
			res=divide(a,b);
			System.out.println("Result = "+ res);

		}
		catch(ArithmeticException e)
		{
			System.out.println("Recaught in main.......");
		}
		System.out.println("Last line of main bbye");
	}
}