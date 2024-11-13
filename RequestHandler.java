
import java.util.*;


import TreeStructure.GTNode;
import TreeStructure.GeneralTree;

public class RequestHandler {
    
    private String[] acceptableRequests = {"mkDir","mkFile","delete","list","setPermission","up","help","cd"};



   
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
            //   ChangeDirectory change = new ChangeDirectory(command.getCurrentDNode());
                tree.changeDirectory(command.getParameters()[1]);  
            }

            case "up" ->{
                tree.moveUp();
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
