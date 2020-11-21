package dsa;
import dsa.models.*;

import org.apache.log4j.Logger;
//Junit 4.13
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class GameManagerImplTest {
    // THE QUICK REMINDER: Remember to name the test class public smh
    //Log4j Logger initialization
    private static final Logger logger = Logger.getLogger(GameManagerImplTest.class);
    //GameManager
    public GameManager manager = null;
    //Estructura de datos
    User user;
    List<GameObject> listGameObjects;
    //Metodo SetUp
    @Before
    public void setUp() {
        //Configuring Log4j
        PropertyConfigurator.configure("src/main/resources/log4j.properties");
        logger.debug("Debug Test Message!");
        logger.info("Info Test Message!");
        logger.warn("Warning Test Message!");
        logger.error("Error Test Message!");
        //Instancing GameManager Implementation
        manager = GameManagerImpl.getInstance();
       //Initializing Object List
        listGameObjects =  new LinkedList<>();
        //Initialzing Test User
        user = new User("xyz", "Krunal", "Badsiwal");
        //Appending data to Object List
        listGameObjects.add(new GameObject("001", "Sword"));
        listGameObjects.add(new GameObject("002", "Shield"));
        listGameObjects.add(new GameObject("003", "Potion"));
        //Adding Objects list to Game Manager
        manager.addGameObjects(listGameObjects);
    }
    //Tests
    //Metodo Test para añadir un usuario en ek sistema y verificar el número de usuarios
    @Test
    public void addUserTest(){
        //Initial Test, initial users in game Zero!
        Assert.assertEquals(0, this.manager.numUsers());
        //Adding a user to the GameManager
        manager.addUser(user.getId(),user.getName(),user.getSurname());
        Assert.assertEquals(1, manager.numUsers());
        //Adding a second user to the GameManager
        manager.addUser("abc","Toni","Oller");
        Assert.assertEquals(2, manager.numUsers());
    }

    @Test
    public void addObjectTest(){
        //Setting up with 1 Test User
        manager.addUser(user.getId(),user.getName(),user.getSurname());
        //Test for the objects the test user has equals 0 as setUp method
        Assert.assertEquals(0, manager.getNumGameObjectsUser(user.getId()));
        //Adding an object to the User passing a id of the Object, Expects http 201 Ok
        Assert.assertEquals(201,manager.addUserGameObject(user.getId(), listGameObjects.get(0).getId()));
        //Test if the number of objects inside Test User has increased to 1
        Assert.assertEquals(1, manager.getNumGameObjectsUser(user.getId()));
    }

    //Metodo Teardown
    @After
    public void tearDown() {
        manager.liberateReserves();
    }
}