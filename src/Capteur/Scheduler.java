package Capteur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import interFace.AlgoDiffusion;

/**
 * @author Aboubacar
 * @author Salifou
 *
 */
public class Scheduler extends JFrame implements ActionListener, ItemListener {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Canal canal1;
   private Canal canal2;
   private Canal canal3;
   private Canal canal4;
   private CapteurImpl cap;
   private JLabel ValCap;
   private boolean modifAlgo;
   private AlgoDiffusion algorithme;

   
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Modification de l'horloge
	 */
 public void execute() {
	 while(true) {
		 if(modifAlgo) {
			 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 this.init(algorithme);
			  modifAlgo= false;
		 }
		 ValCap.setText(String.valueOf(cap.getValue() + 1));
		  cap.tick();
		  try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
 }

	private void init(AlgoDiffusion algorithme2) {
		// TODO Auto-generated method stub
		
	}
}