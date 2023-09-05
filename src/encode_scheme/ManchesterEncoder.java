package encode_scheme;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * 
 * @author Dr. Sunirmal Khatua
 *
 */
public class ManchesterEncoder extends Encoder{
	
	public ManchesterEncoder() {
		super("Manchester Encoding");
	}

	public void encode(Graphics2D g, String data) {
		super.encode(g, data);
		int x = 230; 
	    int y = 180; 
	    int width = (450/data.length()); 
	    g.drawString("Encoded by "+name+" scheme",810,y);
	    for(char i: data.toCharArray()) {
	    	g.drawString(i+"",x+width/2,y-30);
	    	x+=width;
	    }
	    x = 230;
	    g.setColor(Color.green);
	    char prev = 'p';
        for(char i: data.toCharArray()) {
        	if(prev == i) {
        		g.drawLine(x, y-depth, x, y+depth);
        	}
        	if(i=='0') {
				g.drawLine(x, y-depth, x+(width/2), y-depth);
				g.drawLine(x+(width/2), y-depth, x+(width/2), y+depth);
				g.drawLine(x+(width/2), y+depth, x+width, y+depth);
        	}else if(i == '1') {
        		g.drawLine(x, y+depth, x+(width/2), y+depth);
				g.drawLine(x+(width/2), y+depth, x+(width/2), y-depth);
				g.drawLine(x+(width/2), y-depth, x+width, y-depth);
        	}
        	x+=width;
        	prev = i;
        }

	}

}
