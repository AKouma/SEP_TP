package Capteur;

import interFace.AlgoDiffusion;
/**
 * 
 */
import interFace.Capteur;
import interFace.Observer;

public class CapteurImpl implements Capteur {
	AlgoDiffusion algo;
	int v = 0;

	@Override
	public void attach(Observer<Capteur> Cap) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detach(Observer<Capteur> Cap) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getValue() {
		return v;
	}
/**
 * update capteur
 */
	@Override
	public void tick() {
		v++;
	    algo.execute();
	}
   
	/**
	 * Modificatio algo
	 * @param algonew
	 */
	public void setAlgoDiffusion(AlgoDiffusion algonew) {
		algo = algonew;
	}
	/**
	 * 
	 * @return
	 */
	public AlgoDiffusion getAlgoDiffusion() {
		return algo;
	}

}
