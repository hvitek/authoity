package com.compsys.builders;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.List;

public class ObjectDepenceBuilder {
	
	public static void main(String[] args) {
		
//TODO generování všech entit!!!!!!!		
//		List<Class<?>> entities = ClassFinder.find("com.compsys.model");
//        for (Class<?> entity : entities) 
//        { 
//        	
//        	String pathOfEntities = System.getProperty("user.dir") + "\\src\\main\\java\\com\\compsys\\model\\" + entity.getSimpleName() +".java";
//        	System.out.println(pathOfEntities+" - start");
//        	try 
//        	{
//				ObjectDepenceBuilderWorker objectDepenceBuilderWorker = new ObjectDepenceBuilderWorker(pathOfEntities);
//			} 
//        	catch (FileNotFoundException e) {
//				e.printStackTrace();
//			}
//        	System.out.println(pathOfEntities+" - end");
//        }
        
        
    	String pathOfEntities = System.getProperty("user.dir") + "\\src\\main\\java\\com\\compsys\\model\\" + "AttendanceAction.java";
		System.out.println(pathOfEntities+" - start");
		try {
			ObjectDepenceBuilderWorker objectDepenceBuilderWorker = new ObjectDepenceBuilderWorker(pathOfEntities);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(pathOfEntities+" - end");
	}
	

}
