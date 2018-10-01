package com.brainmentors.testengine.user.view;

import static com.brainmentors.testengine.util.constants.CommonUtils.convertPrintStackIntoString;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.brainmentors.testengine.user.dto.RightDTO;
import com.brainmentors.testengine.user.dto.UserDTO;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import javax.swing.JLabel;

public class DashBoardView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	 Logger Dashboardvie=Logger.getLogger(DashBoardView.class);
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		
			public void run() {
				try {
					DashBoardView frame = new DashBoardView();
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
	public void filldashBoard(UserDTO userDTO) {
		Dashboardvie.debug("Inside fill dashboard  method");
		if(userDTO!=null) {
			Dashboardvie.debug("checking if userdto is not null");
			UserIdlbl.setText("Hello " + userDTO.getUserid() +" :Role " +userDTO.getRoleName());
		}
		if(userDTO.getRight()!=null) {
			for(RightDTO right:userDTO.getRight()) {
				Dashboardvie.debug("Inside for loop  for userdto rights ");
				JMenuItem menuItem=new JMenuItem(right.getName());
				menuItem.addActionListener(new ActionListener() {
					

					@Override
					public void actionPerformed(ActionEvent arg0) {
						Dashboardvie.debug("Inside action performed method");
						try{// TODO Auto-generated method stub
							Dashboardvie.debug("Inside fill dashboard  method try block");
					    int indexof=right.getScreenName().lastIndexOf(".java");
					    String className=right.getScreenName().substring(0, indexof);
					    Object object= Class.forName(className).newInstance();
					    Method method =object.getClass().getMethod("setVisible", boolean.class);
					    method.invoke(object, true);
					    Dashboardvie.debug("exiting fill dashboard method");
					}
					catch(Exception e1){
						System.out.println("Refelection related error" +e1);
						Dashboardvie.error(convertPrintStackIntoString(e1));
					}
					}
				});
				Dashboardvie.debug("outside dashboard action perform method");
				file.add(menuItem);
			}
			Dashboardvie.debug("outside dashboard view method");
		}
			
	}
	JMenu file = new JMenu("File");
	private JLabel UserIdlbl = new JLabel("");
	public DashBoardView() {
		Dashboardvie.debug("inside dashboard view constructor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		file.setFont(new Font("Times New Roman", Font.BOLD, 12));
		menuBar.add(file);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		UserIdlbl.setFont(new Font("Times New Roman", Font.BOLD, 24));
		UserIdlbl.setBounds(51, 11, 361, 40);
		contentPane.add(UserIdlbl);
		
		
		Dashboardvie.debug("exiting dashboard view constructor ");
	}
}
