class Box
{
	private int width,height,depth;

	void set(int w,int h, int d)
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
	int volume()
	{
		return width*height*depth;
	}
	
}
class BoxDemo
{
	public static void main(String[] args) {
		Box b1 = new Box();
		Box b2 = new Box();

		b1.set(10,20,30);
		b2.set(1,2,3);
		b1.display();
		int vol = b1.volume();
		System.out.println("volume = "+vol);
		System.out.println("values of box2");
		b2.display();
		System.out.println("volume = "+ b2.volume());
	}
}
