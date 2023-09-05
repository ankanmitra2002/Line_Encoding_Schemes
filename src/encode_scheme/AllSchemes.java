package encode_scheme;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class AllSchemes extends Encoder{

	public AllSchemes() {
		super("All Schemes");
		// TODO Auto-generated constructor stub
	}
	public void encode(Graphics2D g, String data) {
		g.setBackground(Color.WHITE);
		g.clearRect(0, 0, 1000, 1000);
		g.drawString(data, 120,90);
		 //NRZ-I
		Image img = new ImageIcon("computer.jpg").getImage();
		g.drawImage(img,100,100,100,100,null);
		g.drawImage(img,700,100,100,100,null);
		g.drawLine(150, 150, 750, 150);
		int n=data.length();
		int x=230;
		int y = 150; 
		int width = (450/data.length()); 
		for(int j = 0 ; j<=n;j++){
			g.drawLine(x,150,x,800);
			x+=width;
		}
		x = 230;
		 for(char i: data.toCharArray()) {
		    	g.drawString(i+"",x+width/2,y-30);
		    	x+=width;
		    }
		 g.drawString("Encoded by NRZ-I scheme",810,y);
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
	        //NRZ-L
	        g.setColor(Color.black);
	        g.drawImage(img,100,200,100,100,null);
			g.drawImage(img,700,200,100,100,null);
			g.drawLine(150, 250, 750, 250);
	         x = 230; 
	         y = 250; 
		    char prev = 'p';
		    g.drawString("Encoded by NRZ-L scheme",810,y);
		    for(char i: data.toCharArray()) {
		    	g.drawString(i+"",x+width/2,y-30);
		    	x+=width;
		    }
		    x = 230;
		    g.setColor(Color.blue);
	        for(char i: data.toCharArray()) {
	        	if(prev!='p' &&  prev != i) {
	        		g.drawLine(x, y-depth, x, y+depth);
	        	}
	        	if (prev=='p' &&  i=='1') {
	        		g.drawLine(x, y-depth, x, y+depth);
	        	}
	        	if(i=='0') {
	        		g.drawLine(x, y+depth, x+width, y+depth);
	        	}else if(i == '1') {
	        		g.drawLine(x, y-depth, x+width, y-depth);
	        	}
	        	x+=width;
	        	prev = i;
	        }
	        //RZ
	        g.setColor(Color.black);
	        g.drawImage(img,100,300,100,100,null);
			g.drawImage(img,700,300,100,100,null);
			g.drawLine(150, 350, 750, 350);
	        x = 230; 
		    y = 350; 
		    g.drawString("Encoded by RZ scheme",810,y);
		    for(char i: data.toCharArray()) {
		    	g.drawString(i+"",x+width/2,y-30);
		    	x+=width;
		    }
		    x = 230;
		    g.setColor(Color.darkGray);
	        for(char i: data.toCharArray()) {
	        	 if(i == '0'){
	                 g.drawLine(x, y, x, y+depth);
	                 g.drawLine(x, y+depth, x+(width/2), y+depth);
	                 g.drawLine(x+(width/2), y+depth, x+(width/2), y);
	                 g.drawLine(x+(width/2), y, x+width, y);
	                 x+=width;
	             } else if (i == '1'){
	                 g.drawLine(x, y, x, y-depth);
	                 g.drawLine(x, y-depth, x+(width/2), y-depth);
	                 g.drawLine(x+(width/2), y-depth, x+(width/2), y);
	                 g.drawLine(x+(width/2), y, x+width, y);
	                 x+=width;
	             }
	        }
	        //ME
	        g.setColor(Color.black);
	        g.drawImage(img,100,400,100,100,null);
			g.drawImage(img,700,400,100,100,null);
			g.drawLine(150, 450, 750, 450);
	        x = 230; 
		    y = 450; 
		    g.drawString("Encoded by Manchester Encoding scheme",810,y);
		    for(char i: data.toCharArray()) {
		    	g.drawString(i+"",x+width/2,y-30);
		    	x+=width;
		    }
		    x = 230;
		    g.setColor(Color.green);
		    prev = 'p';
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
	        //DME
	        g.setColor(Color.black);
	        g.drawImage(img,100,500,100,100,null);
			g.drawImage(img,700,500,100,100,null);
			g.drawLine(150, 550, 750, 550);
	        x = 230; 
		    y = 550; 
		    g.drawString("Encoded by Differential Manchester Encoding scheme",810,y);
		    for(char i: data.toCharArray()) {
		    	g.drawString(i+"",x+width/2,y-30);
		    	x+=width;
		    }
		    x = 230;
		    g.setColor(Color.cyan);
		    prev = 'p';
		    boolean state = true;
	        for(char i: data.toCharArray()) {
	    			if(i=='0'){
	    				g.drawLine(x, y-depth, x, y+depth);
	    				if(state){
	    					g.drawLine(x, y-depth, x+(width/2), y-depth);
	    					g.drawLine(x+(width/2), y-depth, x+(width/2), y+depth);
	    					g.drawLine(x+(width/2), y+depth, x+width, y+depth);
	    					x+=width;
	    				} else {
	    					g.drawLine(x, y+depth, x+(width/2), y+depth);
	    					g.drawLine(x+(width/2), y+depth, x+(width/2), y-depth);
	    					g.drawLine(x+(width/2), y-depth, x+width, y-depth);
	    					x+=width;
	    				}
	    			} else if(i == '1') {
	    				if(state){
	    					g.drawLine(x, y+depth, x+(width/2), y+depth);
	    					g.drawLine(x+(width/2), y+depth, x+(width/2), y-depth);
	    					g.drawLine(x+(width/2), y-depth, x+width, y-depth);
	    					x+=width;
	    				} else {
	    					g.drawLine(x, y-depth, x+(width/2), y-depth);
	    					g.drawLine(x+(width/2), y-depth, x+(width/2), y+depth);
	    					g.drawLine(x+(width/2), y+depth, x+width, y+depth);
	    					x+=width;
	    				}
	    				state = !state;
	    			}
	        }
	        //AMI
	        g.setColor(Color.black);
	        g.drawImage(img,100,600,100,100,null);
			g.drawImage(img,700,600,100,100,null);
			g.drawLine(150, 650, 750, 650);
	        x = 230; 
		    y = 650; 
		    g.drawString("Encoded by AMI scheme",810,y);
		    for(char i: data.toCharArray()) {
		    	g.drawString(i+"",x+width/2,y-30);
		    	x+=width;
		    }
		    x = 230;
		    g.setColor(Color.yellow);
		    prev = 'p';
		    state = true;
	        for(char i: data.toCharArray()) {
	        	if(i == '0') {
	        		g.drawLine(x, y, x+width, y);
	        	}
	        	if(i == '1') {
					 if(state){
		                    g.drawLine(x,y, x, y-depth);
		                    g.drawLine(x, y-depth, x+width, y-depth);
		                    g.drawLine(x+width, y-depth, x+width, y);
		                } else{
		                    g.drawLine(x,y, x, y+depth);
		                    g.drawLine(x, y+depth, x+width, y+depth);
		                    g.drawLine(x+width, y+depth, x+width, y);
		                }
					 state = !state;
	        	}
	        	x+= width;
	        }
	        //Pseudoternary
	        g.setColor(Color.black);
	        g.drawImage(img,100,700,100,100,null);
			g.drawImage(img,700,700,80,80,null);
			g.drawLine(150, 720, 750, 720);
	        x = 230; 
		    y = 720; 
		    g.drawString("Encoded by Pseudoternary scheme",810,y);
		    for(char i: data.toCharArray()) {
		    	g.drawString(i+"",x+width/2,y-30);
		    	x+=width;
		    }
		    x = 230;
		    g.setColor(Color.MAGENTA);
		    prev = 'p';
		    state = true;
	        for(char i: data.toCharArray()) {
	        	if(i == '1') {
	        		g.drawLine(x, y, x+width, y);
	        	}
	        	if(i == '0') {
					 if(state){
		                    g.drawLine(x,y, x, y-depth);
		                    g.drawLine(x, y-depth, x+width, y-depth);
		                    g.drawLine(x+width, y-depth, x+width, y);
		                } else{
		                    g.drawLine(x,y, x, y+depth);
		                    g.drawLine(x, y+depth, x+width, y+depth);
		                    g.drawLine(x+width, y+depth, x+width, y);
		                }
					 state = !state;
	        	}
	        	x+= width;
	        }
	}
}
