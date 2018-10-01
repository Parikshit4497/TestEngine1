package com.brainmentors.testengine.user.view;

import java.awt.BorderLayout;
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

public class SelectTestView extends JFrame {

	private JPanel contentPane;
	private JPanel contentPane1;
    private JRadioButton Button ;
    private String TestName;
     private ButtonGroup bg =new ButtonGroup();
     JScrollPane scrollPane ;
     ArrayList<JRadioButton> button;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectTestView frame = new SelectTestView();
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
				
		int x=20;
		System.out.println("The size of the test list "  + TestList.size());
		for(int i=0;i<TestList.size();i++) {
			Button= new JRadioButton(TestList.get(i));
		    button=new ArrayList<>();
		    button.add(Button);
			Button.setFont(new Font("Times New Roman", Font.BOLD, 15));
			System.out.println("button loop");
			
			Button.setBounds(40,x,100, 87);
			bg.add(Button);
			contentPane1.add(Button);
			x+=i*120;
			
		
			
		}
	
		
	}
        public void  fetchTest() {
        for(int i=0;i<button.size();i++) {	
        	if(button.get(i).isSelected()) {
        		
    			TestName=button.get(i).getText().trim();
    			TakeTestView taketest=new TakeTestView(TestName);
    	    	taketest.setVisible(true);
    	    	taketest.setExtendedState(JFrame.MAXIMIZED_BOTH);
    			System.out.println(" the test name in fetch test loop " +TestName);
    			System.out.println("The fetch test loop");
    			
    		}else {
    			JOptionPane.showMessageDialog(Button,"select one button ");
    		}
        
        }
        System.out.println("Outside fetch test loop ");
    	
    	this.dispose();
    	System.out.println("Testname sent from select test " + TestName);
		
        }
	/**
	 * Create the frame.
	 */
	public SelectTestView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane= new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(21,29, 939, 431);
		contentPane.add(scrollPane);
		contentPane1 = new JPanel();
		JButton Submit = new JButton("Submit ");
		Submit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
		        fetchTest();
			//	System.out.println(TestName);
				
			}
		});
		scrollPane.setViewportView(contentPane1);
		contentPane1.setLayout(null);
		Submit.setBounds(756, 496, 140, 38);
		contentPane.add(Submit);
		selectTest();
		bg.clearSelection();
	}
}
