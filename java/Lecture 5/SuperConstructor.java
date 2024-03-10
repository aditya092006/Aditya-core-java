class Box
{
	private double width,height,depth;

	Box(double w,double h,double d)
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

	BoxWeight(double width,double height, double depth,double weight)
	{
		super(width,height,depth);
		this.weight = weight;
	}
	void show()
	{
		display();
		System.out.println("weight = "+ weight);
		System.out.println("volume = "+ volume());
	}

}
class SuperConstructor
{
	public static void main(String[] args) {
		BoxWeight bw = new BoxWeight(10,20,30,40);
		System.out.println("Volume of Bw = "+bw.volume());
	}
}