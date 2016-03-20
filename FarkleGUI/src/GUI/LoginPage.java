package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import sun.audio.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	 * Create the frame.
	 */
	public LoginPage() {
		
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
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userUserNameInput = textField.getText();
				System.out.println(userUserNameInput);
				//...
			}
		});
		textField.setBounds(362, 147, 130, 26);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		lblUsername.setBounds(249, 150, 101, 16);
		desktopPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		lblPassword.setBounds(249, 249, 101, 16);
		desktopPane.add(lblPassword);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				GUI test2 = new GUI();
				test2.setVisible(true);
				
			}
		});
		btnBack.setBounds(84, 316, 165, 80);
		desktopPane.add(btnBack);
		
		JButton btnLogin2 = new JButton("Login");
		btnLogin2.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		btnLogin2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				//assuming login is valid
				GameMainMenu gameMenu = new GameMainMenu();
				gameMenu.setVisible(true);
			}
		});
		btnLogin2.setBounds(595, 316, 165, 80);
		desktopPane.add(btnLogin2);
		
		JLabel lblFarkle = new JLabel("FARKLE:\nLogin");
		lblFarkle.setForeground(new Color(255, 255, 255));
		lblFarkle.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 56));
		lblFarkle.setHorizontalAlignment(SwingConstants.CENTER);
		lblFarkle.setBounds(242, 6, 350, 137);
		desktopPane.add(lblFarkle);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = passwordField.getText();
				System.out.println(password);
				//...
			}
		});
		passwordField.setBounds(362, 246, 130, 26);
		desktopPane.add(passwordField);
	}
}
