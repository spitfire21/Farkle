package edu.plu.cs.farkle.client.gui.game;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FinalSettings {
	
	public JPanel getGameSettings(String[] list, String[] sd){
		if (list.length == 1) {
			return getGameSettings(sd);
		}
		else
			return getGameSettings(list);
		
	}
	
	private JPanel getGameSettings(String[] list){
		JPanel jf = new JPanel();
		
		
		
		
		jf.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel title = new JLabel("These are the game rules:");
		title.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		jf.add(title);
		
		JLabel space = new JLabel("");
		jf.add(space);
		
		JLabel label = new JLabel("Play To");
		label.setToolTipText("Reach this score to end the game");
		label.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		jf.add(label);
		
		JLabel ptLabel = new JLabel(list[0]);
		ptLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		jf.add(ptLabel);

		
		JLabel label_1 = new JLabel("Threshold");
		label_1.setToolTipText("The players must roll this number before they can score points");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		jf.add(label_1);
		
		JLabel thLabel = new JLabel(list[1]);
		thLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		jf.add(thLabel);


		JLabel label_2 = new JLabel("Three Pair");
		label_2.setToolTipText("Rolling three pairs (eg: 1,1,3,3,6,6) will earn this number of points");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		jf.add(label_2);
		
		JLabel tpLabel = new JLabel(list[2]);
		tpLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		jf.add(tpLabel);

		
		JLabel label_3 = new JLabel("Straight");
		label_3.setToolTipText("Rolling a straight will earn this amount of points");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		jf.add(label_3);
		
		JLabel stLabel = new JLabel(list[3]);
		stLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		jf.add(stLabel);

		
		
		JLabel label_4 = new JLabel("Full House");
		label_4.setToolTipText("Rolling a full house will earn these points");
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		jf.add(label_4);
		
		JLabel fhLabel = new JLabel(list[4]);
		fhLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		jf.add(fhLabel);


		
		JLabel label_5 = new JLabel("4+");
		label_5.setToolTipText("This is how rolling 4+ of the same number will be scored. \r\nAdd: 300 is added for each matching dice above 3\r\nDouble: every matching dice above 3 of a kind doubles the score\r\nSet: 4 of a kind is 1000 points, 5 of a kind 2000, 6 of a kind 4500");
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		jf.add(label_5);

		JLabel fpLabel = new JLabel(list[5]);
		fpLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		jf.add(fpLabel);

		
		JLabel label_6 = new JLabel("Farklex3 Deduction");
		label_6.setToolTipText("Rolling three farkles in a row will result in a point deduction.");
		label_6.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		jf.add(label_6);
		
		JLabel fdLabel = new JLabel(list[6]);
		fdLabel.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		jf.add(fdLabel);
	
		
		return jf;
	}
}
