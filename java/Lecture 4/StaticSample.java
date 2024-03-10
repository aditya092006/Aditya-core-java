class StaticClass
{
	static int a = 3;
	static int b;

	static
	{
		System.out.println("Inside static block");
		b = a*4;
	}
	{
		System.out.println("Will i ever be executed??");
	}
	static void set(int x)
	{
		System.out.println("x = "+x);
		System.out.println("a = "+a);
		System.out.println("b = "+b);
	}
}


class StaticSample
{
	public static void main(String[] args) {
		System.out.println("Inside main");
		StaticClass obj1 = new StaticClass();
		StaticClass obj2 = new StaticClass();
		StaticClass obj3 = new StaticClass();

		StaticClass.set(200);
		obj1.a = 78;
		obj2.b = obj3.a+5;
		StaticClass.a=10;
		obj3.set(15);
		obj1.a = obj2.b+obj3.a;
		StaticClass.set(1);
		obj3.a=1;
		obj1.b=1;
		StaticClass.set(100);
	}
}