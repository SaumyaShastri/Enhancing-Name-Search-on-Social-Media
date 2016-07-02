import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;


public class CovertingtoEN {

	public static final int Threshold = 3;
	 public static int computeDistance(String s1, String s2) {
		    s1 = s1.toLowerCase();
		    s2 = s2.toLowerCase();
		 
		    int[] costs = new int[s2.length() + 1];
		    for (int i = 0; i <= s1.length(); i++) {
		      int lastValue = i;
		      for (int j = 0; j <= s2.length(); j++) {
		        if (i == 0)
		          costs[j] = j;
		        else {
		          if (j > 0) {
		            int newValue = costs[j - 1];
		            if (s1.charAt(i - 1) != s2.charAt(j - 1))
		              newValue = Math.min(Math.min(newValue, lastValue), costs[j]) + 1;
		            costs[j - 1] = lastValue;
		            lastValue = newValue;
		          }
		        }
		      }
		      if (i > 0)
		        costs[s2.length()] = lastValue;
		    }
		    return costs[s2.length()];
		  }
		 
		  public static void printDistance(String s1, String s2) {
		    System.out.println("Levenshtein distance between " +s1 + " and " + s2 + " is " + computeDistance(s1, s2));
		  }

	public static  void main( String [] args)  throws Exception{	
	HashMap<String,String> hm  = new HashMap<String,String>();
	 final String अ = "अ";
	 final String आ = "आ";
	 final String इ = "इ";
	 final String ई = "ई";
	 final String ए = "ए";
	 final String ऐ = "ऐ";
	 final String ओ = "ओ";
	 final String औ = "औ";
	 final String उ = "उ";
	 final String ऊ = "ऊ";
	 final String ऋ = "ऋ";
	 final String क = "क";
	 final String ख = "ख";
	 final String घ = "घ";
	 final String ग = "ग";
	 final String ङ = "ङ";
	 final String च = "च";
	 final String छ = "छ";
	 final String ज = "ज";
	 final String झ = "झ";
	 final String ञ = "ञ";
	 final String ट = "ट";
	 final String ठ = "ठ";
	 final String ड = "ड";
	 final String ढ = "ढ";
	 final String ण = "ण";
	 final String त = "त";
	 final String थ = "थ";
	 final String द = "द";
	 final String ध = "ध";
	 final String न = "न";
	 final String प = "प";
	 final String फ = "फ";
	 final String ब = "ब";
	 final String भ = "भ";
	 final String म = "म";
	 final String य = "य";
	 final String र = "र";
	 final String ल = "ल";
	 final String व = "व";
	 final String श = "श";
	 final String ष = "ष";
	 final String स = "स";
	 final String ह = "ह";
	 final String क्ष = "क्ष";
	 final String ज्ञ = "ज्ञ";
	 final String त्र = "त्र";
	 HashMap<String,String> hm2  = new HashMap<String,String>();
		
	  hm2.put("947", "e");
	  hm2.put("948","ai");
	  hm2.put("93e","a");
	  hm2.put( "93f","i");
	  hm2.put( "940","ee");
	  hm2.put( "941", "u");
	  hm2.put( "942", "oo");
	  hm2.put( "94b","o");
	  hm2.put("94c", "au");
	  hm2.put("902", "n");
	  		hm.put(अ, "a");
	  		hm.put(आ, "aa");
	  		hm.put(इ, "i");
	  		hm.put(ई, "ee");
	  		hm.put(ए, "e");
	  		hm.put(ऐ, "ai");
	  		hm.put(ओ, "e");
	  		hm.put(औ, "au");
	  		hm.put(उ, "o");
	  		hm.put(ऊ, "oo");
			hm.put(ऋ, "ri");
			hm.put(क, "k");
			hm.put(ख, "kh");
			hm.put(ग, "g");
			hm.put(घ, "gh");
			hm.put(ङ, "xn");
			hm.put(च, "ch");
			hm.put(छ, "chh");
			hm.put(ज, "j");
			hm.put(झ, "z");
			hm.put(ञ, "yn");
			hm.put(ट, "t");
			hm.put(ठ, "tdh");
			hm.put(ड, "d");
			hm.put(ढ, "dhv");
			hm.put(ण, "tn");
			hm.put(त, "t");
			hm.put(थ, "th");
			hm.put(द, "d");
			hm.put(ध, "dh");
			hm.put( न, "n");
			hm.put(प, "p");
			hm.put(फ, "f");
			hm.put(ब, "b");
			hm.put(भ, "bh");
			hm.put(म, "m");
			hm.put(य, "y");
			hm.put(र, "r");
			hm.put(ल, "l");
			hm.put(व, "v");
			hm.put(श, "sh");
			hm.put(ष, "ssh");
			hm.put(स, "s");
			hm.put(ह, "h");
			hm.put(क्ष, "ksh");
			hm.put(ज्ञ, "gy");
			hm.put(त्र, "tr");
			hm.put(" ", " ");
try{
	BufferedReader sr = new BufferedReader(new InputStreamReader(new FileInputStream(new File("Names.txt"))));
	String line = "";
	while ((line = sr.readLine()) != null)
   {
	//Scanner scan = new Scanner(System.in);
	//System.out.println( "Input");
	String[]arr = line.split(",");
	String input = arr[0];
	String english = arr[1];
    int strLen = input.length();
    char consonants[] = new char[strLen];
     String strArray1[] = new String[strLen];
     
     File file1 = new File("EN_trasliteration.txt");
     Writer output1 = null;
     try {
    	 output1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1,true), "UTF8"));
     } 
     catch (UnsupportedEncodingException e) {
     e.printStackTrace();}
     catch (FileNotFoundException e) {
     e.printStackTrace();}
     try {
        ((BufferedWriter) output1).newLine();
        String output="";
          for (int i=0 ; i< strLen ; i++)
       {
    	if(Character.isWhitespace(input.charAt(i))){
    		 output += " ";
    	}
         consonants[i] = input.charAt(i);
         strArray1[i] = Character.toString(input.charAt(i));
         String hin = String.valueOf(consonants[i]) ;
		 //System.out.println(consonants[i]);
		  String value = hm.get(hin);
         if(value !=null)
         	{  output+=value;
         		}
         else
         	{ 	
        	 	int code = (int)(consonants[i]) ;
         		//System.out.println(code);
         		String str = Integer.toHexString(code) ;
         			//System.out.println(str);
         			String value2 = hm2.get(str);
         			if(value2 !=null)
         			{  
         				output+=value2;
         			}
         	}
	 }//for
     int dist = computeDistance(output,english);
     output1.write(String.format("%s\t%s\t%s\t%s\t%n" ,input,english,output,dist));;   
     output1.close();} 
     catch (IOException e) {e.printStackTrace(); } 
} sr.close();   
	}catch (Exception e) {
	      e.printStackTrace();}
}}