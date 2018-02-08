
package Capteur;

import java.util.ArrayList;
import java.util.List;

import interFace.AlgoDiffusion;
import interFace.Capteur;


/**
 * @author Aboubacar
 * @author Salifou
 *
 */
public class DiffusionParEpoque implements AlgoDiffusion {
	private Capteur cap ;
	private List <Canal> listCan = new ArrayList<Canal>();
	/**
	 * 
	 */
	@Override
	public void configure() {
		// TODO Auto-generated method stub

	}
	/**
	 * 
	 */
	@Override
	public void execute() {
		for(Canal i : listCan) {
			i.update(cap);
		}
	}

	/**
	 * Ajout du capteur
	 * @param capImp
	 */
	public void setCapteur(CapteurImpl  capImp) {
		cap = capImp;

	}
	/**
	 * Ajout du Canal
	 * @param canAdd
	 */
	public void addCanal(Canal canAdd) {
		listCan.add(canAdd);
	}
}
