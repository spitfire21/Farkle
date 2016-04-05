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
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FarkleProbabilities extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 * @param frame 
	 */
	public FarkleProbabilities(GameMainMenu frame) {
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
				Rules rules = new Rules(frame);
				setVisible(false);
				rules.setVisible(true);
			}
		});
		button.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		button.setBounds(337, 327, 160, 71);
		desktopPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 21, 752, 282);
		desktopPane.add(scrollPane);
		
		JTextPane txtpnFarkleProbabilities = new JTextPane();
		scrollPane.setViewportView(txtpnFarkleProbabilities);
		txtpnFarkleProbabilities.setFont(new Font("Bodoni 72", Font.PLAIN, 17));
		txtpnFarkleProbabilities.setText("FARKLE PROBABILITIES:\n\nFollowing are the probabilities of scoring combinations in the initial throw of six dice.\n\nDice combination\tProbability\nThree of a kind\t1 in 3.240\nFour of a kind\t1 in 20.736\nThree pair\t1 in 25.92\nStraight\t1 in 64.8\nTwo triplets\t1 in 155.52\nFive of a kind\t1 in 259.2\nSix of a kind\t1 in 7776\n\nFor the most part, less probable combinations are scored higher than more probable combinations (see Scoring Variations).\n\nFollowing are the probabilities of scoring combinations in subsequent throws of the dice.\n\nDice combination\tFive dice left\tFour dice left\tThree dice left\nThree of a kind\t1 in 5.184\t1 in 10.8\t1 in 36\nFour of a kind\t1 in 51.84\t1 in 216\tN/A\nFive of a kind\t1 in 1296\tN/A\tN/A\nFollowing are the probabilities of farkling if all variant scoring combinations are allowed, depending on the number of dice thrown.\n\nDice thrown\tProbability\n6\t1 in 42\n5\t1 in 13\n4\t1 in 6.35 (20 in 127)\n3\t1 in 3.6 (5 in 18)\n2\t1 in 2.25 (4 in 9)\n1\t1 in 1.5 (2 in 3)\n\nThree-pair is the only scoring variation that alters the likelihood of farkling, and only on the initial throw of six dice. If three pairs are not scored, the probability of farkling on the initial throw increases to 1 in 32.\n\nFollowing are the probabilities of making hot dice in a single throw if all variant scoring combinations are allowed, depending on the number of dice thrown.\n\nDice thrown\tProbability\n6\t1 in 12\n5\t1 in 32\n4\t1 in 25\n3\t1 in 18\n2\t1 in 9\n1\t1 in 3\n\nIf no variant scoring combinations are allowed, the probabilities of making hot dice are decreased only slightly for 4-6 dice thrown, and unchanged for 1-3 dice thrown. Odds for these and other die combinations with explanations and simulation results can be found elsewhere.[11][12]\n\n");
		txtpnFarkleProbabilities.setCaretPosition(0);
	}

}
