abstract class Shape
{
	private int side1,side2;

	Shape(int side1,int side2)
	{
		this.side1 = side1;
		this.side2 = side2;
	}

	Shape(int side)
	{
		this.side1 = this.side2 = side;
	}

	int getSide1()
	{
		return side1;
	}
	int getSide2()
	{
		return side2;
	}

	abstract void area();
	abstract void perimeter();
}
class Rectangle extends Shape
{
	Rectangle(int s1,int s2)
	{
		super(s1,s2);
	}
	void area()
	{
		int a = getSide1() * getSide2();
		System.out.println("Area : "+a);
	}

	void perimeter()
	{
		int p = 2*getSide1() + 2*getSide2();
		System.out.println("Permimeter is : "+p);
	}
}
class Square extends Shape
{
	Square(int s)
	{
		super(s);
	}
	void area()
	{
		int a = getSide1() * getSide2();
		System.out.println("Area : "+a);
	}

	void perimeter()
	{
		int p = 4*getSide1();
		System.out.println("Permimeter is : "+p);
	}

}

class AbstractDemo
{
	public static void main(String[] args) {
		Shape s;
		Rectangle r = new Rectangle(10,20);
		s = r;
		s.area();
		s.perimeter();

		Square sq = new Square(10);
		s = sq;
		s.area();
		s.perimeter();

	}
}