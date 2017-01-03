package readingFromFile;

import java.io.*;
import java.util.*;

//import readingFromFile.hangman.Letter;

import java.nio.*;


public class readTxt4 implements Runnable{	
	
	private static List<String> ar4 = new ArrayList<String>();   
    private static boolean parallel;
   

    public readTxt4(){
	/*try (InputStream in = getClass().getResourceAsStream("/s_home/jc615/Year2/co2001/mini - project/Files/file1.txt");
			BufferedReader bf = new BufferedReader(new InputStreamReader(in))){
		
		String line = "";
		while ((line = bf.readLine()) != null)
			ar.add(line);
	}*/
	File file4 = new File("/s_home/jc615/Year2/co2001/mini - project/Files/file4.txt");
	for (int j = 0; j < 50; j++){
    try (BufferedReader br = new BufferedReader(new FileReader(file4))) {
        String sCurrentLine ="";
        while ((sCurrentLine = br.readLine()) != null) {
            ar4.add(sCurrentLine); 
           
        }
    }
	catch (Exception e) {
		System.out.println("Couldnt find file: " + file4);
		System.out.println("Error message: " + e.getMessage());
	}
	}
}
 public String getRandomWord(){
	 if (ar4.isEmpty()) return "No Data";
	 return ar4.get((int)(Math.random()*ar4.size()));
	 
 }

 public static void serialiseArray() throws IOException{
	 	try(FileOutputStream c = new FileOutputStream("OutputArray.bin"); 
	 			ObjectOutputStream p = new ObjectOutputStream(c)){
	 				p.writeObject(ar4);
	 			}
	 }

@Override
public void run() {
	// TODO Auto-generated method stub
	
}
}