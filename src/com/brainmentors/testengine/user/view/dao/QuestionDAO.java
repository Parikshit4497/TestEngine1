package com.brainmentors.testengine.user.view.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.brainmentors.testengine.user.dto.QuestionDTO;
import com.brainmentors.testengine.util.constants.CommonDao;
import com.brainmentors.testengine.util.constants.QueryConstants;

public class QuestionDAO {
	Logger QuestionDao=Logger.getLogger(QuestionDAO.class);
	
	public int getTime(String TestName) {
		System.out.println("Inside QuestionDao function gettime");
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int time = 0;
		try {
		con=CommonDao.getConnection();
		
		pstmt=con.prepareStatement(QueryConstants.fetchTime);
		pstmt.setString(1,TestName);
		rs=pstmt.executeQuery();
		if(rs.next()) {
		time=rs.getInt("testtime");
		con.commit();
		}else {
			con.rollback();
		}
		}catch(SQLException e) {
			System.out.println("Inside getTime sql exception");
			e.printStackTrace();
			System.out.println(e);
			try {
			con.rollback();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return time;
	}
	public ArrayList<QuestionDTO> getQuestions(String TakeTest) throws SQLException, ClassNotFoundException {
		QuestionDao.debug("You have entered question dao with testname to get mapped question ");
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			QuestionDao.debug("inside try block establishing database connection");
			connection=CommonDao.getConnection();
			
			pstmt=connection.prepareStatement(QueryConstants.fetchMappedQuestion);
			System.out.println("Test name recieved by dao " + TakeTest);
			pstmt.setString(1,TakeTest);
			rs=pstmt.executeQuery();
			ArrayList<QuestionDTO> questions = new ArrayList<>();
			while(rs.next()){
				QuestionDao.debug("inside while block for executing the query ");
				QuestionDTO questionDTO = new QuestionDTO();
			
				questionDTO.setId(rs.getInt("qid"));
				questionDTO.setQno(rs.getInt("qno"));
				questionDTO.setName(rs.getString("name"));
				questionDTO.setAns1(rs.getString("ans1"));
				questionDTO.setAns2(rs.getString("ans2"));
				questionDTO.setAns3(rs.getString("ans3"));
				questionDTO.setAns4(rs.getString("ans4"));
				questionDTO.setRans(rs.getString("rans"));
				questionDTO.setScore(rs.getInt("score"));
				questions.add(questionDTO);
				
			}
			
			return questions;
			}
			finally{
				QuestionDao.debug("inside finally");
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(connection!=null) {
					connection.close();
				}
			}
			
	}	
	public ArrayList<QuestionDTO> getQuestions() throws SQLException, ClassNotFoundException {
		QuestionDao.debug("You have entered question dao");
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			QuestionDao.debug("inside try block establishing database connection");
			connection=CommonDao.getConnection();
			pstmt=connection.prepareStatement(QueryConstants.fetchUnmpapped);
			rs=pstmt.executeQuery();
			ArrayList<QuestionDTO> questions = new ArrayList<>();
			while(rs.next()){
				QuestionDao.debug("inside while block for executing the query ");
				QuestionDTO questionDTO = new QuestionDTO();
				questionDTO.setId(rs.getInt("qid"));
				questionDTO.setQno(rs.getInt("qno"));
				questionDTO.setName(rs.getString("name"));
				questionDTO.setAns1(rs.getString("ans1"));
				questionDTO.setAns2(rs.getString("ans2"));
				questionDTO.setAns3(rs.getString("ans3"));
				questionDTO.setAns4(rs.getString("ans4"));
				questionDTO.setRans(rs.getString("rans"));
				questionDTO.setScore(rs.getInt("score"));
				questions.add(questionDTO);
				
			}
			
			return questions;
			}
			finally{
				QuestionDao.debug("inside finally");
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(connection!=null) {
					connection.close();
				}
			}
			
	}	
	public ArrayList<QuestionDTO> getQuestions1() throws SQLException, ClassNotFoundException {
		QuestionDao.debug("You have entered question dao");
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			QuestionDao.debug("inside try block establishing database connection");
			connection=CommonDao.getConnection();
			pstmt=connection.prepareStatement(QueryConstants.firstMapping);
			rs=pstmt.executeQuery();
			ArrayList<QuestionDTO> questions = new ArrayList<>();
			while(rs.next()){
				QuestionDao.debug("inside while block for executing the query ");
				QuestionDTO questionDTO = new QuestionDTO();
				questionDTO.setId(rs.getInt("qid"));
				questionDTO.setQno(rs.getInt("qno"));
				questionDTO.setName(rs.getString("name"));
				questionDTO.setAns1(rs.getString("ans1"));
				questionDTO.setAns2(rs.getString("ans2"));
				questionDTO.setAns3(rs.getString("ans3"));
				questionDTO.setAns4(rs.getString("ans4"));
				questionDTO.setRans(rs.getString("rans"));
				questionDTO.setScore(rs.getInt("score"));
				questions.add(questionDTO);
				
			}
			
			return questions;
			}
			finally{
				QuestionDao.debug("inside finally");
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(connection!=null) {
					connection.close();
				}
			}
			
	}	
