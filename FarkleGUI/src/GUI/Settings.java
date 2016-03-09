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

public class Settings extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Settings frame = new Settings();
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
	public Settings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.GRAY);
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
		list.setBounds(238, 27, 99, 55);
		desktopPane.add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		scrollBar.setBounds(298, 27, 15, 55);
		desktopPane.add(scrollBar);
		
		JLabel lblResolution = new JLabel("Resolution");
		lblResolution.setBounds(63, 27, 79, 16);
		desktopPane.add(lblResolution);
		
		JLabel lblNetwork = new JLabel("Network");
		lblNetwork.setBounds(63, 114, 61, 16);
		desktopPane.add(lblNetwork);
		
		JLabel lblAccount = new JLabel("Account");
		lblAccount.setBounds(63, 167, 61, 16);
		desktopPane.add(lblAccount);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				GameMainMenu newMenu = new GameMainMenu();
				newMenu.setVisible(true);
			}
		});
		btnBack.setBounds(88, 214, 117, 29);
		desktopPane.add(btnBack);
		
		JButton btnSavequit = new JButton("Save/Quit");
		btnSavequit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				GameMainMenu newMenu = new GameMainMenu();
				newMenu.setVisible(true);
			}
		});
		btnSavequit.setBounds(261, 214, 117, 29);
		desktopPane.add(btnSavequit);
	}
}
