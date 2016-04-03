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

public class PlayVariations extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlayVariations frame = new PlayVariations(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PlayVariations(GameMainMenu frame) {
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
				Rules rules = new Rules(null);
				rules.setVisible(true);
				setVisible(false);
			}
		});
		button.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		button.setBounds(337, 331, 160, 71);
		desktopPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 19, 769, 287);
		desktopPane.add(scrollPane);
		
		JTextPane txtpnPlayVariationsSome = new JTextPane();
		scrollPane.setViewportView(txtpnPlayVariationsSome);
		txtpnPlayVariationsSome.setFont(new Font("Bodoni 72", Font.PLAIN, 17));
		txtpnPlayVariationsSome.setText("PLAY VARIATIONS:\n\nSome farkle rules also incorporate one or more of the following variations in the sequence of play.\n\nPlayers may be required to achieve a certain threshold score in their opening turn or turns, before they can begin scoring. Thresholds of 350, 400, 500, or 1000 are used. At the beginning of a game, each player must continue throwing in their turn until they either farkle or reach the threshold. After having reached the threshold once, they are free to stop throwing in subsequent turns whenever they choose.\n\nPlay is almost always to 10,000, but can be to 20,000.\n\nIn a variant described as \"piggybacking\" or \"high-stakes\", each player after the first can choose to begin their turn either with a fresh set of six dice, or by throwing the dice remaining after the previous player has completed their turn. For example, if a player banks three 1's for a score of 1000, the next player may choose to roll the remaining three dice. If they score at least one die, they score 1000 plus whatever additional score they accumulate. Players may thus assume the greater risk of farkling for the chance of scoring the points already accumulated by the player before them. If a player ends their turn on a \"hot dice\", the next player may \"piggyback\" using all six dice.\nPlayers may be required to make at least one additional throw when they have hot dice, even if they have accumulated a high enough score that they would choose not to risk farkling.\n\nThree farkles in a row can result in a deduction of 500[10] or 1000 points from the player's score.\n\nAnother variation is using five dice instead of six. In this version, players cannot score three pair, and this variation often couples an \"instant\" win option, where on the first roll of the five dice on any turn, if the player rolls five of a kind, that player instantly wins the game, regardless of the scores to that point.\n\nAn end-of-game variation described as \"welfare\" requires the winner to score exactly 10,000 points. If a player scores more than 10,000 points, then all points scored in that turn are given to the player with the lowest score.");
	}

}
