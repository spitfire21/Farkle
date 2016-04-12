package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class AdjustScoring extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame for the AdjustScoring object. This object allows
	 * for a user to adjust how the scores for a Farkle game are calculated
	 */
	public AdjustScoring(GameMainMenu frame, AdjustScoring var, AdjustGameplay play) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(128, 0, 0));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Settings test = new Settings(frame, var, play);
				test.setVisible(true);
			}
		});
		button.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		button.setBounds(339, 315, 156, 68);
		desktopPane.add(button);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("No Scoring Dice Rolled");
		rdbtnNewRadioButton.setToolTipText("No scoring dice are rolled (e.g. 2-2-3-4-6-6) is scored as 500.");
		rdbtnNewRadioButton.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBounds(95, 51, 197, 23);
		desktopPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnAsd = new JRadioButton("Three Pair");
		rdbtnAsd.setToolTipText("Three pair (e.g., 1-1-4-4-6-6) is scored as 500, 600, 750, 1000, or 1500.\n\n");
		rdbtnAsd.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 16));
		rdbtnAsd.setBounds(95, 86, 100, 23);
		desktopPane.add(rdbtnAsd);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Straight");
		rdbtnNewRadioButton_1.setToolTipText("A straight (1-2-3-4-5-6) is scored as 1000, 1200, 1500, or 2500.");
		rdbtnNewRadioButton_1.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 16));
		rdbtnNewRadioButton_1.setBounds(95, 121, 141, 23);
		desktopPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Full House");
		rdbtnNewRadioButton_2.setToolTipText("A full house (three of a kind and a pair) is scored as the three of a kind value plus 250. e.g. 3-3-3-2-2 = 550, 4-4-4-3-3 = 650, 5-5-5-1-1 = 750, 1-1-1-3-3 = 1250");
		rdbtnNewRadioButton_2.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 16));
		rdbtnNewRadioButton_2.setBounds(95, 156, 141, 23);
		desktopPane.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnAddValue = new JRadioButton("Add Value");
		rdbtnAddValue.setToolTipText("Adding, for each additional matching die above 3 of a kind, the 3 of a kind score is added. e.g. 3-3-3 = 300, 3-3-3-3 = 300 + 300 (600), 3-3-3-3-3 = 300 + 300 + 300 (900) and 3-3-3-3-3-3 = 300 + 300 + 300 + 300 (1200).\n");
		rdbtnAddValue.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 16));
		rdbtnAddValue.setBounds(95, 191, 141, 23);
		desktopPane.add(rdbtnAddValue);
		
		JRadioButton rdbtnDoubleValue = new JRadioButton("Double Value");
		rdbtnDoubleValue.setToolTipText("Doubling, for each additional matching die above 3, 4 or 5 of a kind the score is doubled. e.g. 3-3-3 = 300, 3-3-3-3 = 300 × 2 (600), 3-3-3-3-3 = 300 × 2 × 2 (1200) and 3-3-3-3-3-3 = 300 × 2 × 2 × 2 (2400)\n");
		rdbtnDoubleValue.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 16));
		rdbtnDoubleValue.setBounds(95, 226, 141, 23);
		desktopPane.add(rdbtnDoubleValue);
		
		JRadioButton rdbtnSetValue = new JRadioButton("Set Value");
		rdbtnSetValue.setToolTipText("Set value, 4 of a kind is scored as 1000 or 2000, 5 of a kind is scored as 2000 or 4000 and 6 of a kind is scored as 3000, 6000 or 10000");
		rdbtnSetValue.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 16));
		rdbtnSetValue.setBounds(95, 261, 141, 23);
		desktopPane.add(rdbtnSetValue);
		
		JTextPane txtpnSelectTheDesired = new JTextPane();
		txtpnSelectTheDesired.setFont(new Font("Bodoni 72", Font.PLAIN, 16));
		txtpnSelectTheDesired.setBackground(new Color(128, 0, 0));
		txtpnSelectTheDesired.setText("Select the desired options from the list. \n\nHover over each option to read a description of\nwhat the setting modifies.");
		txtpnSelectTheDesired.setBounds(501, 51, 269, 234);
		desktopPane.add(txtpnSelectTheDesired);
	}
}
