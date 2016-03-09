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

public class UserCreationPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Create the frame.
	 */
	public UserCreationPage() {
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
		textField.setBounds(155, 65, 130, 26);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCreateANew = new JLabel("Create a new Account");
		lblCreateANew.setBounds(151, 16, 138, 16);
		desktopPane.add(lblCreateANew);
		
		JLabel lblCreateUsername = new JLabel("Create Username");
		lblCreateUsername.setBounds(24, 70, 119, 16);
		desktopPane.add(lblCreateUsername);
		
		JLabel lblNewLabel = new JLabel("Create Password");
		lblNewLabel.setBounds(24, 119, 104, 16);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Verify Password");
		lblNewLabel_1.setBounds(24, 170, 104, 16);
		desktopPane.add(lblNewLabel_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				GUI guiNew = new GUI();
				guiNew.setVisible(true);
			}
		});
		btnBack.setBounds(66, 215, 117, 29);
		desktopPane.add(btnBack);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//assuming login is valid
				GameMainMenu gameMenu = new GameMainMenu();
				gameMenu.setVisible(true);
			}
		});
		btnCreateAccount.setBounds(235, 215, 138, 29);
		desktopPane.add(btnCreateAccount);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(155, 114, 130, 26);
		desktopPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(155, 165, 130, 26);
		desktopPane.add(passwordField_1);
	}
}
