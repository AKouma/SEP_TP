package Capteur;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
/**
 * @author Aboubacar
 * @author Salifou
 *
 */
import interFace.AlgoDiffusion;
import interFace.Capteur;

public class DiffusionAtomique implements AlgoDiffusion {

	private Capteur cap ;
	private List <Canal> listCan = new ArrayList<Canal>();
	private Semaphore sem;

	/***
	 * ajout semaphore
	 */
	@Override
	public void configure() {
		sem = new Semaphore(0);

	}
	/**
	 * Execute la diffusion
	 */
	@Override
	public void execute() {
		for(Canal i : listCan) {
			i.Update(cap);
		}
		try {
			sem.acquire(listCan.size());
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
	 * Reset algo
	 */
	public void reset() {
		sem.release(listCan.size());
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
	public void ajoutCanal(Canal canAdd) {
		listCan.add(canAdd);
	}
}
