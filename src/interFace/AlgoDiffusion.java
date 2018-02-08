package interFace;

import Capteur.Canal;
import Capteur.CapteurImpl;

/**
 * @author Aboubacar
 * @author Salifou
 *
 */
public interface AlgoDiffusion {

	   /**
	    * 
	    */
		public  void configure ();
		
	
/**
 * 
 */
 public void execute();
/**
 * 
 * @param cap
 */

public void setCapteur(CapteurImpl cap);

/**
 * 
 * @param canal1
 */
public void addCanal(Canal canal1);
}
