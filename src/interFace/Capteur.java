package interFace;
/**
 * 
 * @author Salifou
 *
 */
public interface Capteur {

	/**
	 * 
	 * @param Cap
	 */
 public void attach(Observer<Capteur> Cap);
 /**
  * 
  * @param Cap
  */
 public void detach(Observer<Capteur> Cap);
 /**
  * 
  * @return
  */
 public int getValue();
 /**
  * 
  */
 public void tick();
}
