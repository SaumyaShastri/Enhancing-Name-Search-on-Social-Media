import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;

import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;


public class Tweet_Mapping  {
	
	
	TwitterStream twitterStream;
	//public void run()
	//  { twitterStream.shutdown();
	 // try{  
	 //      Thread.sleep (2*60*1000);
	  //      }
     // catch (InterruptedException interruptedException)
     // {System.out.println( "First Thread is interrupted when it is sleeping" +interruptedException);}
	 // }
	
    public static void main(String[] args) {
    	
        ConfigurationBuilder cb = new ConfigurationBuilder();
         cb.setDebugEnabled(true);
         cb.setOAuthConsumerKey("****");
         cb.setOAuthConsumerSecret("****");
         cb.setOAuthAccessToken("****");
         cb.setOAuthAccessTokenSecret("****");

        final TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance(); // FileWriter file = new FileWriter(new File(Data_Twitter.txt));
        StatusListener listener = new StatusListener() {
        
        

            @Override
            public void onStatus(Status status) {
           
                User user = status.getUser();
                
                // gets Username
                String username = status.getUser().getScreenName();
                System.out.println(username);
                String profileLocation = user.getLocation();
                System.out.println("********Location:"+profileLocation);
                long tweetId = status.getId(); 
                System.out.println(tweetId);
                String content = status.getText();
                System.out.println(content +"\n");
                String accountname = user.getName();
                
                HashMap<String, String> usersMap = new HashMap<String, String>();
                String value;
                value = usersMap.get(user);
                
                if (value != null)
       {
        // already exists
       }
       else
       {
           value = String.format("%s\t%s", username, profileLocation);
           usersMap.put(username, value);
                File file1 = new File("stream2.txt");
                Writer output1 = null;
                try {
                output1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file1,true), "UTF8"));
                } 
                catch (UnsupportedEncodingException e) {
                e.printStackTrace();}
                catch (FileNotFoundException e) {
                e.printStackTrace();}
                String lang = status.getLang();
                String a_name = status.getUser().getName();
                String rawJSON =status.getUser().getScreenName(); 
                String rawJSON1 = status.getUser().getLocation();
                String tweet = status.getText();
                String descrip = user.getDescription();
                String image = user.getOriginalProfileImageURL() ;
                tweet = tweet.substring(0,20);
                try {
               
                //String formatStr = "%-5s %-10s %-20s %-20s %-30s %-10s %-150s %-150s %-150s %n";
                String formatStr = "%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%n";
                output1.write(String.format(formatStr,lang,a_name, rawJSON,rawJSON1,tweet.replace('\t',' '),descrip.replace('\t',' '),image));
                
                ((BufferedWriter) output1).newLine();
                output1.close();} 
                catch (IOException e) {e.printStackTrace(); }
          
        }	}
            @Override
		public void onException(Exception arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onDeletionNotice(StatusDeletionNotice arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onScrubGeo(long arg0, long arg1) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStallWarning(StallWarning arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTrackLimitationNotice(int arg0) {
			// TODO Auto-generated method stub
		}

        };
        FilterQuery fq = new FilterQuery();
    
        String keywords[] = {"-"};

        fq.track(keywords);
        fq.language("ar");
        fq.language("hi");
        //fq.locations(locations);
        twitterStream.addListener(listener);
        twitterStream.filter(fq); 
        twitterStream.toString();
     
}  
}
	
