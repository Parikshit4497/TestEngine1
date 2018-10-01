package com.brainmentors.testengine.user.view;

import static com.brainmentors.testengine.util.constants.CommonUtils.convertPrintStackIntoString;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ButtonUI;

import org.apache.log4j.Logger;

import com.brainmentors.testengine.user.dto.QuestionDTO;
import com.brainmentors.testengine.user.view.dao.QuestionDAO;
import com.brainmentors.testengine.util.constants.CommonConstants;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TakeTestView extends JFrame {
    private JPanel contentPane;
    Logger tTView=Logger.getLogger(TakeTestView.class);

	ButtonGroup buttonGroup=new ButtonGroup();
	private String TestName1="";

	
	/**
	 * Launch the application.
	 */
	private ArrayList<QuestionDTO> questions;
	private int index;
	private String yourAns="";
	private int time;
	private Timer timer;
	
	private void showTimeLeft(){
		tTView.debug("Inside show time left function for timer");
		timer = new Timer(CommonConstants.DELAY, new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				timer_count.setText(String.valueOf(time));
			
if(time==0){
					
					timer.stop();
					finishTest();
				}
				time--;
			}
		});
		timer.start();
		tTView.debug("leaving  show time left function for timer");
	}
	private JLabel qno = new JLabel("");
	 
	private JLabel lblQ;
		private void selectAns() {
			if(this.questions.get(index).getYourAns()!=null) {
				yourAns=this.questions.get(index).getYourAns();
				if(yourAns.equals("a")) {
					ans1.setSelected(true);
					
				}else if(yourAns.equals("b")){
					ans2.setSelected(true);
				}else if(yourAns.equals("c")) {
					ans3.setSelected(true);
				}else if(yourAns.equals("d")) {
					ans4.setSelected(true);
				}
			}else {
		       buttonGroup.clearSelection();
			}
		}
	
	private void printQuestion(){
		tTView.debug("inside print question method");
		System.out.println("The print question " + questions.size());
		if(index<questions.size()){
			selectAns();
			
			
			tTView.debug("inside if condition");
		QuestionDTO currentQuestion = questions.get(index);
		question_area.setText(currentQuestion.getName());
		qno.setText(String.valueOf(currentQuestion.getId()));
		ans1.setText(currentQuestion.getAns1());
		
		ans2.setText(currentQuestion.getAns2());
		
		ans3.setText(currentQuestion.getAns3());
		
		ans4.setText(currentQuestion.getAns4());
		
		enableDisableButtons();
		tTView.debug("leaving  if condition");
		}
		tTView.debug("outside printquestion method");
	}
	 private void fetchAns(int index) {
		 
		 
         if(ans1.isSelected())	{
       	  yourAns="a";
       }else if(ans2.isSelected()) {
       	yourAns="b";
       }else if(ans3.isSelected()) {
       	yourAns="c";
       }else if(ans4.isSelected()) {
       	yourAns="d";
       }
	
	 this.questions.get(index).setYourAns(yourAns);
		System.out.println("Question is "+this.questions.get(index));
		yourAns="";
}
private void enableDisableButtons(){
	tTView.debug("Inside enable disable button function");
	if(questions.size()==1){
		previous.setEnabled(false);
		next.setEnabled(false);
	}
	else if(index==0){
	previous.setEnabled(false);
	next.setEnabled(true);
	}
	else if(index == questions.size()-1){
			next.setEnabled(false);
			previous.setEnabled(true);
		}
	else if(index>0 && index<questions.size()){
		previous.setEnabled(true);
		next.setEnabled(true);
	}
	tTView.debug("leaving enable disable function");
}
//  public void setQuestions(String TestName) {
//	  TestName1=TestName;
//	  System.out.println(" set questions testname recieved " +TestName1);
//	}
	public void loadQuestions(){
		tTView.debug("Inside load question function");
		QuestionDAO questionDAO = new QuestionDAO();
		try {
			tTView.debug("Inside try block");
			//questions=new ArrayList<>();
			System.out.println("Test name sent to dao " +TestName1);
			questions = questionDAO.getQuestions(TestName1);
			System.out.println("Functions load question size " +questions.size());
		 time=questionDAO.getTime(TestName1)*60;
		      int i=0;
			while(i<questions.size()) {
				System.out.println("Retrieved list " + this.questions.get(i));
				i++;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "Can't Load Questions");
			tTView.error(convertPrintStackIntoString(e));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Can't Load Questions");
			// TODO Auto-generated catch block
			tTView.error(convertPrintStackIntoString(e));
		}
		tTView.debug("leaving load question method");
	}


