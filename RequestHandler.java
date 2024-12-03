
import java.util.*;


import TreeStructure.GTNode;
import TreeStructure.GeneralTree;

public class RequestHandler {
    
    private String[] acceptableRequests = {"mkDir","mkFile","delete","list","setPassword","up","help","cd","info"};
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
            

                tree.insert(new GTNode(command.getParameters()[1]));
            }

            case "delete" ->{
            

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
                GTNode element = new GTNode(command.getParameters()[1]);
                tree.info(element);
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
