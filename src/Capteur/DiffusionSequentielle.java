
package Capteur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import interFace.AlgoDiffusion;
import interFace.Capteur;

/**
 * @author Aboubacar
 * @author Salifou
 *
 */
public class DiffusionSequentielle implements AlgoDiffusion{

	private Capteur cap ;
	private List <Canal> listCan = new ArrayList<Canal>();
	private Semaphore sem = new Semaphore(1);
;
	private Boolean debut = true;
	private int compteur =0 ;
	private Boolean lecture = true;
	private int Val;

	/***
	 * ajout semaphore
	 */
	@Override
	public void configure() {

	}
	/**
	 * Execute la diffusion
	 */
	@Override
	public void execute() {
		if(debut) {
			debut = false;
			for(Canal i : listCan) {
				i.update(cap);
			}
		}
	}

	/**
	 * 
	 */
	public void acquire() {
       try {
		sem.acquire();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
	}
	/**
	 * on fait la synchronisation
	 */
	public void release() {
		sem.release();

	}
	/**
	 * verification de la lecture
	 * @return lecture
	 */
	public synchronized boolean lecture() {
		if(lecture) {
			lecture = false; 
			return true;
		}
		return lecture;

	}
	/**
	 * on recuper la valeur qui sera afficher
	 * @return Val
	 */

	public synchronized int getValue() {
		compteur++;
		if(compteur == listCan.size() - 1) {
			lecture = true;
			compteur = 0;
			debut= true;

		}
		return Val;

	}

	/**
	 * on modifi la valeur du capteur
	 * @param val1
	 */
	public void setVal(int val1) {
		Val = val1;
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
