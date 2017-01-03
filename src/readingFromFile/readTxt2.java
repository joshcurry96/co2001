package readingFromFile;

import java.io.*;
import java.util.*;

//import readingFromFile.hangman.Letter;

import java.nio.*;


public class readTxt2 implements Runnable{	
	

	private static List<String> ar2 = new ArrayList<String>();
 
    private static boolean parallel;


    public readTxt2(){
	/*try (InputStream in = getClass().getResourceAsStream("/s_home/jc615/Year2/co2001/mini - project/Files/file1.txt");
			BufferedReader bf = new BufferedReader(new InputStreamReader(in))){
		
		String line = "";
		while ((line = bf.readLine()) != null)
			ar.add(line);
	}*/
	File file2 = new File("/s_home/jc615/Year2/co2001/mini - project/Files/file2.txt");
	for (int j = 0; j < 50; j++){
    try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
        String sCurrentLine ="";
        while ((sCurrentLine = br.readLine()) != null) {
            ar2.add(sCurrentLine); 
           
        }
    }
	catch (Exception e) {
		System.out.println("Couldnt find file: " + file2);
		System.out.println("Error message: " + e.getMessage());
	}
	}
}
 public String getRandomWord(){
	 if (ar2.isEmpty()) return "No Data";
	 return ar2.get((int)(Math.random()*ar2.size()));
	 
 }

 public static void serialiseArray() throws IOException{
	 	try(FileOutputStream c = new FileOutputStream("OutputArray.bin"); 
	 			ObjectOutputStream p = new ObjectOutputStream(c)){
	 				p.writeObject(ar2);
	 			}
	 }

@Override
public void run() {
	// TODO Auto-generated method stub
	
}
}
