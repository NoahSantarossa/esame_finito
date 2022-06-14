package myTest;

//import jar
import org.junit.*;
import static org.junit.Assert.*;

// Adapter package 
import myAdapter.*;

import java.util.NoSuchElementException;

/**
 * <p><b>Summary: </b>test suite of list Iterator.
 *  All test is invoked in a ListAdapter.listIterator. All test is used for verify all method of this class.
 * Notation used in this test suite:
 * <ul>
 * <li>{x-y} means elements from x (included) to y (included).</li>
 * <li>{x, y, z, a} means 4 elements which are the same of the list x, y, z, a.</li>
 * </ul>
 * <p><b>Test Suite Design:</b> All test is based on verify the method in various occasion:
 * critical situation, common situation, combined situation and special situation. 
 * All method is tested for verify if its throws its exception.
 * The suite is divided in test cases of the same method(s).</p>
 * <p><b>Pre-Condition:</b> All lists and the collection are null. The iterator is null.</p>
 * <p><b>Post-Condition:</b >All lists and the collection are null. The iterator is null.</p>
 * <p><b>Test Cases:</b>
 * <ul>
 * <li>public void myTest.TestSuiteOfListIterator.End()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_Next_Exception_Empty()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_NextIndex_DifferentCase()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_HasPrev_DifferentCase()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_Previous_Exception_Empty()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_Remove_Add_Combined()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_HasNext_DifferentCase()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_Next_DifferentCase()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_Next_Exception_IAE()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_Remove_Add_Combined_Exception()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_Previous_Exception()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_NextIndex_Empty()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_Set_Add_Remove()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_Remove_Multiple_Exception()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_PreviousIndex_DifferentCase()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_PreviousIndex_Empty()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_Remove_Multiple()</li>
 * <li>public static void myTest.TestSuiteOfListIterator.beforeClassMethod()</li>
 * <li>public void myTest.TestSuiteOfListIterator.beforeMethod()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_HasNext_Empty()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_Set_Exception()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_Set_Mid()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_Set_Mix()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_NextIndex()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_Set_All()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_HasPrev_Empty()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_mixed()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_Add_Multiple()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_mixed3()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_mixed4()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_Add_Empty()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_Remove_1E()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_Remove_Empty()</li>
 * <li>public void myTest.TestSuiteOfListIterator.test_mixed2()</li>
 * </ul>
 * <p><b>Test Suite Execution Records:</b>
 *  All test has been correctly execute.</p>
 * <p><b>Execution Variable:</b> There arent execution variables.</p>
 * @see TestSuiteOfSubListIterator
 * @see TestSuiteOfList
 * 
 */
public class TestSuiteOfListIterator 
{
    HList list, list1;
    HListIterator iterator,iterator1; 

    /**
     * <p><b>Summary</b>:setup all variables.</p>
     */
    @Before
    public void beforeMethod()
    {
        list = new ListAdapter();
        list1 = new ListAdapter();
    }

    /*
    @BeforeClass
    public static void beforeClassMethod()
    {

        try
        {
            Class tsli= TestSuiteOfListIterator.class;
            java.io.FileWriter out = new java.io.FileWriter("out.txt");
            for (Method method : tsli.getMethods())
            {
                out.write(" * <li>" + method.toString() + "</li>\n");
            }
            out.close();
        }catch (java.io.IOException ioe)
        {}
    }*/

     /**
     * <p><b>Summary</b>set to null all item used</p>
     */
    @After
    public void End()
    {
        list=null;
        list1=null;
        iterator=null;
        iterator1=null;
    }
    // ------------------------------------------hasNext method------------------------------------------
    /**
     * <p><b>Summary</b>: hasNext method test case.</p>
     * <p>Test Case Design: Tests the critical case of an iterator of empty list.</p>
     * <p>Test Description: The iterator is created from empty list. All call of method hasNext() return false.</p>
     * <p>Pre-Condition: The list is empty. All support method worked</p>
     * <p>Post-Condition: The list is empty.</p>
     * <p>Expected Results: hasNext returns false, NoSuchElementException is thrown because the list is empty.</p>
     */
    @Test (expected = NoSuchElementException.class)
    public void test_HasNext_Empty()
    {
        iterator = list.listIterator();
        assertFalse("Empty list iterator shouldnt have next.",iterator.hasNext());
        iterator.next();
    }
    
