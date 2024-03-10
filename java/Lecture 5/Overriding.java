class A
{
	int num;

	void show()
	{
		System.out.println("A class a = "+num);
	}
}

class B extends A {
	int num;
	void set(int num1,int num2)
	{
		this.num = num1;
		super.num = num2;
	}

	void show()
	{
		System.out.println("B's num = "+num);
		super.show();
	}

}

class Overriding
{
	public static void main(String[] args) {
		B obj = new B();
		obj.set(10,20);
		obj.show();
	}
}