/**
 * Created by leonid.baranov on 5/18/17.
 */

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.*;
@RunWith(EventListnerRunner.class)
public class LogicTest {

    private TestRoom testRoom;
    private Object object;


    //open the door --> close the door --> check that door is closed (exp: false ( door is closed ))
    @Test
    public void testRoomPositive0() throws RoomClosedException
    {
        Door door = new Door();
        testRoom = new TestRoom(door);
        testRoom.open();
        testRoom.close();
        assertTrue(!door.DoorIsOpened());
    }
    //(door is closed) open the door --> if room is empty, put in the room object
    //--> check the room (exp: NOT EMPTY)
    @Test
    public void testRoomPositive1() throws RoomClosedException
    {
        object = new Object();
        testRoom = new TestRoom(new Door(), object, false);
        testRoom.open();
        if (testRoom.isEmpty())
            testRoom.addObject(object);
        assertTrue(!testRoom.isEmpty());
    }

    //(door is closed) open the door --> if room is empty, put in the room object --> remove object
    //--> check the room (exp: EMPTY)
    @Test
    public void testRoomPositive2() throws RoomClosedException
    {
        object = new Object();
        testRoom = new TestRoom(new Door(), object, false);
        testRoom.open();
        if (testRoom.isEmpty())
            testRoom.addObject(object);
        testRoom.removeObject();
        assertTrue(testRoom.isEmpty());
    }

    // (door is closed) open the door --> if room is empty, put in the room object
    //  --> check the object in the room (exp: true)
    @Test
    public void testRoomPositive3() throws RoomClosedException
    {
        object = new Object();
        testRoom = new TestRoom(new Door(), object, false);
        testRoom.open();
        if (testRoom.isEmpty())
            testRoom.addObject(object);
        testRoom.onObjectInRoom(object);
        assertEquals(true, testRoom.isContainsObject());
    }

    // (door is closed) open the door --> if room is empty, put in the room object
    // --> remove object -->  check the object in the room
    //(exp: false)

    @Test
    public void testRoomPositive4() throws RoomClosedException
    {
        object = new Object();
        testRoom = new TestRoom(new Door(), object, false);
        testRoom.open();
        if (testRoom.isEmpty())
            testRoom.addObject(object);
        testRoom.removeObject();
        testRoom.onObjectInRoom(object);
        assertEquals(false, testRoom.isContainsObject());
    }

    // (door is closed) open the door --> open the door
    // (waiting for a Exception)

    @Test(expected = Exception.class)
    public void testRoomNegative0() throws RoomClosedException
    {
        Door door = new Door();
        testRoom = new TestRoom(door);
        testRoom.open();
        testRoom.open(); // waiting for exception that the door is already opened
    }

    // (door is closed) Try to find out if the door is closed, without opening the door
    // (waiting for a RoomClosedException)

    @Test(expected = RoomClosedException.class)
    public void testRoomNegative1() throws RoomClosedException
    {
        object = new Object();
        testRoom = new TestRoom(new Door(), object, false);
        assertTrue(testRoom.isEmpty());
    }


    //  (door is closed) open the door -->  put in the room object
    // --> put the object again --> waiting for a Exception that we have the object in the room
    @Test(expected = Exception.class)
    public void testRoomNegative2() throws RoomClosedException
    {
        object = new Object();
        testRoom = new TestRoom(new Door(), object, false);
        testRoom.open();
        testRoom.addObject(object);
        testRoom.addObject(object);
    }

    //  (door is closed) open the door --> remove the object from the empty room
    // --> waiting for a Exception that we have no any object in the room
    @Test(expected = Exception.class)
    public void testRoomNegative3() throws RoomClosedException
    {
        object = new Object();
        testRoom = new TestRoom(new Door(), object, false);
        testRoom.open();
        testRoom.removeObject();
    }

    //  (door is closed) add the object
    // (waiting for a RoomClosedException)
    @Test(expected = RoomClosedException.class)
    public void testRoomNegative4() throws RoomClosedException
    {
        object = new Object();
        testRoom = new TestRoom(new Door(), object, false);
        testRoom.addObject(object);
    }




}
