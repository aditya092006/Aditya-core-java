class Box
{
	private double width,height,depth;

	void set(double w,double h,double d)
	{
		width = w;
		height = h;
		depth = d;
	}
	void display()
	{
		System.out.println("Width = "+ width);
		System.out.println("Height = "+ height);
		System.out.println("Depth = "+ depth);

	}
	double volume()
	{
		return width*height*depth;
	}
	
}

class BoxWeight extends Box
{
	private double weight;

	void set(double width,double height, double depth,double weight)
	{
		this.set(width,height,depth);
		this.weight = weight;
	}
	void show()
	{
		display();
		System.out.println("weight = "+ weight);
		System.out.println("volume = "+ volume());
	}

}

class BoxInheritance
{
	public static void main(String[] args) {
		BoxWeight d1 = new BoxWeight();
		BoxWeight d2 = new BoxWeight();
		d1.set(10,20,30,40);
		d2.set(1,2,3,4);
		d1.show();
		d2.show();
	}
}