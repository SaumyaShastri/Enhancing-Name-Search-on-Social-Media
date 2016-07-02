import java.util.HashMap;
import java.util.Scanner;


public class Testing {
	
	 public String[] charAlign(String a, String b) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,String> hm  = new HashMap<String,String>();
		 final String ALEF_WITH_MADDA = "آ";
		 final String ALEF_WITH_HAMZA = "أ";
		 final String WAW_WITH_HAMZA = "ؤ";
		 final String YEH_WITH_HAMZA = "ئ";
		 final String ALEF = "ا";
		 final String BEH = "ب";
		 final String TEH_MARBUTA = "ة";
		 final String TEH = "ت"; 
		 final String THEH = "ث";
		 final String JEEM = "ج";
		 final String HAH = "ح";
		 final String KHAH = "خ";
		 final String DAL = "د";
		 final String THAL = "ذ";
		 final String REH = "ر";
		 final String ZAIN = "ز";
		 final String SEEN = "س";
		 final String SHEEN = "ش"; 
		 final String SAD = "ص";
		 final String DAD = "ض";
		 final String TAH = "ط";
		 final String ZAH = "ظ";
		 final String AIN = "ع";
		 final String GHAIN = "غ";
		 final String FEH = "ف";		
		  final String QAF = "ق";
		 final String KAF = "ك";
		 final String LAM = "ل";
		 final String MEEM = "م";
		 final String NOON = "ن";
		 final String HEH = "ه";
		 final String WAW = "و";
		 final String ALEF_MAKSURA = "ى";
		 final String YEH= "ي"; 
		

			hm.put(ALEF_WITH_MADDA, "a");
	  		hm.put(ALEF_WITH_HAMZA, "aa");
	  		hm.put(WAW_WITH_HAMZA, "i");
	  		hm.put(YEH_WITH_HAMZA, "ee");
	  		hm.put(ALEF, "a");
	  		hm.put(BEH, "b");
	  		hm.put(TEH_MARBUTA, "a");
	  		hm.put(TEH, "t");
	  		hm.put(THEH, "th");
	  		hm.put(JEEM, "j");
			hm.put(HAH, "h");
			hm.put(KHAH, "kh");
			hm.put(DAL, "d");
			//hm.put(THAL, "dh");
			hm.put(THAL, "z");
			hm.put(REH, "r");
			hm.put(ZAIN, "z");
			hm.put(SEEN, "s");
			hm.put(SHEEN, "sh");
			hm.put(SAD, "s");
			//hm.put(DAD, "dhz");
			hm.put(DAD, "d");
			hm.put(TAH, "t");
			//hm.put(ZAH, "zdh");
			hm.put(ZAH, "zdh");
			hm.put(AIN, "a");
			hm.put(GHAIN, "gh");
			hm.put(FEH, "f");
			hm.put(QAF, "Q");
			hm.put(KAF, "k");
			hm.put(LAM, "l");
			hm.put(MEEM, "m");
			hm.put(NOON, "n");
			hm.put(HEH, "h");
			hm.put(WAW, "w");
			hm.put(ALEF_MAKSURA, "a");
			hm.put(YEH, "y");
				
				Scanner scan = new Scanner(System.in);
				System.out.println( "Input in Arabic");
				String input = scan.nextLine();
				System.out.println( "Input in English");
				String english = scan.nextLine();
				english = english.toLowerCase();
				
				//System.out.println(input);
			    int strLen = input.length();
			    char consonants[] = new char[strLen];
			     String strArray1[] = new String[strLen];
			     String output= "";
			     for (int i=0 ; i< strLen ; i++)
			     { 
			    	 if(Character.isWhitespace(input.charAt(i)))
			    	 	{ System.out.print(" ");
			    	 	output += " ";}
			    	 consonants[i] = input.charAt(i);
			    	 strArray1[i] = Character.toString(input.charAt(i));
			    	 String ar = String.valueOf(consonants[i]) ;
			    	 //System.out.println(consonants[i]);
			    	 String value = hm.get(ar);
			    	 if(value !=null)
			    	 	{ output += value;}
			    	/* else
		         		{ 	
		        	 	int code = (int)(consonants[i]) ;
		         		//System.out.println(code);
		         		String str = Integer.toHexString(code) ;
		         		//System.out.println(str);
		         		String value2 = hm2.get(str);
		         		if(value2 !=null)
		         			{  output += value2;}
		         		}*/
			     }
		System.out.println(output);	
		Testing obj = new Testing();
		String [] output2 = obj.charAlign(output, english);
		for(int i =0; i<output2.length; i++)
		{System.out.println(output2[i]);}
		String [] arabic = input.split("\\s+");
		String [] translit = output.split("\\s+");
		for(int j=0; j< arabic.length; j++)
		{
			System.out.println(arabic[j] +" " + translit[j]);
		}
	}

}
