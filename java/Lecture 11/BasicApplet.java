import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

// <applet code= "BasicApplet" width="400" height="800"></applet>

public class BasicApplet extends Applet
{
	final static int GREEN_TIME = 60;
	final static int ORANGE_TIME = 5;
	final static int RED_TIME = 30;
	
	public void paint(Graphics g)
	{
		g.fillRect(140,40,120,340);
		g.fillRect(180,380,40,100);

		g.setColor(Color.RED);
		g.fillOval(150,50,100,100);


		g.setColor(Color.ORANGE);
		g.fillOval(150,160,100,100);


		g.setColor(Color.GREEN);
		g.fillOval(150,270,100,100);

		int green_counter = GREEN_TIME;
		int red_counter = RED_TIME;
		int orange_counter = ORANGE_TIME;
		int counter = GREEN_TIME + RED_TIME + ORANGE_TIME;

		g.setFont(new Font("Arial",Font.BOLD,28));

		while(true)
		{
			counter--;
			System.out.println(counter);

			if(counter>=35)
			{
				g.setColor(Color.WHITE);
				g.fillRect(180,0,60,40);
				g.setColor(Color.BLACK);
				g.drawString(""+green_counter,190,25);

				green_counter--;

				g.fillOval(150,50,100,100);
				g.fillOval(150,160,100,100);

				g.setColor(Color.GREEN);
				g.fillOval(150,270,100,100);


			}

			else if(counter>=30)
			{
				g.setColor(Color.WHITE);
				g.fillRect(180,0,60,40);
				g.setColor(Color.BLACK);
				g.drawString(""+orange_counter,190,25);

				orange_counter--;

				g.fillOval(150,50,100,100);
				
				g.fillOval(150,270,100,100);
				g.setColor(Color.ORANGE);
				g.fillOval(150,160,100,100);


			}

			else if(counter>=0)
			{
				g.setColor(Color.WHITE);
				g.fillRect(180,0,60,40);
				g.setColor(Color.BLACK);
				g.drawString(""+red_counter,190,25);

				red_counter--;

				g.fillOval(150,160,100,100);
				g.fillOval(150,270,100,100);

				g.setColor(Color.RED);
				
				g.fillOval(150,50,100,100);

				if(counter==0)
				{
					green_counter = GREEN_TIME;
					red_counter = RED_TIME;
					orange_counter = ORANGE_TIME;
					counter = GREEN_TIME+RED_TIME+ORANGE_TIME;
				}

			}

			try
			{
				Thread.sleep(250);
			}

			catch(InterruptedException e){}


		}

	}	
}
