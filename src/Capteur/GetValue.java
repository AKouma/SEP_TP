package Capteur;

import java.util.concurrent.Callable;

/**
 * @author Aboubacar
 * @author Salifou
 *
 */
public class GetValue implements Callable<Integer>{

	private CapteurImpl Cap ;
	/**
	 * Constructeur invocateur
	 * @param cap
	 */
	public GetValue(CapteurImpl cap) {
		this.Cap = cap;
 	}
	
/**
 * Call getValeue 
 */
	@Override
	public Integer call() throws Exception {
		return Cap.getValue();
	}

}