public Boolean BulkUpload(ArrayList<QuestionDTO> questionList,String fileName,int time) throws SQLException, ClassNotFoundException {
		QuestionDao.debug("inside bulk upload !");		
		Connection connection=null;
		PreparedStatement pstmt=null;
		int testStatus=0;
		String result="";
		System.out.println("Entering bulk upload");
		try {
			QuestionDao.debug("inside bulk upload try block establishing connection");
		connection=CommonDao.getConnection();
	       System.out.println("Inside try");
	     if(FindTest(fileName).equals("The file with the above testname is alrady present")) {
			System.out.println("Inside if block  for findtest check");
			return false;
	     }else {
		     System.out.println("Inside else block ");
			pstmt=connection.prepareStatement(QueryConstants.updateTest);
			pstmt.setString(1, fileName);
			pstmt.setInt(2, time);
			testStatus=pstmt.executeUpdate();
			System.out.println("After pstmt execute update ");
		}
	    pstmt=connection.prepareStatement(QueryConstants.QUESTION_UPLOAD_SQL);
		for(QuestionDTO question:questionList) {
		System.out.println("Inside question upload");
			QuestionDao.debug("inside bulk upload loop execution prepare statement ");
			
			pstmt.setInt(1,question.getQno());
			pstmt.setString(2, question.getName());
			pstmt.setString(3, question.getAns1());
			pstmt.setString(4, question.getAns2());
			pstmt.setString(5, question.getAns3());
			pstmt.setString(6, question.getAns4());
			pstmt.setString(7, question.getRans());
			pstmt.setInt(8, question.getScore());
			pstmt.addBatch();
			QuestionDao.debug("leaving dashboard for loop");
		}
		System.out.println("Outside question upload");
		int records[]=pstmt.executeBatch();
		if(records.length>0&&testStatus>0) {
			result="The test is uploaded"; 
		connection.commit();
		}else{
			connection.rollback();
		}
	}catch(SQLException e){
		System.out.println("Inside sql exception for outer try ");
	e.printStackTrace();
	try {
	connection.rollback();
	}catch(SQLException e1) {
		e1.printStackTrace();
		System.out.println("Inside sql exception ");
	}
	}catch(ClassNotFoundException e){
		throw e;
	}finally {
        QuestionDao.debug("inside finally");
		if(pstmt!=null) {
			pstmt.close();
		}
		if(connection!=null) {
			connection.close();
		}
	}
		if(TestQuesMap(fileName)) {
			System.out.println("Inside test map if");
		return true ;
		}else {
//			System.out.println("Inside test map else");
			return false;
		}
	}
public boolean TestQuesMap(String fileName) {
	System.out.println("Inside Testquesmap ");
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	boolean status=false;
	
	ArrayList<QuestionDTO> questionList =new ArrayList<>();
	int testid=0;
	System.out.println("Inside testQuesmap ");
	try {
		System.out.println("Inside tetQuesMap try  ");
		con=CommonDao.getConnection();
	if(FindTest(fileName).equals("The file with the above testname is alrady present")) {
		System.out.println("Inside testQuesmap if for find file ");
		pstmt=con.prepareStatement(QueryConstants.getTestId);
		pstmt.setString(1, fileName);
		rs=pstmt.executeQuery();
		rs.next();
		System.out.println("after fetch id prepare statemnet and rs.next ");
		testid=rs.getInt("testid");System.out.println("storing value of test id  ");
	}else {
		return false;
	}
	System.out.println("testid" + testid);
	String statusmap="YES";
	
	if(getQuestions().size()==0) {
       questionList=getQuestions1();
	}else {
		questionList=getQuestions();
	}
  System.out.println("The length of question is " + questionList.size());
	pstmt=con.prepareStatement(QueryConstants.testQuesMap);
	System.out.println("After pstmt for mapping ");
	for(QuestionDTO question:questionList) {
		System.out.println("before first pstmt");
		pstmt.setInt(1, testid);
		System.out.println("after first  pstmt");
		pstmt.setInt(2, question.getId());
		System.out.println("after second pstmt");
		pstmt.addBatch();
		System.out.println("Inside mapping loop");
	}
	int records[]=pstmt.executeBatch();
	pstmt=con.prepareStatement(QueryConstants.StatusUpdate);
	for(QuestionDTO question:questionList) {
		pstmt.setString(1,"YES");
		pstmt.setInt(2,question.getId());
		pstmt.addBatch();
	}
	 int records1[]=pstmt.executeBatch();
	
	if(records.length>0&&records1.length>0) {
		con.commit();
		System.out.println("Inside commit  ");
	status= true;
	}else {
		con.rollback();
		System.out.println("Inside else ");
		status = false;
	}
	}catch(SQLException e) {
		System.out.println("Inside Outer sql catch");
		e.printStackTrace();
		try {
		con.rollback();
		}catch(SQLException e1) {
			e1.printStackTrace();
			System.out.println("Inside inner sql catch");
		}
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}
	return status;
}

public String FindTest(String filename) throws SQLException {
   Connection connection =null;
   PreparedStatement pstmt=null;
   ResultSet rs=null;
   String result="";
   System.out.println("Inside find test for file " + filename);
   try {
	connection=CommonDao.getConnection();
	System.out.println("Inside try block ");
	pstmt=connection.prepareStatement(QueryConstants.findTest);
	pstmt.setString(1,filename);
	System.out.println("after query  ");
	rs=pstmt.executeQuery();
	if(rs.next()) {
		System.out.println("Inside result set if ");
		result="The file with the above testname is alrady present";
	}else{
		System.out.println("Inside result set else ");
		connection.commit();
		result="The test is uploaded";
		}	
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	System.out.println("Class not foun ");
}catch( SQLException e) {
	e.printStackTrace();
	System.out.println("SQL EXCEPTION");
	try {
		connection.rollback();
		
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		System.out.println("Inside subset sql ");
		e1.printStackTrace();
	}
}finally {
	if(connection!=null) {
		connection.close();
	}
	if(pstmt!=null) {
		pstmt.close();
	}if(rs!=null) {
		rs.close();
	}
}
   return result;
  
 }
}