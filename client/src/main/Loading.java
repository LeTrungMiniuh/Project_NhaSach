package main;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.GD_DangNhap;


import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;
import java.net.URL;

public class Loading extends JFrame {

	private JPanel contentPane;
	private JLabel LoadingValue;
	private JLabel Loading;
	private JLabel lblNewLabel_2;
	private JProgressBar LoadingBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
							.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							javax.swing.UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
				} catch (ClassNotFoundException ex) {
					java.util.logging.Logger.getLogger(GD_DangNhap.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (InstantiationException ex) {
					java.util.logging.Logger.getLogger(GD_DangNhap.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (IllegalAccessException ex) {
					java.util.logging.Logger.getLogger(GD_DangNhap.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
				} catch (javax.swing.UnsupportedLookAndFeelException ex) {
					java.util.logging.Logger.getLogger(GD_DangNhap.class.getName()).log(java.util.logging.Level.SEVERE,
							null, ex);
					
				}
				
				try {
					GD_DangNhap lg = new GD_DangNhap();
					lg.setVisible(true);
				} catch (Exception e) {
					// TODO: handle exception
				}
				  
			}
		});
	}
	


	public Loading() {
		
		
		
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
	

		
		JPanel BackgroundPanel = new JPanel();
		BackgroundPanel.setBounds(0, 0, 673, 355);
		contentPane.add(BackgroundPanel);
		BackgroundPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1.setIcon(new ImageIcon(getClass().getResource("/image/Loading.png")));
		lblNewLabel_1.setBounds(0, 41, 663, 127);
		BackgroundPanel.add(lblNewLabel_1);
		
		 Loading = new JLabel("Loading..");
		Loading.setFont(new Font("Tahoma", Font.BOLD, 20));
		Loading.setForeground(SystemColor.text);
		Loading.setBounds(10, 325, 606, 31);
		BackgroundPanel.add(Loading);
		
		 LoadingValue = new JLabel("0%");
		LoadingValue.setForeground(Color.WHITE);
		LoadingValue.setFont(new Font("Tahoma", Font.BOLD, 20));
		LoadingValue.setBounds(616, 319, 70, 42);
		BackgroundPanel.add(LoadingValue);
		
		lblNewLabel_2 = new JLabel("BOOK SYSTEM");
		lblNewLabel_2.setForeground(SystemColor.inactiveCaptionBorder);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 166, 673, 85);
		BackgroundPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		
		lblNewLabel.setBounds(-43, -78, 890, 548);
		BackgroundPanel.add(lblNewLabel);
		
		LoadingBar = new JProgressBar();
		LoadingBar.setForeground(new Color(255, 128, 0));
		LoadingBar.setBounds(0, 354, 673, 37);
		contentPane.add(LoadingBar);
	}
}
