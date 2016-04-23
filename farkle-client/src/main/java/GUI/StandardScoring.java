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

public class StandardScoring extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame for the StandardScoring object. This object
	 * allows for users to view the standard scoring practices for
	 * a game of farkle.
	 * @param frame 
	 */
	public StandardScoring(GameMainMenu frame) {
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
			public void actionPerformed(ActionEvent e) 
			{
				Rules rules = new Rules(frame);
				setVisible(false);
				rules.setVisible(true);
			}
		});
		button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		button.setBounds(337, 348, 160, 71);
		desktopPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 18, 717, 320);
		desktopPane.add(scrollPane);
		
		JTextPane txtpnStandardScoringThe = new JTextPane();
		txtpnStandardScoringThe.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		scrollPane.setViewportView(txtpnStandardScoringThe);
		txtpnStandardScoringThe.setText("STANDARD SCORING:\n\nThe following scores for single dice or combinations of dice are widely established, in that they are common to all or nearly all of the above-cited descriptions of farkle scoring.\n\nDice combination\t\tScore\nEach 1\t\t\t100\nEach 5\t\t\t50\nThree 1s\t\t\t1000\nThree 2s\t\t\t200\nThree 3s\t\t\t300\nThree 4s\t\t\t400\nThree 5s\t\t\t500\nThree 6s\t\t\t600\n\nFor example, if a player throws 1-2-3-3-3-5, they could do any of the following:\n\nscore three 3s as 300 and then throw the remaining three dice\nscore the single 1 as 100 and then throw the remaining five dice\nscore the single 5 as 50 and then throw the remaining five dice\nscore three 3s, the single 1, and the single 5 for a total of 450 and then throw the remaining die\nscore three 3s, the single 1, and the single 5 for a total of 450 and stop, banking 450 points in that turn\n\nThis is not an exhaustive list of plays based on that throw, but it covers the most likely ones. If the player continues throwing, as in any of the above cases except the last, they risk farkling and thus losing all accumulated points. On the other hand, if they score five dice and have only one die to throw, they have a 1 in 3 chance of scoring a single 1 or a single 5, and then having scored all six dice they will have \"hot dice\" and can throw all six dice again to further increase their score.\n\nEach scoring combination must be achieved in a single throw. For example, if a player has already set aside two individual 1s and then throws a third with the four dice remaining, they do not have a triplet of 1s for a score of 1000 but merely three individual 1s for a score of 300.");
		txtpnStandardScoringThe.setCaretPosition(0);
	}

}
