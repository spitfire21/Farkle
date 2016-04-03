package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Settings extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Settings(GameMainMenu frame, ScoringVariations var, PlayVariations play) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(128, 0, 0));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frame.setVisible(true);
			}
		});
		btnBack.setBounds(339, 338, 156, 68);
		desktopPane.add(btnBack);
		
		JButton btnAdjustScoringVariations = new JButton("Adjust Scoring");
		btnAdjustScoringVariations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdjustScoring adjust = new AdjustScoring(frame, var, play);
				adjust.setVisible(true);
				setVisible(false);
			}
		});
		btnAdjustScoringVariations.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		btnAdjustScoringVariations.setBounds(160, 132, 156, 68);
		desktopPane.add(btnAdjustScoringVariations);
		
		JButton btnAdjustGameplay = new JButton("Adjust Gameplay");
		btnAdjustGameplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdjustGameplay adjustG = new AdjustGameplay(frame, var, play);
				adjustG.setVisible(true);
				setVisible(false);
			}
		});
		btnAdjustGameplay.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		btnAdjustGameplay.setBounds(512, 132, 156, 68);
		desktopPane.add(btnAdjustGameplay);
	}
}
