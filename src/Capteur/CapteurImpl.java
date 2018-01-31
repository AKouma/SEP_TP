package Capteur;

import java.util.ArrayList;

import interFace.AlgoDiffusion;
/**
 * 
 */
import interFace.Capteur;
import interFace.Observer;

public class CapteurImpl implements Capteur {
	AlgoDiffusion algo;
	int v = 0;
	ArrayList<Observer<Capteur>> liste = new ArrayList<>();

	@Override
	public void attach(Observer<Capteur> Cap) {
		// TODO Auto-generated method stub
		liste.add(Cap);
	}

	@Override
	public void detach(Observer<Capteur> Cap) {
		// TODO Auto-generated method stub
		liste.remove(Cap);
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
	
	public void setAlgoDiffusion(AlgoDiffusion algoselected) {
		algo = algoselected;
	}
	/**
	 * 
	 * @return
	 */
	public AlgoDiffusion getAlgoDiffusion() {
		return algo;
	}

}
