import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TypeInputsInJava
{
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try
		{
			System.out.print("Enter your name : ");
			String name = br.readLine();
			System.out.print("Enter age : ");
			int age = Integer.parseInt(br.readLine());
			System.out.print("Enter percentage : ");
			float perc = Float.parseFloat(br.readLine());

			System.out.println("Name : "+name);

			System.out.println("age : "+age);

			System.out.println("percentage : "+perc);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			System.out.println("Kuch bhi karta h");
		}
		
	}
}