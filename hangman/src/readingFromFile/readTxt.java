package readingFromFile;

import java.io.*;
import java.util.*;
import java.nio.*;


public class readTxt implements Runnable{	
	
	static List<String> ar = new ArrayList<String>();
	static List<String> ar2 = new ArrayList<String>();
	static List<String> ar3 = new ArrayList<String>(); 
	static List<String> ar4 = new ArrayList<String>();
    public static boolean parallel = false;


public static void main(String[] args) throws IOException {
	if (parallel == true){		
	  method1.run();
	  method2.run();
	  method3.run();
	  method4.run();
	  method5.run();
	}else{
		readFile1();
		readFile2();
		readFile3();
		readFile4();
		serialiseArray();
	}
	  
}
	


	
	
	
	public static List<String> readFile1 (){
    List<String> words = new ArrayList<String>();
    File file1 = new File("/s_home/jc615/Year2/co2001/mini - project/Files/file1.txt");
    //2. Read a file line by line and add file words to words array.
    try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null) {
            words.add(sCurrentLine);
            //System.out.println(words);
        }

        

    } catch (IOException e) {
        e.printStackTrace();
    }
    
    for (int j = 0; j < 50; j++){
    Random rand = new Random();
    int randomNumber = rand.nextInt(words.size() - 1) + 1;
    
  
    String word = words.get(randomNumber);
   // System.out.println(word);
    
    ar.add(word);
    
    }
    System.out.println(ar);
    return ar;
	}
	
	
    public static List<String> readFile2(){
    List<String> words1 = new ArrayList<String>();
    File file2 = new File("/s_home/jc615/Year2/co2001/mini - project/Files/file2.txt");
    //2. Read a file line by line and add file words to words array.
    try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null) {
            words1.add(sCurrentLine);
            //System.out.println(words);
        }

        

    } catch (IOException e) {
        e.printStackTrace();
    }
   
    for (int j = 0; j < 50; j++){
    Random rand = new Random();
    int randomNumber = rand.nextInt(words1.size() - 1) + 1;
    
  
    String word = words1.get(randomNumber);
   // System.out.println(word);
    
    ar2.add(word);
    
    }
    System.out.println(ar2);
    return ar2;
    }
    
    
    public static List<String> readFile3(){
    List<String> words2 = new ArrayList<String>();
    File file3 = new File("/s_home/jc615/Year2/co2001/mini - project/Files/file3.txt");
    //2. Read a file line by line and add file words to words array.
    try (BufferedReader br = new BufferedReader(new FileReader(file3))) {
        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null) {
            words2.add(sCurrentLine);
            //System.out.println(words);
        }

        

    } catch (IOException e) {
        e.printStackTrace();
    }
    
    for (int j = 0; j < 50; j++){
    Random rand = new Random();
    int randomNumber = rand.nextInt(words2.size() - 1) + 1;
    
  
    String word = words2.get(randomNumber);
   // System.out.println(word);
    
    ar3.add(word);
    
    }
    System.out.println(ar3);
    return ar3;
    }
    
    public static List<String> readFile4(){
    List<String> words3 = new ArrayList<String>();
    File file4 = new File("/s_home/jc615/Year2/co2001/mini - project/Files/file4.txt");
    //2. Read a file line by line and add file words to words array.
    try (BufferedReader br = new BufferedReader(new FileReader(file4))) {
        String sCurrentLine;
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

static Runnable method1 = new Runnable(){
	public void run(){
		readFile1();
	}
};
static Runnable method2 = new Runnable(){
	public void run(){
		readFile2();
	}
};
static Runnable method3 = new Runnable(){
	public void run(){
		readFile3();
	}
};
static Runnable method4 = new Runnable(){
	public void run(){
		readFile4();
	}
};
static Runnable method5 = new Runnable(){
	public void run(){
		try {
			serialiseArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
};
}