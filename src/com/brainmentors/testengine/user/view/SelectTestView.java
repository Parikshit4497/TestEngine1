package com.brainmentors.testengine.user.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import com.brainmentors.testengine.util.constants.CommonDao;
import com.brainmentors.testengine.util.constants.QueryConstants;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.ScrollPaneConstants;

public class SelectTestView extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane1;
    private JRadioButton Button ;
    private String TestName;
     private ButtonGroup bg =new ButtonGroup();
     JScrollPane scrollPane ;
     ArrayList<JRadioButton> button;
     static SelectTestView frame;
     private JButton button_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame= new SelectTestView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void selectTest() {
		ArrayList<String> TestList =new ArrayList<>();

		Connection connection =null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		try {
			connection=CommonDao.getConnection();
			pstmt=connection.prepareStatement(QueryConstants.fetchTest);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				TestList.add(rs.getString("testname"));
			}
			if(TestList.size()>0) {
				connection.commit();
			}else{
				connection.close();
			}
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			try {
			connection.rollback();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}catch( SQLException e1) {
			e1.printStackTrace();
		}
				
		int x=10;
		System.out.println("The size of the test list "  + TestList.size());
	    button=new ArrayList<>();
		for(int i=0;i<TestList.size();i++) {
			Button= new JRadioButton(TestList.get(i));
			System.out.println(TestList.get(i));
		
		    button.add(Button);
			Button.setFont(new Font("Times New Roman", Font.BOLD, 15));
			System.out.println("button loop");
			Button.setBounds(20,x,100, 87);
			bg.add(Button);
			scrollPane.add(Button);
			x+=i*20;
		}
        	
		for( int i=0;i<button.size();i++) {
			System.out.println("The test buttons " +button.get(i).getText());
		}
	}
	public boolean  fetchTest() {
		
		for(int i=0;i<button.size();i++) {
			
			if(button.get(i).isSelected()) {
				
				String testName=button.get(i).getText().trim();
				System.out.println("The test name selected is " + testName);
				TakeTestView frame1= new TakeTestView(testName);
				frame1.setVisible(true);
				
				frame.dispose();
				return true;
			}
			
			
			
		}
		
		return false;
			
		
	}
	/**
	 * Create the frame.
	 */
	public SelectTestView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		//contentPane1 = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		scrollPane= new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPane.add(scrollPane);
//		contentPane1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
//		contentPane1.setBounds(100,100, 900, 600);
		scrollPane.setViewportView(contentPane1);
		scrollPane.setPreferredSize(new Dimension(800,400));
		button_1 = new JButton("Submit ");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(fetchTest()) {
					
				}else {
					JOptionPane.showMessageDialog(null, "Select atleast one button ");
				}
			}
		});
		button_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(button_1);
		selectTest();
		bg.clearSelection();
	}
}
