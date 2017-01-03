package readingFromFile;

import java.io.*;
import java.util.*;

//import readingFromFile.hangman.Letter;

import java.nio.*;


public class readTxt implements Runnable{	
	
	private static List<String> ar = new ArrayList<String>();
	private String words;
 
    private static boolean parallel;
    

    public readTxt(){
	/*try (InputStream in = getClass().getResourceAsStream("/s_home/jc615/Year2/co2001/mini - project/Files/file1.txt");
			BufferedReader bf = new BufferedReader(new InputStreamReader(in))){
		
		String line = "";
		while ((line = bf.readLine()) != null)
			ar.add(line);
	}*/
	File file1 = new File("/s_home/jc615/Year2/co2001/mini - project/Files/file1.txt");
	
    try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
        String sCurrentLine ="";
        while ((sCurrentLine = br.readLine()) != null) {

            ar.add(sCurrentLine);
        }
    }
	catch (Exception e) {
		System.out.println("Couldnt find file: " + file1);
		System.out.println("Error message: " + e.getMessage());
	}
	
}
 public String getRandomWord(){
	
	 if (ar.isEmpty()) return "No Data";
	 for (int j = 0; j < 50; j++){
	 words = ar.get((int)(Math.random()*ar.size()));
	 }
	 //System.out.println(words);
	 System.out.println(words);
	 return words;
	
	 
 }
 public String parralel(){
	 Thread thread = new Thread(getRandomWord());
	 thread.start();
	 return words;
 }

 public static void serialiseArray() throws IOException{
 	try(FileOutputStream c = new FileOutputStream("OutputArray.bin"); 
 			ObjectOutputStream p = new ObjectOutputStream(c)){
 				p.writeObject(ar);
 			}
 }
 

@Override
public void run() {
	// TODO Auto-generated method stub
	
}
    
/*public static List<String> readFile1 (){
    List<String> words = new ArrayList<String>();
    File file1 = new File("/s_home/jc615/Year2/co2001/mini - project/Files/file1.txt");
    try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
        String sCurrentLine ="";
        while ((sCurrentLine = br.readLine()) != null) {
            words.add(sCurrentLine);
   
        }

        

    } catch (IOException e) {
        e.printStackTrace();
    }
    
    for (int j = 0; j < 50; j++){
    Random rand = new Random();
    int randomNumber = rand.nextInt(words.size() - 1) + 1;
    
  
    String word = words.get(randomNumber);
 
    
    ar.add(word);
    
    }
    System.out.println(ar);
    return ar;
	}
	/*
	
    public static List<String> readFile2(){
    List<String> words1 = new ArrayList<String>();
    File file2 = new File("/s_home/jc615/Year2/co2001/mini - project/Files/file2.txt");
   
    try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
        String sCurrentLine = "";
        while ((sCurrentLine = br.readLine()) != null) {
            words1.add(sCurrentLine);
            
        }

        

    } catch (IOException e) {
        e.printStackTrace();
    }
   
    for (int j = 0; j < 50; j++){
    Random rand = new Random();
    int randomNumber = rand.nextInt(words1.size() - 1) + 1;
    
  
    String word = words1.get(randomNumber);

    
    ar2.add(word);
    
    }
    System.out.println(ar2);
    return ar2;
    }
    
    
    public static List<String> readFile3(){
    List<String> words2 = new ArrayList<String>();
    File file3 = new File("/s_home/jc615/Year2/co2001/mini - project/Files/file3.txt");

    try (BufferedReader br = new BufferedReader(new FileReader(file3))) {
        String sCurrentLine = "";
        while ((sCurrentLine = br.readLine()) != null) {
            words2.add(sCurrentLine);
          
        }

        

    } catch (IOException e) {
        e.printStackTrace();
    }
    
    for (int j = 0; j < 50; j++){
    Random rand = new Random();
    int randomNumber = rand.nextInt(words2.size() - 1) + 1;
    
  
    String word = words2.get(randomNumber);
 
    
    ar3.add(word);
    
    }
    System.out.println(ar3);
    return ar3;
    }
    
    public static List<String> readFile4(){
    List<String> words3 = new ArrayList<String>();
    File file4 = new File("/s_home/jc615/Year2/co2001/mini - project/Files/file4.txt");
   
    try (BufferedReader br = new BufferedReader(new FileReader(file4))) {
        String sCurrentLine = "";
        while ((sCurrentLine = br.readLine()) != null) {
            words3.add(sCurrentLine);
            //System.out.println(words);
        }

        

    } catch (IOException e) {
        e.printStackTrace();
    }
    
    for (int j = 0; j < 50; j++){
    Random rand = new Random();
    int randomNumber = rand.nextInt(words3.size() - 1) + 1;
    
  
    String word = words3.get(randomNumber);
   // System.out.println(word);
    
    ar4.add(word);
    
    }
    System.out.println(ar4);
    
    return ar4;
    
    }
    public static void serialiseArray() throws IOException{
    	File Output = new File("OutputArray.bin");
    	try(FileOutputStream c = new FileOutputStream(Output); 
    			ObjectOutputStream p = new ObjectOutputStream(c)){
    				p.writeObject(ar);
    				p.writeObject(ar2);
    				p.writeObject(ar3);
    				p.writeObject(ar4);
    			}
    }
    
    public String getRandomWord(){ 
    	if (ar.isEmpty()) return "No Data";
    	return ar.get((int)(Math.random()*ar.size()));
    	
    }
    
    
    
    
    
    
    
    
    

@Override
public void run() {
	readFile1();
	readFile2();
	readFile3();
	readFile4();
	try {
		serialiseArray();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public static void setBoolean(boolean p){
	parallel = p;
}
public boolean getBoolean(){
	return parallel;
}

public static void paraOrSequential(){
	if(readTxt.parallel = true){
		(new Thread(new readTxt())).start(); 
	}
	if(readTxt.parallel = false){
		readFile1();
		readFile2();
		readFile3();
		readFile4();
		try {
			serialiseArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


*/

}