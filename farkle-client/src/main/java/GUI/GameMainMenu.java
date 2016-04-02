package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.plu.cs.farkle.client.CallBack;
import edu.plu.cs.farkle.client.GameClient;

public class GameMainMenu extends JFrame {

	private JPanel contentPane;
	GameMainMenu frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameMainMenu frame = new GameMainMenu(null);
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
	public GameMainMenu(final ArrayList callBack) {
		frame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(139, 0, 0));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listModel.addElement("hello world");
		
		
		JList<String> list = new JList<String>(listModel);
		list.setBounds(486, 93, 269, 325);
		
		
		
		desktopPane.add(list);
		
		JLabel lblLeaderboard = new JLabel("Leaderboard");
		lblLeaderboard.setForeground(new Color(255, 255, 255));
		lblLeaderboard.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeaderboard.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 34));
		lblLeaderboard.setBounds(528, 15, 184, 66);
		desktopPane.add(lblLeaderboard);
		
		
		
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 26));
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				String token = "";
				String name = "";
				CallBack call;
				for (Iterator it = callBack.iterator(); it.hasNext();){
					call = (CallBack) it.next();
					token = call.getToken();
					name = call.getName();
				}
				
				//GameClient client = new GameClient(token, name);
				GamePage newGamePage = new GamePage(frame);
				newGamePage.setVisible(true);
			}
		});
		btnNewGame.setBounds(70, 38, 207, 86);
		desktopPane.add(btnNewGame);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 26));
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Settings set = new Settings(frame);
				set.setVisible(true);
			}
		});
		btnSettings.setBounds(70, 136, 207, 86);
		desktopPane.add(btnSettings);
		
		JButton btnRules = new JButton("Rules");
		btnRules.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 26));
		btnRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Rules rule = new Rules(frame);
				rule.setVisible(true);
			}
		});
		btnRules.setBounds(70, 234, 207, 86);
		desktopPane.add(btnRules);
		
		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 26));
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitGame.setBounds(70, 332, 207, 86);
		desktopPane.add(btnExitGame);
	}
}