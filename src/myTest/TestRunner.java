package myTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

import java.util.*;
import org.junit.runner.Result;

/**
 * <p>The class for verify all tests of the project.</p>
 * 
 * @version JUnit 4.13.2
 * @author Santarossa Noah
 */
public class TestRunner 
{
	private static int totalTests = 0;
	/** 
	 * @param args this param is not use in this case
	 */
	public static void main(String[] args) 
	{
		Result res;

		System.out.println("**Test in execution..**\n");

		System.out.println("\nTest of ListAdapter..");
		res = JUnitCore.runClasses(TestSuiteOfSubList.class,TestSuiteOfList.class,
									TestSuiteOfListIterator.class,TestSuiteOfSubListIterator.class);
		esitoTest(res);
		System.out.println("\n*** All the " + totalTests + " tests have been completed +**");
		
	}

	/**
	 * <p>Print the test result for every suite case
	 * For every suite is indicated how many test of the relative suite have been executed and how many failed</p>
	 * @param res - The result of the invocation of the test class
	 */
	private static void esitoTest(Result res)
	{
		totalTests += res.getRunCount();
		System.out.print("Of " + res.getRunCount() + " tests ");
		if (res.wasSuccessful())
		{
			System.out.println("all are with a positive result");
		}
		else
		{
	  	System.out.println("failed " + res.getFailureCount() + " tests");
			List<Failure> fails = res.getFailures();
			Iterator<Failure> iter = fails.iterator();
			while(iter.hasNext())
			{
				System.out.println(iter.next().toString());
			}
		}
	}
}
