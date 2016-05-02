package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import edu.plu.cs.farkle.client.GUICallBack;
import edu.plu.cs.farkle.client.GameClient;
import edu.plu.cs.farkle.client.ServerCommand;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Graphics;

public class GamePage extends JFrame implements GUICallBack {

	// private static final boolean True = false;
	private JPanel contentPane;
	private GameClient gClient;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_1;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;

	private String name;
	private JTextPane txtpnScore;
	private JTextPane txtpnStoredScore;
	private JTextPane txtpnStatus;
	private JTextPane txtpnHowYouStack;

	ArrayList<Double> storeDemensions;
	private JButton btnRollDice;

	/**
	 * Create the frame for the GameMainMenu object. This object allows for
	 * users to see and play a game of Farkle either locally, or in a
	 * multiplayer fashion.
	 */
	public GamePage(GameMainMenu frame, String token, String name) {
		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		storeDemensions = new ArrayList<Double>();
		storeDemensions.add(0.0);
		storeDemensions.add(0.0);
		storeDemensions.add(0.0);
		storeDemensions.add(0.0);

		this.name = name;
		setResizable(false);
		gClient = new GameClient(token, name, this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(0, 0, screenSize.width, screenSize.height);
		contentPane = new JPanel();

		// contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Create storeDATA LIST
		ArrayList<Integer> storeData = new ArrayList<Integer>();

		// Create Roll Dice Button
		 btnRollDice = new JButton("Roll Dice");
		btnRollDice.setFont(new Font("Times New Roman", Font.PLAIN, 26));

		conversion(332, 419, 150, 54);
		btnRollDice.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		contentPane.add(btnRollDice);

		// Create Dice Panels
		panel = new JPanel();
		conversion(104, 293, 75, 74);
		panel.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		panel.setLayout(new BorderLayout());
		panel.setOpaque(true);
		panel.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panel);

		panel_1 = new JPanel();
		conversion(240, 293, 75, 74);
		panel_1.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		panel_1.setLayout(new BorderLayout());
		panel_1.setOpaque(true);
		panel_1.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panel_1);

