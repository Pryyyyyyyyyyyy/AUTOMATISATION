package priority;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Priority2 implements IHookable {

    @Test
    public void test_a() {
        System.out.println("Test A");
    }

    @Test
    public void test_b() {
        System.out.println("Test B");
    }

    @Test
    public void test_c() {
        System.out.println("Test C");
    }

    @Test
    public void test_d() {
        System.out.println("Test D");
    }

    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        Object[] testInstances = callBack.getParameters();
        Arrays.sort(testInstances, Comparator.comparing(o -> o.getClass().getSimpleName()).reversed());
        callBack.runTestMethod(testResult);
    }
}
