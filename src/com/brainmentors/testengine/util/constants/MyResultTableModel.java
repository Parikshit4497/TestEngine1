package com.brainmentors.testengine.util.constants;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.brainmentors.testengine.user.dto.QuestionDTO;

public class MyResultTableModel extends AbstractTableModel{
private String column[]= {"qid","Question","Right Answer","Your Answer","Score"};
private ArrayList<QuestionDTO> questionList;
public MyResultTableModel(ArrayList<QuestionDTO>questionList) {
	this.questionList=questionList; 
}
	public String 	getColumnName(int columns) {
		return column[columns];
	}
	public int getRowCount() {
		return questionList.size();
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return column.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		QuestionDTO questionDTO = questionList.get(rowIndex);
	switch(columnIndex){	
		case 0:
			return questionDTO.getId();
		case 1:
			return questionDTO.getName();
		case 2:
			return questionDTO.getRans();
		case 3:
			return questionDTO.getYourAns();
		case 4:	
			return questionDTO.getScore();
	}
		// TODO Auto-generated method stub
		return null;
	}

}

