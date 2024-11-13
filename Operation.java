import java.util.Arrays;

import TreeStructure.GTNode;

public class Operation {
    private String command;
    private String[] parameters;
    private GTNode currentObject;
    public Operation(String command){
        this.command = command;
    }


    public Operation(String[] parameter){
        this.command = parameter[0];
        this.parameters = parameter;
        
    }

    public GTNode getCurrentDNode(){
        return currentObject;
    }

     // Getter for command
     public String getCommand() {
        return command;
    }


    // Getter for parameters
    public String[] getParameters() {
        return parameters;
    }


}
