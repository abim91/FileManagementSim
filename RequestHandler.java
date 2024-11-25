
import java.util.*;


import TreeStructure.GTNode;
import TreeStructure.GeneralTree;

public class RequestHandler {
    
    private String[] acceptableRequests = {"mkDir","mkFile","delete","list","setPermission","up","help","cd","info"};



   
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
                GTNode newDir = new GTNode(command.getParameters()[1]);
                tree.insert(newDir);
                System.out.println("Directory '" + newDir.getName() + "' created at: " + newDir.formattedTimestamp());
            }

            case "delete" ->{
            

                tree.remove(command.getParameters());
            }

            case "list" ->{
                tree.list();
            }

            case "mkFile" ->{
                tree.insert(newFile);
                System.out.println("File '" + newFile.getName() + "' created at: " + newFile.formattedTimestamp());
            }


            case "cd" ->{
                GTNode element = tree.getCurrentNode().validateExistance(command.getParameters()[1]);
                if(element == null){
                    System.out.println("This is not a valid address");
                    return;
                }
                
                if(element.isAFile()){
                    System.out.println("Cannot move into a File.");
                    return;
                }

                tree.changeDirectory(command.getParameters()[1]) ;
                
                //tree.changeDirectory(command.getParameters()[1].isAFile );  
            }

            case "up" ->{
                tree.moveUp();
            }
            case "info" -> {
                String nodeName = command.getParameters()[1];
                GTNode node = tree.findNode(nodeName);

                if (node != null) {
                    System.out.println("Name: " + node.getName());
                    System.out.println("Created at: " + node.formattedTimestamp());
                    System.out.println("Last modified at: " + node.formattedLastModifiedTimestamp());
                } 
            }
       
        }

    }


    private boolean validateRequest(String request){
        for(String i : acceptableRequests){
            if(request.equals(i))
                return true;
        }
        return false;

    }
}
