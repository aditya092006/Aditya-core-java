package p2;
class OtherPackage
{
	OtherPackage()
	{
		System.out.println("Other package");
		p1.Protection p = new p1.Protection();
		System.out.println("pub_n = "+p.pub_n);
	}
}