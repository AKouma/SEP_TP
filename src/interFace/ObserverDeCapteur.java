package interFace;
/**
 * @author Aboubacar
 * @author Salifou
 *
 */

public interface ObserverDeCapteur extends Observer<Capteur> {
	
	public void update(Capteur cap);

}
