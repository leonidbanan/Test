import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runner.notification.RunNotifier;

 public class EventListnerRunner extends BlockJUnit4ClassRunner {
    private TestRoomRunListner runListener;
    public EventListnerRunner(Class<TestRoomRunListner> clazz)
            throws InitializationError {
        super(clazz);
        runListener = new TestRoomRunListner();
    }
    public void run(RunNotifier notifier) {
        notifier.addListener(runListener);
        super.run(notifier);
    }
}