package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import javax.swing.border.BevelBorder;

public class GamePage extends JFrame {

	//private static final boolean True = false;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public GamePage(GameMainMenu frame) {
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
		Panel panel = new Panel();
		panel.setBounds(22, 205, 117, 90);
		contentPane.add(panel);
		Panel panel_1 = new Panel();
		panel_1.setBounds(158, 205, 117, 90);
		contentPane.add(panel_1);
		Panel panel_2 = new Panel();
		panel_2.setBounds(294, 205, 117, 90);
		contentPane.add(panel_2);
		Panel panel_3 = new Panel();
		panel_3.setBounds(428, 205, 117, 90);
		contentPane.add(panel_3);
		Panel panel_4 = new Panel();
		panel_4.setBounds(564, 205, 117, 90);
		contentPane.add(panel_4);
		Panel panel_5 = new Panel();
		panel_5.setBounds(703, 205, 117, 90);
		contentPane.add(panel_5);
		Panel panel_6 = new Panel();
		panel_6.setBounds(22, 356, 117, 90);
		contentPane.add(panel_6);
		Panel panel_7 = new Panel();
		panel_7.setBounds(158, 356, 117, 90);
		contentPane.add(panel_7);
		Panel panel_8 = new Panel();
		panel_8.setBounds(294, 356, 117, 90);
		contentPane.add(panel_8);
		Panel panel_9 = new Panel();
		panel_9.setBounds(428, 356, 117, 90);
		contentPane.add(panel_9);
		Panel panel_10 = new Panel();
		panel_10.setBounds(564, 356, 117, 90);
		contentPane.add(panel_10);
		Panel panel_11 = new Panel();
		panel_11.setBounds(705, 356, 115, 90);
		contentPane.add(panel_11);
		
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
		lblFarkle.setBounds(22, 31, 185, 51);
		contentPane.add(lblFarkle);
		
