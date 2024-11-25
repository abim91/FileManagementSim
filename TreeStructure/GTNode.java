package TreeStructure;
import java.time.LocalDateTime;
import java.util.*;
public class GTNode{
    private String name;
    private String info;
    private String fileExtension;
    private List<GTNode> children; //directories aka the folders
    private boolean isAFile;
    private LocalDateTime timestamp; // Timestamp when the node is created
    private LocalDateTime lastModifiedTimestamp;
   // private GTNode parent;

    public GTNode(String name, boolean isAFile){
      //this.info = info;
      this.name = name;
      this.isAFile = true;
      this.timestamp = LocalDateTime.now(); // Set the timestamp when the node is created
      this.lastModifiedTimestamp = this.timestamp;
      
      /*if(!isAFile){
        this.children = new ArrayList<>();
      }*/
     
    }

    public GTNode getParent(){
      return this;
    }
    public List<GTNode> getChildren() {
      return children; 
  }
  
  

    public GTNode(String name){
    
      this.name = name;
      this.children = new ArrayList<>();
      this.isAFile = false;
      this.timestamp = LocalDateTime.now(); // Set the timestamp when the node is created
      this.lastModifiedTimestamp = this.timestamp;
     // this.parent = parent;
    }

    
    public String formattedTimestamp() {
      return timestamp.toString(); // You can customize this format if needed
  }
  public String formattedLastModifiedTimestamp() {
    return lastModifiedTimestamp.toString(); // You can customize the format
}
public void setLastModifiedTimestamp() {
  this.lastModifiedTimestamp = LocalDateTime.now(); // Update last modified time whenever changes happen
}

    public void addChildren(GTNode c){
      children.add(c);
      setLastModifiedTimestamp();
      System.out.println("Add child operation went successful");
    }

    public void removeChildren(String c){
      if(children.size() == 0){
        System.out.println("There is nothing to delete");
      }
      GTNode todelete = new GTNode(null,true);
      for(GTNode i: children){
        if(i.name.equals(c)){
          todelete = i;;
        }
      }
      children.remove(todelete);
      setLastModifiedTimestamp();
    }

    public void listChildren(){
        for(GTNode i : children){
        System.out.println(i.name);
        //System.out.println("List child operation went successful");
        System.out.println(i.name + " (Created at: " + i.formattedTimestamp() + ")");
      }
    }

    public GTNode validateExistance(String node){
      for(GTNode i: children){
        if( i.getName().equals(node)){
          return i;
        }
      }
      return null;
    }
    public String getName(){
      return this.name;
    }

    public void addFile(String name){

    }
    public String toString(){
      return "Node name: " + this.name + ", Created at: " + formattedTimestamp();
    }
    
    
    

  }
