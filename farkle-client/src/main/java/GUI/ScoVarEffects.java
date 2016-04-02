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

public class ScoVarEffects extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoVarEffects frame = new ScoVarEffects();
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
	public ScoVarEffects() {
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
				Rules rule = new Rules(null);
				rule.setVisible(true);
				setVisible(false);
			}
		});
		button.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		button.setBounds(337, 321, 160, 71);
		desktopPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 22, 730, 269);
		desktopPane.add(scrollPane);
		
		JTextPane txtpnEffectsOfScoring = new JTextPane();
		scrollPane.setViewportView(txtpnEffectsOfScoring);
		txtpnEffectsOfScoring.setFont(new Font("Bodoni 72", Font.PLAIN, 18));
		txtpnEffectsOfScoring.setText("EFFECTS OF SCORING VARIATIONS:\n\nScoring additional combinations such as straights and three pairs increases the speed of play by awarding high scores for low probability events that otherwise would score little or nothing (for example, a straight with standard scoring is worth only 150 for the single 1 and single 5). To assess the impact of scoring variations, the following table shows the average score on the initial throw of six dice, assuming that all scoring dice are banked and ignoring any additional scores that would be made on a re-roll of hot dice. The first row shows the average score with standard scoring, and the other rows show the increment in that average for each scoring variant that is used in play.\n\nThe numbers in the table are calculated based on the following scores for variant combinations:\n\nFour of a kind scores three times the score of the corresponding triplet.\nFive of a kind scores five times the score of the corresponding triplet.\nSix of a kind scores ten times the score of the corresponding triplet.\nA straight scores 2500.\nThree pair scores 1500.\nScoring combination\tAverage score on initial throw\nStandard scoring\t302\nFour of a kind\t+47\nFive of a kind\t+8\nSix of a kind\t+0.6\nStraight\t+37\nThree pair\t+52\nTotal (all combinations)\t446.6\n\nThe impact of four or five of a kind is substantially similar if they are scored as 1000 and 2000, respectively. If lower scores are awarded for straights or three pairs, the impact on average scoring will be proportionately lower.\n\nThe above table somewhat overstates the impact of straight and three pair on overall speed of play, as they only score on the initial throw of six dice.");
	}

}
