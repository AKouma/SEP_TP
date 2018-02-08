package Capteur;

import java.util.concurrent.Callable;

import interFace.Capteur;

/**
 * @author Aboubacar
 * @author Salifou
 *
 */
public class Update implements Callable<Object>{
	private Afficheur aff;
	private Canal canal;
	/**
	 * Constructor
	 * @param cap
	 * @param affch
	 */
	public Update(Afficheur affch , Canal can) {
		this.aff= affch;
		this.canal= can;
	}
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object call() throws Exception {
		aff.update(canal);
		return null;
	}

}
