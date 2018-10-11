package com.brainmentors.testengine.user.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
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
import java.awt.Color;
import java.awt.ComponentOrientation;

import javax.swing.UIManager;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import java.awt.GridBagLayout;

public class SelectTestView extends JFrame {

	private static JPanel contentPane;
     private static JRadioButton Button ;
     private static JLabel label;
     private static String TestName;
     private static ButtonGroup bg =new ButtonGroup();
     static ArrayList<JRadioButton> button;
     static SelectTestView frame;
    static  private JButton button_1;
    static private JPanel panel;
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
	public  void selectTest() {
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
		
		
				
	
		
		for(int i=0;i<TestList.size();i++) {
			System.out.println("The list elements  " + TestList.get(i));
		} 
		int x=50;
		String str="";
		System.out.println("The size of the test list "  + TestList.size());
	    button=new ArrayList<>();
	    int j=0;
	    GridBagConstraints c=new GridBagConstraints();
		for(int i=0;i<TestList.size();i++) {
			j=i;
			Button= new JRadioButton(TestList.get(i));
			    c.gridx=1;
		        c.gridy=i;
	        
		        c.insets=new Insets(10,10,10,10);
		        panel.add(Button,c);
			str=(j+1) +". " ;
			label=new JLabel(str);
			 c.gridx=0;
		        c.gridy=i;
		        c.insets=new Insets(10,10,10,10);
		      //  c.anchor=GridBagConstraints.PAGE_START;
		        panel.add(label,c);
			System.out.println("lable text " + label.getText());
	       
			System.out.println(TestList.get(i));
		    button.add(Button);
			Button.setFont(new Font("Times New Roman", Font.BOLD, 15));
			System.out.println("button loop");
		//	Button.setBounds(x,100,100, 87);
			bg.add(Button);
			
			
		//	x+=i*100;
			
			
			
			
		  }
		 
		for( int i=0;i<button.size();i++) {
			System.out.println("The test buttons " +button.get(i).getText());
		}
	}
	public  boolean  fetchTest() {
		
		for(int i=0;i<button.size();i++) {
			
			if(button.get(i).isSelected()) {
				
				String testName=button.get(i).getText().trim();
				System.out.println("The test name selected is " + testName);
				TakeTestView frame1= new TakeTestView(testName);
				frame1.setVisible(true);
				
			//	frame.dispose();
				return true;
			}
			
			
			
		}
		
		return false;
			
		
	}
	/**
	 * Create the frame.
	 */
	public SelectTestView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		button_1 = new JButton("Submit ");
		button_1.setBackground(UIManager.getColor("Button.background"));
		
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(fetchTest()) {
						
					}else {
						JOptionPane.showMessageDialog(null, "Select atleast one test ");
					}
				}
			});
			button_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
			button_1.setBounds(648, 488, 148, 35);
			contentPane.add(button_1);
		
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(34, 23, 900, 400);
		
			
			panel = new JPanel();
		
			panel.setLayout(new GridBagLayout());
			panel.setBounds(34, 23,900, 400);
			scrollPane.setViewportView(panel);
			
			
			contentPane.add(scrollPane);
		      	
		selectTest();
		bg.clearSelection();
	}

}

