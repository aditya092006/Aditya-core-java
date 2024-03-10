class Sample
{
	static int a;

	static
	{
		a = 10;
		System.out.println("Hey test "+ a);
	}
}
class Inherit extends Sample
{
	static int b;

	static
	{
		b = 20;
		{
			a = 30;
		}
		System.out.println("Am i be executed?? "+a+ " "+ b);
 	}
}
class Timepass
{
	public static void main(String[] args) {
		Inherit obj = new Inherit();
		
	}
}