    /**
     * <p><b>Summary</b>: hasNext method test case.
     * The method is forced in various occasion to verify some different case.</p>
     * <p>Test Case Design: Tests the method in various occasion.</p>
     * <p>Test Description: The iterator is created from list. All call of method hasNext() return the correct value.</p>
     * <p>Pre-Condition: The list contains{0-10}. All support method worked</p>
     * <p>Post-Condition: The list contains{0-10}.</p>
     * <p>Expected Results: The method worked perfect in all call.</p>
     */
    @Test 
    public void test_HasNext_DifferentCase()
    {
        for(int i=0;i<11;i++)
            list.add(i);
        iterator=list.listIterator();
        int i=0;
        while(iterator.hasNext())
        {
            assertEquals("the element attend is "+i,i,iterator.next());
            i++;
        }
        iterator=list.listIterator(1);
        assertTrue("the element attend is true",iterator.hasNext());
        iterator=list.listIterator(list.size());
        assertFalse("the element attend is false",iterator.hasNext());


    }
    
    // ------------------------------------------hasPrevious method------------------------------------------
    /**
     * <p><b>Summary</b>: hasPrevious method test case.</p>
     * <p>Test Case Design: Tests the critical case of an iterator of empty list.</p>
     * <p>Test Description: The iterator is created from empty list. All call of method hasPrevious() return false.</p>
     * <p>Pre-Condition: The list is empty. All support method worked</p>
     * <p>Post-Condition: The list is empty.</p>
     * <p>Expected Results: hasPrevious returns false, NoSuchElementException is thrown because the list is empty.</p>
     */
    @Test (expected = NoSuchElementException.class)
    public void test_HasPrev_Empty()
    {
        iterator = list.listIterator();
        assertFalse("Empty list iterator shouldnt have next.",iterator.hasPrevious());
        iterator.next();
    }
    
    /**
     * <p><b>Summary</b>: hasPrevious method test case.
     * The method is forced in various occasion to verify some different case.</p>
     * <p>Test Case Design: Tests the method in various occasion.</p>
     * <p>Test Description: The iterator is created from list. All call of method hasPrevious() return the correct value.</p>
     * <p>Pre-Condition: The list contains{0-10}. All support method worked</p>
     * <p>Post-Condition: The list contains{0-10}.</p>
     * <p>Expected Results: The method worked perfect in all call.</p>
     */
    @Test 
    public void test_HasPrev_DifferentCase()
    {
        for(int i=0;i<11;i++)
            list.add(i);
        iterator=list.listIterator(list.size());
        int i=10;
        while(iterator.hasPrevious())
        {
            assertEquals("the element attend is "+i,i,iterator.previous());
            i--;
        }
        iterator=list.listIterator(1);
        assertTrue("the element attend is true",iterator.hasPrevious());
        iterator=list.listIterator();
        assertFalse("the element attend is false",iterator.hasPrevious());
        iterator=list.listIterator(list.size());
        assertTrue("the element attend is true",iterator.hasPrevious());


    }
   
    //---------------------------------------------Next method---------------------------------------------
    /**
     * <p><b>Summary</b>: next method test case.
     * Test the critical case of invalid iterator.</p>
     * <p>Test Case Design: Try to use methdo add(Object) and remove() to invalidate the iterator. 
     * After call the method next to verify if lunch an exception.</p>
     * <p>Test Description: Test cis based on force the lunch of exception(IAE) by the method.</p>
     * <p>Pre-Condition: List contains {1-10}, iterator is valid. All support method workedworked.</p>
     * <p>Post-Condition: List contains {2,3,4,5,7,8,9,10,11}, iterator is not valid.</p>
     * <p>Expected Results: The method next() lunch IAE becuase the iterator is invalid.</p>
     */
    @Test (expected = IllegalArgumentException.class)
    public void test_Next_Exception_IAE()
    {
        for(int i=1;i<11;i++)
            list.add(i);
        iterator = list.listIterator();

        list.add(11);
        iterator.next();

        list.remove(0);
        iterator.next();
    }
    
