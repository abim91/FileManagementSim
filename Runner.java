import java.util.*;

public class Runner{
    public static final String ANSI_RESET = "\u001B[0m"; 
    public static final String ANSI_BLUE = "\u001B[34m"; 
    public static void main(String[] args) {
        System.out.println("adsdsa");
        System.out.println("""
                            Welcome to File Management Simulator
                            Enter 'help' to get a list of all commands,
                            Enter Q to exit.
                            """);

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

