interface Shape
{
	float PI = 3.14F;
	void area();
}

class Circle implements Shape
{
	int raidus;
	Circle(int raidus)
	{
		this.raidus = raidus;
	}

	public void area()
	{
		System.out.println("Area = "+ (Shape.PI*raidus*raidus));
	}
}

class InterfaceVariable
{
	public static void main(String[] args) {
		new Circle(10).area();
	}
}