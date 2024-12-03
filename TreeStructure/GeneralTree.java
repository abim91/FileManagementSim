package TreeStructure;

public class GeneralTree {
//private GTNode root = new GTNode("~", null,null);
 //   private final static GTNode root = new GTNode("~");
    private GTNode currentNode;
    private GTNode parent;
    private GTNode root ;
    public GeneralTree(GTNode c){
      
        this.currentNode = c;
       // this.parent = null
        
    }

    //use 'isAfile' to create error when doing incorrect function to a file.
    public void insert(GTNode node){
        currentNode.addChildren(node);
    /*     if(root == null){
            
         //   parent = null;
            this.root = new GTNode(node.getName());
        }
        else {
            currentNode.addChildren(node);
            
        }*/
    }
    public GTNode getCurrentNode(){
        return currentNode;
    }
    public void printCurrentDirectory(){
        System.out.println(root);
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

    public void changeDirectory(GTNode moveTo){ //possible error
      //  GTNode node = currentNode.validateExistance(moveTo);
        
        if(moveTo != null){
            moveTo.setParent(currentNode);
            currentNode = moveTo;
            parent = currentNode.getParent();
        }

    }

    
   

    public GTNode moveUp(){
        
        if(parent != null){
            System.out.println("we are at"+ parent.getName());
            currentNode = currentNode.getParent();
            parent = parent.getParent();
            
        } 
        return currentNode;
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

        return null; // Return null if not found
    }

    public void info(String nodeName) {
        GTNode node = findNode(nodeName);

        if (node != null) {
            System.out.println("Name: " + node.getName());
            System.out.println("Created at: " + node.formattedTimestamp());
            System.out.println("Last modified at: " + node.formattedLastModifiedTimestamp());

            // Check if it's a file and display its parent directory
            if (node.isAFile()) {
                GTNode parentDir = node.getParent();
                if (parentDir != null) {
                    System.out.println("Located in directory: " + parentDir.getName());
                } else {
                    System.out.println("This file has no parent (it's at the root level).");
                }
            } else {
                // If it's a directory, list its children
                System.out.println("Contains the following items:");
                for (GTNode child : node.getChildren()) {
                    System.out.println("- " + child.getName());
                }
            }
        } else {
            System.out.println("Node not found!");
        }
    }
} 