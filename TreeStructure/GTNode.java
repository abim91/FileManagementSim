package TreeStructure;

import java.time.LocalDateTime;
import java.util.*;

public class GTNode {
    private String name;
    private boolean isAFile;
    private List<GTNode> children; // directories aka the folders
    private LocalDateTime timestamp; // Timestamp when the node is created
    private LocalDateTime lastModifiedTimestamp;
    private GTNode parent; // Parent directory reference

    // Constructor for file nodes
    public GTNode(String name, boolean isAFile) {
        this.name = name;
        this.isAFile = isAFile;
        this.timestamp = LocalDateTime.now();
        this.lastModifiedTimestamp = this.timestamp;
        this.children = new ArrayList<>();
        this.parent = null;  // Initially, parent is null
    }

    // Constructor for directory nodes
    public GTNode(String name) {
        this.name = name;
        this.isAFile = false;
        this.timestamp = LocalDateTime.now();
        this.lastModifiedTimestamp = this.timestamp;
        this.children = new ArrayList<>();
        this.parent = null;  // Initially, parent is null
    }

    // Getter and setter for parent
    public GTNode getParent() {
        return parent;
    }

    public void setParent(GTNode parent) {
        this.parent = parent;
    }

    public boolean isAFile() {
        return isAFile;
    }

    public String getName() {
        return name;
    }

    public List<GTNode> getChildren() {
        return children;
    }

    // Method to add children (sets parent automatically)
    public void addChildren(GTNode child) {
        children.add(child);
        child.setParent(this); // Set this node as the parent for the child
        setLastModifiedTimestamp();
    }

    public void removeChildren(String name) {
        children.removeIf(child -> child.getName().equals(name));
        setLastModifiedTimestamp();
    }

    public String formattedTimestamp() {
        return timestamp.toString();
    }

    public String formattedLastModifiedTimestamp() {
        return lastModifiedTimestamp.toString();
    }

    public void setLastModifiedTimestamp() {
        this.lastModifiedTimestamp = LocalDateTime.now(); // Update last modified time whenever changes happen
    }

    // Override toString for easy printing of node details
    @Override
    public String toString() {
        return "Node name: " + name + ", Created at: " + formattedTimestamp();
    }
}