    /**
     * <p><b>Summary</b>: next method test case.
     * Test the critical case of empty list.</p>
     * <p>Test Case Design: Try to call the method next() in a empty list.</p>
     * <p>Test Description: Test is based on force the lunch of exception(NSEE) by the method.</p>
     * <p>Pre-Condition: List is empty. iterator is valid. All support method worked.</p>
     * <p>Post-Condition: List is empty. iterator is not valid.</p>
     * <p>Expected Results: The method next() lunch NSEE becuase the iterator is invalid.</p>
     */
    @Test (expected = NoSuchElementException.class)
    public void test_Next_Exception_Empty()
    {
        iterator = list.listIterator();
        iterator.next();
    }
    
    /**
     * <p><b>Summary</b>: Next method test case.
     * The method is forced in various occasion to verify some different case.</p>
     * <p>Test Case Design: Tests the method in various occasion.</p>
     * <p>Test Description: The iterator is created from list. All call of method Next() return the correct value.</p>
     * <p>Pre-Condition: The list contains{0-10}. All support method worked</p>
     * <p>Post-Condition: The list contains{0-10}.</p>
     * <p>Expected Results: The method worked perfect in all call.</p>
     */
    @Test 
    public void test_Next_DifferentCase()
    {
        for(int i=0;i<11;i++)
            list.add(i);
        iterator=list.listIterator();
        int i=0;
        while(iterator.hasNext())
        {
            assertEquals("the element attend is "+i,i,iterator.next());
            i++;
        }
        iterator=list.listIterator(0);
        assertEquals("the element attend is 0",0,iterator.next());

        iterator=list.listIterator(list.size()-1);
        assertEquals("the element attend is 10",10,iterator.next());

        iterator=list.listIterator(5);
        assertEquals("the element attend is 5",5,iterator.next());




    }
    
    //---------------------------------------------Previous method---------------------------------------------

    /**
     * <p><b>Summary</b>: previous method test case.</p>
     * <p>Test Case Design:  If the list has structural changes when i invoked  method previous() that lunch an 
     * exception catch by the method (IAE IllegalArgumentException).</p>
     * <p>Test Description: Test creates a list, and the iterator method is called. 
     * Modify the list with add e remove method. Iterator became invalid . Next method is invoked.</p>
     * <p>Pre-Condition: List contains {1:10}, iterator is valid.</p>
     * <p>Post-Condition: List contains {2,3,4,5,7,8,9,10,11}, iterator is not valid.</p>
     * <p>Expected Results: IllegalArgumentException is thrown by the method(lunch by previous()).</p>
     */
    @Test (expected = IllegalArgumentException.class)
    public void test_Previous_Exception()
    {
        for(int i=1;i<11;i++)
            list.add(i);
        iterator = list.listIterator(5);
        list.add(11);
        iterator.previous();

        list.remove(0);
        iterator.previous();
    }

    /**
     * <p><b>Summary</b>: previous method test case.
     * Test the critical case of empty list.</p>
     * <p>Test Case Design: Try to call the method previous() in a empty list.</p>
     * <p>Test Description: Test is based on force the lunch of exception(NSEE) by the method.</p>
     * <p>Pre-Condition: List is empty. iterator is valid. All support method worked.</p>
     * <p>Post-Condition: List is empty. iterator is not valid.</p>
     * <p>Expected Results: The method previous() lunch NSEE becuase the iterator is invalid.</p>
     */
    @Test (expected = NoSuchElementException.class)
    public void test_Previous_Exception_Empty()
    {
        iterator = list.listIterator();
        iterator.previous();
    }
    
    /**
     * <p><b>Summary</b>: nextIndex test case.
     * Tests the method in a list containing 100 elements.</p>
     * <p>Test Case Design: For each element, nextIndex should return
     * the next element returned index.</p>
     * <p>Test Description: List contains {0-100}. The method nextIndex should return the index of next call.</p>
     * <p>Pre-Condition: List contains {0-100}.</p>
     * <p>Post-Condition: List is unchanged.</p>
     * <p>Expected Results: nextIndex returns the next element returned
     * index. List is unchanged.</p>
     */
    @Test
    public void test_NextIndex()
    {
        for(int i=0;i<101;i++)
            list.add(i);

        int index = 0;
        iterator = list.listIterator();
        while (iterator.hasNext())//end when hasNext return false
        {
            assertEquals(index++, iterator.nextIndex());
            iterator.next();
        }
        HList temp = new ListAdapter();
        for(int i=0;i<101;i++)
            temp.add(i);
        assertTrue("List shouldnt change after use.",list.equals(temp));
    }

