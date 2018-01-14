package interFace;
/**
 * 
 * @author Salifou
 *
 */

public interface ObserverDeCapteur extends Observer<Capteur> {
	
	public void Update(Capteur cap);
}
