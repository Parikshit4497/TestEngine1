package com.brainmentors.testengine.user.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentors.testengine.question.helper.QuestionUploadHelper;
import com.brainmentors.testengine.question.helper.RecordUploaderHelper;

import java.awt.FlowLayout;

public class UploadViewFileTest extends JFrame  {

	private JPanel contentPane;

	
	public void upload() {
		String path;

		//.debug("Inside upload method");
		JFileChooser jfilechooser=new JFileChooser("C:\\User\\hp\\Documents");
	 jfilechooser.showOpenDialog(this);
	 File file =jfilechooser.getSelectedFile();
		
      	
		try {
		      RecordUploaderHelper helper=new RecordUploaderHelper();
			//QuplVieFi.debug("Inside try block method for upload test");
			System.out.println(file.getAbsolutePath());
			String pathname=file.getAbsolutePath();
			
			System.out.println(helper);
			boolean isUpload =helper.read(file.getAbsolutePath());
			System.out.println(file.getAbsolutePath());
			JOptionPane.showMessageDialog(this, isUpload?"file is uploaded":"file is not uploaded ");
			//QuplVieFi.debug("leaving try block");
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Sorry you can't upload file");
		}
		//QuplVieFi.debug("leaving upload method");
}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UploadViewFileTest frame = new UploadViewFileTest();
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
	public UploadViewFileTest() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUpload = new JButton("upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//createHelper();   
				upload();
				    
			}

			
		});
		btnUpload.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnUpload.setBounds(411, 500, 186, 37);
		contentPane.add(btnUpload);
		
	}
}