    //------------------------------------------ set method ------------------------------------------
    /**
     * <p><b>Summary</b>: set method test case.
     * set method is invoked on an iterator in the critical case empty list</p>
     * <p><b>Test Case Design</b>: As the list is empty all method call throws IllegalStateException.</p>
     * <p><b>Test Description</b>: set is invoked on iterator.</p>
     * <p><b>Pre-Condition</b>: List is empty. The support method worked</p>
     * <p><b>Post-Condition</b>: List is still empty.</p>
     * <p><b>Expected Results</b>: HIllegalStateException is thrown.</p>
     */
    @Test (expected = IllegalStateException.class)
    public void test_Set_Exception()
    {
        iterator = list.listIterator();
        iterator.set(0);
    }

    /**
     * <p><b>Summary</b>: set method test case.
     * Test an critical case that lunch an exception.</p>
     * <p><b>Test Case Design</b>: Tests if the method lunch ISE when is call set in an invalid position.</p>
     * <p><b>Test Description</b>: remove and add is invoked by the iterator of list.</p>
     * <p><b>Pre-Condition</b>: List has 1 element. ALl support method worked.</p>
     * <p><b>Post-Condition</b>: List still has 1 element.</p>
     * <p><b>Expected Results</b>: the method lunch ISE because add and remove put the iterator on an invalid position</p>
     */
    @Test (expected = IllegalStateException.class)
    public void test_Set_Add_Remove()
    {
        iterator = list.listIterator();
        iterator.add(0);
        iterator.set(1);

        iterator.remove();
        iterator.set(1);

    }  

    /**
     * <p><b>Summary</b>: set method test case.
     * Fill the list with data and after use the set method.</p>
     * <p><b>Test Case Design</b>: List contains {100} 100 times,
     * then an iterator iterates through it and sets all
     * the elements to their index. Set is tested with each element
     * in the list.</p>
     * <p><b>Test Description</b>: Use the method set to change the list.</p>
     * <p><b>Pre-Condition</b>: List contains 100 elements. All support method worked.</p>
     * <p><b>Post-Condition</b>: List contains 100 element {0-100}.</p>
     * <p><b>Expected Results</b>: The list contains the correct value. 
     * The assertEquals return true with list specific.</p>
     */
    @Test
    public void test_Set_All()
    {
        
        for (int i = 0; i < 100; i++)
            list.add(1);

        iterator = list.listIterator();
        int i = 0;
        while (iterator.hasNext())
        {
            assertEquals("Should be 1 in all occurance.", 1, iterator.next());
            iterator.set(i);
            i++;
        }

        for (i = 0; i < 100; i++)
            list.add(i);
        assertEquals("the list should be the same",list, list);

    }

    /**
     * <p><b>Summary</b>: set method test case.
     * Fill the list with data and after use the set method.</p>
     * <p><b>Test Case Design</b>: List contains {100} 100 times,
     * then an iterator iterates through it and sets all
     * the elements to their index. Set is tested with each element
     * in the list.</p>
     * <p><b>Test Description</b>: Use the method set to change the list.</p>
     * <p><b>Pre-Condition</b>: List contains 100 elements. All support method worked.</p>
     * <p><b>Post-Condition</b>: List contains 100 element {0-100}.</p>
     * <p><b>Expected Results</b>: The list contains the correct value. 
     * The method worked and list(mid) return 49.The second assert return the value set before (199)</p>
     */
    @Test
    public void test_Set_Mid()
    {
        
        for (int i = 0; i < 100; i++)
            list.add(i);

        iterator = list.listIterator();
        int mid= 49;
        assertEquals("the method should return 49.",49, list.set(mid, 199));
        assertEquals("the new 49 position is occuped by 199", 199,list.get(mid));
        

    }

