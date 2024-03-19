package com.test;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReverseAsciiFileContents {
	
	  public static void main(String[] args) throws Exception {
	        String inputFile = "resources/input.txt";
	        String outputFile = "resources/reversed_output.txt";

	        try {
	        	ReverseAsciiFileContents asciiContents = new ReverseAsciiFileContents();
	        	List<String> lines = asciiContents.readFile(inputFile);
	        	List<String> reverseLines = asciiContents.reverseContent(lines);
	        	asciiContents.writeFile(outputFile, reverseLines);	            
	        } 
	        catch (IOException e) {
	        	e.printStackTrace();	        
	        }
	       
	    }
	  
	  public List<String> readFile(String inputFile) throws IOException {
		  Path inputPath = Paths.get(inputFile);
          List<String> lines = Files.readAllLines(inputPath, StandardCharsets.UTF_8);
          return lines;
	  }

	public List<String> reverseContent(List<String> contentList) throws Exception {
		List<String> reverseContentList = new ArrayList<String>();
		for(String content : contentList) {
			if(!Charset.forName("US-ASCII").newEncoder().canEncode(content)) {
			  throw new Exception("content is non ASCII");	
			}
			reverseContentList.add(new StringBuilder(content).reverse().toString());
		}
		
		return reverseContentList;
	}
	
	  public void writeFile(String outputFile, List<String> reverseList) throws IOException {
          Path outputPath = Paths.get(outputFile);
          Files.write(outputPath, reverseList, StandardCharsets.UTF_8);
	  }
	
}
