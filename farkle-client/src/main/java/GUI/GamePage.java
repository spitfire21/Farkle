package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
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

public class GamePage extends JFrame implements GUICallBack {

	//private static final boolean True = false;
	private JPanel contentPane;
	private GameClient gClient;
	private Panel panel;
	private Panel panel_2;
	private Panel panel_1;
	private Panel panel_3;
	private Panel panel_4;
	private Panel panel_5;
	private Panel panel_6;
	private Panel panel_7;
	private Panel panel_8;
	private Panel panel_9;
	private Panel panel_10;
	private Panel panel_11;
	
	private String name;
	private JTextPane txtpnScore;
	private JTextPane txtpnStoredScore;
	private JTextPane txtpnStatus;

	/**
	 * Create the frame.
	 */
	public GamePage(GameMainMenu frame, String token, String name) {
		this.name = name;
		gClient = new GameClient(token, name, this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 489);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Create storeDATA LIST
		ArrayList<Integer> storeData = new ArrayList<Integer>();
		
		//Create Roll Dice Button
		JButton btnRollDice = new JButton("Roll Dice");
		btnRollDice.setBounds(294, 310, 117, 29);
		contentPane.add(btnRollDice);
		
		//Create Dice Panels
		panel = new Panel();
		panel.setBounds(22, 205, 117, 90);
		contentPane.add(panel);
		panel_1 = new Panel();
		panel_1.setBounds(158, 205, 117, 90);
		contentPane.add(panel_1);
		panel_2 = new Panel();
		panel_2.setBounds(294, 205, 117, 90);
		contentPane.add(panel_2);
		panel_3 = new Panel();
		panel_3.setBounds(428, 205, 117, 90);
		contentPane.add(panel_3);
		panel_4 = new Panel();
		panel_4.setBounds(564, 205, 117, 90);
		contentPane.add(panel_4);
	    panel_5 = new Panel();
		panel_5.setBounds(703, 205, 117, 90);
		contentPane.add(panel_5);
		 panel_6 = new Panel();
		panel_6.setBounds(22, 356, 117, 90);
		contentPane.add(panel_6);
		panel_7 = new Panel();
		panel_7.setBounds(158, 356, 117, 90);
		contentPane.add(panel_7);
	    panel_8 = new Panel();
		panel_8.setBounds(294, 356, 117, 90);
		contentPane.add(panel_8);
		panel_9 = new Panel();
		panel_9.setBounds(428, 356, 117, 90);
		contentPane.add(panel_9);
		panel_10 = new Panel();
		panel_10.setBounds(564, 356, 117, 90);
		contentPane.add(panel_10);
		panel_11 = new Panel();
		panel_11.setBounds(705, 356, 115, 90);
		contentPane.add(panel_11);
		panel_6.setVisible(false);
		panel_7.setVisible(false);
		panel_8.setVisible(false);
		panel_9.setVisible(false);
		panel_10.setVisible(false);
		panel_11.setVisible(false);
		//Create Label for Stored
		JLabel lblNewLabel = new JLabel("Stored");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 24));
		lblNewLabel.setBounds(22, 328, 117, 22);
		contentPane.add(lblNewLabel);
		
		//Create Label for Farkle
		JLabel lblFarkle = new JLabel("Farkle");
		lblFarkle.setForeground(new Color(255, 255, 255));
		lblFarkle.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD | Font.ITALIC, 65));
		lblFarkle.setBounds(22, 31, 302, 51);
		contentPane.add(lblFarkle);
		
		//Create Label for Game Leaderboard
		JLabel lblGameStandings = new JLabel("Game Standing");
		lblGameStandings.setForeground(new Color(255, 255, 255));
		lblGameStandings.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 27));
		lblGameStandings.setBounds(464, 31, 240, 29);
		contentPane.add(lblGameStandings);
		
		//Create Label for underline for Farkle
		JLabel lblHh = new JLabel("__________________________");
		lblHh.setForeground(new Color(255, 255, 255));
		lblHh.setBackground(Color.BLACK);
		lblHh.setBounds(22, 76, 212, 22);
		contentPane.add(lblHh);
		
		//Create button to go back to home page
		JButton btnHomePage = new JButton("Home Page");
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frame.setVisible(true);
			}
		});
		//Set bounds for home page button
		btnHomePage.setBounds(722, 17, 117, 29);
		contentPane.add(btnHomePage);
		
		//Create label for Your roll
		JLabel lblYourRoll = new JLabel("Your Roll (Click to store)");
		lblYourRoll.setForeground(new Color(255, 255, 255));
		lblYourRoll.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 24));
		lblYourRoll.setBounds(22, 168, 359, 22);
		contentPane.add(lblYourRoll);
		
		
		//CREATE STORE DICE BUTTON __________________________________________________________
		JButton btnStoreDice = new JButton("Store Dice");
		btnStoreDice.setBounds(428, 310, 117, 29);
		contentPane.add(btnStoreDice);
		
		JButton btnEndTurn = new JButton("End Turn");
		btnEndTurn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gClient.sendJSON("SCORE", name, "SCORING", gClient.getDice(), 0, 0);
			}
		});
		btnEndTurn.setBounds(364, 171, 117, 25);
		contentPane.add(btnEndTurn);
		
		txtpnScore = new JTextPane();
		txtpnScore.setText("Score");
		txtpnScore.setBounds(464, 72, 207, 21);
		contentPane.add(txtpnScore);
		
		txtpnStoredScore = new JTextPane();
		txtpnStoredScore.setText("Stored Score");
		txtpnStoredScore.setBounds(464, 105, 207, 21);
		contentPane.add(txtpnStoredScore);
		
		txtpnStatus = new JTextPane();
		txtpnStatus.setText("Status:");
		txtpnStatus.setBounds(32, 105, 150, 40);
		contentPane.add(txtpnStatus);
		
		
		
		//ROLL DICE BUTTON LISTERNER __________________________________________________________
		btnRollDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storeData.removeAll(storeData);
				for(int i = 0; i < 6; i++){
					storeData.add(0);
				}
				gClient.sendJSON("ROLL", name, "ROLLING", gClient.getDice(), 0, 0);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
					ArrayList<Integer> dice = gClient.getDice();
					
					//DICE 1---------------------------------------------------------
					panel.removeAll();
					Image img = null;
					String diceName = "/0.jpg";
					JButton picLabel = new JButton("");
					if(!panel_6.isVisible()){
					diceName = rollFunction(dice);
					
					img = new ImageIcon(this.getClass().getResource(diceName)).getImage();
					picLabel.setIcon(new ImageIcon(img));
					picLabel.setBounds(6, 6, 285, 266);
					panel.add(picLabel);
					if(diceName.equals("/0.jpg")){
						panel.setVisible(false);
					}
					JButton picLabel7 = new JButton("");
					picLabel7.setIcon(new ImageIcon(img));
					picLabel7.setBounds(6, 6, 285, 266);
					panel_6.add(picLabel7);
					
					picLabel7.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.out.println("STORE MEEEE");
							storeData.set(0,0);
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
							//System.out.println(rolledA);
							storeData.set(0,rolledA);
							panel.setVisible(false);
							panel_6.setVisible(true);
							
						}
					});
					
				
					
					

				
					
					//DICE 2---------------------------------------------------------
					panel_1.removeAll();
					JButton picLabel2 = new JButton("");
					Image img2 = null;
					String diceName2 = "/0.jpg";
					if(!panel_7.isVisible()){
					diceName2 = rollFunction(dice);
					
					img2 = new ImageIcon(this.getClass().getResource(diceName2)).getImage();
					picLabel2.setIcon(new ImageIcon(img2));
					picLabel2.setBounds(6, 6, 285, 266);
					panel_1.add(picLabel2);
					if(diceName2.equals("/0.jpg")){
						panel_1.setVisible(false);
					}
					JButton picLabel8 = new JButton("");
					picLabel8.setIcon(new ImageIcon(img2));
					picLabel8.setBounds(6, 6, 285, 266);
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
			      //   panel_7.setVisible(false);
					
					picLabel2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//System.out.println(rolledA2);
							storeData.set(1,rolledA2);
							panel_1.setVisible(false);
							panel_7.setVisible(true);
						}
					});
					
					
					
					//DICE 3---------------------------------------------------------
					
					
					panel_2.removeAll();
					JButton picLabel3 = new JButton("");
					Image img3 = null;
					String diceName3= "/0.jpg";
					if(!panel_8.isVisible()){
					 diceName3 = rollFunction(dice);
					if(diceName3.equals("/0.jpg")){
						panel_2.setVisible(false);
					}
					 img3 = new ImageIcon(this.getClass().getResource(diceName3)).getImage();
					picLabel3.setIcon(new ImageIcon(img3));
					picLabel3.setBounds(6, 6, 285, 266);
					panel_2.add(picLabel3);
					JButton picLabel9 = new JButton("");
					picLabel9.setIcon(new ImageIcon(img3));
					picLabel9.setBounds(6, 6, 285, 266);
					panel_8.add(picLabel9);
					picLabel9.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							storeData.set(2,0);
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
			       //  panel_8.setVisible(false);
					
					picLabel3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//System.out.println(rolledA3);
							storeData.set(2,rolledA3);
							panel_2.setVisible(false);
							panel_8.setVisible(true);
						}
					});
					
					
					
					
					
					//DICE 4---------------------------------------------------------
					
					
					panel_3.removeAll();
					JButton picLabel4 = new JButton("");
					Image img4 = null;
					String diceName4 = "/0.jpg";
					if(!panel_9.isVisible()){
					diceName4 =rollFunction(dice);
					if(diceName4.equals("/0.jpg")){
						panel_3.setVisible(false);
					}
					img4 = new ImageIcon(this.getClass().getResource(diceName4)).getImage();
					picLabel4.setIcon(new ImageIcon(img4));
					picLabel4.setBounds(6, 6, 285, 266);
					panel_3.add(picLabel4);
					JButton picLabel10 = new JButton("");
					picLabel10.setIcon(new ImageIcon(img4));
					picLabel10.setBounds(6, 6, 285, 266);
					panel_9.add(picLabel10);
					
					picLabel10.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							storeData.set(3,0);
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
							//System.out.println(rolledA4);
							storeData.set(3,rolledA4);
							panel_3.setVisible(false);
							panel_9.setVisible(true);
						}
					});
					
					
					
					
					//DICE 5---------------------------------------------------------
					
					panel_4.removeAll();
					JButton picLabel5 = new JButton("");
					Image img5 = null;
					String diceName5 = "/0.jpg";
					if(!panel_10.isVisible()){
					diceName5 = rollFunction(dice);
					
					if(diceName5.equals("/0.jpg")){
						panel_4.setVisible(false);
					}
					img5 = new ImageIcon(this.getClass().getResource(diceName5)).getImage();
					picLabel5.setIcon(new ImageIcon(img5));
					picLabel5.setBounds(6, 6, 285, 266);
					panel_4.add(picLabel5);
					
					JButton picLabel11 = new JButton("");
					picLabel11.setIcon(new ImageIcon(img5));
					picLabel11.setBounds(6, 6, 285, 266);
					panel_10.add(picLabel11);
					
					picLabel11.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							storeData.set(4,0);
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
							//System.out.println(rolledA5);
							storeData.set(4,rolledA5);
							panel_4.setVisible(false);
							panel_10.setVisible(true);
						}
					});
					
					
					
					
					//DICE 6---------------------------------------------------------
					
					
					panel_5.removeAll();
					JButton picLabel6 = new JButton("");
					String diceName6 = "/0.jpg";
					Image img6 = null;
					if(!panel_11.isVisible()){
					diceName6 = rollFunction(dice);
				
					
					if(diceName6.equals("/0.jpg")){
						panel_5.setVisible(false);
					}
				    img6 = new ImageIcon(this.getClass().getResource(diceName6)).getImage();
					picLabel6.setIcon(new ImageIcon(img6));
					picLabel6.setBounds(6, 6, 285, 266);
					panel_5.add(picLabel6);
					
					JButton picLabel12 = new JButton("");
					picLabel12.setIcon(new ImageIcon(img6));
					picLabel12.setBounds(6, 6, 285, 266);
					panel_11.add(picLabel12);
					
					picLabel12.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							storeData.set(5,0);
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
			       //  panel_11.setVisible(false);
					
					picLabel6.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//System.out.println(rolledA6);
							storeData.set(5,rolledA6);
							panel_5.setVisible(false);
							panel_11.setVisible(true);
						}
					});
					
					
			contentPane.revalidate();	
			if(gClient.getError().equals("Farkle") || gClient.getError().equals("Status Waiting") ){
				
				 JOptionPane.showMessageDialog(null, "Farkle", "Please Wait",
						                                    JOptionPane.ERROR_MESSAGE);
				 txtpnScore.setText("Score: " + 0);
					txtpnStoredScore.setText("Stored Score: " + 0);
						
					}
			}
		}); //END OF BUTTON LISTENER ROLL DICE
		
		
