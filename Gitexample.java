
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Gitexample {

    public static void main(String[] args) {
       
        //String repoUrl = "https://github.com/divyayerkewar/Git-Github-Assignment.git";

        //clone the repo
        System.out.println ("cloning the repository");
        runCommand("git clone " + "https://github.com/divyayerkewar/Git-Github-Assignment.git",null);

        
        String repoFolder = "Git-Github-Assignment";

        // Check the status
        System.out.println("Checking the status...");
        runCommand("cd " + repoFolder + " && git status",null);

        // Add all changes
        System.out.println("Adding all changes");
        runCommand("cd " + repoFolder + " && git add .",null);

        // Commit the changes
        System.out.println("Committing the changes");
        runCommand("cd " + repoFolder + " && git commit -m \"Initial commit\"",null);

        // Push the changes
        System.out.println("Pushing the changes");
        runCommand("cd " + repoFolder + " && git push",null);

        System.out.println("Operations completed!");
    }

    // Method to run a command 
    private static void runCommand(String command,String directory) {
        try {
            //create a processbuilder to run the command
            ProcessBuilder builder = new ProcessBuilder("cmd.exe","/c",command);

        // set the work directory
            if(directory !=null){
                builder.directory(new java.io.File(directory));
            }
               //start the process
            Process process =builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));// converts the byte stream into a character stream
        
            //Read the output of the command
            String line;
            
            while ((line = reader.readLine()) != null) {//read the output of the command line by line and print it
                System.out.println(line);
            }
            process.waitFor();//wait until process has completed before continuing
        } catch (IOException |InterruptedException a) {//catches errors releated to input and output operations and  catches interruption while waiting for the process to finish
            a.printStackTrace();
        }
    }
}




