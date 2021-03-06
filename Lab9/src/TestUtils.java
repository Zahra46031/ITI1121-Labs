import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.runner.Result;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

public class TestUtils {

    public static final String DIV = "******************************************************************";
    public static final String EXCEPTION_DELIM = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    
    public static void runClass(java.lang.Class<?> c) {

        Result result = JUnitCore.runClasses(c);
        System.out.println();

        System.out.println("List of failed tests:");
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println();

        System.out.print("Passed all the tests (true/false): ");
        System.out.println(result.wasSuccessful());

    }
}