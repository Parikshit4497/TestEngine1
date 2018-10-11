package com.brainmentors.testengine.user.view;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentors.testengine.question.helper.QuestionUploadHelper;
import com.brainmentors.testengine.question.helper.RecordUploaderHelper;
import static com.brainmentors.testengine.util.constants.CommonUtils.convertPrintStackIntoString;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import java.awt.event.ActionEvent;
import org.apache.log4j.Logger;
public class AdminView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	 private static AdminView frame ;
	private static RoleRightsView frame1;
	private static AuthenticationView frame2;
static	Logger adminview = Logger.getLogger(AdminView.class);
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminView();
					frame.adminview.debug("Inside main method of admin view");
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
	public static void authenticationOpen() {
		adminview.debug("Entering authentication open ");
		try {
		frame2=new AuthenticationView();
		}catch(Exception e1) {
			
				AdminView.generateMsg(false);
		
		}
		frame2.setVisible(true);
	//	this.dispose();
		adminview.debug("leaving  authentication ");
	}
	public static void roleRights() {
		adminview.debug("Inside role rights function for frame call");
		
		try {
		frame1=new RoleRightsView();
		}catch(IndexOutOfBoundsException e) {
			AdminView.generateMsg(false);
		}
		frame1.setVisible(true);
		//this.dispose();
	adminview.debug("leaving  role rights");
	}
	public static void generateMsg(boolean status) {
		if(status==false) {
			JOptionPane.showMessageDialog(frame,"No new Records for assigning role and rights  or authentication");
		}
	}

	public void upload() {
		adminview.debug("Inside admin  upload function " );
		JFileChooser jfilechooser=new JFileChooser("C:\\User\\hp\\Documents");
		 jfilechooser.showOpenDialog(this);
		 File file =jfilechooser.getSelectedFile();
			
	      	
			try {
				adminview.debug("Inside  try adminview upload ");
				RecordUploaderHelper helper=new RecordUploaderHelper() ;
				//QuplVieFi.debug("Inside try block method for upload test");
				System.out.println(file.getAbsolutePath());
				System.out.println(helper);
				boolean isUpload =helper.read(file.getAbsolutePath());
				System.out.println(file.getAbsolutePath());
				JOptionPane.showMessageDialog(this, isUpload?"file is uploaded":"file is not uploaded ");
				//QuplVieFi.debug("leaving try block");
			adminview.debug("Leaving try upload admin view");
			}catch(IOException e) {
				e.printStackTrace();
				System.out.println("Sorry you can't upload file");
				System.out.println(e);
				adminview.error(convertPrintStackIntoString(e));
			}
	}
	public AdminView() {
		adminview.debug("entering admin view");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(395, 28, 172, 82);
		contentPane.add(lblNewLabel);
		
		JButton btnAuthentication = new JButton("Authentication ");
		btnAuthentication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminview.debug("entering authentication button event ");
				
				authenticationOpen();
				
			}
		});
		adminview.debug("leaving  authentication button event ");
		btnAuthentication.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnAuthentication.setBounds(461, 455, 178, 37);
		contentPane.add(btnAuthentication);
		
		JButton btnAdmin = new JButton("User Role and Rights");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminview.debug("adding role rights button event ");
			roleRights();
			
			}
		});
		adminview.debug("leaving  role rights button event ");
		btnAdmin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAdmin.setBounds(149, 454, 163, 39);
		contentPane.add(btnAdmin);
		
		JButton btnBulkupload = new JButton("Bulk Upload ");
		btnBulkupload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminview.debug("entering bulk upload method ");
			    upload();
			    }
		});
		adminview.debug("leaving  button bulk upload ");
		btnBulkupload.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBulkupload.setBounds(775, 455, 178, 37);
		contentPane.add(btnBulkupload);
		adminview.debug("leaving  admin view");
	}

}
