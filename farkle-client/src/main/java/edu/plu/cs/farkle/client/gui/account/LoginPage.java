package edu.plu.cs.farkle.client.gui.account;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import sun.audio.*;
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
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Creates the frame for the LoginPage object.
	 * LoginPage represents the window in which
	 * a user will login to his/her account in order
	 * to be able to participate in the game.
	 */
	public LoginPage(final ArrayList callBack, GUI gui) {
		
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
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
				String userUserNameInput = textField.getText();
				System.out.println(userUserNameInput);
				//...
			}
		});
		textField.setBounds(352, 147, 130, 26);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblUsername.setBounds(200, 150, 150, 23);
		desktopPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPassword.setBounds(200, 249, 150, 23);
		desktopPane.add(lblPassword);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				gui.setVisible(true);
				
			}
		});
		btnBack.setBounds(84, 316, 165, 80);
		desktopPane.add(btnBack);
		
		JButton btnLogin2 = new JButton("Login");
		btnLogin2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLogin2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String token = "";
				for (Iterator it = callBack.iterator(); it.hasNext();)
					token = ((CallBack)(it.next())).login(textField.getText(),passwordField.getText());
				if(token.length() < 8){
					JOptionPane.showMessageDialog(null, "Login Failed. Please enter a correct username and/or password.");
				}
				else{
					setVisible(false);
				GameMainMenu gameMenu = new GameMainMenu(callBack);
				gameMenu.setVisible(true);
				}
			}
		});
		btnLogin2.setBounds(595, 316, 165, 80);
		desktopPane.add(btnLogin2);
		
		JLabel lblFarkle = new JLabel("FARKLE:\nLogin");
		lblFarkle.setForeground(new Color(255, 255, 255));
		lblFarkle.setFont(new Font("Times New Roman", Font.PLAIN, 56));
		lblFarkle.setHorizontalAlignment(SwingConstants.CENTER);
		lblFarkle.setBounds(190, 6, 454, 137);
		desktopPane.add(lblFarkle);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = passwordField.getText();
				System.out.println(password);
				
			}
		});
		passwordField.setBounds(352, 246, 130, 26);
		desktopPane.add(passwordField);
	}
}
