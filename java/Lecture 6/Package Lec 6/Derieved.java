package p1;

class Derieved extends Protection
{
	Derieved()
	{
		System.out.println("Inside Derieved");
		//System.out.println("pri_n = "+pri_n); // error cuz private no acess
		System.out.println("n = "+n);
		System.out.println("pro_n = "+pro_n);
		System.out.println("pub_n = "+pub_n);
	}
}