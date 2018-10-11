package com.brainmentors.testengine.user.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentors.testengine.util.constants.PathConstants;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JWindow;

import java.awt.Font;

import org.apache.log4j.Logger;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.Color;
/**
 * @author hp
 *   
 * */
public class SplashTest extends JWindow implements PathConstants{
    Logger logger =Logger.getLogger(SplashTest.class);
	private JPanel splashTest;
	JProgressBar progressBar = new JProgressBar();
	int counter=1;
	Timer timer;
	private void animation() {
		logger.debug("Inside animation method before timer logic...");
		timer=new Timer(70,(e)->{
		if(counter>100) {
			timer.stop();
			SplashTest.this.setVisible(false);
			SplashTest.this.dispose();
			LoginView  login =new LoginView();
			login.setVisible(true);
		}
		progressBar.setValue(counter);
		counter++;
		}); 
		timer.start();
		logger.debug("leaving animation logic......");
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashTest frame = new SplashTest();
					frame.logger.debug("Inside main and loading splash screen frame");
					frame.setVisible(true);
					frame.animation();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SplashTest() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logger.debug("Inside splas test method");
		setBounds(100, 100,1000, 600);
		splashTest = new JPanel();
		splashTest.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(splashTest);
		splashTest.setLayout(null);
		splashTest.setLocation(100, 1000);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SplashTest.class.getResource(Splash_Constant)));
		lblNewLabel.setBounds(175, 166, 660, 250);
		splashTest.add(lblNewLabel);
		progressBar.setStringPainted(true);
		progressBar.setBackground(new Color(102, 255, 0));
		progressBar.setBounds(10, 529, 990, 23);
		splashTest.add(progressBar);
		
		JLabel lblNewLabel_1 = new JLabel("BPIT TEST AND ASSIGNMENT PORTAL");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_1.setBounds(41, 451, 959, 50);
		splashTest.add(lblNewLabel_1);
		logger.debug(" leaving  splash test method");
	}
}
