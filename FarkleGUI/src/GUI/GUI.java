package GUI;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.*;

public class GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.DARK_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblFarkle = new JLabel("FARKLE");
		lblFarkle.setFont(new Font("Lucida Grande", Font.PLAIN, 46));
		lblFarkle.setBounds(23, -25, 166, 161);
		desktopPane.add(lblFarkle);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage test = new LoginPage();
				test.setVisible(true);
				setVisible(false);
				
			}
		});
		btnLogin.setBounds(34, 107, 117, 29);
		desktopPane.add(btnLogin);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				UserCreationPage userPage = new UserCreationPage();
				userPage.setVisible(true);
			}
		});
		btnCreateAccount.setBounds(34, 149, 140, 29);
		desktopPane.add(btnCreateAccount);
		
		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitGame.setBounds(34, 187, 117, 29);
		desktopPane.add(btnExitGame);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/image.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(221, 60, 190, 156);
		desktopPane.add(lblNewLabel);
	}
}
