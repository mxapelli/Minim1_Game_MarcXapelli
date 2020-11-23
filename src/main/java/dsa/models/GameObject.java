package dsa.models;

public class GameObject {
    private  String name;
    private  String id;

    //Constructor
    public GameObject(String id, String name){
        this.name = name;
        this.id = id;
    }
    //Empty constructor
    public GameObject(){
    }
    //Getters and setters
    public void setName(String name){this.name =name;}
    public void setId(String id){this.id =id;}
    public String getName() {
        return this.name;
    }
    public String getId() {return id;}
    @Override
    //Logger information
    public String toString(){
        return "ID: " + this.getId() + " | Name: " + this.getName() ;
    }
}
