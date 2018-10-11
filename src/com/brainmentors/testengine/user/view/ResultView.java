package com.brainmentors.testengine.user.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.brainmentors.testengine.user.dto.QuestionDTO;
import com.brainmentors.testengine.util.constants.MyResultTableModel;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ResultView extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	
	public ResultView(ArrayList<QuestionDTO>  questions,int finalScore) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		JLabel NoOfTestsTaken = new JLabel("No of Tests Taken");
//		NoOfTestsTaken.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		NoOfTestsTaken.setHorizontalAlignment(SwingConstants.CENTER);
//		NoOfTestsTaken.setBounds(65, 210, 146, 25);
//		contentPane.add(NoOfTestsTaken);
//		
//		JLabel TestNo = new JLabel("New label");
//		TestNo.setFont(new Font("Times New Roman", Font.PLAIN, 13));
//		TestNo.setBounds(259, 211, 182, 25);
//		contentPane.add(TestNo);
//		
//		JLabel StudentReport = new JLabel("Student Report");
//		StudentReport.setHorizontalAlignment(SwingConstants.CENTER);
//		StudentReport.setFont(new Font("Times New Roman", Font.BOLD, 18));
//		StudentReport.setBounds(406, 33, 231, 36);
//		contentPane.add(StudentReport);
//		
//		JLabel lblNewLabel = new JLabel("Name of Student");
//		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel.setBounds(70, 114, 125, 25);
//		contentPane.add(lblNewLabel);
//		
//		JLabel studentName = new JLabel("New label");
//		studentName.setBounds(259, 115, 193, 25);
//		contentPane.add(studentName);
//		
//		JLabel Stream1 = new JLabel("Stream");
//		Stream1.setHorizontalAlignment(SwingConstants.CENTER);
//		Stream1.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		Stream1.setBounds(43, 160, 113, 27);
//		contentPane.add(Stream1);
//		
//		JLabel StreamText = new JLabel("New label");
//		StreamText.setBounds(259, 161, 193, 26);
//		contentPane.add(StreamText);
//		
//		JLabel AvgPerScor = new JLabel("Average Percentage Score");
//		AvgPerScor.setHorizontalAlignment(SwingConstants.LEFT);
//		AvgPerScor.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		AvgPerScor.setBounds(75, 254, 193, 25);
//		contentPane.add(AvgPerScor);
//		
//		JLabel AvgPerScorInt = new JLabel("New label");
//		AvgPerScorInt.setFont(new Font("Times New Roman", Font.PLAIN, 13));
//		AvgPerScorInt.setBounds(288, 255, 164, 25);
//		contentPane.add(AvgPerScorInt);
//		
		JLabel LastTestScore = new JLabel("Last Test Score");
		LastTestScore.setHorizontalAlignment(SwingConstants.CENTER);
		LastTestScore.setFont(new Font("Times New Roman", Font.BOLD, 15));
		LastTestScore.setBounds(348, 491, 171, 25);
		contentPane.add(LastTestScore);
	
		JLabel LateTestSco = new JLabel(" "+finalScore);
		LateTestSco.setBounds(629, 492, 153, 25);
		contentPane.add(LateTestSco);
		
//		JLabel ClassRank = new JLabel("Class Rank");
//		ClassRank.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		ClassRank.setHorizontalAlignment(SwingConstants.CENTER);
//		ClassRank.setBounds(30, 443, 154, 25);
//		contentPane.add(ClassRank);
//		
//		JLabel class_rank = new JLabel("New label");
//		class_rank.setBounds(259, 443, 153, 27);
//		contentPane.add(class_rank);
//		
//		JLabel lblNewLabel_2 = new JLabel("Date of Submission");
//		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		lblNewLabel_2.setBounds(56, 371, 158, 25);
//		contentPane.add(lblNewLabel_2);
//		
//		JLabel date_of_sub = new JLabel("New label");
//		date_of_sub.setBounds(259, 372, 153, 24);
//		contentPane.add(date_of_sub);
//		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(98, 24, 794, 441);
     	contentPane.add(scrollPane);
		
		table =new JTable();
		table.setModel(new MyResultTableModel(questions));
		scrollPane.setViewportView(table);
	}
}
