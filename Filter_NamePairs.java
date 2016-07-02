import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;


public class Filter_NamePairs {

	public static void main(String[] args) throws IOException {
		BufferedReader sr = new BufferedReader(new InputStreamReader(new FileInputStream(new File("stream3.txt"))));
		Writer output1 = null;
		String line = "";
		int flag = 0;
		while ((line = sr.readLine()) != null)
		{ File file1 = new File("ValidNamePairs.txt");
		  String[]  input  = new String [2];
		  input = line.split("\\t");
		  String hindi = input[0];
		  String english = input[1];
		  int strLen = hindi.length();
		    char consonants[] = new char[strLen];
		     String strArray1[] = new String[strLen];
		     for (int i=0 ; i< strLen ; i++)
		     { 
		    	 consonants[i] = hindi.charAt(i);
		    	 strArray1[i] = Character.toString(hindi.charAt(i));
		    	 //String hin = String.valueOf(consonants[i]) ;
		    	 int code = (int)(consonants[i]) ;
	         	 //String str = Integer.toHexString(code) ;
                 if (code>2304 && code<2431)
                 {flag=1; }
		     }
		if (flag==0)
		{ output1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1,true), "UTF8"));
		 output1.write(line);
		 ((BufferedWriter) output1).newLine();
		 output1.close(); } 
		}

	sr.close();}

}
