package com.brainmentors.testengine.question.helper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.Row;

import com.brainmentors.testengine.user.dto.QuestionDTO;
import com.brainmentors.testengine.user.dto.UserDTO;
import com.brainmentors.testengine.user.view.dao.QuestionDAO;
import com.brainmentors.testengine.user.view.dao.UserDao;
import com.brainmentors.testengine.util.constants.CommonUtils;
import com.brainmentors.testengine.util.constants.PathConstants;

public class RecordUploaderHelper {
	public boolean writeToDB(String path) throws IOException{
		ArrayList<UserDTO> userList = new ArrayList<>();
			boolean isFirstRowPass = false;
			boolean isUploaded = false;
			int cellCounter;
			FileInputStream file = new FileInputStream(path);
			HSSFWorkbook workBook = new HSSFWorkbook(file);
			HSSFSheet sheet = workBook.getSheetAt(0);
			Iterator<Row> rows = sheet.rowIterator();
			while(rows.hasNext()){
				Row currentRow = rows.next();
				if(!isFirstRowPass){
					isFirstRowPass = true;
					continue;
				}
				cellCounter=0;
				UserDTO userDTO = new UserDTO();
				Iterator<Cell> cells = currentRow.cellIterator();
				while(cells.hasNext()){
					Cell currentCell = cells.next();
					cellCounter++;
					setIntoUserRecords(userDTO, currentCell, cellCounter);
	
				} // Cell Loop Ends
				userList.add(userDTO);
			} // Row Loop Ends
		    UserDao userDAO =new UserDao();
			isUploaded=true;
			try {
				userDAO.BulkUpload(userList);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			return isUploaded;
		}
		
		
	

	
	public void setIntoUserRecords(UserDTO userDTO,Cell currentCell,int cellCount) {
		if(cellCount==1) {
			userDTO.setFirstName(currentCell.getStringCellValue());
			}
		if(cellCount==2) {
			userDTO.setLastName(currentCell.getStringCellValue());
		}
		if(cellCount==3) {
			userDTO.setEmailId(currentCell.getStringCellValue());
		}
		if(cellCount==4) {
			userDTO.setPhoneNO(currentCell.getStringCellValue());
		}
		if(cellCount==5) {
			userDTO.setPassword(currentCell.getStringCellValue());
		}
		if(cellCount==6) {
			userDTO.setConfirmPassword(currentCell.getStringCellValue());
		}
		if(cellCount==7) {
			 userDTO.setSelectCity(currentCell.getStringCellValue());
		}
		if(cellCount==8) {
			 userDTO.setSelectCollege(currentCell.getStringCellValue());
		}
		if(cellCount==9) {
			 userDTO.setSelectStream(currentCell.getStringCellValue());
		}
		
		if(cellCount==10) {
			userDTO.setSelectUsertype(currentCell.getStringCellValue());
		}if(cellCount==11) {
			userDTO.setGender(currentCell.getStringCellValue());
		}if(cellCount==12) {
			 String strValue;
			 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			 Date today =  currentCell.getDateCellValue() ;      
			  String reportDate = df.format(today);
			 
		userDTO.setDateOfBirth(reportDate);	
		}if(cellCount==13) {
						userDTO.setCollegId(String.valueOf((int)currentCell.getNumericCellValue()));
//
		}if(cellCount==14) {
			userDTO.setUserid(currentCell.getStringCellValue());
		}
	}
	

	
	public boolean read(String path) throws IOException {
		boolean isUploaded = false;
		File file = new File(path);
		
		String fileName = CommonUtils.getFileName(path);
		String uploadPath = PathConstants.UPLOAD_PATH+fileName;
	System.out.println(" upload path" +uploadPath );
	System.out.println("path  :::::" +path);
		FileOutputStream fo=null;
		BufferedOutputStream bo = null;
		FileInputStream fs = null;
		BufferedInputStream bs = null;
		try {
			fo = new FileOutputStream(uploadPath);
			bo = new BufferedOutputStream(fo);
			fs = new FileInputStream(path);
			bs = new BufferedInputStream(fs);
		if(file.exists()) {
			int singleByte = bs.read();
			while(singleByte!=-1) {
				bo.write(singleByte);
				singleByte = bs.read();
			}
			//isUploaded=writeToDB(uploadPath);
		}
		    else {
				System.out.println("File not exists");
		    }
		//isUploaded=writeToDB(uploadPath);
		}
		finally {
			if(bo!=null) {
			bo.close();
			}
			if(fo!=null) {
			fo.close();
			}
			if(bs!=null) {
			bs.close();
			}
			if(fs!=null) {
			fs.close();
			}
		}
		isUploaded=writeToDB(uploadPath);
		
		
		return isUploaded;
	}
}
