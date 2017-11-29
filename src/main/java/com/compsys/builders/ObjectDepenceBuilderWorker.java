package com.compsys.builders;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ObjectDepenceBuilderWorker {
	String[] methodRows;
	
	public String Path = "";
	public ObjectDepenceBuilderWorker(String path) throws FileNotFoundException 
	{
		Path = path;
		updateText();
	}
	
	public String getTextOfFile(String path) throws FileNotFoundException
	{
		File file = new File(path);
		String contents = new Scanner(file).useDelimiter("\\Z").next();
		return contents;
	}
	public void makeController() {
		
	}
	
		public void work(String text) {
		StringBuilder fileContent = new StringBuilder(text);  
		int indexOfId = fileContent.indexOf("@Id");
		
		File f = new File(Path);
		String name = f.getName().replaceAll(".java", "").toLowerCase();
		
		String sequenceGeneratorName = "id_" + name.toLowerCase() + "_gen";
		String sequenceName = name.toLowerCase()+"_id_seq";
		String sequenceGenerator = "@SequenceGenerator(name=\""+sequenceGeneratorName+"\", sequenceName=\""+sequenceName+"\", allocationSize=1)";
		String generatedValue = "@GeneratedValue(generator=\""+sequenceGeneratorName+"\",strategy=GenerationType.SEQUENCE)";
		fileContent.insert(indexOfId+3, '\n'+ sequenceGenerator + '\n' + generatedValue);
		
		
		BufferedWriter writer = null;
		try
		{
		    writer = new BufferedWriter( new FileWriter(Path));
		    writer.write(fileContent.toString());

		}
		catch ( IOException e)
		{
		}
		finally
		{
		    try
		    {
		        if ( writer != null)
		        writer.close( );
		    }
		    catch ( IOException e)
		    {
		    }
		}
	}
	public void updateText() throws FileNotFoundException 
	{
		
		String[] separated = getTextOfFile(Path).split("//rows_determiner");
		String textOfFile = separated[1].trim();
		methodRows = textOfFile.split(";");
		System.out.println(textOfFile);
		System.out.println(methodRows[0]);
		System.out.println(methodRows[1]);
		System.out.println(methodRows[2]);
		System.out.println(methodRows[3]);
	}
}
