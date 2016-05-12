package edu.plu.cs.farkle.client.gui.account;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.plu.cs.farkle.client.account.CallBack;
import edu.plu.cs.farkle.client.gui.GUI;
import edu.plu.cs.farkle.client.gui.game.GameMainMenu;

import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.SwingConstants;

public class UserCreationPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * This initializes the UserCreationPage object. This object
	 * serves as the window in which a user will create an
	 * account with which to login to game.
	 */
	public UserCreationPage(final ArrayList callBack, GUI gui) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 489);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(55, 55, 55));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = textField.getText();
			}
		});
		textField.setBounds(352, 74, 130, 26);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCreateANew = new JLabel("New Account");
		lblCreateANew.setForeground(Color.WHITE);
		lblCreateANew.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateANew.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblCreateANew.setBounds(297, 16, 241, 46);
		desktopPane.add(lblCreateANew);
		
		JLabel lblCreateUsername = new JLabel("Create Username:");
		lblCreateUsername.setForeground(new Color(255, 255, 255));
		lblCreateUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCreateUsername.setBounds(150, 77, 190, 16);
		desktopPane.add(lblCreateUsername);
		
		JLabel lblNewLabel = new JLabel("Create Password:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(150, 141, 190, 16);
		desktopPane.add(lblNewLabel);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				gui.setVisible(true);
			}
		});
		btnBack.setBounds(132, 297, 180, 76);
		desktopPane.add(btnBack);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnCreateAccount.addActionListener(new ActionListener() {
			
			// serves to verify user credentials (make sure they are unique, passwords match, etc)
			public void actionPerformed(ActionEvent e) {
				
				String registered = "";
				for (Iterator it = callBack.iterator(); it.hasNext();){
					CallBack callback = (CallBack)it.next();
					registered = callback.createAccount(textField.getText(),passwordField.getText());
					callback.login(textField.getText(), passwordField.getText());
					
				}
				
				if (registered.equals("User Already Exists") || registered == null){
					JOptionPane.showMessageDialog(null, "Account already exits. Please change your username.");
				}
				else {
					JOptionPane.showMessageDialog(null, "Account successfully created!");
					setVisible(false);
				GameMainMenu gameMenu = new GameMainMenu(callBack);
				gameMenu.setVisible(true);
				}
			}
		});
		btnCreateAccount.setBounds(538, 297, 180, 76);
		desktopPane.add(btnCreateAccount);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userPassWordBox1 = passwordField.getText();
			}
		});
		passwordField.setBounds(352, 136, 130, 26);
		desktopPane.add(passwordField);
	}
}
