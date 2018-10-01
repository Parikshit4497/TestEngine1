package com.brainmentors.testengine.util.constants;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

public interface CommonUtils {
	Logger commonutils=Logger.getLogger(CommonUtils.class);
	    public static String getFileName(String path) {
	    	commonutils.debug("Inside file");
	     	int indexOf=path.lastIndexOf( "\\" ) ;
	    	String absPath=path.substring(indexOf+1);
	    	
	    	return "\\"+absPath;
	    }
         public static String convertPrintStackIntoString(Exception e) {
        	 StringWriter sw=new StringWriter();
        	 PrintWriter pw=new PrintWriter(sw);
        	 e.printStackTrace(pw);
        	 e.printStackTrace(pw);
        	 String message =sw.toString();
        	 return message;
        	 
        	 
         }
}
