package encode_scheme;

import java.awt.Color;
import java.awt.Graphics2D;

public class NRZ_I extends Encoder {

	public NRZ_I() {
		super("NRZ-I");
		// TODO Auto-generated constructor stub
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
	    g.setColor(Color.red);
	    int stateChange = y+depth;
        for(char i: data.toCharArray()) {
        	if(i == '0') {
        		g.drawLine(x, y-depth, x, y+depth);
        		if(stateChange == y-depth) {
        			stateChange = y+depth;
        		}
        		else {
        			stateChange = y-depth;
        		}
        	}
        	if(i=='0') {
        		g.drawLine(x,stateChange, x+width,stateChange);
        	}else if(i == '1') {
        		g.drawLine(x,stateChange, x+width,stateChange);
        	}
        	x+=width;
        }
	
	}
}
