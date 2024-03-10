package p1;

class SamePackage
{
	SamePackage()
	{
		System.out.println("Inside SamePackage");
		Protection p = new Protection();
		//System.out.println("pri_n = "+p.pri_n);
		//System.out.println("n = "+p.n);
		System.out.println("pro_n = "+p.pro_n);
		System.out.println("pub_n = "+p.pub_n);
	}
}