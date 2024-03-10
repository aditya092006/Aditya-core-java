import java.io.BufferedReader;
import java.io.File;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileOutputStream;

class FileWriterByteStream
{
	public static void main(String[] args) {
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			File f = new File("File Created\\WriteOutput.am");

			FileOutputStream fout = new FileOutputStream(f,true);

			String inputLine = null;
			System.out.println("Enter content: when u type \"exit\" program ends");
			int i=0;
			while(!(inputLine = br.readLine()).equalsIgnoreCase("exit"))
			{
				byte b[] = inputLine.concat("\n").getBytes();
				// while(i!=b.length)
				// {
				// 	System.out.println(b[i]);
				// 	i++;
				// }
				// i=0;
				fout.write(b);
			}
			System.out.println("All content has been written");
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