package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import edu.plu.cs.farkle.client.CallBack;
import edu.plu.cs.farkle.client.ClientBase;

public class GUI extends JFrame {

	private JPanel contentPane;
	private static ClientBase client;
	private ArrayList clientObjs = new ArrayList(); 
	private static GUI frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame = new GUI();
					client = new ClientBase(frame);
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
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		SwingUtilities.updateComponentTreeUI(this);
		setDefaultLookAndFeelDecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(128, 0, 0));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblFarkle = new JLabel("FARKLE");
		lblFarkle.setHorizontalAlignment(SwingConstants.CENTER);
		lblFarkle.setForeground(new Color(255, 255, 255));
		lblFarkle.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 68));
		lblFarkle.setBounds(35, -28, 267, 161);
		desktopPane.add(lblFarkle);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 26));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage test = new LoginPage(clientObjs, frame);
				test.setVisible(true);
				setVisible(false);
				
			}
		});
		btnLogin.setBounds(80, 105, 180, 83);
		desktopPane.add(btnLogin);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 26));
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				UserCreationPage userPage = new UserCreationPage(clientObjs, frame);
				userPage.setVisible(true);
			}
		});
		btnCreateAccount.setBounds(77, 215, 183, 83);
		desktopPane.add(btnCreateAccount);
		
		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 26));
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitGame.setBounds(77, 325, 183, 83);
		desktopPane.add(btnExitGame);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/image.gif")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(410, 58, 339, 350);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Farkle Sprint 3: Team Yellow");
		lblNewLabel_1.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(305, 420, 224, 16);
		desktopPane.add(lblNewLabel_1);
	}
	public void registerCallback(CallBack client)
		{
			clientObjs.add(client);
		}
}
