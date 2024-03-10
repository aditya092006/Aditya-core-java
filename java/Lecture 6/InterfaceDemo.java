interface A
{
	void method1();
}
interface B extends A
{
	void method2();
}
interface C extends B
{
	void method3();
}
class ImplementInterface implements C 
{
	public void method1()
	{
		System.out.println("Hello from method 1");
	}
	public void method2()
	{
		System.out.println("Hello from method 2");
	}
	public void method3()
	{
		System.out.println("Hello from method 3");
	}
	void myOwnMethod()
	{
		System.out.println("My own method :> ");
	}
}
class InterfaceDemo
{
	public static void main(String[] args) {
		
		ImplementInterface obj = new ImplementInterface();

		A refA;
		refA = obj;
		refA.method1();
		C refC;
		refC = obj;
		refC.method1();
		refC.method2();
		refC.method3();

		obj.method1();
		obj.method2();
		obj.method3();
		obj.myOwnMethod();
	}
}