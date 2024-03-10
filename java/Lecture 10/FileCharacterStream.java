import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileNotFoundException;

class FileCharacterStream
{
	public static void main(String[] args) {
		File f = new File("File Created\\Sample.txt");
		FileInputStream inStream = null;
		BufferedReader brFile = null;
		try
		{
			inStream = new FileInputStream(f);
			brFile = new BufferedReader(new InputStreamReader(inStream));

			String line = null;
			while((line = brFile.readLine())!=null)
			{
				System.out.println(line);
			}
		} 
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(inStream!=null)
				{
					inStream.close();
				}
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}