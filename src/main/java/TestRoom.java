/**
 * Created by leonid.baranov on 5/18/17.
 */
public class TestRoom implements Room,IEventListener {

    private Door door;
    private Object object;
    private boolean containsObject;

    public TestRoom(Door door, Object object, boolean containsObject) {
        this.door = door;
        this.object = object;
        this.containsObject = containsObject;
    }

    public TestRoom(Door door) {
        this.door = door;
    }

    public boolean isContainsObject() {
        return containsObject;
    }

    public void open() {
        door.openDoor();
    }

    public void close() {
        door.closeDoor();
    }

    public boolean isEmpty() throws RoomClosedException {

        if ( !door.DoorIsOpened() ) throw new RoomClosedException();
        if ( getObject() == null ) // if no object
            return true; //room is empty
        return false;

    }

    public Object getObject() throws RoomClosedException {
        if (!door.DoorIsOpened()) throw new RoomClosedException();
        return object;
    }

    public void addObject(Object object) throws RoomClosedException {
        if (!door.DoorIsOpened()) throw new RoomClosedException();
        this.object = object;

    }

    public void removeObject() throws RoomClosedException {
        if (!door.DoorIsOpened()) throw new RoomClosedException();
        this.object = null;

    }

    public void subscribe(IEventListener listener) {
       listener.onObjectInRoom(object);//???
    }

    public void onObjectInRoom(Object object) {
       if (object.equals(this.object))
           containsObject = true;
    }
}
