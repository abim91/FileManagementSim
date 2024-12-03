
import java.util.*;


import TreeStructure.GTNode;
import TreeStructure.GeneralTree;

public class RequestHandler {
    
    private String[] acceptableRequests = {"mkDir","mkFile","remove","list","move","up","help","cd","info"};
    String CurrentDir = "~";

  


   
    GTNode current = new GTNode("~");
    private GeneralTree tree = new GeneralTree(current);
    public RequestHandler(){
        tree.insert(current);
    }

    public void request(Operation command){

        if(!(validateRequest(command.getCommand()))){
            System.out.println("This is not a valid function");
            return;
        }


        switch(command.getCommand()){
            case "help" ->{
                tree.help();
            }

            case "mkDir" ->{
            
                GTNode node = new GTNode(command.getParameters()[1]); 
                tree.insert(node);
          
            }

            case "remove" ->{
            

                tree.remove(command.getParameters());
             
            }

            case "list" ->{
                tree.list();
            }

            case "mkFile" ->{
                
                tree.insert((new GTNode(command.getParameters()[1],true)));
            }


            case "cd" ->{
                GTNode element = tree.getCurrentNode().validateExistance(command.getParameters()[1]);
                
                if(element == null){
                    System.out.println("This is not a valid address");
                    return;
                }
                
                if(element.isAFile()){
                    System.out.println("Cannot move into a File.");
                    return ;
                }

                tree.changeDirectory(element) ;
                current = element;
               
                
                
            }

            case "up" ->{
                //tree.moveUp();
                current = tree.moveUp();
            }

            case "info" -> {

              //  String nodeName = command.getParameters()[1];
                
                tree.info(command.getParameters()[1]);
            }

            case "move" -> {
                if (command.getParameters().length == 3) {
                    String fileName = command.getParameters()[1];
                    String targetDirName = command.getParameters()[2];
                    tree.moveFile(fileName, targetDirName);
                } else {
                    System.out.println("Usage: move <file_name> <target_directory>");
                }
            }
       
        }

    }

    public String workingDirectory(){
        return current.getName();
    }

    private boolean validateRequest(String request){
        for(String i : acceptableRequests){
            if(request.equals(i))
                return true;
        }
        return false;

    }
}
