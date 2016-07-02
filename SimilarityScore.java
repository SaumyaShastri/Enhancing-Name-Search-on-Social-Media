//import java.text.DecimalFormat;
import java.util.HashMap;

public class SimilarityScore {
    
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
		    //System.out.println("Levenshtein distance between " +s1 + " and " + s2 + " is " + computeDistance(s1, s2));
		  }

	public String[] Score(String input, String english) {
		HashMap<String,String> hm  = new HashMap<String,String>();
		 final String A = "अ";
		 final String AA = "आ";
		 final String I = "इ";
		 final String II = "ई";
		 final String E = "ए";
		 final String AI = "ऐ";
		 final String O = "ओ";
		 final String AU = "औ";
		 final String U = "उ";
		 final String UU = "ऊ";
		 final String R = "ऋ";
		 final String KA = "क";
		 final String KHA = "ख";
		 final String GHA = "घ";
		 final String GA = "ग";
		 final String NGA = "ङ";
		 final String CA = "च";
		 final String CHA = "छ";
		 final String JA = "ज";
		 final String JHA = "झ";
		 final String NYA = "ञ";
		 final String TTA = "ट";
		 final String TTHA = "ठ";
		 final String DDA = "ड";
		 final String DDHA = "ढ";
		 final String NNA = "ण";
		 final String TA = "त";
		 final String THA = "थ";
		 final String DA = "द";
		 final String DHA = "ध";
		 final String NA = "न";
		 final String PA = "प";
		 final String PHA = "फ";
		 final String BA = "ब";
		 final String BHA = "भ";
		 final String MA = "म";
		 final String YA = "य";
		 final String RA = "र";
		 final String LA = "ल"; 
		 final String VA = "व";
		 final String SHA = "श";
		 final String SSA = "ष";
		 final String SA = "स";
		 final String HA = "ह";
		 final String KSHA = "क्ष";
		 final String GYA = "ज्ञ";
		 final String TRA = "त्र";
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
		  		hm.put(A, "a");
		  		hm.put(AA, "aa");
		  		hm.put(I, "i");
		  		hm.put(II, "ee");
		  		hm.put(E, "e");
		  		hm.put(AI, "ai");
		  		hm.put(O, "e");
		  		hm.put(AU, "au");
		  		hm.put(U, "o");
		  		hm.put(UU, "oo");
				hm.put(R, "ri");
				hm.put(KA, "k");
				hm.put(KHA, "kh");
				hm.put(GA, "g");
				hm.put(GHA, "gh");
				hm.put(NGA, "xn");
				hm.put(CA, "ch");
				hm.put(CHA, "chh");
				hm.put(JA, "j");
				hm.put(JHA, "jha");
				hm.put(NYA, "yn");
				hm.put(TTA, "t");
				hm.put(TTHA, "tdh");
				hm.put(DDA, "d");
				hm.put(DDHA, "dhv");
				hm.put(NNA, "tn");
				hm.put(TA, "t");
				hm.put(THA, "th");
				hm.put(DA, "d");
				hm.put(DHA, "dh");
				hm.put( NA, "n");
				hm.put(PA, "p");
				hm.put(PHA, "f");
				hm.put(BA, "b");
				hm.put(BHA, "bh");
				hm.put(MA, "m");
				hm.put(YA, "y");
				hm.put(RA, "r");
				hm.put(LA, "l");
				hm.put(VA, "v");
				hm.put(SHA, "sh");
				hm.put(SSA, "ssh");
				hm.put(SA, "s");
				hm.put(HA, "h");
				hm.put(KSHA, "ksh");
				hm.put(GYA, "gy");
				hm.put(TRA, "tr");
				hm.put(" ", " ");
				
				//Scanner scan = new Scanner(System.in);
				//System.out.println( "Input in Hindi");
				//String input = scan.nextLine();
				//System.out.println( "Input in English");
				//String english = scan.nextLine();
				//english = english.toLowerCase();
				
				//System.out.println(input);
			    int strLen = input.length();
			    char consonants[] = new char[strLen];
			     String strArray1[] = new String[strLen];
			     String output= "";
			     for (int i=0 ; i< strLen ; i++)
			     { 
			    	 if(Character.isWhitespace(input.charAt(i)))
			    	 	{ System.out.print(" ");}
			    	 consonants[i] = input.charAt(i);
			    	 strArray1[i] = Character.toString(input.charAt(i));
			    	 String hin = String.valueOf(consonants[i]) ;
			    	 //System.out.println(consonants[i]);
			    	 String value = hm.get(hin);
			    	 if(value !=null)
			    	 	{ output += value;}
			    	 else
		         		{ 	
		        	 	int code = (int)(consonants[i]) ;
		         		//System.out.println(code);
		         		String str = Integer.toHexString(code) ;
		         		//System.out.println(str);
		         		String value2 = hm2.get(str);
		         		if(value2 !=null)
		         			{  output += value2;}
		         		}
			     }
			    // System.out.println("Transliteration : "+output);
			     //printDistance(output,english);
			     double distance = computeDistance(output,english);
			     double length = english.length();
			     double Threshold = (distance/length)* 100;
			    // DecimalFormat df = new DecimalFormat("#.##");
			    // System.out.println(df.format(Threshold));
			    /* if(Threshold > 30)
			     	{System.out.println("Invalid name pair");}
			     else
			     	{System.out.println("Valid name pair");} */
			     String [] Retval= new String [5];
			     Retval[0]= input;
			     Retval[1]= english;
			     Retval[2]=output;
			     Retval[3]= String.valueOf(distance);
			     Retval[4]= String.valueOf(Threshold);
			     return Retval;
	}}

