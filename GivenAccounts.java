import java.io.*;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import twitter4j.*;
import twitter4j.conf.*;

public class GivenAccounts {
  public static void main(String[] a) {

    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setOAuthConsumerKey("rsSxx6wD2RR6C3eFUCyiAkHR4");
    cb.setOAuthConsumerSecret("3g66sKqoEIHJNBtWebjwdYcLojSqkGhDGqpZjiv2Ymb4LZQD6D");
    cb.setOAuthAccessToken("729914601849167872-mXRAIOB82Ejn28qHKbKltdrVRhc3M7b");
    cb.setOAuthAccessTokenSecret("jxkOyjWliB3S8lJqpcJH72N3SyWpZMchfdiiUva2FEmXs");

    Twitter twitter = new TwitterFactory(cb.build()).getInstance();

    int pageno = 1;

    ArrayList<Status> statuses = new ArrayList<>();

       String line = "";

    try{
      BufferedReader sr = new BufferedReader(new InputStreamReader(new FileInputStream(new File("Account_Names.txt"))));

      while ((line = sr.readLine()) != null)
      {
        String user = line;
        ArrayList<String> Names = new ArrayList<String>();
        Names.add(line);
        int i;
        for (i=0; i<Names.size();i++) {

          try {

            int size = statuses.size(); 
            Paging page = new Paging(pageno++, 100);
            statuses.addAll(twitter.getUserTimeline(user, page));

            if (statuses.size() == size)
              break;
          }
          catch(TwitterException e) {

            e.printStackTrace();
          }
        }
        for (int i1 = 0; i1 < statuses.size(); i1++) {
          Status elt = statuses.get(i1);
          System.out.println("Element: "+i1+"::" + elt.getUser().getScreenName()+" "+elt.getText()+"::"+elt.toString());
          
          String user1 = elt.getUser().getScreenName();
          String tweet = elt.getText().toString();
          
          File file1 = new File("Sample.txt");
          Writer output1 = null;
          try {
          output1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1,true), "UTF8"));
          } 
          catch (UnsupportedEncodingException e) {
          e.printStackTrace();}
          catch (FileNotFoundException e) {
          e.printStackTrace();}
          try {
            
        	 // String formatStr = "%-20s %-15s %-100s %n";
        	 // output1.write(String.format(formatStr, user1, tweet));
             output1.write(user1);
             output1.write(tweet);
              ((BufferedWriter) output1).newLine();
              output1.close();} 
              catch (IOException e) {e.printStackTrace(); } 
          
          
        }


        System.out.println("Total: "+statuses.size());
        
      }
       sr.close();
      }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}