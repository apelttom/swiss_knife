import java.io.*;
import java.util.Scanner;

/* This is a simple Java program that helps me solving
	problems during my work in the corporate.
   FileName : "SwissKnife.java". */
class SwissKnife 
{ 

    private static final String ACCESS_RIGHT_VARONIS_KEYWORD = "pc1s003";
    // Program begins with a call to main().  
    public static void main(String args[]) 
    {
        if(args.length == 0)
        {
            System.out.println("Proper Usage is: java SwissKnife filename");
            System.exit(0);
        } else{
            System.out.println("Opening file: " + args[0]);
            System.out.println("Formatted result:");
            System.out.println(formatAccessRightsForVaronis(args[0]));
        }
    }
    
    private static String formatAccessRightsForVaronis(String accessRightsOnLinesPath){
        String output = "";
        try{
            File file = new File(accessRightsOnLinesPath);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                String line = scanner.next();
                if(line.contains(ACCESS_RIGHT_VARONIS_KEYWORD)){
                    String parsedLine = line.substring(line.indexOf("\\"));
                    output = output + parsedLine + ";";
                }
            }
            scanner.close();
		}
		catch (FileNotFoundException e){
            System.err.println("An error occured during opening of " + accessRightsOnLinesPath);
            System.err.println(e.getMessage());
        }
        return output;
    }
} 