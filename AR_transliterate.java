import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;


public class AR_transliterate extends Arabic_Mapping {

	public  String[] charAlign(String a, String b) {
		int[][] T = new int[a.length() + 1][b.length() + 1];

		for (int i = 0; i <= a.length(); i++) {
			T[i][0] = i;
		}

		for (int i = 0; i <= b.length(); i++) {
			T[0][i] = i;
		}

		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				if (a.charAt(i - 1) == b.charAt(j - 1)) {
					T[i][j] = T[i - 1][j - 1];
				} else {
					T[i][j] = Math.min(T[i - 1][j], T[i][j - 1]) + 1;
				}
			}
		}

		StringBuilder aa = new StringBuilder(), bb = new StringBuilder();

		for (int i = a.length(), j = b.length(); i > 0 || j > 0;) {
			if (i > 0 && T[i][j] == T[i - 1][j] + 1) {
				aa.append(a.charAt(--i));
				bb.append("-");
			} else if (j > 0 && T[i][j] == T[i][j - 1] + 1) {
				bb.append(b.charAt(--j));
				aa.append("-");
			} else if (i > 0 && j > 0 && T[i][j] == T[i - 1][j - 1]) {
				aa.append(a.charAt(--i));
				bb.append(b.charAt(--j));
			}
		}

		return new String[]{aa.reverse().toString(), bb.reverse().toString()};
	}	

	public static void main(String[] args) throws IOException {
		BufferedReader sr = new BufferedReader(new InputStreamReader(new FileInputStream(new File("SortedAR_names.txt"))));
		String arabic=null;
		String eng= null;
		String trnslit = null;
		String dist = null;
		String Thrhld = null;
		Writer output1 = null;
		String line = "";
		int numLines = 0;
		String msg;
		int errorsNAMEPAIR = 0;
		int singleName = 0;
		while ((line = sr.readLine()) != null)
		{
			numLines++;

			if (numLines%100==0)
			{
				msg = String.format("Processing line: %d, errors:%d single names:%d", numLines, errorsNAMEPAIR, singleName);
				System.out.println(msg);
			}

			File file1 = new File("Parsed_AR.txt");
			String [] values = line.split("\\t");

			if(values.length<2)
			{	
				errorsNAMEPAIR++;
				continue;

			}
			String input = values[0];
			String english = values[1];
			String trimmed = input.trim();
			int count = 0;
			for(int k = 0; k < trimmed.length(); k++) {
				if(Character.isWhitespace(trimmed.charAt(k)))
				{ count++;}
			}
			if(count==1)
			{
				singleName++;
				
			AR_transliterate obj = new AR_transliterate();
			String [] output = obj.Score(input, english);
			arabic=output[0];
			eng= output[1];
			trnslit = output[2];
			dist = output[3];
			Thrhld = output[4];

			String[] sequence = obj.charAlign(eng,trnslit);
			String normalEN = sequence[0];
			String normalTL = sequence[1];
			String[] ar = arabic.split("\\s+");

			String [] space = new String [100];
			space = normalTL.split("\\s+");
			int one = space[0].length();
			int two = normalEN.length();
			//int next = one +1;
			String first = normalEN.substring(0,one);
			String second = normalEN.substring(one,two);
			first = first.replace("-","" );
			second = second.replace("-", "");

			output1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1,true), "UTF8"));
			String formatStr = "%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%n";
			output1.write(String.format(formatStr,arabic,eng, trnslit,dist,Thrhld,normalEN,normalTL,ar[0],first,ar[1],second));

			output1.close();}
			
			else if( count == 0)
			{
			AR_transliterate obj = new AR_transliterate();
			String [] output = obj.Score(input, english);
			arabic=output[0];
			eng= output[1];
			trnslit = output[2];
			dist = output[3];
			Thrhld = output[4];

			String[] sequence = obj.charAlign(eng,trnslit);
			String normalEN = sequence[0];
			String normalTL = sequence[1];
			String[] ar = arabic.split("\\s+");

			String [] space = new String [100];
			space = normalTL.split("\\s+");
			int one = space[0].length();
			//int two = normalEN.length();
			//int next = one +1;
			String first = normalEN.substring(0,one);
			//String second = normalEN.substring(one,two);
			first = first.replace("-","" );
			//second = second.replace("-", "");

			output1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1,true), "UTF8"));
			String formatStr = "%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%n";
			output1.write(String.format(formatStr,arabic,eng, trnslit,dist,Thrhld,normalEN,normalTL,ar[0],first));

			output1.close();}
		}
		sr.close();

	}

}
