package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.SwingConstants;

import edu.plu.cs.farkle.client.CallBack;

public class UserCreationPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * This initializes the UserCreationPage object. This object
	 * serves as the window in which a user will create an
	 * account with which to login to game.
	 */
	public UserCreationPage(final ArrayList callBack, GUI gui) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 489);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(128, 0, 0));
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
		lblCreateANew.setFont(new Font("Arial Black", Font.PLAIN, 26));
		lblCreateANew.setBounds(297, 16, 241, 46);
		desktopPane.add(lblCreateANew);
		
		JLabel lblCreateUsername = new JLabel("Create Username:");
		lblCreateUsername.setForeground(new Color(255, 255, 255));
		lblCreateUsername.setFont(new Font("Arial", Font.PLAIN, 20));
		lblCreateUsername.setBounds(168, 77, 172, 16);
		desktopPane.add(lblCreateUsername);
		
		JLabel lblNewLabel = new JLabel("Create Password:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(168, 141, 172, 16);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Verify Password:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(168, 205, 172, 16);
		desktopPane.add(lblNewLabel_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				gui.setVisible(true);
			}
		});
		btnBack.setBounds(132, 297, 180, 76);
		desktopPane.add(btnBack);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setFont(new Font("Arial", Font.PLAIN, 20));
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
				// failed
				}
				else {
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
		
		passwordField_1 = new JPasswordField();
		passwordField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userPassWordBox2 = passwordField.getText();
			}
		});
		passwordField_1.setBounds(352, 200, 130, 26);
		desktopPane.add(passwordField_1);
	}
}
