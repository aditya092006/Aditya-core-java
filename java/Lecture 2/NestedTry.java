class NestedTry
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
			System.out.println("going in inner try");

			
			try
			{
				if(num2==1)
				{
					num1 = num1/(num2-num2);
				}
				else
				{
					int c[] = {10,20,30};
					c[num2] = 190;
				}
				System.out.println("last line of inner try");
			}
			catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Andha h kya bhai?");
			}
		}
		catch(ArithmeticException e)
		{
			System.out.println("cannot divide by zero");
		}

		System.out.println("last lineof main..... bye bye");
	}
}