    /**
     * <p><b>Summary</b>: set methods test case.</p>
     * <p><b>Test Case Design</b>: Tests the iterator with a combination of some method.</p>
     * <p><b>Test Description</b>: The list is modified some times and after call the method set. 
     * Now check if the method worked in stressed occasion.</p>
     * <p><b>Pre-Condition</b>: The list is empty. ALl support method worked.</p>
     * <p><b>Post-Condition</b>: The list contains "abc".</p>
     * <p><b>Expected Results</b>: In all occasion the method set worked correctly.</p>
     */
    @Test
    public void test_Set_Mix()
    {
        
        iterator = list.listIterator();
        iterator.add("the");
        iterator.add("pen");
        assertEquals("pen", iterator.previous());
        iterator.remove();
        iterator.add("table");

        String temp = "";
        while (iterator.hasPrevious())
            temp += iterator.previous();
        assertEquals("tablethe", temp);

        iterator.next();
        iterator.set("try");
        iterator.next();
        iterator.set("again");
        
        temp = "";
        while (iterator.hasPrevious())
            temp += iterator.previous();
        assertEquals("againtry", temp);

        //reverse
        temp="";
        while(iterator.hasPrevious())
            iterator.previous();

        while (iterator.hasNext())
            temp += iterator.next();
            assertEquals("tryagain", temp);
    }

    // ------------------------------------------ previousIndex method ------------------------------------------
    /**
     * <p><b>Summary</b>: previousIndex test case.
     * Tests the method in different occasion.</p>
     * <p><b>Test Case Design</b>: Test the iterator previousIndex method in various occasion.</p>
     * <p><b>Test Description</b>: THe method is invoked in some case. </p>
     * <p><b>Pre-Condition</b>: List contains {0-100}. All support method worked.</p>
     * <p><b>Post-Condition</b>: List contains {0-100} .</p>
     * <p><b>Expected Results</b>: The method return the correct value in all occasion. The list is unchanged.</p>
     */
    @Test
    public void test_PreviousIndex_DifferentCase()
    {
        for(int i=0;i<101;i++)
            list.add(i);

        iterator = list.listIterator(list.size());//iterator on the last item
        assertEquals("previousIndex should be 100.", 100, iterator.previousIndex());

        iterator = list.listIterator(51);//in the middle
        assertEquals("previousIndex should be 50.", 50, iterator.previousIndex());


        iterator = list.listIterator(0);//iterator in the first position
        assertEquals("previousIndex should be -1.", -1, iterator.previousIndex());
        Object[] temp =new Object[101];
        for(int i=0;i<101;i++)
            temp[i]=i;
        assertArrayEquals("the array should be the same becuase the list is unchanged",temp, list.toArray());
    }

    /**
     * <p><b>Summary</b>: previousIndex test case.
     * Tests the method in critical case of empty list.</p>
     * <p><b>Test Case Design</b>: Test the critical case of empty list when invoked the method previous index.</p>
     * <p><b>Test Description</b>: THe method is invoked in the empty list. The method return an invalid index. </p>
     * <p><b>Pre-Condition</b>: List is empty. All support method worked.</p>
     * <p><b>Post-Condition</b>: List is empty .</p>
     * <p><b>Expected Results</b>: The method return -1 that is the index previous the first.</p>
     */
     @Test
    public void test_PreviousIndex_Empty()
    {
        iterator = list.listIterator();
        assertEquals("previousIndex should be -1.", -1, iterator.previousIndex());
    }

    // ------------------------------------------ nextIndex method ------------------------------------------
    /**
     * <p><b>Summary</b>: nextIndex test case.
     * Tests the method in an empty list limit case.</p>
     * <p>Test Case Design: Critical case of an empty list, the method nextIndex return list.size()</p>
     * <p>Test Description: the method nextIndex is invoked on an empty list. The method should return the size of the list(isEmpty).</p>
     * <p>Pre-Condition: List is empty. All support method worked.</p>
     * <p>Post-Condition: List is empty.</p>
     * <p>Expected Results: nextIndex equals size, beacuse there isnt element in the list</p>
     */
    @Test
    public void test_NextIndex_Empty()
    {
        iterator = list.listIterator();
        assertEquals("nextIndex should be the list size.", list.size(), iterator.nextIndex());
    }

