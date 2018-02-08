package Capteur;

import java.util.concurrent.Callable;

/**
 * @author Aboubacar
 * @author Salifou
 *
 */
public class GetValue implements Callable<Integer>{

	private CapteurImpl Cap ;
	public GetValue(CapteurImpl cap) {
		Cap = cap;
 	}

	@Override
	public Integer call() throws Exception {
		return Cap.getValue();
	}

}
