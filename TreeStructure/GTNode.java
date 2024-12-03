package TreeStructure;
import java.util.*;
import java.time.LocalDateTime;
public class GTNode{
    private String name;
    private String info;
    private String fileExtension;
    private List<GTNode> children; //directories aka the folders
    private boolean isAFile;
    private GTNode parent;
    private LocalDateTime timestamp; // Timestamp when the node is created
    private LocalDateTime lastModifiedTimestamp;
   // private GTNode parent;

    public GTNode(String name, boolean isAFile){
      //this.info = info;
      this.name = name;
      this.isAFile = isAFile;
      this.timestamp = LocalDateTime.now();
      this.lastModifiedTimestamp = this.timestamp;
      /*if(!isAFile){
        this.children = new ArrayList<>();
      }*/
     
    }

    public boolean isAFile(){
      return this.isAFile;
    }
  

    public GTNode(String name){
    
      this.name = name;
      this.children = new ArrayList<>();
      this.isAFile = false;
      this.timestamp = LocalDateTime.now();
      this.lastModifiedTimestamp = this.timestamp;
     // this.parent = parent;
    }

    public void setParent(GTNode parent){
      this.parent = parent;
     
  }
    public GTNode getParent(){
      if(parent != null){
          System.out.println(parent.getName() + " parent isn't null");
          return parent;
          
      }
      System.out.println("parent is null");
      return this;
      
  }
  
  public List<GTNode> getChildren() {
    return children;
}
    public void addChildren(GTNode c){
      children.add(c);
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
    }

    public void listChildren(){
        for(GTNode i : children){
            System.out.println("- "+i.name);
       
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
      return "I am a node";
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

  }