package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameMainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameMainMenu frame = new GameMainMenu();
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
	public GameMainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JList list = new JList();
		list.setBounds(308, 38, 102, 201);
		desktopPane.add(list);
		
		JLabel lblLeaderboard = new JLabel("Leaderboard");
		lblLeaderboard.setBounds(320, 10, 77, 16);
		desktopPane.add(lblLeaderboard);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setBounds(27, 38, 117, 29);
		desktopPane.add(btnNewGame);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Settings set = new Settings();
				set.setVisible(true);
			}
		});
		btnSettings.setBounds(27, 79, 117, 29);
		desktopPane.add(btnSettings);
		
		JButton btnRules = new JButton("Rules");
		btnRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Rules rule = new Rules();
				rule.setVisible(true);
			}
		});
		btnRules.setBounds(27, 120, 117, 29);
		desktopPane.add(btnRules);
		
		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitGame.setBounds(27, 161, 117, 29);
		desktopPane.add(btnExitGame);
	}
}
