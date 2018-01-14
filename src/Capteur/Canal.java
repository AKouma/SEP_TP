package Capteur;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import interFace.AlgoDiffusion;
import interFace.Capteur;
import interFace.Observer;
import interFace.ObserverDeCapteur;
import interFace.Subject;

/**
 * @author Aboubacar
 * @author Salifou
 *
 */
public class Canal implements Capteur, ObserverDeCapteur {
  
		CapteurImpl cap;
		Afficheur affch;
     /**
      * Constructeur d'un nouveau canal
      * @param cap1 : capteur d'entrée
      * @param affch1 : Afficheur
      */
     
     public Canal(CapteurImpl cap1, Afficheur affch1) {
    	 this.cap= cap1;
    	 this.affch = affch1;
    	
	}
    

	@SuppressWarnings("unchecked")
	@Override
	public void Update(Capteur cap) {
     Update newUpdate= new Update(cap, affch);
		ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);
       scheduler.schedule(newUpdate, (long)(Math.random() * 4000) + 500, TimeUnit.MILLISECONDS);

	}

	@Override
	public void attach(Observer<Capteur> Cap) {
		// TODO Auto-generated method stubs
		
	}

	@Override
	public void detach(Observer<Capteur> Cap) {
		// TODO Auto-generated method stub
		
	}
/**
 * Recuperation de la valeur du capteur
 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int getValue() {
	int tmp=0;
	GetValue val = new GetValue(cap);
	ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);
    ScheduledFuture future=  scheduler.schedule(val, (long)(Math.random() * 4000) + 500, TimeUnit.MILLISECONDS);
  
		try {
			try {
				tmp = (int) future.get();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			}
		
		return tmp;
	}

	/**
	 * 
	 * @return: algorithme de diffusion utiliser
	 */
	public AlgoDiffusion allgoUtiliser() {
		return cap.getAlgoDiffusion();
		
	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Subject Capteur) {
		// TODO Auto-generated method stub
		
	}

	

}