    /**
     * <p><b>Summary</b>: nextIndex test case.
     * Tests the method in different occasion.</p>
     * <p><b>Test Case Design</b>: Test the iterator nextIndex method in various occasion.</p>
     * <p><b>Test Description</b>: THe method is invoked in some case. </p>
     * <p><b>Pre-Condition</b>: List contains {0-100}. All support method worked.</p>
     * <p><b>Post-Condition</b>: List contains {0-100} .</p>
     * <p><b>Expected Results</b>: The method return the correct value in all occasion. The list is unchanged.</p>
     */@Test
    public void test_NextIndex_DifferentCase()
    {
        for(int i=0;i<101;i++)
            list.add(i);

        iterator = list.listIterator(list.size());//iterator on the last item
        assertEquals("previousIndex should be 101.", 101, iterator.nextIndex());

        iterator = list.listIterator(50);//in the middle
        assertEquals("previousIndex should be 50.", 50, iterator.nextIndex());


        iterator = list.listIterator(0);//iterator in the first position
        assertEquals("previousIndex should be 0.", 0, iterator.nextIndex());
        Object[] temp =new Object[101];
        for(int i=0;i<101;i++)
            temp[i]=i;
        assertArrayEquals("the array should be the same becuase the list is unchanged",temp, list.toArray());
    }

    //----------------------------------------- remove method ------------------------------------------
    /**
     * <p><b>Summary</b>: remove method test case.
     * Test if the method lunch the exception.</p>
     * <p><b>Test Case Design</b>: Tests if based on force the method to lunch an exception (ISE).
     * The method is based on critical case empty list.</p>
     * <p><b>Test Description</b>: the method remove is invoked in a empty list.</p>
     * <p><b>Pre-Condition</b>: List is empty. All support method worked.</p>
     * <p><b>Post-Condition</b>: List is empty.</p>
     * <p><b>Expected Results</b>: the method lunch IllegalStateException.</p>
     */
    @Test (expected = IllegalStateException.class)
    public void test_Remove_Empty()
    {
        iterator = list.listIterator();
        iterator.remove();
    }

    /**
     * <p><b>Summary</b>: remove method test case.
     * Test if the method lunch the exception.</p>
     * <p><b>Test Case Design</b>: Tests is based on force the method to lunch an exception (ISE).
     * The method add in invoked before and after invoke remove.</p>
     * <p><b>Test Description</b>: the method remove is invoked in a empty list.</p>
     * <p><b>Pre-Condition</b>: List is empty.The iterator is valid. All support method worked.</p>
     * <p><b>Post-Condition</b>: List is empty.</p>
     * <p><b>Expected Results</b>: the method remove() lunch IllegalStateException because is applied on an invalid iterator.</p>
     */
    @Test (expected = IllegalStateException.class)
    public void test_Remove_Add_Combined_Exception()
    {
        iterator = list.listIterator();
        iterator.add(77);
        iterator.remove();
    }

    /**
     * <p><b>Summary</b>: remove method test case.
     * Test if the method worked in critical situation.</p>
     * <p><b>Test Case Design</b>: Tests is based on verify what happen when remove is invoked 
     * after add, but in the middle set the iterator on previous position(that is valid).</p>
     * <p><b>Test Description</b>: the method remove is invoked after add() with the iterator is put on the valid position.</p>
     * <p><b>Pre-Condition</b>: List is empty.The iterator is valid. All support method worked.</p>
     * <p><b>Post-Condition</b>: List is empty.The iterator is valid.</p>
     * <p><b>Expected Results</b>: the method worked perfect.</p>
     */
    @Test
    public void test_Remove_Add_Combined()
    {
        iterator = list.listIterator();
        iterator.add(77);
        iterator.add(123);
        assertEquals("the prev element is 123",123,iterator.previous());
        iterator.remove();
        assertEquals("the prev element is 77",77,iterator.previous());
        iterator.remove();
        assertEquals("the list size is 0",0, list.size());
    }

    /**
     * <p><b>Summary</b>: remove method test case.
     * Test if the method worked in the critical case dim1.</p>
     * <p><b>Test Case Design</b>: Tests is based on try what happen with list with one size..</p>
     * <p><b>Test Description</b>: the method remove is invoked after method add in one size list.</p>
     * <p><b>Pre-Condition</b>: List contains{77}. All support method worked.</p>
     * <p><b>Post-Condition</b>: List is empty.</p>
     * <p><b>Expected Results</b>: the method worked.</p>
     */
    @Test
    public void test_Remove_1E()
    {
        
        list.add(77);
        iterator = list.listIterator(1);
        iterator.previous();
        iterator.remove();
    }

