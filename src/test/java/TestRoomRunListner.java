import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

/**
 * Created by leonid.baranov on 5/19/17.
 */


public class TestRoomRunListner extends RunListener {


        @Override
        public void testStarted(Description description) throws Exception {
            System.out.println("test start: " + description.getMethodName());
        }

        @Override
        public void testFinished(Description description) throws Exception {
            System.out.println("test and: " + description.getMethodName() + "\n----");
        }

        @Override
        public void testFailure(Failure failure) throws Exception {
            System.out.println("test failed with next exception: " + failure.getException());
        }

        @Override
        public void testIgnored(Description description) throws Exception {
            System.out.println("test ignored: " + description.getMethodName() + "\n----");
        }

        @Override
        public void testRunFinished(Result result) throws Exception {
            System.out.println("Test results: ");
            System.out.println("Tests were run: " + result.getRunCount());
            System.out.println("Tests were failed: " + result.getFailureCount());
            System.out.println("Tests were ignored: " + result.getIgnoreCount());
            System.out.println("All tests completed successfully: " + result.wasSuccessful());
        }
}

