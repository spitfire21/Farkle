package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Settings extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings frame = new Settings(null);
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
	public Settings(GameMainMenu frame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(128, 0, 0));
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"800x600", "1024x768", "1280x720", "1920x1080", "2560x1440"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(512, 27, 88, 85);
		desktopPane.add(list);
		
		JLabel lblResolution = new JLabel("Resolution:");
		lblResolution.setForeground(new Color(255, 255, 255));
		lblResolution.setHorizontalAlignment(SwingConstants.CENTER);
		lblResolution.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		lblResolution.setBounds(210, 51, 117, 29);
		desktopPane.add(lblResolution);
		
		JLabel lblNetwork = new JLabel("Network:");
		lblNetwork.setForeground(new Color(255, 255, 255));
		lblNetwork.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		lblNetwork.setHorizontalAlignment(SwingConstants.CENTER);
		lblNetwork.setBounds(210, 145, 117, 29);
		desktopPane.add(lblNetwork);
		
		JLabel lblAccount = new JLabel("Account:");
		lblAccount.setForeground(new Color(255, 255, 255));
		lblAccount.setFont(new Font("Bodoni 72 Smallcaps", Font.PLAIN, 20));
		lblAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccount.setBounds(210, 186, 117, 29);
		desktopPane.add(lblAccount);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			
				frame.setVisible(true);
			}
		});
		btnBack.setBounds(85, 338, 156, 68);
		desktopPane.add(btnBack);
		
		JButton btnSavequit = new JButton("Save/Quit");
		btnSavequit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			
				frame.setVisible(true);
			}
		});
		btnSavequit.setBounds(574, 338, 156, 68);
		desktopPane.add(btnSavequit);
	}
}
