package encode_scheme;

import java.awt.Graphics2D;

/**
 * 
 * @author Dr. Sunirmal Khatua
 *
 */
public  class EncoderFactory {
	
	public static void encode(Graphics2D g, String scheme, String data) {
		createEncoder(scheme).encode(g, data);
	}
	
	
	public static Encoder createEncoder(String scheme) {
		if(scheme.equals("Manchester")) {
			return new ManchesterEncoder();
		}else if(scheme.equals("Differential Manchester")) {
			return new DifferentialManchesterEncoder();
		}else if (scheme.equals("NRZ-L")) {
			return new NRZ_L();
		}else if (scheme.equals("NRZ-I")) {
			return new NRZ_I();
		}else if (scheme.equals("RZ")) {
			return new RZ();
		}else if (scheme.equals("AMI")) {
			return new AMI();
		}else if (scheme.equals("Pseudoternary")) {
			return new Pseudoternary();
		}else if (scheme.equals("All Schemes")) {
			return new AllSchemes();
		}else {
			return null;//TO BE DONE for OTHER SCHEMES....
		}
	}
	
	

}
