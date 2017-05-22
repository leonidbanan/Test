/**
 * Created by leonid.baranov on 5/18/17.
 */

//Door -open close and
//state - if the door is opened
public class Door {
    private boolean isDoorOpened;

    //


    public Door() {       //по умолчанию дверь закрыта
        isDoorOpened = false;
    }

    public boolean isDoorOpened() {
        return isDoorOpened;
    }

    public void setDoorOpened(boolean doorOpened) {
        isDoorOpened = doorOpened;
    }

    public boolean DoorIsOpened() {
        return isDoorOpened;
    }
        // открыть
    public void openDoor() {
        isDoorOpened = true;
    }
        // закрыть
    public void closeDoor() {
        isDoorOpened = false;
    }
}
