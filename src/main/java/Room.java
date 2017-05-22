/**
 * Created by leonid.baranov on 5/18/17.
 */
public interface Room {
    void open();

    void close();

    boolean isEmpty() throws RoomClosedException;

    Object getObject() throws RoomClosedException;

    void addObject(Object object) throws RoomClosedException;

    void removeObject() throws RoomClosedException;

    void subscribe(IEventListener listener);
}
