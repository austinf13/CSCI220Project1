import java.io.File;
import java.util.Scanner;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.io.File;
/**
/This program is to create a word cloud of any text file.
/Austin Fry
/9/9/2015
*/
public class cloudProj
{
	public HashMap<String, Integer> wordCount;
	
		public void readIt(Scanner infile, int limit) 
		{
			wordCount = new HashMap<String, Integer>();
			while (limit > 0 && infile.hasNext())
            {
                String word = infile.next();
                if(wordCount.containsKey(word))
                {
                    wordCount.put(word, wordCount.get(word)+1);
                }
                else{
                    wordCount.put(word, 1);
                }
             limit--;
            }
            try{
                PrintWriter out = new PrintWriter("Thingy.html");
                out.println("<html>");
                out.println("<body>");
                for (String key : wordCount.keySet())
                {
                	System.out.println(key+" "+wordCount.get(key));
                    int freq = wordCount.get(key)*30;
                    out.println("<p style=font-size:" + freq + ">" + key + ",  " + freq/30 + "</p>");
                }
                out.println("</body>");
                out.println("</html>");
            }
            catch(IOException e) 
            {
                System.out.println("File Error");
            }
        }
    
    public static void main(String [] args)
    {
    	int limit;
    	if(args.length==2)
                {
                	limit = Integer.parseInt(args[1]);
                }
                else{
                	limit = -50;
                }
        if(args.length<1){
            System.out.println("Please kind sir, give me something to read.");
        }
        else{
            File fileToRead = new File(args[0]);
            cloudProj mainObject = new cloudProj();
            try{
                Scanner in = new Scanner(fileToRead);
                mainObject.readIt(in, limit);
            }

            catch(IOException e) 
            {
                System.out.println("File Error");
            }
        }   
    }
}

