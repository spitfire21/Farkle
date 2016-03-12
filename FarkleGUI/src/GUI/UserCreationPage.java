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
import javax.swing.SwingConstants;

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
		setBounds(100, 100, 845, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(128, 0, 0));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setBounds(352, 74, 130, 26);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCreateANew = new JLabel("Create a new Account");
		lblCreateANew.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateANew.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 26));
		lblCreateANew.setBounds(297, 16, 241, 46);
		desktopPane.add(lblCreateANew);
		
		JLabel lblCreateUsername = new JLabel("Create Username:");
		lblCreateUsername.setForeground(new Color(255, 255, 255));
		lblCreateUsername.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		lblCreateUsername.setBounds(168, 70, 144, 16);
		desktopPane.add(lblCreateUsername);
		
		JLabel lblNewLabel = new JLabel("Create Password:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		lblNewLabel.setBounds(168, 141, 144, 16);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Verify Password:");
		lblNewLabel_1.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(168, 205, 144, 16);
		desktopPane.add(lblNewLabel_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				GUI guiNew = new GUI();
				guiNew.setVisible(true);
			}
		});
		btnBack.setBounds(132, 297, 180, 76);
		desktopPane.add(btnBack);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//assuming login is valid
				GameMainMenu gameMenu = new GameMainMenu();
				gameMenu.setVisible(true);
			}
		});
		btnCreateAccount.setBounds(538, 297, 180, 76);
		desktopPane.add(btnCreateAccount);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(352, 136, 130, 26);
		desktopPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(352, 200, 130, 26);
		desktopPane.add(passwordField_1);
	}
}
