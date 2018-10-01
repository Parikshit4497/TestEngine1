package com.brainmentors.testengine.question.helper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.brainmentors.testengine.user.dto.QuestionDTO;
import com.brainmentors.testengine.user.view.dao.QuestionDAO;
import com.brainmentors.testengine.util.constants.CommonUtils;
import com.brainmentors.testengine.util.constants.PathConstants;
public class QuestionUploadHelper {
   
	
	public boolean  writeToDB(String path,String fileName,int time) throws IOException{
		ArrayList<QuestionDTO> questionList = new ArrayList<>();
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
				QuestionDTO questionDTO = new QuestionDTO();
				Iterator<Cell> cells = currentRow.cellIterator();
				while(cells.hasNext()){
					Cell currentCell = cells.next();
					cellCounter++;
					setIntoQuestionDTO(questionDTO, currentCell, cellCounter);
	
				} // Cell Loop Ends
				questionList.add(questionDTO);
			} // Row Loop Ends
			QuestionDAO questionDAO = new QuestionDAO();
			
			try {
				isUploaded= questionDAO.BulkUpload(questionList,fileName,time);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return isUploaded;
		}
		
		
	
	
	
	public void setIntoQuestionDTO(QuestionDTO questionDTO,Cell currentCell,int cellCount) {
		if(cellCount==1) {
			questionDTO.setId((int)currentCell.getNumericCellValue());
			}
		if(cellCount==2) {
			questionDTO.setName(currentCell.getStringCellValue());
		}
		if(cellCount==3) {
			questionDTO.setAns1(currentCell.getStringCellValue());
		}
		if(cellCount==4) {
			questionDTO.setAns2(currentCell.getStringCellValue());
		}
		if(cellCount==5) {
			questionDTO.setAns3(currentCell.getStringCellValue());
		}
		if(cellCount==6) {
			questionDTO.setAns4(currentCell.getStringCellValue());
		}
		if(cellCount==7) {
			questionDTO.setRans(currentCell.getStringCellValue());
		}
		if(cellCount==8) {
			questionDTO.setScore((int)currentCell.getNumericCellValue());
		}
	}
	

	
	public boolean read(String path,int time) throws IOException {
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
		isUploaded=writeToDB(uploadPath,fileName.substring(1),time);
		
		System.out.println("WritToDb" + isUploaded);
		return isUploaded;
	}





	
	
	
}
