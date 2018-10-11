package com.brainmentors.testengine.user.view.dao;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.log4j.Logger;
import org.apache.poi.hslf.record.Record;

import com.brainmentors.testengine.user.dto.LoginDTo;
import com.brainmentors.testengine.user.dto.QuestionDTO;
import com.brainmentors.testengine.user.dto.RegisterDTO;
import com.brainmentors.testengine.user.dto.RightAuthenticationDTO;
import com.brainmentors.testengine.user.dto.RightDTO;
import com.brainmentors.testengine.user.dto.UserDTO;
import com.brainmentors.testengine.util.constants.CommonDao;
import com.brainmentors.testengine.util.constants.QueryConstants;
import com.brainmentors.testengine.util.constants.QueryConstants;

public class UserDao {
	Logger logger3= Logger.getLogger(UserDao.class);
	public boolean submitAuth(ArrayList<UserDTO> userDTOlist) throws SQLException {
		Connection con=null ;
		PreparedStatement pstmt=null;
		boolean result=false;
		try {
        con=CommonDao.getConnection();
		pstmt=con.prepareStatement(QueryConstants.UserAuthentication);
		for(int i=0;i<userDTOlist.size();i++) {
		  pstmt.setString(1,userDTOlist.get(i).getAuthentication());
		  pstmt.setInt(2, userDTOlist.get(i).getUid());
		  pstmt.addBatch();
		}
		int records[]=pstmt.executeBatch();
		    if(records.length>0) {
		    	con.commit();
		    	result=true;
		    }else {
		    	con.rollback();
		    	result=false;
		    }
	 }catch(SQLException e) {
		 e.printStackTrace();
		 result=false;
		try {
		 con.rollback();
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
	 }catch(ClassNotFoundException e) {
		 e.printStackTrace();
		 result=false;
	 }finally {
		 if(con!=null) {
			 con.close();
		 }
		 if(pstmt!=null) {
			 pstmt.close();
		 }
	 }
		return false;
	}
 	public void updateRoleAndRights(ArrayList<UserDTO> userDTOlist) throws SQLException, ClassNotFoundException {
// 		System.out.println("###########################################################################################");
// 		System.out.println("Inside UserDAO updateRoleAndRights ");
// 		System.out.println("Rights ::::::: ");
// 		for(UserDTO ud : userDTOlist) {
// 			for(RightAuthenticationDTO rights : ud.getRightIstrueDto().getRightAuth()) {
// 				System.out.println("Right VALUE IS "+rights.getRightvalue());
// 			}
// 		}
 	//	System.out.println("#################################################################################################");
	   Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			System.out.println("Updating started");
			int i;
			con=CommonDao.getConnection();
			pstmt=con.prepareStatement(QueryConstants.setUserRole);
		for( i=0;i<userDTOlist.size();i++) {
			pstmt.setInt(1,userDTOlist.get(i).getUid());
			pstmt.setInt(2,Integer.parseInt(userDTOlist.get(i).getRoleID()) );
			pstmt.addBatch();
		}
			
			
 	      int records[]=pstmt.executeBatch();
 	    
 	      pstmt=con.prepareStatement(QueryConstants.setRoleRightMapping);
 	     for(i=0;i<userDTOlist.size();i++) {
 	    	 for(int j=0;j<userDTOlist.get(i).getRightIstrueDto().getRightAuth().size();j++) {
 	    		 System.out.println("Right=" + userDTOlist.get(i).getRightIstrueDto().getRightAuth().get(j).getRightvalue());
 	    		 if(userDTOlist.get(i).getRightIstrueDto().getRightAuth().get(j).getRightvalue()>0) {
 			      pstmt.setInt(1,userDTOlist.get(i).getRightIstrueDto().getRightAuth().get(j).getRightvalue());
    	
 			pstmt.setInt(2,Integer.parseInt(userDTOlist.get(i).getRoleID()) );
 			System.out.println(" role " + Integer.parseInt(userDTOlist.get(i).getRoleID())) ;
 			pstmt.addBatch();
 	    		 }
 		   }
 	    	
 		 }
			
 	      int records1[]=pstmt.executeBatch();
 	     
 	      if(records.length>0&&records1.length>0) {
 	    	  con.commit();
 	    	  System.out.println("Data entered in DB");
 	      }else {
 	    	  con.rollback();
 	    	  System.out.println("Data entry cancelled");
 	      }
		}
		catch(Exception e ){
			System.out.println("Exception is **************************** "+e);
			e.printStackTrace();
		  con.rollback();
		}finally {
			if(con !=null) {
				con.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			
		}
			
			
			
	
		
		
	}
	public ArrayList<UserDTO> fetchUserData() throws ClassNotFoundException, SQLException{
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			ArrayList<UserDTO> userDTOlist=new ArrayList<>();
			connection=CommonDao.getConnection();
			
			pstmt=connection.prepareStatement(QueryConstants.fetchUserRecord);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				UserDTO userdto=new UserDTO();
				userdto.setFirstName(rs.getString("firstname"));
				userdto.setLastName(rs.getString("lastname"));
				userdto.setEmailId(rs.getString("emailid"));
				userdto.setPhoneNO(rs.getString("phoneno"));
				userdto.setPassword(rs.getString("password"));
				userdto.setConfirmPassword(rs.getString("confirmpassword"));
				userdto.setSelectCity(rs.getString("selectcity"));
				userdto.setSelectCollege(rs.getString("selectcollege"));
				userdto.setSelectUsertype(rs.getString("selectusertype"));
				userdto.setGender(rs.getString("gender"));
				userdto.setDateOfBirth(rs.getString("dateofbirth"));
				userdto.setCollegId(rs.getString("collegeid"));
				userdto.setUserid(rs.getString("userid"));
				userdto.setUid(rs.getInt("uid"));
				userDTOlist.add(userdto);
				
			}
			
		  
			return userDTOlist;
		}finally {
			if(connection!=null) {
				connection.close();
			}
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
		}
	}
	public String checkIfPresent(UserDTO registerdto) throws SQLException, ClassNotFoundException{
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String result;
		try{
			logger3.debug("Inside try");
			connection = CommonDao.getConnection();
			pstmt = connection.prepareStatement(QueryConstants.searchRecord);
		    
			pstmt.setString(1, registerdto.getEmailId());
			pstmt.setString(2, registerdto.getPhoneNO());
			pstmt.setString(3, registerdto.getCollegId());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result= "Either email id or college id or  phoneNo already exits in the database  ";
			}else {
				result= doRegister(registerdto);
			}
	    }
		finally{
			logger3.debug("INside Finally ");
			
			
			if(pstmt!=null){
			pstmt.close();
			}
			if(connection!=null){
			connection.close();
			}
			if(rs!=null) {
				rs.close();
			}
		}
		return result;
	}
	public String doRegister(UserDTO registerdto) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String result;
		try {
			connection = CommonDao.getConnection();
			pstmt = connection.prepareStatement(QueryConstants.REGISTER_SQL);
			pstmt.setString(1, registerdto.getFirstName());
			pstmt.setString(2, registerdto.getLastName());
			pstmt.setString(3, registerdto.getEmailId());
			pstmt.setString(4, registerdto.getPhoneNO());
			pstmt.setString(5, registerdto.getPassword());
			pstmt.setString(6, registerdto.getConfirmPassword());
			pstmt.setString(7, registerdto.getSelectCity());
			pstmt.setString(8, registerdto.getSelectCollege());
			pstmt.setString(9, registerdto.getSelectStream());
			pstmt.setString(10, registerdto.getSelectUsertype());
			pstmt.setString(11, registerdto.getGender());
			pstmt.setString(12, registerdto.getDateOfBirth());
			pstmt.setString(13, registerdto.getCollegId());
			System.out.println(registerdto.getUserid());
			pstmt.setString(14, registerdto.getUserid());
			int insertUpdate=pstmt.executeUpdate();
		
			if(insertUpdate>0) {
				connection.commit();
				result=insertUpdate>0?"record updated successfully":"record not updated successfully ";
			}else{
				connection.rollback();
				result="record could not be updated succefully ";
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			connection.rollback();
			result="Database connectivity issue has occurred";
		}
		
		finally{
			logger3.debug("INside Finally ");
			
			
			if(pstmt!=null){
			pstmt.close();
			}
			if(connection!=null){
			connection.close();
			}
			if(rs!=null) {
				rs.close();
			}
		}
		return result;
	}
	
	public UserDTO dologin(LoginDTo LoginDTO) throws ClassNotFoundException, SQLException {
		UserDTO userDTO=null;
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<RightDTO> rights=null; 
		try {
			logger3.debug("Inside Userdao login behind connection establishment ");
			connection=CommonDao.getConnection();
		
			pstmt=connection.prepareStatement(QueryConstants.login_sql);
			pstmt.setString(1, LoginDTO.getUserId());
			pstmt.setString(2, LoginDTO.getPassword());
			logger3.debug("Inside Userdao login after prepare statement  ");
			rs=pstmt.executeQuery();
		
			logger3.debug("Inside Userdao login after result set  ");
			while(rs.next()) {
				logger3.debug("inside loop executing result set statement  ");
				if(userDTO==null) {
					userDTO = new UserDTO();
					userDTO.setUserid(rs.getString("userid"));
					userDTO.setRoleName(rs.getString("rolename"));
					rights=new ArrayList();
					userDTO.setRight(rights);
				}
				RightDTO right=new RightDTO(rs.getString("rightname"),rs.getString("screenname"));
				rights.add(right);
				logger3.debug("leaving  loop executing result set statement  ");
			
			}
			
		}	finally {
		
			logger3.debug("entering finally  ");
			if(connection!=null) {
				connection.close();
			}
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			
		}
		logger3.debug("exiting do login ");
		return userDTO;
		
	}
	public void BulkUpload(ArrayList<UserDTO> userList) throws SQLException,ClassNotFoundException {
		Connection connection=null;
		PreparedStatement pstmt=null;
		try {
		connection=CommonDao.getConnection();
		pstmt=connection.prepareStatement(QueryConstants.REGISTER_SQL);
		for(UserDTO userListDetails:userList) {
			pstmt.setString(1,userListDetails.getFirstName());
			pstmt.setString(2, userListDetails.getLastName());
			pstmt.setString(3, userListDetails.getEmailId());
			pstmt.setString(4, userListDetails.getPhoneNO());
			pstmt.setString(5, userListDetails.getPassword());
			pstmt.setString(6, userListDetails.getConfirmPassword());
			pstmt.setString(7, userListDetails.getSelectCity());
			pstmt.setString(8, userListDetails.getSelectCollege());
			pstmt.setString(9,userListDetails.getSelectStream());
			pstmt.setString(10,userListDetails.getSelectUsertype() );
			pstmt.setString(11,userListDetails.getGender() );
			pstmt.setString(12,userListDetails.getDateOfBirth());
			pstmt.setString(13,userListDetails.getCollegId());
			pstmt.setString(14, userListDetails.getUserid());
			pstmt.addBatch();
			
		}
		int records[]=pstmt.executeBatch();
		if(records.length>0) {
		connection.commit();
		}else {
			connection.rollback();
		}
	}catch(SQLException e){
		connection.rollback();
		throw e;
	}catch(ClassNotFoundException e){
	 throw e;
	}	
		finally {
	
	    if(pstmt!=null) {
			pstmt.close();
		}
		if(connection!=null) {
			connection.close();
		}
	}
}

}
