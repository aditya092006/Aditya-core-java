import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class FileWriterCharacterStream
{
	public static void main(String[] args) {
		
	
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			File f = new File("File Created\\CharacterOutputWriter.txt");
			PrintWriter fout = new PrintWriter(f);
			String inputLine = "";
			System.out.println("Enter Content till exit");

			while(!(inputLine = br.readLine()).equalsIgnoreCase("exit"))
			{
				fout.println(inputLine);
			}
			fout.close();
			System.out.println("All content written");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}