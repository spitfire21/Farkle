package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import edu.plu.cs.farkle.client.GameClient;
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
import javax.swing.ScrollPaneConstants;

public class GeneralRules extends JFrame {

	private JPanel contentPane;


	/**
	 * This creates the frame for the GeneralRules object.
	 * This object serves describe the default Farkle rules.
	 */
	public GeneralRules(GameMainMenu frame) {
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
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rules rules = new Rules(frame);
				setVisible(false);
				rules.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		btnNewButton.setBounds(339, 351, 156, 65);
		desktopPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(50, 23, 731, 313);
		scrollPane.getVerticalScrollBar().setValue(0);
		desktopPane.add(scrollPane);
		
		JTextPane txtpnFarkleIsPlayed = new JTextPane();
		
		scrollPane.setViewportView(txtpnFarkleIsPlayed);
		txtpnFarkleIsPlayed.setFont(new Font("Bodoni 72", Font.PLAIN, 18));
		txtpnFarkleIsPlayed.setText("GENERAL RULES:\n\nFarkle is played by two or more players, with each player in succession having a turn at throwing the dice. Each player's turn results in a score, and the scores for each player accumulate to some winning total (usually 10,000).\n\nAt the beginning of each turn, the player throws all the dice at once from a cup.\n\nAfter each throw, one or more scoring dice must be set aside (see sections on scoring below).\n\nThe player may then either end their turn and bank the score accumulated so far, or continue to throw the remaining dice.\n\nIf the player has scored all six dice, they have \"hot dice\" and may continue their turn with a new throw of all six dice, adding to the score they have already accumulated. There is no limit to the number of \"hot dice\" a player may roll in one turn.\n\nIf none of the dice score in any given throw, the player has \"farkled\" and all points for that turn are lost.\n\nAt the end of the player's turn, the dice are handed to the next player in succession (usually in clockwise rotation), and they have their turn.\n\nOnce a player has achieved a winning point total, each other player has one last turn to score enough points to surpass that high-score.");
		txtpnFarkleIsPlayed.setCaretPosition(0);
	}
}
