package com.brainmentors.testengine.user.view;

import static com.brainmentors.testengine.util.constants.CommonUtils.convertPrintStackIntoString;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.brainmentors.testengine.user.dto.UserDTO;
import com.brainmentors.testengine.user.view.dao.UserDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import java.awt.event.ActionEvent;

public class AuthenticationView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	Logger authenticationview =Logger.getLogger(AuthenticationView.class);
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthenticationView frame = new AuthenticationView();
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
	JLabel lblNewLabel = new JLabel("Authentication ");
	JLabel firstLbl = new JLabel("First Name");
	JLabel FirstNametxt = new JLabel("");
		JLabel lastNamelbl = new JLabel("Last Name");
		JLabel lastnametext = new JLabel("");
		JLabel phonelbl = new JLabel("Phone No");
		JLabel phonelbltxt = new JLabel("");
		JLabel EmailIDlbl = new JLabel("Email Id");
		JLabel EmailIdtxt = new JLabel("");
		JLabel UserTypelbl = new JLabel("User Type");
		JLabel CollegId = new JLabel("CollegeId");
		JLabel cllgIdlbl = new JLabel("");
		JLabel usertype_txt = new JLabel("");
		JLabel authenticationlbl = new JLabel("Authentication");
		JRadioButton yes = new JRadioButton("Yes");
		JRadioButton no = new JRadioButton("No");
		JButton previous = new JButton("Previous");
		JButton next = new JButton("Next");
        ArrayList<UserDTO> userDTOlist=new ArrayList<>();
        ButtonGroup bg=new ButtonGroup();
        private int index;
		private String authentication;
        public void loadUserdata() {
			UserDao userdao=new UserDao();
			authenticationview.debug("Inside loaduser data function ");
			 try {
				userDTOlist=userdao.fetchUserData();
				
				authenticationview.debug("Inside loaduser data function ");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
				authenticationview.error(convertPrintStackIntoString(e));
			}

			
			 authenticationview.debug(" leaving  loaduser data   ");
        }
        public boolean submitAuthentication()  {
        	authenticationview.debug("Inside submit authentication function ");
        	getDataAuthentication(index);
        	UserDao userdao=new UserDao();
        	boolean result=false;
        	try {
        	 result=userdao.submitAuth(userDTOlist) ;
        	 System.out.println("Result in authentication view " + result);
        	 authenticationview.debug("Inside submit authentication try  ");
        	
        	}catch(SQLException e) {
        		e.printStackTrace();
        		System.out.println(e);
        		authenticationview.error(convertPrintStackIntoString(e));
        	}
        	
        	System.out.println("Result in authen view sent" + result);
        	return result;
        }
        public void selectYourOption() {
        		if(this.userDTOlist.get(index).getAuthentication()!=null) {
        	  authentication=this.userDTOlist.get(index).getAuthentication();
        	
             if(authentication.equals("yes")) {
        		  yes.setSelected(true);
        	  }else if(authentication.equals("no")) {
        		  no.setSelected(true);
        	  }
        	}else {
        		  bg.clearSelection();
        	  }		
        }
        public void enableDisableButton() {
    		if(userDTOlist.size()==1){
    			previous.setEnabled(false);
    			next.setEnabled(false);
    		}
    		else
    		if(index==0){
    		previous.setEnabled(false);
    		next.setEnabled(true);
    		}
    		else
    			if(index == userDTOlist.size()-1){
    				next.setEnabled(false);
    				previous.setEnabled(true);
    				
    			}
    		else
    		if(index>0 && index<userDTOlist.size()){
    			previous.setEnabled(true);
    			next.setEnabled(true);
    		}
    	}
        public void printUserData() throws Exception {
        	
           if(userDTOlist.size()==0) {
        	    throw new Exception("IndexOutOfBoundException");
           }
        	if(index<userDTOlist.size()) {
        		selectYourOption();
        	}
        	UserDTO userdto=new UserDTO();
        	userdto=userDTOlist.get(index);
        	FirstNametxt.setText(userdto.getFirstName());
        	lastnametext.setText(userdto.getLastName());
        	 phonelbltxt.setHorizontalAlignment(SwingConstants.LEFT);
        	
        	 phonelbltxt.setText(userdto.getPhoneNO());
        	 EmailIdtxt.setText(userdto.getEmailId());
        	 cllgIdlbl.setText(userdto.getCollegId());
        	 usertype_txt.setFont(new Font("Times New Roman", Font.BOLD, 15));
        	 usertype_txt.setText(userdto.getSelectUsertype());
             enableDisableButton();
             
        }
	     public void getDataAuthentication(int index) {
	    	 
	    	 if(yes.isSelected()) {
	    		 authentication="yes";
	    	 }else if(no.isSelected()) {
	    		 authentication="no";
	    	 }
	    	 this.userDTOlist.get(index).setAuthentication(authentication);
	    	 authentication="";
	     }
		public AuthenticationView() throws Exception {
		loadUserdata();
			printUserData();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		bg.add(yes);
		bg.add(no);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(344, 11, 194, 39);
		contentPane.add(lblNewLabel);
		
		
		firstLbl.setHorizontalAlignment(SwingConstants.LEFT);
		firstLbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		firstLbl.setBounds(41, 87, 103, 21);
		contentPane.add(firstLbl);
		
		
		FirstNametxt.setHorizontalAlignment(SwingConstants.LEFT);
		FirstNametxt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		FirstNametxt.setBounds(154, 87, 125, 21);
		contentPane.add(FirstNametxt);
		
	
		lastNamelbl.setHorizontalAlignment(SwingConstants.LEFT);
		lastNamelbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lastNamelbl.setBounds(324, 87, 86, 18);
		contentPane.add(lastNamelbl);
		
		
		lastnametext.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lastnametext.setBounds(420, 89, 125, 18);
		contentPane.add(lastnametext);
		
		
		phonelbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		phonelbl.setBounds(641, 87, 79, 18);
		contentPane.add(phonelbl);
		
		
		phonelbltxt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		phonelbltxt.setBounds(730, 88, 135, 18);
		contentPane.add(phonelbltxt);
		
		
		EmailIDlbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		EmailIDlbl.setBounds(41, 138, 86, 21);
		contentPane.add(EmailIDlbl);
		
	
		EmailIdtxt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		EmailIdtxt.setBounds(154, 138, 125, 18);
		contentPane.add(EmailIdtxt);
		
	
		CollegId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		CollegId.setBounds(324, 138, 86, 18);
		contentPane.add(CollegId);
		
		
		cllgIdlbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cllgIdlbl.setBounds(420, 138, 125, 18);
		contentPane.add(cllgIdlbl);
		
		
		UserTypelbl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		UserTypelbl.setBounds(641, 138, 79, 18);
		contentPane.add(UserTypelbl);
		
		
		usertype_txt.setBounds(730, 138, 150, 21);
		contentPane.add(usertype_txt);
		
		
		authenticationlbl.setHorizontalAlignment(SwingConstants.CENTER);
		authenticationlbl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		authenticationlbl.setBounds(344, 190, 150, 27);
		contentPane.add(authenticationlbl);
		
		
		yes.setFont(new Font("Times New Roman", Font.BOLD, 15));
		yes.setBounds(90, 288, 79, 23);
		contentPane.add(yes);
		
		
		no.setFont(new Font("Times New Roman", Font.BOLD, 15));
		no.setBounds(567, 288, 79, 21);
		contentPane.add(no);
		
		
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            getDataAuthentication(index);
				index=index+-1;
				try {
					printUserData() ;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		previous.setFont(new Font("Times New Roman", Font.BOLD, 15));
		previous.setBounds(90, 404, 119, 23);
		contentPane.add(previous);
		
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index==0) {
					getDataAuthentication(0);
					index=index+1;
				}else {
					getDataAuthentication(index);
					index=index+1;
				}
				try {
					printUserData();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		next.setFont(new Font("Times New Roman", Font.BOLD, 15));
		next.setBounds(386, 404, 89, 23);
		contentPane.add(next);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean status=false;
				status=submitAuthentication();
		String	result=	status?"Authentication sucessfull":"Authentication unsucessful";
		JOptionPane.showMessageDialog(btnNewButton_2,result);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setBounds(710, 404, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
