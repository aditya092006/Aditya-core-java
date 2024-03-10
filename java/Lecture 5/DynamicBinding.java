class A
{
	int a=100;
	void show()
	{
		System.out.println("I am class A= "+a);
	}
}
class B extends A
{
	int b = 200;
	void show()
	{
		System.out.println("I am class B = "+b);
	}
	void bKaMethod()
	{
		System.out.println("I am b! not overridden");
	}
}
class C extends B
{
	int c = 300;
	void show()
	{
		System.out.println("C is c = "+c);

	}
	void cKaMethod()
	{
		System.out.println("Yeh C ka Method");
	}
}

class DynamicBinding
{
	public static void main(String[] args) {
		A a;
		B b = new B();
		a = b;
		a.show();

		C c = new C();
		a = c;
		a.show();

		b = c;
		b.show();
		b.bKaMethod();
	}
}