		panel_2 = new JPanel();
		conversion(376, 293, 75, 74);
		panel_2.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		panel_2.setLayout(new BorderLayout());
		panel_2.setOpaque(true);
		panel_2.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panel_2);

		panel_3 = new JPanel();
		conversion(510, 293, 75, 74);
		panel_3.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		panel_3.setLayout(new BorderLayout());
		panel_3.setOpaque(true);
		panel_3.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panel_3);

		panel_4 = new JPanel();
		conversion(646, 293, 75, 74);
		panel_4.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		panel_4.setLayout(new BorderLayout());
		panel_4.setOpaque(true);
		panel_4.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panel_4);

		panel_5 = new JPanel();
		conversion(785, 293, 75, 74);
		panel_5.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		panel_5.setLayout(new BorderLayout());
		panel_5.setOpaque(true);
		panel_5.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panel_5);

		panel_6 = new JPanel();
		conversion(104, 514, 75, 74);
		panel_6.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		panel_6.setLayout(new BorderLayout());
		panel_6.setOpaque(true);
		panel_6.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panel_6);

		panel_7 = new JPanel();
		conversion(240, 514, 75, 74);
		panel_7.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		panel_7.setLayout(new BorderLayout());
		panel_7.setOpaque(true);
		panel_7.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panel_7);

		panel_8 = new JPanel();
		conversion(376, 514, 75, 74);
		panel_8.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		panel_8.setLayout(new BorderLayout());
		panel_8.setOpaque(true);
		panel_8.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panel_8);

		panel_9 = new JPanel();
		conversion(510, 514, 75, 74);
		panel_9.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		panel_9.setLayout(new BorderLayout());
		panel_9.setOpaque(true);
		panel_9.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panel_9);

		panel_10 = new JPanel();
		conversion(646, 514, 75, 74);
		panel_10.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		panel_10.setLayout(new BorderLayout());
		panel_10.setOpaque(true);
		panel_10.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panel_10);

		panel_11 = new JPanel();
		conversion(785, 514, 75, 74);
		panel_11.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		panel_11.setLayout(new BorderLayout());
		panel_11.setOpaque(false);
		panel_11.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(panel_11);

		panel_6.setVisible(false);
		panel_7.setVisible(false);
		panel_8.setVisible(false);
		panel_9.setVisible(false);
		panel_10.setVisible(false);
		panel_11.setVisible(false);
		// Create Label for Stored
		JLabel lblNewLabel = new JLabel("Stored Dice");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		conversion(29, 426, 143, 47);
		lblNewLabel.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		contentPane.add(lblNewLabel);

		// Create Label for Farkle
		JLabel lblFarkle = new JLabel("Farkle Multiplayer");
		lblFarkle.setForeground(new Color(255, 255, 255));
		lblFarkle.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		conversion(22, 18, 422, 61);
		lblFarkle.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		contentPane.add(lblFarkle);

		// Create Label for Game Leaderboard
		JLabel lblGameStandings = new JLabel("Game Standing");
		lblGameStandings.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameStandings.setForeground(new Color(255, 255, 255));
		lblGameStandings.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		conversion(1023, 39, 174, 40);
		lblGameStandings.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		contentPane.add(lblGameStandings);

		// Create button to go back to home page
		JButton btnHomePage = new JButton("Exit Current Game");
		btnHomePage.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frame.setVisible(true);
			}
		});
		// Set bounds for home page button
		conversion(1023, 627, 174, 48);
		btnHomePage.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		contentPane.add(btnHomePage);

		// Create label for Your roll
		JLabel lblYourRoll = new JLabel("Your Current Roll (Click to store)");
		lblYourRoll.setForeground(new Color(255, 255, 255));
		lblYourRoll.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		conversion(29, 233, 363, 40);
		lblYourRoll.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		contentPane.add(lblYourRoll);

		// CREATE STORE DICE BUTTON
		// __________________________________________________________
		JButton btnStoreDice = new JButton("Store Dice");
		btnStoreDice.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		conversion(523, 419, 150, 54);
		btnStoreDice.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		contentPane.add(btnStoreDice);

		JButton btnEndTurn = new JButton("End Turn");
		btnEndTurn.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		btnEndTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gClient.sendJSON("SCORE", name, "SCORING", gClient.getDice(), 0, 0);
			}
		});
		conversion(419, 623, 165, 48);
		btnEndTurn.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		contentPane.add(btnEndTurn);

		txtpnScore = new JTextPane();
		txtpnScore.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtpnScore.setText("Your Total Score:");
		conversion(1023, 105, 174, 47);
		txtpnScore.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		contentPane.add(txtpnScore);

		txtpnStoredScore = new JTextPane();
		txtpnStoredScore.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtpnStoredScore.setText("Stored Score:");
		conversion(1023, 189, 174, 47);
		txtpnStoredScore.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		contentPane.add(txtpnStoredScore);

		txtpnStatus = new JTextPane();
		txtpnStatus.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		txtpnStatus.setText("Game Status:");
		conversion(32, 105, 274, 40);
		txtpnStatus.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		contentPane.add(txtpnStatus);

		txtpnHowYouStack = new JTextPane();
		txtpnHowYouStack.setText("How you stack up:");
		txtpnHowYouStack.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		conversion(1023, 285, 174, 276);
		txtpnHowYouStack.setBounds((int) Math.round(storeDemensions.get(0)), (int) Math.round(storeDemensions.get(1)),
				(int) Math.round(storeDemensions.get(2)), (int) Math.round(storeDemensions.get(3)));
		contentPane.add(txtpnHowYouStack);
		
		//Multiplayer Dialogue
		int multi = JOptionPane.YES_NO_OPTION;
		String mp;
        int mResult = JOptionPane.showConfirmDialog (null, "Multiplayer","Would you like to play with other's", multi);
        if(mResult == JOptionPane.YES_OPTION){
        	mp = "1";
        	gClient.sendJSON("MULTI", name, mp, null, 0, 0);
        }
        else{
        	mp = "0";
        	gClient.sendJSON("MULTI", name, mp, null, 0, 0);
        }
        System.out.println("MP:"+mp);
		// ROLL DICE BUTTON LISTERNER
		// __________________________________________________________
		btnRollDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeData.removeAll(storeData);
				for (int i = 0; i < 6; i++) {
					storeData.add(0);
				}
				btnRollDice.setEnabled(false);
				gClient.sendJSON("ROLL", name, "ROLLING", gClient.getDice(), 0, 0);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				ArrayList<Integer> dice = gClient.getDice();

				// DICE
				// 1---------------------------------------------------------
				panel.removeAll();
				Image img = null;
				String diceName = "/0.jpg";
				JButton picLabel = new JButton("");
				picLabel.setBackground(new Color(0, 0, 0, 0));

				if (!panel_6.isVisible()) {
					diceName = rollFunction(dice);

					img = new ImageIcon(this.getClass().getResource(diceName)).getImage();
					picLabel.setIcon(new ImageIcon(img));
					conversion(6, 6, 285, 266);
					picLabel.setBounds((int) Math.round(storeDemensions.get(0)),
							(int) Math.round(storeDemensions.get(1)), (int) Math.round(storeDemensions.get(2)),
							(int) Math.round(storeDemensions.get(3)));
					panel.add(picLabel);
					if (diceName.equals("/0.jpg")) {
						panel.setVisible(false);
					}
					JButton picLabel7 = new JButton("");
					picLabel7.setBackground(new Color(0, 0, 0, 0));
					picLabel7.setIcon(new ImageIcon(img));
					conversion(6, 6, 285, 266);
					picLabel7.setBounds((int) Math.round(storeDemensions.get(0)),
							(int) Math.round(storeDemensions.get(1)), (int) Math.round(storeDemensions.get(2)),
							(int) Math.round(storeDemensions.get(3)));
					panel_6.add(picLabel7);

					picLabel7.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.out.println("STORE MEEEE");
							storeData.set(0, 0);
							panel.removeAll();
							panel.add(picLabel);
							panel.setVisible(true);
							panel_6.setVisible(false);
							

						}
					});
				}

				String[] result = diceName.split("/|\\.");
				String temp = result[1];
				int rolledA = Integer.parseInt(temp);

				picLabel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// System.out.println(rolledA);
						storeData.set(0, rolledA);
						panel.setVisible(false);
						panel_6.setVisible(true);
						

					}
				});

				// DICE
				// 2---------------------------------------------------------
				panel_1.removeAll();
				JButton picLabel2 = new JButton("");
				Image img2 = null;
				String diceName2 = "/0.jpg";
				picLabel2.setBackground(new Color(0, 0, 0, 0));
				if (!panel_7.isVisible()) {
					diceName2 = rollFunction(dice);

					img2 = new ImageIcon(this.getClass().getResource(diceName2)).getImage();
					picLabel2.setIcon(new ImageIcon(img2));
					conversion(6, 6, 285, 266);
					picLabel2.setBounds((int) Math.round(storeDemensions.get(0)),
							(int) Math.round(storeDemensions.get(1)), (int) Math.round(storeDemensions.get(2)),
							(int) Math.round(storeDemensions.get(3)));
					panel_1.add(picLabel2);
					if (diceName2.equals("/0.jpg")) {
						panel_1.setVisible(false);
					}
					JButton picLabel8 = new JButton("");
					picLabel8.setIcon(new ImageIcon(img2));
					picLabel8.setBackground(new Color(0, 0, 0, 0));
					conversion(6, 6, 285, 266);
					picLabel8.setBounds((int) Math.round(storeDemensions.get(0)),
							(int) Math.round(storeDemensions.get(1)), (int) Math.round(storeDemensions.get(2)),
							(int) Math.round(storeDemensions.get(3)));
					panel_7.add(picLabel8);
					picLabel8.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							storeData.set(1, 0);
							panel_1.removeAll();
							panel_1.add(picLabel2);
							panel_1.setVisible(true);
							panel_7.setVisible(false);
							
						}
					});

				}

				String[] result2 = diceName2.split("/|\\.");
				String temp2 = result2[1];
				int rolledA2 = Integer.parseInt(temp2);
				// panel_7.setVisible(false);

				picLabel2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// System.out.println(rolledA2);
						storeData.set(1, rolledA2);
						panel_1.setVisible(false);
						panel_7.setVisible(true);
						
					}
				});

				// DICE
				// 3---------------------------------------------------------

				panel_2.removeAll();
				JButton picLabel3 = new JButton("");
				Image img3 = null;
				String diceName3 = "/0.jpg";
				picLabel3.setBackground(new Color(0, 0, 0, 0));
				if (!panel_8.isVisible()) {
					diceName3 = rollFunction(dice);
					if (diceName3.equals("/0.jpg")) {
						panel_2.setVisible(false);
					}
					img3 = new ImageIcon(this.getClass().getResource(diceName3)).getImage();
					picLabel3.setIcon(new ImageIcon(img3));
					conversion(6, 6, 285, 266);
					picLabel3.setBounds((int) Math.round(storeDemensions.get(0)),
							(int) Math.round(storeDemensions.get(1)), (int) Math.round(storeDemensions.get(2)),
							(int) Math.round(storeDemensions.get(3)));
					panel_2.add(picLabel3);
					JButton picLabel9 = new JButton("");
					picLabel9.setBackground(new Color(0, 0, 0, 0));
					picLabel9.setIcon(new ImageIcon(img3));
					conversion(6, 6, 285, 266);
					picLabel9.setBounds((int) Math.round(storeDemensions.get(0)),
							(int) Math.round(storeDemensions.get(1)), (int) Math.round(storeDemensions.get(2)),
							(int) Math.round(storeDemensions.get(3)));
					panel_8.add(picLabel9);
					picLabel9.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							storeData.set(2, 0);
							panel_2.removeAll();
							panel_2.add(picLabel3);
							panel_2.setVisible(true);
							panel_8.setVisible(false);
						
						}
					});
				}

				String[] result3 = diceName3.split("/|\\.");
				String temp3 = result3[1];
				int rolledA3 = Integer.parseInt(temp3);
				// panel_8.setVisible(false);

				picLabel3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// System.out.println(rolledA3);
						storeData.set(2, rolledA3);
						panel_2.setVisible(false);
						panel_8.setVisible(true);
						
					}
				});

				// DICE
				// 4---------------------------------------------------------

				panel_3.removeAll();
				JButton picLabel4 = new JButton("");
				Image img4 = null;
				String diceName4 = "/0.jpg";
				picLabel4.setBackground(new Color(0, 0, 0, 0));
				if (!panel_9.isVisible()) {
					diceName4 = rollFunction(dice);
					if (diceName4.equals("/0.jpg")) {
						panel_3.setVisible(false);
					}
					img4 = new ImageIcon(this.getClass().getResource(diceName4)).getImage();
					picLabel4.setIcon(new ImageIcon(img4));
					conversion(6, 6, 285, 266);
					picLabel4.setBounds((int) Math.round(storeDemensions.get(0)),
							(int) Math.round(storeDemensions.get(1)), (int) Math.round(storeDemensions.get(2)),
							(int) Math.round(storeDemensions.get(3)));
					panel_3.add(picLabel4);
					JButton picLabel10 = new JButton("");
					picLabel10.setBackground(new Color(0, 0, 0, 0));
					picLabel10.setIcon(new ImageIcon(img4));
					conversion(6, 6, 285, 266);
					picLabel10.setBounds((int) Math.round(storeDemensions.get(0)),
							(int) Math.round(storeDemensions.get(1)), (int) Math.round(storeDemensions.get(2)),
							(int) Math.round(storeDemensions.get(3)));
					panel_9.add(picLabel10);

					picLabel10.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							storeData.set(3, 0);
							panel_3.removeAll();
							panel_3.add(picLabel4);
							panel_3.setVisible(true);
							panel_9.setVisible(false);
							
						}
					});
				}

				String[] result4 = diceName4.split("/|\\.");
				String temp4 = result4[1];
				int rolledA4 = Integer.parseInt(temp4);
				// panel_9.setVisible(false);

				picLabel4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// System.out.println(rolledA4);
						storeData.set(3, rolledA4);
						panel_3.setVisible(false);
						panel_9.setVisible(true);
						
						
					}
				});

				// DICE
				// 5---------------------------------------------------------

				panel_4.removeAll();
				JButton picLabel5 = new JButton("");
				Image img5 = null;
				String diceName5 = "/0.jpg";
				picLabel5.setBackground(new Color(0, 0, 0, 0));
				if (!panel_10.isVisible()) {
					diceName5 = rollFunction(dice);

					if (diceName5.equals("/0.jpg")) {
						panel_4.setVisible(false);
					}
					img5 = new ImageIcon(this.getClass().getResource(diceName5)).getImage();
					picLabel5.setIcon(new ImageIcon(img5));
					conversion(6, 6, 285, 266);
					picLabel5.setBounds((int) Math.round(storeDemensions.get(0)),
							(int) Math.round(storeDemensions.get(1)), (int) Math.round(storeDemensions.get(2)),
							(int) Math.round(storeDemensions.get(3)));
					panel_4.add(picLabel5);

					JButton picLabel11 = new JButton("");
					picLabel11.setIcon(new ImageIcon(img5));
					picLabel11.setBackground(new Color(0, 0, 0, 0));
					conversion(6, 6, 285, 266);
					picLabel11.setBounds((int) Math.round(storeDemensions.get(0)),
							(int) Math.round(storeDemensions.get(1)), (int) Math.round(storeDemensions.get(2)),
							(int) Math.round(storeDemensions.get(3)));
					panel_10.add(picLabel11);

					picLabel11.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							storeData.set(4, 0);
							panel_4.removeAll();
							panel_4.add(picLabel5);
							panel_4.setVisible(true);
							panel_10.setVisible(false);
							
						}
					});

				}

				String[] result5 = diceName5.split("/|\\.");
				String temp5 = result5[1];
				int rolledA5 = Integer.parseInt(temp5);
				// panel_10.setVisible(false);

				picLabel5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// System.out.println(rolledA5);
						storeData.set(4, rolledA5);
						panel_4.setVisible(false);
						panel_10.setVisible(true);
						
					}
				});

				// DICE
				// 6---------------------------------------------------------

				panel_5.removeAll();
				JButton picLabel6 = new JButton("");
				String diceName6 = "/0.jpg";
				Image img6 = null;
				picLabel6.setBackground(new Color(0, 0, 0, 0));
				if (!panel_11.isVisible()) {
					diceName6 = rollFunction(dice);

					if (diceName6.equals("/0.jpg")) {
						panel_5.setVisible(false);
					}
					img6 = new ImageIcon(this.getClass().getResource(diceName6)).getImage();
					picLabel6.setIcon(new ImageIcon(img6));
					conversion(6, 6, 285, 266);
					picLabel6.setBounds((int) Math.round(storeDemensions.get(0)),
							(int) Math.round(storeDemensions.get(1)), (int) Math.round(storeDemensions.get(2)),
							(int) Math.round(storeDemensions.get(3)));
					panel_5.add(picLabel6);

					JButton picLabel12 = new JButton("");
					picLabel12.setIcon(new ImageIcon(img6));
					picLabel12.setBackground(new Color(0, 0, 0, 0));
					conversion(6, 6, 285, 266);
					picLabel12.setBounds((int) Math.round(storeDemensions.get(0)),
							(int) Math.round(storeDemensions.get(1)), (int) Math.round(storeDemensions.get(2)),
							(int) Math.round(storeDemensions.get(3)));
					panel_11.add(picLabel12);

					picLabel12.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							storeData.set(5, 0);
							panel_5.removeAll();
							panel_5.add(picLabel6);
							panel_5.setVisible(true);
							panel_11.setVisible(false);
						
						}
					});

				}

				String[] result6 = diceName6.split("/|\\.");
				String temp6 = result6[1];
				int rolledA6 = Integer.parseInt(temp6);
				// panel_11.setVisible(false);

				picLabel6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// System.out.println(rolledA6);
						storeData.set(5, rolledA6);
						panel_5.setVisible(false);
						panel_11.setVisible(true);
						
					}
				});

				contentPane.revalidate();
				if (gClient.getError().equals("Farkle") || gClient.getError().equals("Status Waiting")) {

					JOptionPane.showMessageDialog(null, "Farkle", "Please Wait", JOptionPane.ERROR_MESSAGE);
					txtpnScore.setText("Score: " + 0);
					txtpnStoredScore.setText("Stored Score: " + 0);

				}

			}
		}); // END OF BUTTON LISTENER ROLL DICE

		// INSERT THE BACKGROUND DICE
		// IMAGE--------------------------------------
		JLabel background = new JLabel();
		background.setBounds(0, 0, screenSize.width, screenSize.height);
		Image backgroundImg = null;

		if (screenSize.width <= 1280) {
			backgroundImg = new ImageIcon(this.getClass().getResource("/blackDie1280.jpg")).getImage();
		} else if (screenSize.width > 1280 && screenSize.width <= 1440) {
			backgroundImg = new ImageIcon(this.getClass().getResource("/blackDie1440.jpg")).getImage();
		} else {
			backgroundImg = new ImageIcon(this.getClass().getResource("/blackDie1920.jpg")).getImage();
		}
		background.setIcon(new ImageIcon(backgroundImg));
		contentPane.add(background);

		// STORE DICE BUTTON LISTERNER
		// __________________________________________________________
		btnStoreDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("STORED DATA");
				for (int i = 0; i < storeData.size(); i++) {
					System.out.print(storeData.get(i));
				}
				gClient.sendJSON("STORE", name, "STORE", storeData, gClient.getScore(), gClient.getStoredScore());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (!gClient.getError().equals("Error")) {
					// panel.setVisible(true);
					// panel_1.setVisible(true);
					// panel_2.setVisible(true);
					// panel_3.setVisible(true);
					// panel_4.setVisible(true);
					// panel_5.setVisible(true);
					panel.removeAll();
					panel_1.removeAll();
					panel_2.removeAll();
					panel_3.removeAll();
					panel_4.removeAll();
					panel_5.removeAll();
					if(!panel_6.isVisible())
					panel_6.removeAll();
					if(!panel_7.isVisible())
					panel_7.removeAll();
					if(!panel_8.isVisible())
					panel_8.removeAll();
					if(!panel_9.isVisible())
					panel_9.removeAll();
					if(!panel_10.isVisible())
					panel_10.removeAll();
					if(!panel_11.isVisible())
					panel_11.removeAll();
					btnRollDice.setEnabled(true);
					gClient.getStoredScore();

					if (panel_6.isVisible() && panel_7.isVisible() && panel_8.isVisible() && panel_9.isVisible()
							&& panel_10.isVisible() && panel_11.isVisible()) {
						panel.setVisible(true);
						panel_1.setVisible(true);
						panel_2.setVisible(true);
						panel_3.setVisible(true);
						panel_4.setVisible(true);
						panel_5.setVisible(true);
						panel_6.setVisible(false);
						panel_7.setVisible(false);
						panel_8.setVisible(false);
						panel_9.setVisible(false);
						panel_10.setVisible(false);
						panel_11.setVisible(false);
						panel_6.removeAll();
						panel_7.removeAll();
						panel_8.removeAll();
						panel_9.removeAll();
						panel_10.removeAll();
						panel_11.removeAll();
						

					}
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Store", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}// END OF PUBLIC GAMEPAGE

	public void conversion(int x, int y, int w, int h) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double sw = screenSize.width;
		double sh = screenSize.height;
		double temp1 = sw / x;
		double a = (sw / temp1);
		System.out.print("temp1= " + temp1);
		System.out.print("a is : " + a);
		storeDemensions.set(0, a);

		double temp2 = sh / y;
		double b = (sh / temp2);
		storeDemensions.set(1, b);

		double temp3 = sw / w;
		double c = (sw / temp3);
		storeDemensions.set(2, c);

		double temp4 = sh / h;
		double d = (sh / temp4);
		storeDemensions.set(3, d);

	}

	public String rollFunction(List<Integer> dice) {
		String pictureName = "/0.jpg";
		;
		int randomNum = 0;
		if (dice.size() > 0) {
			randomNum = dice.get(0);
			dice.remove(0);
		}

		if (randomNum == 1)
			pictureName = "/1.png";
		else if (randomNum == 2)
			pictureName = "/2.png";
		else if (randomNum == 3)
			pictureName = "/3.png";
		else if (randomNum == 4)
			pictureName = "/4.png";
		else if (randomNum == 5)
			pictureName = "/5.png";
		else if (randomNum == 6)
			pictureName = "/6.png";
		else
			pictureName = "/0.jpg";

		return pictureName;
	}

	@Override
	public void updateStatus(ServerCommand command) {
		

		if(command.getCommand().equals("WIN"))
		{
			JOptionPane.showMessageDialog(null, command.getMessage());
		}
		
		if (command.getCommand().equals("Status Rolling") && command.getMessage().contains(("please roll")) && command.getName().equals(name)) {
			txtpnHowYouStack.setText("Player: " + command.getName() + " " + command.getScore() + "\n" +name +" "+ + gClient.getScore()+"\n"+ gClient.getOppenentScore());
			panel.removeAll();
			panel_1.removeAll();
			panel_2.removeAll();
			panel_3.removeAll();
			panel_4.removeAll();
			panel_5.removeAll();
			panel_6.removeAll();
			panel_7.removeAll();
			panel_8.removeAll();
			panel_9.removeAll();
			panel_10.removeAll();
			panel_11.removeAll();

			panel.setVisible(true);
			panel_1.setVisible(true);
			panel_2.setVisible(true);
			panel_3.setVisible(true);
			panel_4.setVisible(true);
			panel_5.setVisible(true);

			panel_6.setVisible(false);
			panel_7.setVisible(false);
			panel_8.setVisible(false);
			panel_9.setVisible(false);
			panel_10.setVisible(false);
			panel_11.setVisible(false);
			btnRollDice.setEnabled(true);
			JOptionPane.showMessageDialog(null, command.getMessage(), "Status Rolling",
					JOptionPane.INFORMATION_MESSAGE);
			
		}
	
       
        		
        	
       
        

		if (command.getCommand().equals("Status Waiting") && command.getMessage().startsWith("YOU ARE")
				&& command.getName().equals(name)) {
			


			if (command.getName().equals(name)&&command.getMessage().charAt(command.getMessage().length() - 1) == '0') {
				SettingsDialogue sd = new SettingsDialogue();
				int result = JOptionPane.showConfirmDialog(null, sd, "Game Settings", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					System.out.println("value: " + sd.getSettings());
					// send settings message order:max points, threshold, 3
					// pair, 4+, straight, full, farkle deduction
					gClient.sendJSON("SETTINGS", command.getName(), sd.getSettings(), null, 0, 0);

				}

			}
			JOptionPane.showMessageDialog(null,
					command.getMessage() + "\n Hello " + command.getName() + "\nWaiting for other opponents",
					"Status Waiting", JOptionPane.INFORMATION_MESSAGE);

		}
		if (command.getCommand().equals("Status Waiting") && command.getMessage().contains("connected to the game")) {
			JOptionPane.showMessageDialog(null, command.getMessage(), "Status Waiting",
					JOptionPane.INFORMATION_MESSAGE);
			
		}
		try {
			txtpnScore.setText("Score: " + command.getScore());
			txtpnStoredScore.setText("Stored Score: " + command.getStoredScore());
			txtpnStatus.setText("Status: " + command.getCommand());
			if (command.getCommand().equals("SCORE")) {
				txtpnHowYouStack.setText("Player: " + command.getName() + " " + command.getScore() + "\n" +name +" "+ + gClient.getScore()+"\n"+ gClient.getOppenentScore());
				txtpnStatus.setText("Status: Waiting");
				

			}

		} catch (NullPointerException e) {

		}
		
	}
}
