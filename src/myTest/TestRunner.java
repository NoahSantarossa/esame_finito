package myTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

import java.util.*;
import org.junit.runner.Result;

/**
 * <p><b>Summary</b>:The class for verify all tests of the project.</p>
 * The class its call in cmd prompt for verify myTest package (main class).
 * It is based on JUnit framework and its use the package org.junit.runner.notification.Failure for save the eventual error.
 * Use the library: hamcrest-core-1.3.jar and junit-4.13.2.jar.
 * @version 1.0
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

		System.out.println("\n***Test in execution..***");

		System.out.println("\nTest of TestSuiteOfSubList, TestSuiteOfList, TestSuiteOfListIterator, TestSuiteOfSubListIterator.\n");
		res = JUnitCore.runClasses(TestSuiteOfSubList.class,TestSuiteOfList.class,
									TestSuiteOfListIterator.class,TestSuiteOfSubListIterator.class);
		esitoTest(res);

		System.out.println("\n***All the " + totalTests + " tests have been completed***\n");
		System.out.println("The total time for tests is "+res.getRunTime()+" ms.");
		
		System.out.println("\n***TestClass completed correctly***\n");
		
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
			System.out.println("all are ended with a positive result.");
		}
		else
		{
	  	System.out.println("failed " + res.getFailureCount() + " tests.");
			List<Failure> fails = res.getFailures();
			Iterator<Failure> iter = fails.iterator();
			while(iter.hasNext())
			{
				System.out.println(iter.next().toString());
			}
		}
	}
}
