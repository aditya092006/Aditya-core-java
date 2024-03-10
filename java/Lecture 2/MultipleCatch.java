class MultipleCatch
{
	public static void main(String args[])
	{
		int num1 = 12;
		int num2 = args.length;
		System.out.println("Going to block");
		try
		{
			int result = num1/num2;
			System.out.println("Divison of"+num1 + "and" + num2 + "=" + result);
			int c[] = {10,20,30};
			c[num2] = 190;
			System.out.println("Last kune of try...");
		}
		catch(ArithmeticException e)
		{
			System.out.println("cannot divide by zero");
			//e.printStackTrace();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Andha h kya bhai?");
		}
		System.out.println("last lineof main..... bye bye");
	}
}