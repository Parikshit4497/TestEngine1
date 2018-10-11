package com.brainmentors.testengine.user.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentors.testengine.user.dto.RightAuthenticationDTO;
import com.brainmentors.testengine.user.dto.RightDTO;
import com.brainmentors.testengine.user.dto.RightIsTruecountDTO;
import com.brainmentors.testengine.user.dto.UserDTO;
import com.brainmentors.testengine.user.view.dao.UserDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class RoleRightsView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoleRightsView frame = new RoleRightsView();
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
	private int index;
	private String  roleid="";
	private int count=0;
	int i=0;
	private RightIsTruecountDTO rightIsTrueDTO;
private 	RightAuthenticationDTO rightAuth;

	private ArrayList<RightAuthenticationDTO> right;
	JButton submit = new JButton("Submit");
	JLabel heading = new JLabel("User Role Right ");
	JLabel firstNamelbl = new JLabel("First Name");
	JLabel lastNamelbl = new JLabel("Last Name");
	JLabel firstNamelbltxt = new JLabel("");
	JLabel lastNametxt = new JLabel("");
	JLabel Phone_no = new JLabel("Phone No");
	JLabel phone_txt = new JLabel("");
	JLabel emailId = new JLabel("EmailId");
	JLabel emailtxt = new JLabel("");
	JLabel CollegeIDlbl = new JLabel("CollegeId");
	JLabel cllgidtext = new JLabel("");
	JLabel userRolelbl = new JLabel("User Role\r\n");
	JLabel userRoletxt = new JLabel("");
	JLabel Role = new JLabel("Role");
	JRadioButton Role2 = new JRadioButton("2");
	JRadioButton Role1 = new JRadioButton("1\r\n");
	JRadioButton Role3 = new JRadioButton("3");
	JLabel adminlbl = new JLabel("Admin\r\n");
	JButton btnBack = new JButton("Back");
	JLabel studentlbl = new JLabel("Student");
	JLabel teacherlbl = new JLabel("Teacher");
	//JLabel uploadTest = new JLabel("Upload Test");
//	private JLabel rightlbl = new JLabel("Right");
	//JLabel takeTestlbl = new JLabel("Take Test");
	//JLabel seeresuktlbl = new JLabel("See Result");
	ButtonGroup bg=new ButtonGroup();
	JButton previous = new JButton("Previous");
	JButton next = new JButton("Next");
   
