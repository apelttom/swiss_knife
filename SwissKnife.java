import java.io.*;
import java.awt.Robot;
import java.util.Random;

/* This is a simple Java program that helps me solving
	problems during my work in the corporate.
   FileName : "SwissKnife.java". */
class SwissKnife
{

    private static final String ACCESS_RIGHT_VARONIS_KEYWORD = "pc1s003";
    private static final int FIVE_SECONDS = 5000;
    private static final int MAX_X = 400;
    private static final int MAX_Y = 400;

    // Program begins with a call to main().
    public static void main(String args[]) throws Exception
    {
        if(args.length == 0) {
            System.out.println("Proper Usage is:\n"
                + "java SwissKnife acessRightsFilePath\n"
                + "java SwissKnife noFile moveMouse");
            System.exit(0);
        } else if(args.length == 1) {
            System.out.println("Opening file: " + args[0]);
            System.out.println("Formatted result:");
            System.out.println(formatAccessRightsForVaronis(args[0]));
        } else {
          Robot robot = new Robot();
          Random random = new Random();

          while(true) {
            robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
            Thread.sleep(FIVE_SECONDS);
          }
        }
    }

    private static String formatAccessRightsForVaronis(String accessRightsOnLinesPath){
        String output = "";
        try{
            File file = new File(accessRightsOnLinesPath);
            BufferedReader br = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(file), "UTF-8"
                ));
            String line = "";
            while((line = br.readLine()) != null){
                if(line.contains(ACCESS_RIGHT_VARONIS_KEYWORD)){
                    String parsedLine = line.substring(line.indexOf("\\"));
                    output = output + parsedLine + ";\r\n";
                }
            }
            br.close();
        }
        catch (FileNotFoundException e){
            System.err.println("An error occured during opening of " + accessRightsOnLinesPath);
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println("An error occured during opening of " + accessRightsOnLinesPath);
            System.err.println(e.getMessage());
        }
        return output;
    }
}
