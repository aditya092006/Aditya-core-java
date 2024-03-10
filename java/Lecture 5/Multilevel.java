class A
{
	A()
	{
		System.out.println("Inside a class");
	}
}
class B extends A
{
	B()
	{
		System.out.println("Inside b class");
	}
}

class C extends B
{
	C()
	{
		System.out.println("Inside c class");
	}
}
class Multilevel
{
	public static void main(String[] args) {
		new C();
		new B();
		new A();
	}
}