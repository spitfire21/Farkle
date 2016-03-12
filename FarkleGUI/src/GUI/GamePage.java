package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.BevelBorder;

public class GamePage extends JFrame {

	//private static final boolean True = false;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GamePage frame = new GamePage();
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
	public GamePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 489);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnRollDice = new JButton("Roll Dice");
		btnRollDice.setBounds(359, 311, 117, 29);
		contentPane.add(btnRollDice);
		
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
		
		JLabel lblNewLabel = new JLabel("Stored");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 24));
		lblNewLabel.setBounds(22, 328, 117, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblFarkle = new JLabel("Farkle");
		lblFarkle.setForeground(new Color(255, 255, 255));
		lblFarkle.setFont(new Font("Bodoni 72 Smallcaps", Font.BOLD | Font.ITALIC, 65));
		lblFarkle.setBounds(22, 31, 185, 51);
		contentPane.add(lblFarkle);
		
		JLabel lblGameStandings = new JLabel("Game Standing");
		lblGameStandings.setForeground(new Color(255, 255, 255));
		lblGameStandings.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 27));
		lblGameStandings.setBounds(464, 31, 185, 29);
		contentPane.add(lblGameStandings);
		
		JLabel lblHh = new JLabel("__________________________");
		lblHh.setForeground(new Color(255, 255, 255));
		lblHh.setBackground(Color.BLACK);
		lblHh.setBounds(22, 76, 212, 22);
		contentPane.add(lblHh);
		
		JButton btnHomePage = new JButton("Home Page");
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				GameMainMenu home = new GameMainMenu();
				home.setVisible(true);
			}
		});
		btnHomePage.setBounds(722, 17, 117, 29);
		contentPane.add(btnHomePage);
		
		JLabel lblYourRoll = new JLabel("Your Roll (Click to store)");
		lblYourRoll.setForeground(new Color(255, 255, 255));
		lblYourRoll.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 24));
		lblYourRoll.setBounds(22, 168, 273, 22);
		contentPane.add(lblYourRoll);
		
		
		//BUTTON LISTERNER __________________________________________________________
		
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
					
					String[] result = diceName.split("/|\\.");
				         String temp = result[1];
				         int rolledA = Integer.parseInt(temp);
				         //System.out.print(rolledA);
					
					picLabel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.out.println(rolledA);
							panel.setVisible(false);
							panel_6.add(picLabel);
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
					
					String[] result2 = diceName2.split("/|\\.");
			         String temp2 = result2[1];
			         int rolledA2 = Integer.parseInt(temp2);
			         //System.out.print(rolledA2);
					
					picLabel2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.out.println(rolledA2);
							panel_1.setVisible(false);
							panel_7.add(picLabel2);
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
					
					String[] result3 = diceName3.split("/|\\.");
			         String temp3 = result3[1];
			         int rolledA3 = Integer.parseInt(temp3);
			         //System.out.print(rolledA3);
					
					picLabel3.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.out.println(rolledA3);
							panel_2.setVisible(false);
							panel_8.add(picLabel3);
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
					
					String[] result4 = diceName4.split("/|\\.");
			         String temp4 = result4[1];
			         int rolledA4 = Integer.parseInt(temp4);
			         //System.out.print(rolledA4);
					
					picLabel4.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.out.println(rolledA4);
							panel_3.setVisible(false);
							panel_9.add(picLabel4);
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
					
					String[] result5 = diceName5.split("/|\\.");
			         String temp5 = result5[1];
			         int rolledA5 = Integer.parseInt(temp5);
			         //System.out.print(rolledA5);
					
					picLabel5.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.out.println(rolledA5);
							panel_4.setVisible(false);
							panel_10.add(picLabel5);
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
					
					String[] result6 = diceName6.split("/|\\.");
			         String temp6 = result6[1];
			         int rolledA6 = Integer.parseInt(temp6);
			         //System.out.print(rolledA6);
					
					picLabel6.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							System.out.println(rolledA6);
							panel_5.setVisible(false);
							panel_11.add(picLabel6);
						}
					});
					
					
			contentPane.revalidate();	
				
			}
		}); //END OF BUTTON LISTENER ROLL DICE
		
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
