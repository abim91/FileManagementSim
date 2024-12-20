
import java.util.*;


import TreeStructure.GTNode;
import TreeStructure.GeneralTree;

public class RequestHandler {
    
    private String[] acceptableRequests = {"mkDir","mkFile","delete","list","setPermission","up","help","cd","info","move"};



   
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
                // Create a new directory and display its timestamp
                GTNode newDir = new GTNode(command.getParameters()[1]);
                tree.insert(newDir);
                System.out.println("Directory '" + newDir.getName() + "' created at: " + newDir.formattedTimestamp());
            

                
            }

            case "remove" ->{
            

                tree.remove(command.getParameters());
            }

            case "list" ->{
                tree.list();
            }

            case "mkFile" ->{GTNode newFile = new GTNode(command.getParameters()[1], true);
                tree.insert(newFile);
                System.out.println("File '" + newFile.getName() + "' created at: " + newFile.formattedTimestamp());
            
            }


            case "cd" ->{
            //   ChangeDirectory change = new ChangeDirectory(command.getCurrentDNode());
                tree.changeDirectory(command.getParameters()[1]);  
            }

            case "up" ->{
                tree.moveUp();
            }
            case "info" -> {
                String nodeName = command.getParameters()[1];
                tree.info(nodeName);
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


    private boolean validateRequest(String request){
        for(String i : acceptableRequests){
            if(request.equals(i))
                return true;
        }
        return false;

    }
}