//    JCheckBox Right1 = new JCheckBox("1");
//    JCheckBox Right2 = new JCheckBox("2");
//    JCheckBox Right3 = new JCheckBox("3");
//    JCheckBox right4 = new JCheckBox("4");
//    JCheckBox[] rightArray={Right1,Right2,Right3,right4};
	ArrayList<UserDTO> userDTOlist =new ArrayList<>();
	public void adminView() {
		AdminView frame=new AdminView();
		frame.setVisible(true);
		this.dispose();
		
	}
	public void loadUserData() {
	             UserDao userdao=new UserDao();
	            
	            	 
	            	 try {
						userDTOlist=userdao.fetchUserData();
						
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	          
	}
	
//	public void fetchRight(int index) {
//		count=0;
//	    right=new ArrayList<>();
//	    
//	    rightIsTrueDTO=new RightIsTruecountDTO();
//		if(Right1.isSelected()) {
//			RightAuthenticationDTO rightAuth=new RightAuthenticationDTO(); 
//			 rightAuth.setRightButton(Right1);
//			 rightAuth.setBoolean(true);
//		     rightAuth.setRightvalue(1);
//		     right.add(rightAuth);
//		     rightIsTrueDTO.setAnsticked(true);
//		}else {
//			RightAuthenticationDTO rightAuth=new RightAuthenticationDTO(); 
//			 rightAuth.setRightButton(Right1);
//			 rightAuth.setBoolean(false);
//	         right.add(rightAuth);
//	   }
//		if(Right2.isSelected()) {
//			 RightAuthenticationDTO rightAuth=new RightAuthenticationDTO();
//			 rightAuth.setRightButton(Right2);
//			 rightAuth.setBoolean(true);
//			 rightIsTrueDTO.setAnsticked(true);
//		       rightAuth.setRightvalue(2);
//				right.add(rightAuth);
//			}else {
//			 RightAuthenticationDTO rightAuth=new RightAuthenticationDTO();
//			 rightAuth.setRightButton(Right2);
//			 rightAuth.setBoolean(false);
//			 right.add(rightAuth);
//		}
//		if(Right3.isSelected()) {
//			 RightAuthenticationDTO rightAuth=new RightAuthenticationDTO();
//			 rightAuth.setRightButton(Right3);
//			 rightAuth.setBoolean(true);
//			 rightAuth.setRightvalue(3);
//			 rightIsTrueDTO.setAnsticked(true);
//				right.add(rightAuth);
//			}else {
//			 RightAuthenticationDTO rightAuth =new RightAuthenticationDTO();
//			 rightAuth.setRightButton(Right3);
//			 rightAuth.setBoolean(false);
//		     right.add(rightAuth);
//			}
//		if(right4.isSelected()) {
//			 RightAuthenticationDTO rightAuth=new RightAuthenticationDTO(); 
//			 rightAuth.setRightButton(right4);
//			 rightAuth.setBoolean(true);
//			 rightAuth.setRightvalue(4);
//			 rightIsTrueDTO.setAnsticked(true);
//				right.add(rightAuth);
//		}else {
//			 RightAuthenticationDTO rightAuth=new RightAuthenticationDTO(); 
//			 rightAuth.setRightButton(right4);
//			 rightAuth.setBoolean(false);
//		     right.add(rightAuth);
//		}
//		rightIsTrueDTO.setRightAuth(right);
//		this.userDTOlist.get(index).setRightIstrueDto(rightIsTrueDTO);
//	  }
//	public void selectUserRight() {
//		if(this.userDTOlist.get(index).getRightIstrueDto()!=null) {
//			System.out.println("Is null" +this.userDTOlist.get(index).getRightIstrueDto());
//			
//    System.out.println("select user rightindex" + index);
//	int i=0;		
//	if(this.userDTOlist.get(index).getRightIstrueDto().isAnsticked()) {
//	right=this.userDTOlist.get(index).getRightIstrueDto().getRightAuth();
//		while(i<right.size()) {
//			if(right.get(i).isBoolean()) {
//				right.get(i).getRightButton().setSelected(true);
//			}else{
//				right.get(i).getRightButton().setSelected(false);
//			}
//			i++;
//		}
//	}
//}else {
//          i=0;
//	//right=this.userDTOlist.get(index).getRightIstrueDto().getRightAuth();
//	while(i<4) {
//	        rightArray[i].setSelected(false);
//	        i++;
//	}
//		
//}
//}
//	
	public void printUserData() throws IndexOutOfBoundsException{
		if(userDTOlist.size()==0) {
           throw new IndexOutOfBoundsException();
		}
		if(index<this.userDTOlist.size()) {
			selectUserRole();
	//	 selectUserRight();
		}
    UserDTO userdto=new UserDTO();
	userdto=userDTOlist.get(index);
	firstNamelbltxt.setText(userdto.getFirstName());
	lastNametxt.setText(userdto.getLastName());
	phone_txt.setText(userdto.getPhoneNO());
	emailtxt.setText(userdto.getEmailId());
	cllgidtext.setText(userdto.getCollegId());
	userRoletxt.setText(userdto.getSelectUsertype());
	enableDisableButton();

	}
	
	public void enableDisableButton() {
		if(userDTOlist.size()==1){
			previous.setEnabled(false);
			next.setEnabled(false);
			submit.setEnabled(true);
		}
		else
		if(index==0){
		previous.setEnabled(false);
		next.setEnabled(true);
		submit.setEnabled(false);
		}
		else
			if(index == userDTOlist.size()-1){
				next.setEnabled(false);
				previous.setEnabled(true);
				submit.setEnabled(true);
			}
		else
		if(index>0 && index<userDTOlist.size()){
			previous.setEnabled(true);
			next.setEnabled(true);
			submit.setEnabled(false);
		}
	}
	public void fetchRole(int index) {
		 //
		if(Role1.isSelected()) {
			roleid="1";
		}else if(Role2.isSelected()) {
			roleid="2";
		}else if(Role3.isSelected()) {
			roleid="3";
		}
		System.out.println( " role id " + roleid);
	    this.userDTOlist.get(index).setRoleID(roleid);
	    System.out.println( "he role id sent " + this.userDTOlist.get(index).getRoleID());
	    roleid="";
	    
	}

	public void selectUserRole() {
		if(this.userDTOlist.get(index).getRoleID()!=null) {
			roleid=this.userDTOlist.get(index).getRoleID();
			if(roleid=="1") {
				Role1.setSelected(true);
			}else if(roleid=="2") {
				Role2.setSelected(true);
			}else if(roleid=="3") {
				Role3.setSelected(true);
			}
		}else {
				bg.clearSelection();
			}
		}
	public void fetchNextScreen() throws Exception {
		UserDao userdao=new UserDao();
		 fetchRole(index);
		//   fetchRight(index);
		try {
			userdao.updateRoleAndRights(userDTOlist);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AuthenticationView frame=new AuthenticationView();
		frame.setVisible(true);
		this.dispose();
	}
	
	public RoleRightsView() throws IndexOutOfBoundsException {
		loadUserData();
		printUserData();

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		bg.add(Role1);
		bg.add(Role2);
		bg.add(Role3);
		
	
		heading.setHorizontalAlignment(SwingConstants.CENTER);
		heading.setFont(new Font("Times New Roman", Font.BOLD, 18));
		heading.setBounds(313, 11, 342, 42);
		contentPane.add(heading);
		
		
		firstNamelbl.setHorizontalAlignment(SwingConstants.LEFT);
		firstNamelbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		firstNamelbl.setBounds(74, 74, 81, 31);
		contentPane.add(firstNamelbl);
		
		
		firstNamelbltxt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		firstNamelbltxt.setBounds(165, 74, 140, 22);
		contentPane.add(firstNamelbltxt);
		
		
		lastNamelbl.setHorizontalAlignment(SwingConstants.LEFT);
		lastNamelbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lastNamelbl.setBounds(356, 74, 115, 23);
		contentPane.add(lastNamelbl);
		
		
		lastNametxt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lastNametxt.setBounds(481, 74, 130, 22);
		contentPane.add(lastNametxt);
		
		
		Phone_no.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Phone_no.setBounds(641, 79, 122, 23);
		contentPane.add(Phone_no);
		
		phone_txt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		phone_txt.setHorizontalAlignment(SwingConstants.CENTER);
		phone_txt.setBounds(773, 74, 157, 22);
		contentPane.add(phone_txt);
		
	
		emailId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		emailId.setHorizontalAlignment(SwingConstants.LEFT);
		emailId.setBounds(74, 116, 81, 31);
		contentPane.add(emailId);
		
		
		emailtxt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		emailtxt.setHorizontalAlignment(SwingConstants.LEFT);
		emailtxt.setBounds(165, 117, 157, 22);
		contentPane.add(emailtxt);
		
		
		CollegeIDlbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		CollegeIDlbl.setBounds(356, 117, 115, 22);
		contentPane.add(CollegeIDlbl);
		
	
		cllgidtext.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cllgidtext.setBounds(481, 114, 130, 22);
		contentPane.add(cllgidtext);
		
		
		userRolelbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		userRolelbl.setBounds(641, 113, 122, 26);
		contentPane.add(userRolelbl);
		
		
		userRoletxt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		userRoletxt.setBounds(781, 114, 149, 22);
		contentPane.add(userRoletxt);
		
		
		Role.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Role.setBounds(74, 158, 99, 31);
		contentPane.add(Role);
		
		
		Role1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Role1.setBounds(49, 207, 42, 23);
		contentPane.add(Role1);
		
		
		Role2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Role2.setBounds(313, 207, 42, 23);
		contentPane.add(Role2);
		
		

		adminlbl.setBounds(97, 205, 115, 26);
		adminlbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(adminlbl);
			
		
		studentlbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		studentlbl.setBounds(597, 209, 104, 19);
		contentPane.add(studentlbl);
		
	
		Role3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Role3.setBounds(541, 207, 50, 23);
		contentPane.add(Role3);
		
		
		teacherlbl.setHorizontalAlignment(SwingConstants.LEFT);
		teacherlbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		teacherlbl.setBounds(377, 209, 92, 19);
		contentPane.add(teacherlbl);
		
		

		
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fetchRole(index);
				System.out.println("Role index previous " + index);
			
				System.out.println("Rigt index previous " + index);
				index=index+-1;
				printUserData();
			}
		});
		previous.setFont(new Font("Times New Roman", Font.BOLD, 15));
		previous.setBounds(84, 396, 122, 31);
		contentPane.add(previous);
		
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   if(index==0) {
				   fetchRole(0);
				 //  fetchRight(0);
				   index=index+1;
			   }else {
				fetchRole(index);System.out.println("Role index next "+ index);
			
				index=index+1;
			   }
			   printUserData();
			}
		});
		next.setFont(new Font("Times New Roman", Font.BOLD, 15));
		next.setBounds(299, 397, 130, 28);
		contentPane.add(next);
		
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(index == userDTOlist.size()-1) {
				try {
					fetchNextScreen();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else{
					JOptionPane.showMessageDialog(submit, "please fill in the details for all the users");
				}
			}
		});
		submit.setFont(new Font("Times New Roman", Font.BOLD, 15));
		submit.setBounds(507, 397, 119, 28);
		contentPane.add(submit);
		
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminView();
			}
		});
		btnBack.setActionCommand("Back");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnBack.setBounds(705, 401, 119, 28);
		contentPane.add(btnBack);
		

	}
}