		//Create Label for Game Leaderboard
		JLabel lblGameStandings = new JLabel("Game Standing");
		lblGameStandings.setForeground(new Color(255, 255, 255));
		lblGameStandings.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 27));
		lblGameStandings.setBounds(464, 31, 185, 29);
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
		lblYourRoll.setBounds(22, 168, 273, 22);
		contentPane.add(lblYourRoll);
		
		
		//CREATE STORE DICE BUTTON __________________________________________________________
		JButton btnStoreDice = new JButton("Store Dice");
		btnStoreDice.setBounds(428, 310, 117, 29);
		contentPane.add(btnStoreDice);
		
		
		
		//ROLL DICE BUTTON LISTERNER __________________________________________________________
		btnRollDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				
					//DICE 1---------------------------------------------------------
					panel.removeAll();
					JButton picLabel = new JButton("");
					String diceName = rollFunction();
					Image img = new ImageIcon(this.getClass().getResource(diceName)).getImage();
					picLabel.setIcon(new ImageIcon(img));
					picLabel.setBounds(6, 6, 285, 266);
					panel.add(picLabel);
					JButton picLabel7 = new JButton("");
					picLabel7.setIcon(new ImageIcon(img));
					picLabel7.setBounds(6, 6, 285, 266);
					panel_6.add(picLabel7);
					
					String[] result = diceName.split("/|\\.");
				         String temp = result[1];
				         int rolledA = Integer.parseInt(temp);
				         panel_6.setVisible(false);
				         
					picLabel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//System.out.println(rolledA);
							storeData.add(rolledA);
							panel.setVisible(false);
							panel_6.setVisible(true);
							
						}
					});
					
					
					picLabel7.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.out.println("STORE MEEEE");
							storeData.remove((Integer)rolledA);
							panel.removeAll();
							panel.add(picLabel);
							panel.setVisible(true);
							panel_6.setVisible(false);
							
						}
					});
					
					

				
					
					//DICE 2---------------------------------------------------------
					panel_1.removeAll();
					JButton picLabel2 = new JButton("");
					String diceName2 = rollFunction();
					Image img2 = new ImageIcon(this.getClass().getResource(diceName2)).getImage();
					picLabel2.setIcon(new ImageIcon(img2));
					picLabel2.setBounds(6, 6, 285, 266);
					panel_1.add(picLabel2);
					JButton picLabel8 = new JButton("");
					picLabel8.setIcon(new ImageIcon(img2));
					picLabel8.setBounds(6, 6, 285, 266);
					panel_7.add(picLabel8);
					
					String[] result2 = diceName2.split("/|\\.");
			         String temp2 = result2[1];
			         int rolledA2 = Integer.parseInt(temp2);
			         panel_7.setVisible(false);
					
					picLabel2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//System.out.println(rolledA2);
							storeData.add(rolledA2);
							panel_1.setVisible(false);
							panel_7.setVisible(true);
						}
					});
					
					picLabel8.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							storeData.remove((Integer)rolledA2);
							panel_1.removeAll();
							panel_1.add(picLabel2);
							panel_1.setVisible(true);
							panel_7.setVisible(false);
						}
					});
					
					
					//DICE 3---------------------------------------------------------
					
					
					panel_2.removeAll();
					JButton picLabel3 = new JButton("");
					String diceName3 = rollFunction();
					Image img3 = new ImageIcon(this.getClass().getResource(diceName3)).getImage();
					picLabel3.setIcon(new ImageIcon(img3));
					picLabel3.setBounds(6, 6, 285, 266);
					panel_2.add(picLabel3);
					JButton picLabel9 = new JButton("");
					picLabel9.setIcon(new ImageIcon(img3));
					picLabel9.setBounds(6, 6, 285, 266);
					panel_8.add(picLabel9);
					
					String[] result3 = diceName3.split("/|\\.");
			         String temp3 = result3[1];
			         int rolledA3 = Integer.parseInt(temp3);
			         panel_8.setVisible(false);
					
					picLabel3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//System.out.println(rolledA3);
							storeData.add(rolledA3);
							panel_2.setVisible(false);
							panel_8.setVisible(true);
						}
					});
					
					picLabel9.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							storeData.remove((Integer)rolledA3);
							panel_2.removeAll();
							panel_2.add(picLabel3);
							panel_2.setVisible(true);
							panel_8.setVisible(false);
						}
					});
					
					
					
					//DICE 4---------------------------------------------------------
					
					
					panel_3.removeAll();
					JButton picLabel4 = new JButton("");
					String diceName4 = rollFunction();
					Image img4 = new ImageIcon(this.getClass().getResource(diceName4)).getImage();
					picLabel4.setIcon(new ImageIcon(img4));
					picLabel4.setBounds(6, 6, 285, 266);
					panel_3.add(picLabel4);
					JButton picLabel10 = new JButton("");
					picLabel10.setIcon(new ImageIcon(img4));
					picLabel10.setBounds(6, 6, 285, 266);
					panel_9.add(picLabel10);
					
					String[] result4 = diceName4.split("/|\\.");
			         String temp4 = result4[1];
			         int rolledA4 = Integer.parseInt(temp4);
			         panel_9.setVisible(false);
					
					picLabel4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//System.out.println(rolledA4);
							storeData.add(rolledA4);
							panel_3.setVisible(false);
							panel_9.setVisible(true);
						}
					});
					
					picLabel10.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							storeData.remove((Integer)rolledA4);
							panel_3.removeAll();
							panel_3.add(picLabel4);
							panel_3.setVisible(true);
							panel_9.setVisible(false);
						}
					});
					
					
					//DICE 5---------------------------------------------------------
					
					panel_4.removeAll();
					JButton picLabel5 = new JButton("");
					String diceName5 = rollFunction();
					Image img5 = new ImageIcon(this.getClass().getResource(diceName5)).getImage();
					picLabel5.setIcon(new ImageIcon(img5));
					picLabel5.setBounds(6, 6, 285, 266);
					panel_4.add(picLabel5);
					JButton picLabel11 = new JButton("");
					picLabel11.setIcon(new ImageIcon(img5));
					picLabel11.setBounds(6, 6, 285, 266);
					panel_10.add(picLabel11);
					
					String[] result5 = diceName5.split("/|\\.");
			         String temp5 = result5[1];
			         int rolledA5 = Integer.parseInt(temp5);
			         panel_10.setVisible(false);
					
					picLabel5.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//System.out.println(rolledA5);
							storeData.add(rolledA5);
							panel_4.setVisible(false);
							panel_10.setVisible(true);
						}
					});
					
					picLabel11.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							storeData.remove((Integer)rolledA5);
							panel_4.removeAll();
							panel_4.add(picLabel5);
							panel_4.setVisible(true);
							panel_10.setVisible(false);
						}
					});
					
					
					
					//DICE 6---------------------------------------------------------
					
					
					panel_5.removeAll();
					JButton picLabel6 = new JButton("");
					String diceName6 = rollFunction();
					Image img6 = new ImageIcon(this.getClass().getResource(diceName6)).getImage();
					picLabel6.setIcon(new ImageIcon(img6));
					picLabel6.setBounds(6, 6, 285, 266);
					panel_5.add(picLabel6);
					JButton picLabel12 = new JButton("");
					picLabel12.setIcon(new ImageIcon(img6));
					picLabel12.setBounds(6, 6, 285, 266);
					panel_11.add(picLabel12);
					
					String[] result6 = diceName6.split("/|\\.");
			         String temp6 = result6[1];
			         int rolledA6 = Integer.parseInt(temp6);
			         panel_11.setVisible(false);
					
					picLabel6.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							//System.out.println(rolledA6);
							storeData.add(rolledA6);
							panel_5.setVisible(false);
							panel_11.setVisible(true);
						}
					});
					
					picLabel12.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							storeData.remove((Integer)rolledA6);
							panel_5.removeAll();
							panel_5.add(picLabel6);
							panel_5.setVisible(true);
							panel_11.setVisible(false);
						}
					});
			contentPane.revalidate();	
			}
		}); //END OF BUTTON LISTENER ROLL DICE
		
		
//STORE DICE BUTTON LISTERNER __________________________________________________________
		btnStoreDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("STORED DATA");
				for(int i =0; i<storeData.size(); i++){
					System.out.print(storeData.get(i));
				}
			}
		});
		
		
		
		
		
	}//END OF PUBLIC GAMEPAGE

	
	

	public static String rollFunction() {
	      String pictureName = "";
	      Random rand = new Random();	
	      int randomNum = rand.nextInt((6 - 1) + 1) + 1;	
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
			else
				pictureName = "/6.jpg";
	      return pictureName; 
	   }
}
