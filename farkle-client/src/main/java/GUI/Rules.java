package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Frame;

public class Rules extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame for the Rules object. The Rules object
	 * allows for a user to select which rules they wish to view
	 */
	public Rules(GameMainMenu frame) {
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
		btnNewButton.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(337, 356, 160, 71);
		desktopPane.add(btnNewButton);
		
		JButton btnGeneralRules = new JButton("General Rules");
		btnGeneralRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GeneralRules general = new GeneralRules(frame);
				general.setVisible(true);
				setVisible(false);
			}
		});
		btnGeneralRules.setFont(new Font("Arial", Font.PLAIN, 20));
		btnGeneralRules.setBounds(71, 47, 160, 71);
		desktopPane.add(btnGeneralRules);
		
		JButton btnStandardScoring = new JButton("Standard Scoring");
		btnStandardScoring.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StandardScoring std = new StandardScoring(frame);
				std.setVisible(true);
				setVisible(false);
			}
		});
		btnStandardScoring.setFont(new Font("Arial", Font.PLAIN, 18));
		btnStandardScoring.setBounds(71, 141, 160, 71);
		desktopPane.add(btnStandardScoring);
		
		JButton btnScoringVariations = new JButton("Scoring Variations");
		btnScoringVariations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoringVariations var = new ScoringVariations(frame);
				var.setVisible(true);
				setVisible(false);
			}
		});
		btnScoringVariations.setFont(new Font("Arial", Font.PLAIN, 18));
		btnScoringVariations.setBounds(71, 224, 160, 71);
		desktopPane.add(btnScoringVariations);
		
		JButton btnPlayVariations = new JButton("Play Variations");
		btnPlayVariations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlayVariations play = new PlayVariations(frame);
				play.setVisible(true);
				setVisible(false);
			}
		});
		btnPlayVariations.setFont(new Font("Arial", Font.PLAIN, 20));
		btnPlayVariations.setBounds(555, 47, 160, 71);
		desktopPane.add(btnPlayVariations);
		
		JButton btnProbabilities = new JButton("Probabilities");
		btnProbabilities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FarkleProbabilities prob = new FarkleProbabilities(frame);
				prob.setVisible(true);
				setVisible(false);
			}
		});
		btnProbabilities.setFont(new Font("Arial", Font.PLAIN, 20));
		btnProbabilities.setBounds(555, 141, 160, 71);
		desktopPane.add(btnProbabilities);
		
		JButton btnEffectsOfScoring = new JButton("Effects of Scoring Variations");
		btnEffectsOfScoring.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScoVarEffects a = new ScoVarEffects(frame);
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnEffectsOfScoring.setFont(new Font("Arial", Font.PLAIN, 10));
		btnEffectsOfScoring.setBounds(555, 224, 160, 71);
		desktopPane.add(btnEffectsOfScoring);
	}
}
