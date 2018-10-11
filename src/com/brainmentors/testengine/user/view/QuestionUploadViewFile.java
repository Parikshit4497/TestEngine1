package com.brainmentors.testengine.user.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import java.awt.event.ActionEvent;
import java.awt.Font;

import com.brainmentors.testengine.question.helper.QuestionUploadHelper;
import com.brainmentors.testengine.user.view.*;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

//class JobUpload implements Runnable{
//	QuestionUploadHelper help;
//	String path;
//	int Time=0;
//	boolean isUploaded=false;
//	Thread t ;
//	JobUpload(QuestionUploadHelper helper,String msg,int time) {
//		help=helper;
//		path=msg;
//		t=new Thread(this);
//		Time=time;
//		t.start();
//		
//	
//	}
//	
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		
//			try {
//				//System.out.println(path);
//				isUploaded=help.read(path,Time);
//				System.out.println("isUploaded" + isUploaded);
//								
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//		     System.out.println("Exception");       
//			} 
//	
//	
//	}
//	public boolean isUploaded() {
//		return isUploaded;
//	}
//}
public class QuestionUploadViewFile extends JFrame {

	private JPanel contentPane;
	 Logger QuplVieFi=Logger.getLogger(QuestionUploadViewFile.class);
	/**
	 * Launch the application.
	 */	
	 File file;
	 QuestionUploadHelper helper =new QuestionUploadHelper();
	 private final JLabel TestTime = new JLabel("EnterTestTime");
	 private JTextField TimeEntry;
	 int time=0;
	public void upload()  {
		   
			String path;
			
			QuplVieFi.debug("Inside upload method");
			JFileChooser jfilechooser=new JFileChooser("C:\\User\\hp\\Documents");
		 jfilechooser.showOpenDialog(this);
		 
		 file =jfilechooser.getSelectedFile();
		 QuplVieFi.debug("Inside try block method for upload test");
				//System.out.println(file.getAbsolutePath());
				//boolean isUpload =helper.read(file.getAbsolutePath());
		            time=Integer.parseInt(TimeEntry.getText());
//			     JobUpload job=new JobUpload(helper,file.getAbsolutePath(),time);
     		    boolean isUpload=false;
			    try {
					isUpload=helper.read(file.getAbsolutePath(),time);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    System.out.println(" 1 " +isUpload);
				//ystem.out.println(file.getAbsolutePath());
				JOptionPane.showMessageDialog(this, isUpload?"The file is uploaded":"The file is already present or database issue");
				
				QuplVieFi.debug("leaving try block");
		
		
				
			QuplVieFi.debug("leaving upload method");
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionUploadViewFile frame = new QuestionUploadViewFile();
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
	public QuestionUploadViewFile() {
		QuplVieFi.debug("Inside uploadview file constructor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Upload");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			      upload();
			}
		});
		btnNewButton.setBounds(402, 482, 175, 41);
		contentPane.add(btnNewButton);
		TestTime.setHorizontalAlignment(SwingConstants.CENTER);
		TestTime.setFont(new Font("Times New Roman", Font.BOLD, 15));
		TestTime.setBounds(139, 117, 161, 31);
		contentPane.add(TestTime);
		
		TimeEntry = new JTextField();
		TimeEntry.setHorizontalAlignment(SwingConstants.CENTER);
		TimeEntry.setBounds(321, 123, 112, 20);
		contentPane.add(TimeEntry);
		TimeEntry.setColumns(10);
		
		JLabel timeUnit = new JLabel("minutes");
		timeUnit.setHorizontalAlignment(SwingConstants.CENTER);
		timeUnit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		timeUnit.setBounds(443, 121, 88, 22);
		contentPane.add(timeUnit);QuplVieFi.debug("leaving uploadview file constructor");
	}
}
