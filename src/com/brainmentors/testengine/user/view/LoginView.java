package com.brainmentors.testengine.user.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentors.testengine.user.dto.LoginDTo;
import com.brainmentors.testengine.user.dto.RegisterDTO;
import com.brainmentors.testengine.user.dto.UserDTO;
import com.brainmentors.testengine.user.view.dao.UserDao;
import com.brainmentors.testengine.util.constants.PathConstants;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static com.brainmentors.testengine.util.constants.CommonUtils.convertPrintStackIntoString;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import java.awt.event.ActionEvent;
/**
 * 
 * */
public class LoginView extends JFrame implements PathConstants{
    Logger logger1= Logger.getLogger(LoginView.class);
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					LoginView frame = new LoginView();
					frame.logger1.debug("Inside LoginView Class main loading frame");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void  loadRegister() {
		
			//this.setVisible(false);
			//this.dispose();
			RegisterWindow  registerWindow=new RegisterWindow();
			registerWindow.setVisible(true);
	
	}
	
	public  void checkLogin() {
		String userid=textField.getText();
		String password=new String(passwordField.getPassword());
		logger1.debug("Inside checklogin class with userid" +userid);
		LoginDTo loginDTO=new LoginDTo();
		loginDTO.setUserId(userid);
		loginDTO.setPassword(password);
		System.out.println(userid);
		System.out.println(password);
		UserDao userdao=new UserDao();
		try {
		  logger1.debug("Inside check login and loading method do login " +userid);
		
		  UserDTO userdto=userdao.dologin(loginDTO);
		  if(userdto==null) {
		JOptionPane.showMessageDialog(this, "Invalid user id ");
		  return;
		  }
		  DashBoardView dashBoard = new DashBoardView();
			dashBoard.filldashBoard(userdto);
			dashBoard.setVisible(true);
			dashBoard.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//	this.setVisible(false);
			//this.dispose();

		}catch(ClassNotFoundException e) {
	           JOptionPane.showMessageDialog(this, "Contact system admin some DB problem has occurred");
	           logger1.error(convertPrintStackIntoString(e));
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(this, "Might be DBcredential change");
			logger1.error(convertPrintStackIntoString(e));
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this,"Some serious probelm has occurred please contact the admin team");
			logger1.error(convertPrintStackIntoString(e));
		}
		
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		logger1.debug("Inside login view message");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserId");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(92, 131, 90, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(397, 47, 137, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password\r\n");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(111, 184, 83, 41);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(241, 145, 229, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(241, 197, 230, 20);
		contentPane.add(passwordField);
		
		JLabel label = new JLabel("");
		label.setBounds(436, 148, 46, 14);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                       checkLogin();			
                       logger1.debug("Inside login button method");
			}
		});logger1.debug("Outside login button method");
		btnNewButton.setBounds(140, 265, 145, 31);
		contentPane.add(btnNewButton);
		
		JButton btnReset = new JButton("Register");
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadRegister();
				logger1.debug("Inside Reset button method");
			}
		});
		logger1.debug("Outside Reset button method");
		btnReset.setBounds(345, 265, 126, 31);
		contentPane.add(btnReset);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LoginView.class.getResource(Login_View)));
		lblNewLabel_2.setBounds(604, 141, 250, 250);
		contentPane.add(lblNewLabel_2);
		logger1.debug("leaving debug method");
	
	}
}
