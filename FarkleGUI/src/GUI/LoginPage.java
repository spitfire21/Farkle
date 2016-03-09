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
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public LoginPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setBounds(158, 84, 130, 26);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(65, 89, 81, 16);
		desktopPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(65, 144, 61, 16);
		desktopPane.add(lblPassword);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				GUI test2 = new GUI();
				test2.setVisible(true);
				
			}
		});
		btnBack.setBounds(65, 205, 117, 29);
		desktopPane.add(btnBack);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//assuming login is valid
				GameMainMenu gameMenu = new GameMainMenu();
				gameMenu.setVisible(true);
			}
		});
		btnLogin.setBounds(254, 205, 117, 29);
		desktopPane.add(btnLogin);
		
		JLabel lblFarkle = new JLabel("FARKLE");
		lblFarkle.setBounds(196, 29, 61, 16);
		desktopPane.add(lblFarkle);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 139, 130, 26);
		desktopPane.add(passwordField);
	}
}