    /**
     * <p><b>Summary</b>: remove method test case.
     * Test if the method worked in the critical case remove multiple.</p>
     * <p><b>Test Case Design</b>: Tests is based on try what happen when the method remove have multiple call.</p>
     * <p><b>Test Description</b>: the method remove is invoked after a remove call.</p>
     * <p><b>Pre-Condition</b>: List contains{77,123,17}. The iterator is valid. All support method worked.</p>
     * <p><b>Post-Condition</b>: The iterator is invalid</p>
     * <p><b>Expected Results</b>: the method lunch IllegalStateException .</p>
     */
    @Test (expected = IllegalStateException.class)
    public void test_Remove_Multiple_Exception()
    {
        
        list.add(77);
        list.add(123);
        list.add(17);
        iterator = list.listIterator(3);
        iterator.remove();
        iterator.remove();
    }

    /**
     * <p><b>Summary</b>: remove method test case.
     * Test if the method worked in the critical case remove multiple.</p>
     * <p><b>Test Case Design</b>: Tests is based on try what happen when the method remove have multiple call.</p>
     * <p><b>Test Description</b>: the method remove is invoked after a remove call(2 time).</p>
     * <p><b>Pre-Condition</b>: List contains{77,123,17}. The iterator is valid. All support method worked.</p>
     * <p><b>Post-Condition</b>: The list is empty. The iterator is valid</p>
     * <p><b>Expected Results</b>: the method worked.</p>
     */
    @Test 
    public void test_Remove_Multiple()
    {
        list.add(77);
        list.add(123);
        list.add(17);
        iterator = list.listIterator(3);
        iterator.previous();
        iterator.remove();
        iterator.previous();
        iterator.remove();
        iterator.previous();
        iterator.remove();
        assertArrayEquals("the array should be the same",new Object[]{}, list.toArray());
    }

    //----------------------------------------- add method ------------------------------------------
    /**
     * <p><b>Summary</b>: add method test case.
     * Test if the method worked in the critical case add multiple.</p>
     * <p><b>Test Case Design</b>: Tests is based on try what happen when the method add have multiple call.</p>
     * <p><b>Test Description</b>: the method add is invoked after a add call(2 time).</p>
     * <p><b>Pre-Condition</b>: List is empty. The iterator is valid. All support method worked.</p>
     * <p><b>Post-Condition</b>: The list contains{17,123,77}. The iterator is valid</p>
     * <p><b>Expected Results</b>: the method worked.</p>
     */
    @Test 
    public void test_Add_Multiple()
    {
        iterator = list.listIterator();
        iterator.add(77);
        iterator.add(123);
        iterator.add(17);

        assertArrayEquals("the array should be the same",new Object[]{77,123,17}, list.toArray());
    }

    /**
     * <p><b>Summary</b>: add method test case.
     * Test if the method worked in the critical case empty list.</p>
     * <p><b>Test Case Design</b>: Tests is based on try what happen with list with one size..</p>
     * <p><b>Test Description</b>: the method add is invoked on a empty list.</p>
     * <p><b>Pre-Condition</b>: List is empty. The iterator is valid. All support method worked.</p>
     * <p><b>Post-Condition</b>: List contains {123}. The iterator is valid.</p>
     * <p><b>Expected Results</b>: the method worked.</p>
     */
    @Test
    public void test_Add_Empty()
    {
        iterator = list.listIterator();
        iterator.add(123);
    }

    //----------------------------------------- mixed method------------------------------------------

