package readingFromFile;

import java.io.*;
import java.util.*;



public class readTxt {	
	
	static List<String> ar = new ArrayList<String>();
	static List<String> ar2 = new ArrayList<String>();
	static List<String> ar3 = new ArrayList<String>(); 
	static List<String> ar4 = new ArrayList<String>();



public static void main(String[] args) {
	
	
	readFile1();
	readFile2();
	readFile3();
	readFile4();
}
	
	
	public static void readFile1 (){
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
	}
	
	
    public static void readFile2(){
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
    }
    
    
    public static void readFile3(){
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
    }
    
    public static void readFile4(){
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
    }
    
}

