package readingFromFile;

import java.io.*;
import java.util.*;

//import readingFromFile.hangman.Letter;

import java.nio.*;


public class readTxt3 implements Runnable{	
	
	private static List<String> ar3 = new ArrayList<String>(); 
  
    private static boolean parallel;
   

    public readTxt3(){
	/*try (InputStream in = getClass().getResourceAsStream("/s_home/jc615/Year2/co2001/mini - project/Files/file1.txt");
			BufferedReader bf = new BufferedReader(new InputStreamReader(in))){
		
		String line = "";
		while ((line = bf.readLine()) != null)
			ar.add(line);
	}*/
	File file3 = new File("/s_home/jc615/Year2/co2001/mini - project/Files/file3.txt");
	for (int j = 0; j < 50; j++){
    try (BufferedReader br = new BufferedReader(new FileReader(file3))) {
        String sCurrentLine ="";
        while ((sCurrentLine = br.readLine()) != null) {
            ar3.add(sCurrentLine); 
           
        }
    }
	catch (Exception e) {
		System.out.println("Couldnt find file: " + file3);
		System.out.println("Error message: " + e.getMessage());
	}
	}
}
 public String getRandomWord(){
	 if (ar3.isEmpty()) return "No Data";
	 return ar3.get((int)(Math.random()*ar3.size()));
	 
 }

 public static void serialiseArray() throws IOException{
	 	try(FileOutputStream c = new FileOutputStream("OutputArray.bin"); 
	 			ObjectOutputStream p = new ObjectOutputStream(c)){
	 				p.writeObject(ar3);
	 			}
	 }

@Override
public void run() {
	// TODO Auto-generated method stub
	
}
}