    /**
     * <p><b>Summary</b>: mixed method test case.
     * Test if the combination of iterator method worked.</p>
     * <p><b>Test Case Design</b>: Tests is based on try method in stressed situation.</p>
     * <p><b>Test Description</b>: Do some operation with iteratpr and controll if combination worked..</p>
     * <p><b>Pre-Condition</b>: List is empty. The iterator is valid. All support method worked.</p>
     * <p><b>Post-Condition</b>: The list is empty. The iterator is valid</p>
     * <p><b>Expected Results</b>: The combination of method worked.</p>
     */
    @Test
    public void test_mixed()
    {
        list.add(77);
        iterator=list.listIterator();
        iterator.add(1);
        assertEquals("the elem should be 77", 77,iterator.next());
        iterator=list.listIterator(1);
        assertEquals("the method should return 1",iterator.previous(),1);
        iterator.add(28);
        assertArrayEquals("the array should be the same",new Object[]{28,1,77}, list.toArray());
        
        iterator =list.listIterator();
        iterator.add("a");//add "a" as first
        iterator.next();
        iterator.remove();//remove 28
        assertArrayEquals("the array should be the same",new Object[]{"a",1,77}, list.toArray());

        assertTrue("the method should return true",iterator.hasNext());
        iterator =list.listIterator();
        assertFalse("the method should return false",iterator.hasPrevious());
        assertTrue("the method should return true",iterator.hasNext());

    }

    /**
     * <p><b>Summary</b>: mixed method test case.
     * Test if the combination of iterator method worked.</p>
     * <p><b>Test Case Design</b>: Tests is based on try method in stressed situation.</p>
     * <p><b>Test Description</b>: Do some operation with iteratpr and controll if combination worked..</p>
     * <p><b>Pre-Condition</b>: List is empty. The iterator is valid. All support method worked.</p>
     * <p><b>Post-Condition</b>: The list is empty. The iterator is valid</p>
     * <p><b>Expected Results</b>: The combination of method worked.</p>
     */
    @Test(expected = NoSuchElementException.class)
    public void test_mixed2()
    {
        iterator=list.listIterator();
        iterator1=list1.listIterator();
        iterator1.add(77);
        iterator.add(1);
        assertEquals("the elem should be 1", 1,iterator.previous());
        assertEquals("the elem should be 77", 77,iterator1.previous());
        assertNotEquals("the hashcode shouldnt be the same",iterator1.hashCode(), iterator.hashCode());

        iterator.remove();
        iterator1.remove();
        assertNotEquals("the hashcode shouldnt be the same",iterator1.hashCode(), iterator.hashCode());

        iterator.previous();
    }

    /**
     * <p><b>Summary</b>: mixed method test case.
     * Test if the combination of iterator method worked.</p>
     * <p><b>Test Case Design</b>: Tests is based on try method in stressed situation.</p>
     * <p><b>Test Description</b>: Do some operation with iteratpr and controll if combination worked..</p>
     * <p><b>Pre-Condition</b>: List is empty. The iterator is valid. All support method worked.</p>
     * <p><b>Post-Condition</b>: The list is empty. The iterator is valid</p>
     * <p><b>Expected Results</b>: The combination of method worked.</p>
     */
    @Test(expected = IllegalStateException.class)
    public void test_mixed3()
    {
        iterator=list.listIterator();
        iterator1=list1.listIterator();
        iterator1.add(77);
        iterator.add(1);
        assertEquals("the elem should be 1", 1,iterator.previous());
        assertEquals("the elem should be 77", 77,iterator1.previous());
        assertNotEquals("the hashcode shouldnt be the same",iterator1.hashCode(), iterator.hashCode());

        iterator.remove();
        iterator1.remove();
        assertNotEquals("the hashcode shouldnt be the same",iterator1.hashCode(), iterator.hashCode());

        iterator.add(1);
        iterator.remove();
    }

    /**
     * <p><b>Summary</b>: mixed method test case.
     * Test if the combination of iterator method worked.</p>
     * <p><b>Test Case Design</b>: Tests is based on try method in stressed situation.</p>
     * <p><b>Test Description</b>: Do some operation with iteratpr and controll if combination worked..</p>
     * <p><b>Pre-Condition</b>: List is empty. The iterator is valid. All support method worked.</p>
     * <p><b>Post-Condition</b>: The list is empty. The iterator is valid</p>
     * <p><b>Expected Results</b>: The combination of method worked.</p>
     */
    @Test
    public void test_mixed4()
    {
        iterator=list.listIterator();
        for(int i=0;i<101;i++)
            iterator.add(i);
        iterator=list.listIterator(50);
        assertEquals("the elemet should be 50",50,iterator.next());
        iterator.remove();
        assertEquals("the element should be 51",list.get(50), 51);
        list.clear();
        iterator=list.listIterator();
        iterator.add(1);
        assertArrayEquals("the array should be the same",new Object[]{1}, list.toArray());

    }

}
