package TreeStructure;

public class GeneralTree {
    private GTNode root;
    private GTNode currentNode;
    private GTNode parent;

    public GeneralTree(GTNode c) {
        this.currentNode = c;
        this.parent = null;
        if (c != null) {
            c.setParent(null); // Root node should have no parent
        }
    }

    public void insert(GTNode node) {
        if (root == null) {
            root = new GTNode("~"); // Root directory has no parent, so it's initialized separately
            node.setParent(root);   // Set root as parent of the first node added
        } else {
            currentNode.addChildren(node); // Add the new node and automatically set its parent
        }
    }

    public GTNode getCurrentNode() {
        return currentNode;
    }

    public void printCurrentDirectory() {
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

        return null; // Return null if not found
    }

    public void remove(String... args) {
        System.out.println(args[1]);
        currentNode.removeChildren(args[1]);
    }

    public void help() {
        System.out.println("""
                Operation           Description
                __________          _____________
                mkDir <name>        Add a folder <name> in the current directory
                remove <name>       Remove <name> folder or file from the current Directory
                mkFile <name>       Add a file <name> in the current directory
                list                List all the files and directories in the current directory
                up                  Move Up one level from the current directory
                cd <name>           Move from the current directory to <name> directory
                help                List all the available commands
                info                Lists the name, date created, and date last modified
                move <file> <dir>   Move a file <file> to the directory <dir>
                """);
    }

    public void list() {
        currentNode.getChildren().forEach(child -> {
            System.out.println(child.getName() + " (Created at: " + child.formattedTimestamp() + ")");
        });
    }

    public void changeDirectory(String moveTo) {
        GTNode node = findNode(moveTo);
        if (node != null && !node.isAFile()) {
            parent = currentNode;
            currentNode = node;
        }
    }

    public void moveUp() {
        if (parent != null) {
            currentNode = parent;
            parent = currentNode.getParent();  // Update parent to the parent's parent
        }
    }

    public void move(String fileName, String targetDirectoryName) {
        GTNode file = findNode(fileName);
        GTNode targetDir = findNode(targetDirectoryName);

        if (file != null && targetDir != null && !file.isAFile()) {
            // Remove the file from the current directory and add it to the target directory
            currentNode.removeChildren(file.getName());
            targetDir.addChildren(file);
            System.out.println("Moved " + fileName + " to " + targetDirectoryName);
        }
    }
    public void moveFile(String fileName, String targetDirName) {
        GTNode fileNode = findNode(fileName); // Find the file to move
        if (fileNode == null || !fileNode.isAFile()) {
            System.out.println("File not found or it's not a file.");
            return;
        }

        GTNode targetDirNode = findNode(targetDirName); // Find the target directory
        if (targetDirNode == null || targetDirNode.isAFile()) {
            System.out.println("Target directory not found or it is not a directory.");
            return;
        }

        // Remove the file from the current directory and add it to the target directory
        currentNode.removeChildren(fileName); // Remove from current directory
        targetDirNode.addChildren(fileNode); // Add to the target directory

        System.out.println("File '" + fileName + "' has been moved to directory '" + targetDirName + "'.");
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