//	public static void main(String[] args) {
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TakeTestView frame = new TakeTestView();
//					frame.setVisible(true);
//				//	frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	/**
	 * Create the frame.
	 */
	private int checkTest() {
		int score=0;
		for(QuestionDTO questionDTO: questions) {
			if(!questionDTO.getRans().equals(questionDTO.getYourAns())) {
				questionDTO.setScore(0);
			}
			score+=questionDTO.getScore();
		}
		return score;
	}
private void	finishTest() {
		
		fetchAns(index);
		ResultView rs=new ResultView(questions,checkTest());
		rs.setVisible(true);
		this.setVisible(false);
		this.dispose();
	}
	
	
	
	 JRadioButton ans1 = new JRadioButton("");
	private final JLabel timer1 = new JLabel("Timer");
	JRadioButton ans2 = new JRadioButton("");
	JRadioButton ans3 = new JRadioButton("");
	JRadioButton ans4 = new JRadioButton("");
	private final JLabel timer_count = new JLabel("0");
	JButton previous = new JButton("Previous");
	JButton next = new JButton("Next");
	private JLabel question_area=new JLabel("");
	private JLabel	question = new JLabel("");
		
	public TakeTestView(String TestName) {
		TestName1=TestName;
		loadQuestions();
		printQuestion();
		
		tTView.debug("Inside take test view constructor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel top_heading = new JLabel(TestName1);
		top_heading.setHorizontalAlignment(SwingConstants.CENTER);
		top_heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
		top_heading.setBounds(357, 12, 232, 32);
		contentPane.add(top_heading);
		question_area.setFont(new Font("Times New Roman", Font.BOLD, 15));
		question_area.setHorizontalAlignment(SwingConstants.CENTER);

		
		
		qno.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		qno.setBounds(73, 102, 30, 32);
		contentPane.add(qno);
		
		lblQ = new JLabel("Q");
		lblQ.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblQ.setBounds(27, 102, 30, 32);
		contentPane.add(lblQ);
		
		
		
		
		question_area.setBounds(109, 91, 755, 202);
		contentPane.add(question_area);
		
		
		ans1.setHorizontalAlignment(SwingConstants.LEFT);
		ans1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		ans1.setBounds(143, 322, 209, 32);
		contentPane.add(ans1);
		buttonGroup.add(ans1);
		
		ans2.setHorizontalAlignment(SwingConstants.LEFT);
		ans2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		ans2.setBounds(143, 411, 207, 32);
		contentPane.add(ans2);
		buttonGroup.add(ans2);
		
		ans3.setHorizontalAlignment(SwingConstants.LEFT);
		ans3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		ans3.setBounds(509, 322, 209, 32);
		contentPane.add(ans3);
		buttonGroup.add(ans3);
		
		ans4.setHorizontalAlignment(SwingConstants.LEFT);
		ans4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		ans4.setBounds(509, 411, 209, 32);
		contentPane.add(ans4);
		buttonGroup.add(ans4);
		
		
		timer1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		timer1.setHorizontalAlignment(SwingConstants.CENTER);
		timer1.setBounds(838, 21, 74, 24);
		contentPane.add(timer1);
		timer_count.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		timer_count.setBounds(848, 56, 74, 24);
		contentPane.add(timer_count);
		
		
		previous.setFont(new Font("Times New Roman", Font.BOLD, 15));
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tTView.debug("Inside previous action performed method");
				fetchAns(index);
				index = index - 1;
				printQuestion();
              
			}
		});
		tTView.debug("outside previous action performed method");
		previous.setBounds(143, 492, 113, 30);
		contentPane.add(previous);
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tTView.debug("Inside next action method");
				if(index==0) {
					fetchAns(0);
				index = index + 1;
				}
				else {
					
					fetchAns(index);
					index=index+1;
					
				}
				printQuestion();
				
			}
		});
		
		tTView.debug("Outside action performed method");
		next.setFont(new Font("Times New Roman", Font.BOLD, 15));
		next.setBounds(357, 493, 134, 28);
		contentPane.add(next);
		
		JButton btnNewButton = new JButton("FINISH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			      finishTest();
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(656, 492, 128, 30);
		contentPane.add(btnNewButton);
		showTimeLeft();
		tTView.debug("leaving take test view method");
	}
}
