package GUI;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;

public class SettingsDialogue extends JPanel {

	private JComboBox playCombo, threshCombo, threeCombo, fourCombo, straightCombo, fullCombo, farkleCombo;

	/**
	 * Create the panel.
	 */
	public SettingsDialogue() {
		setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label = new JLabel("Play To");
		label.setToolTipText("Reach this score to end the game");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		add(label);
		
		playCombo = new JComboBox<Integer>();
		playCombo.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		playCombo.setEditable(true);
		playCombo.addItem("10000");
		playCombo.addItem("20000");
		playCombo.setEditable(true);
		add(playCombo);
		
		JLabel label_1 = new JLabel("Threshold");
		label_1.setToolTipText("The players must roll this number before they can score points");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		add(label_1);
		
		threshCombo = new JComboBox<Integer>();
		threshCombo.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		threshCombo.setEditable(false);
		threshCombo.addItem("0");
		threshCombo.addItem("350");
		threshCombo.addItem("400");
		threshCombo.addItem("500");
		threshCombo.addItem("1000");
		add(threshCombo);
		
		JLabel label_2 = new JLabel("Three Pair");
		label_2.setToolTipText("Rolling three pairs (eg: 1,1,3,3,6,6) will earn this number of points");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		add(label_2);
		
		threeCombo = new JComboBox();
		threeCombo.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		threeCombo.setEditable(false);
		threeCombo.addItem("0");
		threeCombo.addItem("300");
		threeCombo.addItem("600");
		threeCombo.addItem("750");
		add(threeCombo);
		
		JLabel label_3 = new JLabel("Straight");
		label_3.setToolTipText("Rolling a straight will earn this amount of points");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		add(label_3);
		
		straightCombo = new JComboBox();
		straightCombo.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		straightCombo.setEditable(false);
		straightCombo.addItem("0");
		straightCombo.addItem("1000");
		straightCombo.addItem("1200");
		straightCombo.addItem("1500");
		straightCombo.addItem("2500");
		add(straightCombo);
		
		JLabel label_4 = new JLabel("Full House");
		label_4.setToolTipText("Rolling a full house will earn these points");
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		add(label_4);
		
		fullCombo = new JComboBox();
		fullCombo.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		fullCombo.setEditable(false);
		fullCombo.addItem("0");
		fullCombo.addItem("1500");
		fullCombo.addItem("2000");
		fullCombo.addItem("2500");
		add(fullCombo);
		
		JLabel label_5 = new JLabel("4+");
		label_5.setToolTipText("This is how rolling 4+ of the same number will be scored. \r\nAdd: 300 is added for each matching dice above 3\r\nDouble: every matching dice above 3 of a kind doubles the score\r\nSet: 4 of a kind is 1000 points, 5 of a kind 2000, 6 of a kind 4500");
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		add(label_5);
		
		fourCombo = new JComboBox();
		fourCombo.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		fourCombo.setEditable(false);
		fourCombo.addItem("none");
		fourCombo.addItem("add");
		fourCombo.addItem("double");
		fourCombo.addItem("set");
		add(fourCombo);
		
		JLabel label_6 = new JLabel("Farklex3 Deduction");
		label_6.setToolTipText("Rolling three farkles in a row will result in a point deduction.");
		label_6.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		add(label_6);
		
		farkleCombo = new JComboBox();
		farkleCombo.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		farkleCombo.setEditable(false);
		farkleCombo.addItem("0");
		farkleCombo.addItem("500");
		farkleCombo.addItem("1000");
		add(farkleCombo);

	}
	
	public String getSettings(){
		 
		return playCombo.getSelectedItem().toString() + "," +
				threshCombo.getSelectedItem().toString() + "," + 
				threeCombo.getSelectedItem().toString() + "," +
				fourCombo.getSelectedItem().toString() + "," +
				straightCombo.getSelectedItem().toString() + "," +
				fullCombo.getSelectedItem().toString() + "," +
				farkleCombo.getSelectedItem().toString();
	}

}
