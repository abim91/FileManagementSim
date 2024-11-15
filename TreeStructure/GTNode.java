package TreeStructure;
import java.util.*;
public class GTNode{
    private String name;
    private String info;
    private String fileExtension;
    private List<GTNode> children; //directories aka the folders
    private boolean isAFile;
   // private GTNode parent;

    public GTNode(String name, boolean isAFile){
      //this.info = info;
      this.name = name;
      this.isAFile = true;
      /*if(!isAFile){
        this.children = new ArrayList<>();
      }*/
     
    }

    public GTNode getParent(){
      return this;
    }
  

    public GTNode(String name){
    
      this.name = name;
      this.children = new ArrayList<>();
      this.isAFile = false;
     // this.parent = parent;
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
        System.out.println(i.name);
        //System.out.println("List child operation went successful");
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
    

  }