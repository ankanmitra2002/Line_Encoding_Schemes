package encode_scheme;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * 
 * @author Dr. Sunirmal Khatua
 *
 */
public abstract class Encoder {
	
	String name;
	static int depth = 10;
	public Encoder(String name) {
		this.name = name;
	}
	
	public void encode(Graphics2D g, String data) {
		g.setBackground(Color.WHITE);
		g.clearRect(0, 0, 1000, 1000);
		g.drawString(data, 120,90);
		Image i = new ImageIcon("computer.jpg").getImage();
		g.drawImage(i,100,100,100,100,null);
		g.drawImage(i,700,100,100,100,null);
		g.drawLine(150, 180, 750, 180);
		int n=data.length();
		int x=230;
		int width = (450/data.length()); 
		for(int j = 0 ; j<=n;j++){
			g.drawLine(x,150,x,200);
			x+=width;
		}
	}

}
