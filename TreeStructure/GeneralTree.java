package TreeStructure;

public class GeneralTree {
//private GTNode root = new GTNode("~", null,null);
    private GTNode root;
    private GTNode currentNode;
    private GTNode parent;
    public GeneralTree(GTNode c){
        this.currentNode = c;
        
    }

    //use 'isAfile' to create error when doing incorrect function to a file.
    public void insert(GTNode node){
    
        if(root == null){
            
            parent = null;
            this.root = new GTNode(node.getName());
        }
        else {
            currentNode.addChildren(node);
            
        }
    }
    public GTNode getCurrentNode(){
        return currentNode;
    }
    public void printCurrentDirectory(){
        System.out.println(root);
    }
    public GTNode findNode(String nodeName) {
        return findNodeRecursively(currentNode, nodeName);
    }
    private GTNode findNodeRecursively(GTNode currentNode, String nodeName) {
        if (currentNode.getName().equals(nodeName)) {
            return currentNode;
        }
        for (GTNode child : currentNode.getChildren()) {
            GTNode foundNode = findNodeRecursively(child, nodeName);
            if (foundNode != null) {
                return foundNode; 
            }
        }
        return null; 
    }
    

    public void remove(String... args){
        System.out.println(args[1]);
        currentNode.removeChildren(args[1]);
    }

    public void help(){
        System.out.println("""
                        Operation           Description
                        __________          _____________
                        mkDir <name>        Add a folder <name> in the current directory
                        remove <name>       Remve <name> folder or file from the current Directory
                        mkFile <name>       Add a file <name> in the current directory
                        list                List all the files and directores in the current directory
                        up                  Move Up the one level from the current directory
                        cd <name>           Move from current directory to <name> directory
                        help                List all the avaliable commands
                            """);
    }

    public void list(String... args){
        currentNode.listChildren();
    }

    public void changeDirectory(String moveTo){
        GTNode node = currentNode.validateExistance(moveTo);
        
        if(node != null){
            this.parent = currentNode;
            currentNode = node;
        }

    }


    public void moveUp(){
        
        if(parent != null){
            System.out.println("we get here");
            currentNode = parent;
            parent = parent.getParent();
           
        }
    }
    

} 
