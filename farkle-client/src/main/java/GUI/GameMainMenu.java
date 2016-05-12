package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import edu.plu.cs.farkle.client.CallBack;
import edu.plu.cs.farkle.client.ClientMainPage;

public class GameMainMenu extends JFrame {

	private JPanel contentPane;
	GameMainMenu frame;


	/**
	 * Create the frame for the GameMainMenu object.
	 * This object serves as the window in which a user can
	 * choose to start a new game, adjust settings, read about rules,
	 * as well as exit the game.
	 */
	public GameMainMenu(final ArrayList callBack) {
		frame = this;
		setResizable(false);
		setBounds(100, 100, 845, 489);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(55, 55, 55));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		
		
		ClientMainPage mp = new ClientMainPage();
		//Get LeaderBoard

		
		 ActionListener getLeaderBoardGui = new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	
	        		DefaultListModel<String> listModel = new DefaultListModel<String>();

	            	try {
	            		String uName = "";
	            		CallBack call;
	            		for (Iterator it = callBack.iterator(); it.hasNext();){
	            			call = (CallBack) it.next();
	            			uName = call.getName();
	            		}
	            		
	            		List<String> vList = mp.getList();
	        			
	        			listModel.addElement(mp.getURank(uName));
	        			listModel.addElement("\n");
	        			
	        			for(int i=0;i<vList.size();i++){
	        				listModel.addElement(vList.get(i));
	        				if(i==9)
	        					break;
	        			}
	        		} catch (IOException e1) {
	        			// TODO Auto-generated catch block
	        			e1.printStackTrace();
	        		}
	            	JList<String> list = new JList<String>(listModel);
	        		list.setBounds(486, 93, 269, 325);
	        		desktopPane.add(list);
	            }
	            
		 };
		 	//updates every 100 seconds
	        Timer timer = new Timer(100000,getLeaderBoardGui);
	        timer.setInitialDelay(0);
	        timer.setRepeats(true);
	        timer.start();

		
		
		
		JLabel lblLeaderboard = new JLabel("Leaderboard");
		lblLeaderboard.setForeground(new Color(255, 255, 255));
		lblLeaderboard.setHorizontalAlignment(SwingConstants.LEFT);
		lblLeaderboard.setFont(new Font("Times New Roman", Font.PLAIN, 34));
		lblLeaderboard.setBounds(497, 17, 274, 66);
		desktopPane.add(lblLeaderboard);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setFont(new Font("Times New Roman", Font.PLAIN, 20));
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
				//timer.stop();
				GamePage newGamePage = new GamePage(frame, token, name);
				newGamePage.setVisible(true);
				setVisible(false);
			}
		});
		btnNewGame.setBounds(70, 38, 207, 86);
		desktopPane.add(btnNewGame);
		
		JButton btnRules = new JButton("Rules");
		btnRules.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Rules rule = new Rules(frame);
				rule.setVisible(true);
			}
		});
		btnRules.setBounds(70, 136, 207, 86);
		desktopPane.add(btnRules);
		
		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitGame.setBounds(70, 234, 207, 86);
		desktopPane.add(btnExitGame);
	}
}



