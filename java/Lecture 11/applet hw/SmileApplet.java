import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

//<applet code="SmileApplet" width="1000" height="1000"></applet>

public class SmileApplet extends Applet
{
	

	public void paint(Graphics g)
	{
		g.setColor(Color.ORANGE);
		g.fillOval(100,100,800,800);

		g.setColor(Color.BLACK);
		g.fillOval(200,300,150,150);

		g.fillOval(650,300,150,150);

		g.setColor(Color.BLACK);

		for(int i=1;i<=180;++i)
		{
			g.drawArc(200,500,600,300,0,-i);


			try
			{
				Thread.sleep(50);
			}
			catch(InterruptedException e)
			{}
		}

	}
}