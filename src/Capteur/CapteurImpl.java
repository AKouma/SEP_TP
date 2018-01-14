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
		return this.v;
	}
/**
 * 
 */
	@Override
	public void tick() {
      algo.execute();
       this.incV();
	}
   /**
    * 
    */
	public void incV() {
		v++;
	}
	
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
