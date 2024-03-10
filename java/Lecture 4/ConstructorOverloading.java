class Sample
{
	Sample()
	{
		System.out.println("I am default constructor");
	}
	Sample(int a)
	{
		System.out.println("I am paramertized int "+ a);
	}
	Sample(String a)
	{
		System.out.println("I am paramertized String "+ a);
	}
	Sample(float a)
	{
		System.out.println("I am paramertized float "+ a);
	}
}

class ConstructorOverloading
{
	public static void main(String[] args) {
		Sample s1 = new Sample();
		Sample s2 = new Sample(10);
		Sample s3 = new Sample("I AM THE BEAST");
		Sample s4 = new Sample((float)14.75);
		Sample s5 = new Sample(10.25F);
		
		
	}
}