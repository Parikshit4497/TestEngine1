package com.brainmentors.testengine.util.constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.brainmentors.testengine.user.dto.UserDTO;

public interface Offline {
	public static UserDTO readObj() throws IOException, ClassNotFoundException {
		File file =new File(PathConstants.file_path);
		if(file.exists()) {
			FileInputStream in=new FileInputStream(file);
			ObjectInputStream oi=new ObjectInputStream(in);
			UserDTO userdto=(UserDTO)oi.readObject();
			return userdto;
		}else {
			return null;
		}
		
		
	}
           public static boolean writeToObj(UserDTO userdto) throws IOException {
        	   FileOutputStream file=new FileOutputStream(PathConstants.file_path);
        	   ObjectOutputStream os=new ObjectOutputStream(file);
        	   os.writeObject(userdto);
        	   os.close();
        	   file.close();
        	   return true;
        	   
           }
}
