package Capteur;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

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

   /*
    * (non-Javadoc)
    * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
    */
	@Override
	public void itemStateChanged(ItemEvent e) {
	 System.out.println("" + ((JRadioButton) e.getItem()).getActionCommand() + "");
	 if(e.getStateChange() == ItemEvent.DESELECTED) {
		 if(algorithme instanceof DiffusionAtomique) {
			 ((DiffusionAtomique) algorithme).reset();
		 } 
		modifAlgo= true;
	 }
		if(e.getStateChange() == ItemEvent.SELECTED) {
			if(((JRadioButton) e.getItem()).getActionCommand().equals("atomique")){
				algorithme = new DiffusionAtomique();
				
			}
			
		if(((JRadioButton) e.getItem()).getActionCommand().equals("sequentielle")){
			algorithme = new DiffusionSequentielle();
			
		}
		
		if(((JRadioButton) e.getItem()).getActionCommand().equals("epoque")){
			algorithme = new DiffusionParEpoque();
			
		}
		}
	}
	

	/**
	 * 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
    System.out.println("Choix algorithme diffusion");
      e.getActionCommand();
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
		
    this.setTitle("Capteur Pojet Sep");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel pan = new JPanel(new GridLayout(0, 1));
    Border bord = BorderFactory.createTitledBorder("Sheduler");
    pan.setBorder(bord);
    ButtonGroup group= new ButtonGroup();
    
    JRadioButton radio1 = new JRadioButton("Atomique");
    radio1.setMnemonic(KeyEvent.VK_1);
    radio1.setActionCommand("atomique");
    radio1.setSelected(true);
    
    JRadioButton radio2 = new JRadioButton("Sequentielle");
    radio2.setMnemonic(KeyEvent.VK_2);
    radio2.setActionCommand("sequentielle");
    
    
    
    JRadioButton radio3 = new JRadioButton("Epoque"); 
    radio3.setMnemonic(KeyEvent.VK_3);
    radio3.setActionCommand("epoque");
    
    group.add(radio1);
    pan.add(radio1);
    group.add(radio2);
    pan.add(radio2);
    group.add(radio3);
    pan.add(radio3);
		
	radio1.addActionListener(this);	
	radio2.addActionListener(this);	
	radio3.addActionListener(this);
	radio1.addItemListener(this);	
	radio2.addItemListener(this);	
	radio3.addItemListener(this);
	
      JPanel Shedule = new JPanel(new GridLayout(2, 2));
      Border borSheldul =  BorderFactory.createTitledBorder("Afficheur");
      Shedule.setBorder(borSheldul);
      
      JLabel lab1 = new JLabel("Afficheur 1");
      lab1.setFont(new Font("Red", Font.PLAIN, 26));
      Shedule.add(lab1);
      
      JLabel lab2 = new JLabel("Afficheur 2");
      lab2.setFont(new Font("Red", Font.PLAIN, 26));
      Shedule.add(lab2);
      
      JLabel lab3 = new JLabel("Afficheur 3");
      lab3.setFont(new Font("Red", Font.PLAIN, 26));
      Shedule.add(lab3);
      
      JLabel lab4 = new JLabel("Afficheur 4");
      lab4.setFont(new Font("Red", Font.PLAIN, 26));
      Shedule.add(lab4);
      
      Afficheur Aff1 = new Afficheur("0");
		Aff1.setFont(new Font("Red", Font.PLAIN, 26));
		Shedule.add(Aff1);
		Afficheur Aff2 = new Afficheur("0");
		Aff2.setFont(new Font("Red", Font.PLAIN, 26));
		 Shedule.add(Aff2);
		Afficheur Aff3 = new Afficheur("0");
		Aff3.setFont(new Font("Red", Font.PLAIN, 26));
		Shedule.add(Aff3);
		Afficheur Aff4 = new Afficheur("0");
		Aff4.setFont(new Font("Red", Font.PLAIN, 26));
		Shedule.add(Aff4);
      
      Container contenPan = this.getContentPane();
      contenPan.add(pan, BorderLayout.SOUTH);
      contenPan.add(Shedule, BorderLayout.NORTH);
      
     JPanel panCap = new JPanel(new GridLayout(2, 2));
     Border bordCap = BorderFactory.createTitledBorder("Capteur");
     panCap.setBorder(bordCap);
      JLabel titre = new JLabel("Valeur du Capteur");
      titre.setFont(new Font("red", Font.PLAIN, 66));
      titre.setHorizontalAlignment(SwingConstants.CENTER);
      panCap.add(titre);
      
      ValCap = new JLabel("0");
      ValCap.setFont(new Font("Red", Font.PLAIN, 66));
      ValCap.setHorizontalAlignment(SwingConstants.CENTER);
      panCap.add(ValCap);
      
      contenPan.add(panCap, BorderLayout.CENTER);
      if(algorithme2 instanceof DiffusionAtomique) {
    	  radio1.setSelected(true);
      }
     
      else if(algorithme2 instanceof DiffusionSequentielle) {
    	  radio2.setSelected(true);
      }
      else if (algorithme2 instanceof DiffusionParEpoque) {
    	  radio3.setSelected(true);
      }
      
      this.setSize(900,500);
      this.setResizable(false);
      this.setVisible(true);
      
      cap = new CapteurImpl();
      
      canal1 = new Canal(cap, Aff1);
      canal2 =  new Canal(cap, Aff2);
      canal3 = new Canal(cap, Aff3);
      canal4 = new Canal(cap, Aff4);
      
      algorithme2.setCapteur(cap);
      algorithme2.addCanal(canal1);
      algorithme2.addCanal(canal2);
      algorithme2.addCanal(canal3);
      algorithme2.addCanal(canal4);
      
      cap.setAlgoDiffusion(algorithme2);
      
      
	}
	/**
	 * lancement de l'application
	 * @param args
	 */
	public static void main(String args[]) {
	Scheduler shel = new Scheduler();
	shel.init(new DiffusionAtomique());
	shel.execute();
	}
	
}
