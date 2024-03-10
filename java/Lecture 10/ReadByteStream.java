import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

class ReadByteStream
{
	public static void main(String[] args) {
		File f = new File("File Created\\WriteOutput.am");
		FileInputStream inStream = null;

		try
		{
			inStream = new FileInputStream(f);
			int character;
			//int i=0;
			while((character = inStream.read())!=-1)
			{
				System.out.print((char)character);
				//++i;
			}
			//System.out.println("value of i : "+i);
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