//STORE DICE BUTTON LISTERNER __________________________________________________________
		btnStoreDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("STORED DATA");
				for(int i =0; i<storeData.size(); i++){
					System.out.print(storeData.get(i));
				}
				gClient.sendJSON("STORE", name, "STORE", storeData, gClient.getScore(), gClient.getStoredScore());
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!gClient.getError().equals("Error")){
//				panel.setVisible(true);
//				panel_1.setVisible(true);
//				panel_2.setVisible(true);
//				panel_3.setVisible(true);
//				panel_4.setVisible(true);
//				panel_5.setVisible(true);
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
				
				gClient.getStoredScore();
			
					if(panel_6.isVisible()&&panel_7.isVisible()
							&&panel_8.isVisible()&&panel_9.isVisible()
							&&panel_10.isVisible()&&panel_11.isVisible()){
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
						
						
					
				}
				}
				else {
					 JOptionPane.showMessageDialog(null, "Invalid Store", "Error",
                             JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		
		
		
	}//END OF PUBLIC GAMEPAGE


	

	public static String rollFunction(List<Integer> dice) {
	      String pictureName = "/0.jpg";;
	      int randomNum = 0;
	      if(dice.size()>0){
	      randomNum = dice.get(0);
	      dice.remove(0);
	      }
	      
			if (randomNum == 1)
				pictureName = "/1.jpg";
			else if (randomNum == 2)
				pictureName = "/2.jpg";
			else if (randomNum == 3)
				pictureName = "/3.jpg";
			else if (randomNum == 4)
				pictureName = "/4.jpg";
			else if (randomNum == 5)
				pictureName = "/5.jpg";
			else if (randomNum == 6)
				pictureName = "/6.jpg";
			else
				pictureName = "/0.jpg";
	      
	      
	      return pictureName; 
	   }




	@Override
	public void updateStatus(ServerCommand command) {
		
		if(command.getCommand().equals("Status Rolling") && 
				command.getMessage().contains(("please roll")))
				{
			
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
			 JOptionPane.showMessageDialog(null, command.getMessage() , "Status Rolling",
                     JOptionPane.INFORMATION_MESSAGE);
		}
		if(command.getCommand().equals("Status Waiting") && 
				command.getMessage().startsWith("YOU ARE") && command.getName().equals(name)){
			 JOptionPane.showMessageDialog(null, command.getMessage() + "\n Hello "+command.getName()
			 + "\nWaiting for other opponents", "Status Waiting",
                     JOptionPane.INFORMATION_MESSAGE);
		}
		if(command.getCommand().equals("Status Waiting") && command.getMessage().contains("connected to the game")){
			JOptionPane.showMessageDialog(null, command.getMessage(), "Status Waiting",
                    JOptionPane.INFORMATION_MESSAGE);
		}
		try{
		txtpnScore.setText("Score: " + command.getScore());
		txtpnStoredScore.setText("Stored Score: " + command.getStoredScore());
		txtpnStatus.setText("Status: "+ command.getCommand());
		if(command.getCommand().equals("SCORE")){
			txtpnStatus.setText("Status: Waiting");
			
		}
		
		}
		catch(NullPointerException e)
		{
			
		}
	}
}
