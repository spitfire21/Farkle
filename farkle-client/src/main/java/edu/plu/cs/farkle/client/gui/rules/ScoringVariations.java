package edu.plu.cs.farkle.client.gui.rules;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.plu.cs.farkle.client.gui.game.GameMainMenu;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ScoringVariations extends JFrame {

	private JPanel contentPane;

	/**
	 * This creates the frame for the ScoringVariations object.
	 * The ScoringVariations object highlights the various
	 * Farkle scoring variations possible
	 */
	public ScoringVariations(GameMainMenu frame) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 489);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(55, 55, 55));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rules rules = new Rules(frame);
				rules.setVisible(true);
				setVisible(false);
			}
		});
		button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		button.setBounds(337, 337, 160, 71);
		desktopPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 6, 698, 316);
		desktopPane.add(scrollPane);
		
		JTextPane txtpnScoringVariationsSince = new JTextPane();
		scrollPane.setViewportView(txtpnScoringVariationsSince);
		txtpnScoringVariationsSince.setText("SCORING VARIATIONS:\n\nSince farkle is a folk game, variant rules are used in different playing communities. While the standard rules described above are widely used, even they are not universal. For example, the commercially marketed game of Pocket Farkel differs in that three 1s are scored as 300 rather than 1000.[6] In addition, some players score one or more combinations of dice beyond the standard ones. Those variations include the following.\n\nNo scoring dice are rolled (e.g. 2-2-3-4-6-6) is scored as 500.\n\nThree pair (e.g., 1-1-4-4-6-6) is scored as 500, 600, 750, 1000, or 1500.\n\nA straight (1-2-3-4-5-6) is scored as 1000, 1200, 1500, or 2500.\n\nA full house (three of a kind and a pair) is scored as the three of a kind value plus 250. e.g. 3-3-3-2-2 = 550, 4-4-4-3-3 = 650, 5-5-5-1-1 = 750, 1-1-1-3-3 = 1250\n\nFour, five and six of a kind are scored in one of 3 ways: adding, doubling or set value:\nAdding, for each additional matching die above 3 of a kind, the 3 of a kind score is added. e.g. 3-3-3 = 300, 3-3-3-3 = 300 + 300 (600), 3-3-3-3-3 = 300 + 300 + 300 (900) and 3-3-3-3-3-3 = 300 + 300 + 300 + 300 (1200).\n\nDoubling, for each additional matching die above 3, 4 or 5 of a kind the score is doubled. e.g. 3-3-3 = 300, 3-3-3-3 = 300 × 2 (600), 3-3-3-3-3 = 300 × 2 × 2 (1200) and 3-3-3-3-3-3 = 300 × 2 × 2 × 2 (2400)\n\nSet value, 4 of a kind is scored as 1000 or 2000, 5 of a kind is scored as 2000 or 4000 and 6 of a kind is scored as 3000, 6000 or 10000\n\nDice value\t3 of a kind\t\n\nAdding\tDoubling\tSet value\n4 of a kind\t5 of a kind\t6 of a kind\t4 of a kind\t5 of a kind\t6 of a kind\t4 of a kind\t5 of a kind\t6 of a kind\nTwo\t200\t400\t600\t800\t400\t800\t1600\t1000 or 2000\t2000 or 4000\t3000, 6000 or 10000\nOne (low)[6]\t300\t600\t900\t1200\t600\t1200\t2400\nThree\t300\t600\t900\t1200\t600\t1200\t2400\nFour\t400\t800\t1200\t1600\t800\t1600\t3200\nFive\t500\t1000\t1500\t2000\t1000\t2000\t4000\nSix\t600\t1200\t1800\t2400\t1200\t2400\t4800\nOne (high)\t1000\t2000\t3000\t4000\t2000\t4000\t8000\nLike the standard combinations, any of these variant combinations must be achieved in a single throw.\n\nThese are the variations listed in the above-cited descriptions of farkle scoring, but further variations presumably exist. Since it is a folk game, players are free to agree upon whatever scores they choose for whatever combinations they choose to recognize.");
		txtpnScoringVariationsSince.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtpnScoringVariationsSince.setCaretPosition(0);
	}

}
