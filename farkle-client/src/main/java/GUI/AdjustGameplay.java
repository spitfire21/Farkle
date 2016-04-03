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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdjustGameplay extends JFrame {

	private JPanel contentPane;
	private JTextField txtAdjustScoreThreshold;
	private JTextField txtAdjustMaxScore;


	/**
	 * Create the frame.
	 */
	public AdjustGameplay(GameMainMenu frame, ScoringVariations var, PlayVariations play) {
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
		button.setBounds(339, 323, 156, 68);
		desktopPane.add(button);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Select the desired options from the list. \n\nHover over each option to read a description of\nwhat the setting modifies.");
		textPane.setFont(new Font("Bodoni 72", Font.PLAIN, 16));
		textPane.setBackground(new Color(128, 0, 0));
		textPane.setBounds(507, 41, 269, 234);
		desktopPane.add(textPane);
		
		txtAdjustScoreThreshold = new JTextField();
		txtAdjustScoreThreshold.setToolTipText("Players may be required to achieve a certain threshold score in their opening turn or turns, before they can begin scoring. Thresholds of 350, 400, 500, or 1000 are used. At the beginning of a game, each player must continue throwing in their turn until they either farkle or reach the threshold. After having reached the threshold once, they are free to stop throwing in subsequent turns whenever they choose.");
		txtAdjustScoreThreshold.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdjustScoreThreshold.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 16));
		txtAdjustScoreThreshold.setText("Adjust Score Threshold");
		txtAdjustScoreThreshold.setBounds(64, 41, 171, 26);
		desktopPane.add(txtAdjustScoreThreshold);
		txtAdjustScoreThreshold.setColumns(10);
		
		txtAdjustMaxScore = new JTextField();
		txtAdjustMaxScore.setToolTipText("Play is almost always to 10,000, but can be to 20,000.");
		txtAdjustMaxScore.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 16));
		txtAdjustMaxScore.setHorizontalAlignment(SwingConstants.CENTER);
		txtAdjustMaxScore.setText("Adjust Max Score");
		txtAdjustMaxScore.setBounds(64, 79, 130, 26);
		desktopPane.add(txtAdjustMaxScore);
		txtAdjustMaxScore.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Enable Piggybacking");
		rdbtnNewRadioButton.setToolTipText("In a variant described as \"piggybacking\" or \"high-stakes\", each player after the first can choose to begin their turn either with a fresh set of six dice, or by throwing the dice remaining after the previous player has completed their turn. For example, if a player banks three 1's for a score of 1000, the next player may choose to roll the remaining three dice. If they score at least one die, they score 1000 plus whatever additional score they accumulate. Players may thus assume the greater risk of farkling for the chance of scoring the points already accumulated by the player before them. If a player ends their turn on a \"hot dice\", the next player may \"piggyback\" using all six dice.");
		rdbtnNewRadioButton.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 16));
		rdbtnNewRadioButton.setBounds(64, 117, 171, 23);
		desktopPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnHotDiceMod = new JRadioButton("Hot Dice Mod");
		rdbtnHotDiceMod.setToolTipText("Players may be required to make at least one additional throw when they have hot dice, even if they have accumulated a high enough score that they would choose not to risk farkling.");
		rdbtnHotDiceMod.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 16));
		rdbtnHotDiceMod.setBounds(64, 152, 141, 23);
		desktopPane.add(rdbtnHotDiceMod);
		
		JRadioButton rdbtnEnableDeduction = new JRadioButton("Enable Deduction");
		rdbtnEnableDeduction.setToolTipText("Three farkles in a row can result in a deduction of 500[10] or 1000 points from the player's score.");
		rdbtnEnableDeduction.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 16));
		rdbtnEnableDeduction.setBounds(64, 187, 156, 23);
		desktopPane.add(rdbtnEnableDeduction);
		
		JRadioButton rdbtnUseFiveDice = new JRadioButton("Use Five Dice");
		rdbtnUseFiveDice.setToolTipText("Another variation is using five dice instead of six. In this version, players cannot score three pair, and this variation often couples an \"instant\" win option, where on the first roll of the five dice on any turn, if the player rolls five of a kind, that player instantly wins the game, regardless of the scores to that point.");
		rdbtnUseFiveDice.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 16));
		rdbtnUseFiveDice.setBounds(64, 222, 141, 23);
		desktopPane.add(rdbtnUseFiveDice);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Enable Welfare");
		rdbtnNewRadioButton_1.setToolTipText("An end-of-game variation described as \"welfare\" requires the winner to score exactly 10,000 points. If a player scores more than 10,000 points, then all points scored in that turn are given to the player with the lowest score.");
		rdbtnNewRadioButton_1.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 16));
		rdbtnNewRadioButton_1.setBounds(64, 257, 141, 23);
		desktopPane.add(rdbtnNewRadioButton_1);
	}
}
