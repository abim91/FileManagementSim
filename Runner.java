import java.util.*;

public class Runner{
    public static final String ANSI_RESET = "\u001B[0m"; 
    public static final String ANSI_BLUE = "\u001B[34m"; 
    public static void main(String[] args) {
            System.out.println("********************************************");
        System.out.println("*                                          *");
        System.out.println("*       Welcome to File Management         *");
        System.out.println("*                  Simulator               *");
        System.out.println("*                                          *");
        System.out.println("*   Enter 'help' for a list of commands    *");
        System.out.println("*            Enter 'Q' to exit.           *");
        System.out.println("*                                          *");
        System.out.println("********************************************");

        Scanner scan = new Scanner(System.in);
     
        RequestHandler handler = new RequestHandler();//must be outside so the inital root is added only once
        while(true){
            String a = handler.workingDirectory();
          //  a. setColor(Color.RED);
            System.out.print(">> " + ANSI_BLUE + handler.workingDirectory() +ANSI_RESET+" "); //fix the working dir par
            String answer = scan.nextLine();

            String[] myArray = answer.split(" +");
            if(answer.equals("Q")){
                System.out.println("Good-Bye");
                break;
            }
    
            handler.request(new Operation(myArray));

         
            }
    
    }
}

