package dsa.models;

import java.util.LinkedList;
import java.util.List;

public class User {

    private String id;
    private String name;
    private String surname;
    //List of Objects
    private List<GameObject> listGameObjects = null;
    //User Constructor
    public User(String id, String name, String surname){
        this.name = name;
        this.id = id;
        this.surname = surname;
        this.listGameObjects = new LinkedList<>();
    }
    //Empty Constructor
    public User(){ }

    public int getNumGameObjects(){
        return this.listGameObjects.size();
    }

    //Returns an object from the list, else null for Out of bounds or Not initialized
    public GameObject getGameObject(int index){
        try {
            return this.listGameObjects.get(index);
        }
        catch (IndexOutOfBoundsException | ExceptionInInitializerError e ){
            return null;
        }
    }
    //Adds object to the User list
    public int setGameObject(GameObject gameObject){
        try{
            this.listGameObjects.add(gameObject);
        }
        catch (ExceptionInInitializerError e)
        {
            return 400;//400 Bad Request
        }
        catch (IndexOutOfBoundsException e){
            return 507;//Insufficient storage
        }
        return 201;//201 Created
    }
    //Returns User Object List
    public List<GameObject> getListGameObjects(){
        return this.listGameObjects;
    }
    //Setter for Swagger API,DON'T USE IN MAIN CODE!
    public void setListGameObjects(List<GameObject> listGameObjects) {
            this.listGameObjects = (listGameObjects);
    }
    //Adds a List of Objects to User
    public int setListGameObjects_resCode(List<GameObject> listGameObjects) {
        try{
            this.listGameObjects.addAll(listGameObjects);
        }
        catch(NullPointerException e){
            return 204;//204 No Content
        }
        catch( IndexOutOfBoundsException e){
            return 400;//400 Bad Request
        }
        return 201;//201 Created
    }
    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    //Returns user in string format
    public String toString(){
        return "ID: " + this.getId() + " | Name: " + this.getName() + " | Surname: " + this.getSurname() ;
    }
}
