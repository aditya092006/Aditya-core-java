package t1;

class Time implements A,B,t2.D
{
	public void methodA()
	{
		System.out.println("Method A sucess");
	}
	public void methodB()
	{
		System.out.println("Method B sucess");
	}
	public void methodC()
	{
		System.out.println("Method C sucess");
	}
	public void methodD()
	{
		System.out.println("Method D sucess");
	}
}
class Test 
{
	public static void main(String[] args) {
		
		Time obj = new Time();
		obj.methodA();
		obj.methodB();
		obj.methodC();
		obj.methodD();
	}
}