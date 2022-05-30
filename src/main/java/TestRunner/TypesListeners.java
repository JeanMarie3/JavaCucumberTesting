package TestRunner;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
    public class TypesListeners implements ITestListener {

        // This belongs to ITestListener and will execute before starting of Test set/batch
        public void onStart(ITestContext arg)
        {

            System.out.println("Starts Test execution... "+arg.getName());
        }

        // This belongs to ITestListener and will execute after starting of Test set/batch
        public void onFinish(ITestContext arg) {
            System.out.println("Congratulations, we managed..... ");
            System.out.println("============================..... ");
            System.out.println("Finish Test execution..... "+arg.getName());
        }

        // This belongs to ITestListener and will execute before the main test start i.e. @Test
        public void onTestStart(ITestResult arg0) {

            System.out.println("Starts test ... "+arg0.getName());
        }

        // This belongs to ITestListener and will execute when a test is passed
        public void onTestSuccess(ITestResult iTestResult) {
            System.out.println("Passed test ... "+iTestResult.getName());
        }

        // This belongs to ITestListener and will execute when a test is failed
        public void onTestFailure(ITestResult iTestResult) {
            System.out.println("Failed test ... "+iTestResult.getName());
        }

        // This belongs to ITestListener and will execute when a test is skipped
        public void onTestSkipped (ITestResult iTestResult) {
            System.out.println("Skipped test....... "+iTestResult.getName());
        }

        //Not important, we ignore it now
        public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
            //To do
            System.out.println("At least");
        }


    }
