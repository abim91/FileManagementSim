import java.util.*;


import TreeStructure.GTNode;
import TreeStructure.GeneralTree;

public class Runner{
    public static void main(String[] args) {
        System.out.println("""
                            Welcome to File Management Simulator
                            Enter 'help' to get a list of all commands,
                            Enter Q to exit.
                            """);

        Scanner scan = new Scanner(System.in);
     
        RequestHandler handler = new RequestHandler();//must be outside so the inital root is added only once
        while(true){
            
            System.out.print(">> " + handler.workingDirectory() ); //fix the working dir par
            String answer = scan.nextLine();

            String[] myArray = answer.split(" +");
            if(answer.equals("Q")){
                System.out.println("Good-Bye");
                break;
            }
    
            handler.request(new Operation(myArray));

           // System.out.println(myArray[0]);
           
        }
    
    }
}

