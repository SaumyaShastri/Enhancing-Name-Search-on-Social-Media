import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;


public class Test_Cases extends SimilarityScore {

	public static void main(String[] args) throws IOException {
		BufferedReader sr = new BufferedReader(new InputStreamReader(new FileInputStream(new File("Names.txt"))));
		  String hindi=null;
		  String eng= null;
		  String trnslit = null;
		  String dist = null;
		  String Thrhld = null;
        Writer output1 = null;
		String line = "";
		while ((line = sr.readLine()) != null)
	   {
		File file1 = new File("NamePairs.txt");
		String [] values = line.split("\\t");
		String input = values[0];
		String english = values[1];
		Test_Cases obj = new Test_Cases();
		String [] output = obj.Score(input, english);
		int i =0;
		for (i=0; i<5; i++)
		{ hindi = output[0];
		  eng = output[1];
		  trnslit = output[2];
		  dist = output[3];
		  Thrhld = output[4];}
		 output1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1,true), "UTF8"));
         String formatStr = "%s\t%s\t%s\t%s\t%s\t%n";
		 output1.write(String.format(formatStr,hindi,eng, trnslit,dist,Thrhld));
		 ((BufferedWriter) output1).newLine();
		 output1.close();
        }
		sr.close();
		
}}