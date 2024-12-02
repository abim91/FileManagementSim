import TreeStructure.GTNode;

public class Operation {
    private String command;
    private String[] parameters;
    private GTNode currentObject;

    public Operation(String[] parameter) {
        this.command = parameter[0];
        this.parameters = parameter;
    }

    public String getCommand() {
        return command;
    }

    public String[] getParameters() {
        return parameters;
    }

    public GTNode getCurrentObject() {
        return currentObject;
    }
}
