package myTest;

//import package testjunit and myAdapter
import myAdapter.*;
import org.junit.Before;
import org.junit.Test;

//import the assert
import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;


import org.junit.After;
/**
 * <p><b>Summary:</b>test suite of list method.
 * All test is invoked in a ListAdapter. All test is used for verify all method of this class.
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
 * <li>public void myTest.TestSuiteOfList.setup()</li>
 * <li>public static void myTest.TestSuiteOfList.iterate(myAdapter.HListIterator)</li>
 * <li>public void myTest.TestSuiteOfList.test_RemoveAll_Range()</li>
 * <li>public void myTest.TestSuiteOfList.test_Constructor_CollNull()</li>
 * <li>public void myTest.TestSuiteOfList.test_Add_DifferentValue()</li>
 * <li>public void myTest.TestSuiteOfList.test_Constructor_Coll()</li>
 * <li>public void myTest.TestSuiteOfList.test_Constructor_CollEmpty()</li>
 * <li>public void myTest.TestSuiteOfList.test_Size_DifferentValue()</li>
 * <li>public void myTest.TestSuiteOfList.test_ToArray_ArrayTarget_NULL()</li>
 * <li>public void myTest.TestSuiteOfList.test_RemoveAll_EmptyColl()</li>
 * <li>public void myTest.TestSuiteOfList.test_Clear_1Element()</li>
 * <li>public void myTest.TestSuiteOfList.test_RemoveAll_EmptyList()</li>
 * <li>public void myTest.TestSuiteOfList.test_RemoveAddMixed()</li>
 * <li>public void myTest.TestSuiteOfList.test_RetainAll_Empty()</li>
 * <li>public void myTest.TestSuiteOfList.test_RetainAll_DifferentCase()</li>
 * <li>public void myTest.TestSuiteOfList.test_ToArray_ArrayTarget_Small()</li>
 * <li>public void myTest.TestSuiteOfList.test_ContainsAll_EmptyColl()</li>
 * <li>public void myTest.TestSuiteOfList.test_RemoveAll_Duplicates()</li>
 * <li>public void myTest.TestSuiteOfList.test_Clear_DifferentCase()</li>
 * <li>public void myTest.TestSuiteOfList.test_Remove_fromEmpty()</li>
 * <li>public void myTest.TestSuiteOfList.test_Remove_notInLIst()</li>
 * <li>public void myTest.TestSuiteOfList.test_ToArray_EmptyArray()</li>
 * <li>public void myTest.TestSuiteOfList.test_ContainsAll_NotElem()</li>
 * <li>public void myTest.TestSuiteOfList.test_ContainsAll_TueOrFalse()</li>
 * <li>public void myTest.TestSuiteOfList.test_Contains_NullElem()</li>
 * <li>public void myTest.TestSuiteOfList.test_Contains_Range()</li>
 * <li>public void myTest.TestSuiteOfList.test_ToArray_FillWithData()</li>
 * <li>public void myTest.TestSuiteOfList.test_ToArray_ArrayArg_1()</li>
 * <li>public void myTest.TestSuiteOfList.test_RetainAll_Null()</li>
 * <li>public void myTest.TestSuiteOfList.test_RetainAll_BothDuplicate()</li>
 * <li>public void myTest.TestSuiteOfList.test_RetainAll_CollDuplicate()</li>
 * <li>public void myTest.TestSuiteOfList.test_ContainsAll_Nullcoll()</li>
 * <li>public void myTest.TestSuiteOfList.test_AddIndex_DifferentValue()</li>
 * <li>public void myTest.TestSuiteOfList.test_IndexOf_NotRange()</li>
 * <li>public void myTest.TestSuiteOfList.test_LastIndexOf_Generic()</li>
 * <li>public void myTest.TestSuiteOfList.test_IndexOf_Generic()</li>
 * <li>public void myTest.TestSuiteOfList.test_LastIndexOf_NotRange()</li>
 * <li>public void myTest.TestSuiteOfList.test_IndexOf_Duplicates()</li>
 * <li>public void myTest.TestSuiteOfList.test_LastIndexOf_Duplicates()</li>
 * <li>public void myTest.TestSuiteOfList.test_RecursiveSublist()</li>
 * <li>public static void myTest.TestSuiteOfList.beforeClassMethod()</li>
 * <li>public void myTest.TestSuiteOfList.test_Constructor_()</li>
 * <li>public void myTest.TestSuiteOfList.test_Size_Empty()</li>
 * <li>public void myTest.TestSuiteOfList.Clear()</li>
 * <li>public void myTest.TestSuiteOfList.test_Size_1()</li>
 * <li>public void myTest.TestSuiteOfList.testSize()</li>
 * <li>public void myTest.TestSuiteOfList.test_Add_1()</li>
 * <li>public void myTest.TestSuiteOfList.test_AddIndex_Mid()</li>
 * <li>public void myTest.TestSuiteOfList.test_Add_1_Empty()</li>
 * <li>public void myTest.TestSuiteOfList.test_AddAll_Null()</li>
 * <li>public void myTest.TestSuiteOfList.test_isEmpty_0()</li>
 * <li>public void myTest.TestSuiteOfList.test_Contains_Elem()</li>
 * <li>public void myTest.TestSuiteOfList.test_AddAll_0()</li>
 * <li>public void myTest.TestSuiteOfList.test_Clear()</li>
 * <li>public void myTest.TestSuiteOfList.test_AddAll()</li>
 * <li>public void myTest.TestSuiteOfList.test_Clear_Empty()</li>
 * <li>public void myTest.TestSuiteOfList.test_isEmpty()</li>
 * <li>public void myTest.TestSuiteOfList.test_ToArray_0to39()</li>
 * <li>public void myTest.TestSuiteOfList.testToArray()</li>
 * <li>public void myTest.TestSuiteOfList.test_RemoveAll_()</li>
 * <li>public void myTest.TestSuiteOfList.test_Remove_first()</li>
 * <li>public void myTest.TestSuiteOfList.test_Set_Exception()</li>
 * <li>public void myTest.TestSuiteOfList.test_HashCode_Null()</li>
 * <li>public void myTest.TestSuiteOfList.test_HashCode_Same()</li>
 * <li>public void myTest.TestSuiteOfList.test_Set_Range()</li>
 * <li>public void myTest.TestSuiteOfList.test_HashCode()</li>
 * <li>public void myTest.TestSuiteOfList.test_Set_Generic()</li>
 * <li>public void myTest.TestSuiteOfList.test_Mixed1()</li>
 * <li>public void myTest.TestSuiteOfList.test_Mixed4()</li>
 * <li>public void myTest.TestSuiteOfList.test_Mixed3()</li>
 * <li>public void myTest.TestSuiteOfList.test_Mixed2()</li>
 * </ul>
 * <p><b>Test Suite Execution Records:</b>
 *  All test has been correctly execute.</p>
 * <p><b>Execution Variable:</b> There arent execution variables.</p>
 * @see TestSuiteOfSubList
 * @see TestSuiteOfList
 * 
 */
public class TestSuiteOfList{

    HCollection coll;
    private HList list, listWithData;
    static String[] argv = {"pippo", "qui", "pluto", "paperino", "qui", "ciccio"};
    HListIterator li;
    /**
     * <p><b>Summary</b>:setup the variables.</p>
     */
    @Before
    public void setup()
    {
        coll = new ListAdapter();
        list = new ListAdapter();
        listWithData = new ListAdapter();

        for (int i = 0; i < 5; i++)
            listWithData.add(i + 1);
        li=null;
    }
    /*
    @BeforeClass
    public static void beforeClassMethod()
    {

        try
        {
            Class tsli= TestSuiteOfList.class;
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
     * <p><b>Summary</b>:set to null all item used</p>
     */
    @After
    public void Clear()
    {
        coll=null;
        list=null;
        listWithData=null;
        li=null;
        
    }
    // -----------------------------------------test of constructor----------------------------------------
    
    /**
     * <p><b>Summary</b>:costructor method test case. 
     * The test case is based on costructor check</p>
     * <p>Test Case Design:The design use assert to verify the costructor.</p>
     * <p>Test Description: Test check the default costructor.</p>
     * <p>Pre-Condition: The list is empty. All support method worked.</p>
     * <p>Post-Condition: the list is empty</p>
     * <p>Expected Results: The default costructor worked. The method toArray should return the same array.</p>
     */
    @Test
    public void test_Constructor_() 
    {
        assertArrayEquals("the default constructor should be work", new ListAdapter().toArray(),list.toArray());
    }

    /**
     * <p><b>Summary</b>: costructor method test case. 
     * The test case is based on costructor  by collection check</p>
     * <p>Test Case Design:The design use assert to verify the costructor by collection.</p>
     * <p>Test Description: Test check the costructor with parametre.</p>
     * <p>Pre-Condition: The list is empty. ListwithData contains {1,2,3,4,5}. All support method worked.</p>
     * <p>Post-Condition: the list contains {1,2,3,4,5}</p>
     * <p>Expected Results: The costructor by collection work. The method toArray should return the same array.</p>
     */
    @Test
    public void test_Constructor_Coll() 
    {
        for(int i=1;i<6;i++)
            coll.add(i);
        list= new ListAdapter(coll);
        assertArrayEquals("the constructor by coll should be return the same array", listWithData.toArray(),list.toArray());
    }

    /**
     * <p><b>Summary</b>: costructor method test case. 
     * The test case is based on costructor by collection check</p>
     * <p>Test Case Design:The design use assert to verify the costructor by collection in the critical case collection null.</p>
     * <p>Test Description: Test check the costructor with parametre when coll is null.</p>
     * <p>Pre-Condition: The list is empty. coll is null.</p>
     * <p>Post-Condition: the list is empty.</p>
     * <p>Expected Results: The costructor by collection return NUllPoinetrException (NPE).</p>
     */
    @Test (expected = NullPointerException.class)
    public void test_Constructor_CollNull() 
    {
        coll= null;
        list= new ListAdapter(coll);//return exception
    }

    /**
     * <p><b>Summary</b>: costructor method test case. 
     * The test case is based on costructor by collection check</p>
     * <p>Test Case Design:The design use assert to verify the costructor by collection in the critical case collection empty.</p>
     * <p>Test Description: Test check the costructor with parametre when coll is empty.</p>
     * <p>Pre-Condition: The list is empty. coll is empty.</p>
     * <p>Post-Condition: the list is empty.</p>
     * <p>Expected Results: The costructor by collection return true checked with an empty array.</p>
     */
    @Test 
    public void test_Constructor_CollEmpty() 
    {
        list = new ListAdapter(coll);
        assertArrayEquals("the array should be the same",new Object[]{}, list.toArray());
    }
  
    // -----------------------------------------test of method size----------------------------------------
    
    /**
     * <p><b>Summary</b>: size method test case. 
     * The test case assert if after some operation the method size return the correct value</p>
     * <p>Test Case Design:The design use assert to verify the method size(). 
     * From Sommerville:"Test method combined with other method (add(Object),remove(Object) and clear())</p>
     * <p>Test Description: Test is used with a generic case of operation with list</p>
     * <p>Pre-Condition: The method add(Object), remove(Object) and clear() worked. 
     * The list is empty at the beginning.</p>
     * <p>Post-Condition: The list is empty after the call of method clear()</p>
     * <p>Expected Results: The size method returns the correct result in all of case tested.</p>
     */
    @Test
    public void testSize() 
    {
        assertEquals("the size of the list should be zero",0, list.size());
        list.add(1);
        list.add(2);
        assertEquals("the size of the list should be two",2, list.size());
        list.remove(1);
        assertEquals("the size of the list should be one",1, list.size());
        list.clear();
        assertEquals("the size of the list should be zero",0, list.size());
    }

    /**
     * <p><b>Summary</b>: size method test case. 
     * The test case asserts if the method size worked. Use doubble check with method isEmpty().</p>
     * <p>Test Case Design: The design is a simple assert for verify the method. Call the method size in a empty list. 
     * From Sommerville: "Test with sequences of zero lenght."</p>
     * <p>Test Description: Test based on critical case "list with zero size". 
     * The test is based on verify if size worked and isnt modify the list.</p>
     * <p>Pre-Condition: The method isEmpty() worked. The list is empty.</p>
     * <p>Post-Condition: The list is still empty.</p>
     * <p>Expected Results: The size method zero and the method is empty return true</p>
     */
    @Test
    public void test_Size_Empty()
    {
        assertEquals("the list is empty,and size return zero", 0, list.size());
        assertTrue("return true if the size of empty list is zero", list.isEmpty());
    }

    /**
     * <p><b>Summary</b>: size method test case. 
     * The test is based on verify method size in the list with different size(1000/100/10)</p>
     * <p>Test Case Design: The design is a simple assert of a size call with a large number of data. 
     * From Sommerville: "Test with sequences of different size."</p>
     * <p>Test Description: Test based on a specific list with 1000/100/10 elements and call size for 
     * compare the expect value with the true value.</p>
     * <p>Pre-Condition: The method clear() and add(Object) worked. The list is empty.</p>
     * <p>Post-Condition: The list have 10 elements.</p>
     * <p>Expected Results: The size method returns 1000/100/10.</p>
     */
    @Test
    public void test_Size_DifferentValue()
    {
        for (int i = 1; i <= 1000; i++)//insert data
            list.add(i);
        assertEquals("the list size is 1000", 1000, list.size());
        list.clear();
        for (int i = 1; i <= 100; i++)//insert data
            list.add(i);
            assertEquals("the list size is 100", 100, list.size());
            list.clear();
        for (int i = 1; i <= 10; i++)//insert data
            list.add(i);
            assertEquals("the list size is 100", 10, list.size());        
        }

    /**
     * <p><b>Summary</b>: size method test case. 
     * The test case asserts if the method worked with the list with size 1. The list is modified before the asserts with add(Object).</p>
     * <p>Test Case Design: The design is a simple assert of a size call and expected 1 size and not being empty. 
     * From Sommerville: "Test software with sequences of a single value"</p>
     * <p>Test Description: Test based on the test of critical case "list with one element"</p>
     * <p>Pre-Condition: The list contains {1}. All support method worked.</p>
     * <p>Post-Condition: The list contains {1}.</p>
     * <p>Expected Results: The size method returns 1 and the isEmpty method returns false.</p>
     */
    @Test
    public void test_Size_1()
    {
        list.add(1);
        assertEquals("the list have a size of one ", 1, list.size());
        assertFalse("the method is empty return false because size of list is 1", list.isEmpty());
    }
    
    // ------------------------------------------test of methods add ------------------------------------------

    /**
     * <p><b>Summary</b>: add method test case. 
     * The test case asserts if the method worked when add to empty list</p>
     * <p>Test Case Design: The design is a simple assert of add call in empty list. 
     * From Sommerville: "Test software with sequences of a single value"</p>
     * <p>Test Description: Test based on the test of critical case "list with one element"</p>
     * <p>Pre-Condition: All support method worked. The list is empty.</p>
     * <p>Post-Condition: The list contains {10}.</p>
     * <p>Expected Results: The method add return true. The method isEmpty return true before and false after the method add.</p>

     */
    @Test
    public void test_Add_1()
    {
        assertTrue("the list is empty if return true", list.isEmpty());
        assertTrue("the method add should be return true",list.add(10));
        assertFalse("the list is empty if return false", list.isEmpty());
        assertEquals("the size of list should be 1", 1, list.size());
    }

    /**
     * <p><b>Summary</b>: add method test case. 
     * The test case asserts if the method worked when add different number of element 1000/100/10</p>
     * <p>Test Case Design: The design is a simple assert of add different number of datas. 
     * From Sommerville: "Test with sequences of different size."</p>
     * <p>Test Description: Test based on a specific list with 1000/100/10 elements</p>
     * <p>Pre-Condition: All support method worked. The list is empty.</p>
     * <p>Post-Condition: The list has 10 element.</p>
     * <p>Expected Results: The add method worked in different type of add sequences.</p>
     */
    @Test
    public void test_Add_DifferentValue()
    {
        for(int i=1;i<=1000;i++)
            assertTrue("the assert should return true",list.add(i));
        list.clear();
        for(int i=1;i<=100;i++)
            assertTrue("the assert should return true",list.add(i));
        list.clear();
        for(int i=1;i<=10;i++)
            assertTrue("the assert should return true",list.add(i));
            
        assertEquals("the list size is 10",10, list.size());
    }
    
    /**
     * <p><b>Summary</b>: add method test case. 
     * The test case asserts if the method worked when add to empty list</p>
     * <p>Test Case Design: The design is a simple assert of add call in empty list. 
     * From Sommerville: "Test software with sequences of a single value"</p>
     * <p>Test Description: Test based on the test of critical case "list with one element"</p>
     * <p>Pre-Condition: All support method worked. The list is empty.</p>
     * <p>Post-Condition: The list contains {10}.</p>
     * <p>Expected Results: The method add return true.</p>

     */
    @Test
    public void test_Add_1_Empty()
    {
        assertTrue("the list is empty if return true", list.isEmpty());
        list.add(0,10);
        assertEquals("the element should be 10",10, list.get(0));
    }

    /**
     * <p><b>Summary</b>: add method test case. 
     * The test case asserts if the method worked when add number in different 1000/100/10</p>
     * <p>Test Case Design: The design is a simple assert of add number in different position. 
     * From Sommerville: "Test with sequences of different size."</p>
     * <p>Test Description: Test based on a list fill with data and after add element in position(1000/100/10) new data </p>
     * <p>Pre-Condition: All support method worked. The list is empty.</p>
     * <p>Post-Condition: The list has 10 element.</p>
     * <p>Expected Results: The method worked in all situation.</p>
     */
    @Test
    public void test_AddIndex_DifferentValue()
    {
        for(int i=1;i<1000;i++)
            list.add(i);
        list.add(999, "a");
        assertEquals("the element at position 1000 is 'a' ","a", list.get(999));
        list.clear();

        for(int i=1;i<100;i++)
            list.add(i);
        list.add(99, "a");
        assertEquals("the element at position 1000 is 'a' ","a", list.get(99));
        list.clear();

        for(int i=1;i<10;i++)
            list.add(i);
        list.add(9, "a");
        assertEquals("the element at position 1000 is 'a' ","a", list.get(9));
        assertEquals("the list should be size of 10", 10, list.size());
        
    }

    /**
     * <p><b>Summary</b>: add method test case. 
     * The test case asserts if the method worked when add number in the middle</p>
     * <p>Test Case Design: The design is a simple assert of add number in different position(middle). 
     * From Sommerville: "Test with sequences of different size."</p>
     * <p>Test Description: Test based on a list fill with data and after add element in position(middle)</p>
     * <p>Pre-Condition: All support method worked. The list is empty.</p>
     * <p>Post-Condition: The list is empty.</p>
     * <p>Expected Results: The method worked with different type of add sequences.</p>
     */
    @Test
    public void test_AddIndex_Mid()
    {
        for(int i=1;i<20;i++)
            list.add(i);
        int middle = 9;
        list.add(middle, "a");
        assertEquals("the element in the middle position is 'a' ","a", list.get(9));
        list.clear();
        assertTrue("the list is empty return true", list.isEmpty());
        
    }

    /**
     * <p><b>Summary</b>: addAll method test case. 
     * The test case asserts if the method worked when use a collection of Object.</p>
     * <p>Test Case Design: The design is a simple assert with collection of number from 1 to 10. 
     * From Sommerville: "Test with sequences of different size."</p>
     * <p>Test Description: Test based on a collection fill with data and after with the method addAll(collection) 
     * put all data in the list.</p>
     * <p>Pre-Condition: The list and the collection are empty. All support method worked.</p>
     * <p>Post-Condition: The list contains all element of collection.</p>
     * <p>Expected Results: The method containsAll(Collection) return true. If i compare the result of add(collection) and a specific array 
     * with the same data the result of assertarrayEquals is true.</p>
     */
    @Test
    public void test_AddAll()
    {
        for(int i=1;i<10;i++)
            coll.add(i);
        list.addAll(coll);
        assertArrayEquals("if the method worked the arrays should be the same",new Object[]{1,2,3,4,5,6,7,8,9}, list.toArray());
        assertTrue("the method contains(collection) should be return true", list.containsAll(coll));
        
    }

    /**
     * <p><b>Summary</b>: addAll method test case. 
     * The test case asserts if the method worked when use an empty collection</p>
     * <p>Test Case Design: The design is a simple assert with collection empty and second check with hashCode(). 
     * From Sommerville: "Test with sequence of zero length"</p>
     * <p>Test Description: Test based on a collection with size=0.</p>
     * <p>Pre-Condition: The list and the collection are empty. All support method worked.</p>
     * <p>Post-Condition: The list and collection is empty.</p>
     * <p>Expected Results: The method containsAll(Collection) return true. The method with that parametre didnt modify the list.</p>
     */
    @Test
    public void test_AddAll_0()
    {
        HList temp = list;
        list.addAll(coll);
        assertArrayEquals("if the method worked the arrays should be the same",new Object[]{}, list.toArray());
        assertTrue("the method contains(collection) should be return true", list.containsAll(coll));
        assertEquals("the method hashcode should return the same value",temp.hashCode(), list.hashCode());
        
    }
    
    /**
     * <p><b>Summary</b>: addAll method test case. 
     * The test is based on verify the method addAll in critical situation of null collection.</p>
     * <p>Test Case Design: The design is a simple assert with collection null. 
     * From Sommerville: "Test critical case(null poiter)"</p>
     * <p>Test Description: Test based on test if the collection passed as parametre didnt point to any object.</p>
     * <p>Pre-Condition: The list is empty. The collection is null. All support method worked.</p>
     * <p>Post-Condition: The list is empty and the coll is null.</p>
     * <p>Expected Results: The method catch the NUllPointerException lunch by addAll(collection).</p>
     */
    @Test
    public void test_AddAll_Null()
    {
        coll =null;
        try{
            list.addAll(coll);
            throw new Exception();
        }catch(Exception e)
        {
            assertEquals(NullPointerException.class, e.getClass());
        }
        
    }
      
    //-----------------------------------------test of is empty method------------------------------------
    
    /**
     * <p><b>Summary</b>: isEmpty method test case. 
     * The test case asserts if the method worked after use some method that modify the list.</p>
     * <p>Test Case Design: The design is a simple assert of isEmpty(). 
     * From Sommerville: "Test method combination"</p>
     * <p>Test Description: Test based on combination of method for modify list and verify the method isEmpty()</p>
     * <p>Pre-Condition: All support method worked. The list is empty.</p>
     * <p>Post-Condition: The list is empty.</p>
     * <p>Expected Results: The method isEmpty() return true at the beginning. If the size of list is @gt 1 return false</p>
     */
    @Test
    public void test_isEmpty() 
    {
        assertEquals("the list is empty",true, list.isEmpty());
        list.add(1);
        assertFalse("the method isEmpty should be return false", list.isEmpty());
        list.clear();
        assertTrue("the method isEmpty should be return true", list.isEmpty());
        assertEquals(true, list.isEmpty());
    }

    /**
     * <p><b>Summary</b>: isEmpty method test case. 
     * The test case asserts if the method worked.</p>
     * <p>Test Case Design: The design is a simple assert of isEmpty(). 
     * From Sommerville: "Test with critical case(empty list)"</p>
     * <p>Test Description: Test based on use assert to verify the method isEmpty().</p>
     * <p>Pre-Condition: All support method worked. The list is empty.</p>
     * <p>Post-Condition: The list is empty.</p>
     * <p>Expected Results: The method isEmpty() didnt modify the list. The method return true always.
     * The method size() return 0.</p>
     */
    @Test
    public void test_isEmpty_0() 
    {
        assertTrue("the method isEmpty should be return true", list.isEmpty());
        assertEquals("the method isEmpty should be return true",0, list.size());
    }

    // ------------------------------------------ clear method ------------------------------------------

    /**
     * <p><b>Summary</b>: clear method test case.
     * The test case assert if after call the method clear() the list is empty</p>
     * <p>Test Case Design:The design use assert to verify the method size(). 
     * From Sommerville:"Test method combined with other method (size() and add(Object))</p>
     * <p>Test Description: Test is used with a generic case of operation with list</p>
     * <p>Pre-Condition: All support method worked. The list is empty.</p>
     * <p>Post-Condition: The list is empty at the end</p>
     * <p>Expected Results: The size method returns 0, that is correct because clear() delete all element from list</p>
     */
    @Test
    public void test_Clear() 
    {
        assertEquals("the size of the list should be zero, bacause list is empty",0, list.size());
        list.add(1);
        assertEquals("the size of the list should be one, because I add an element",1, list.size());
        list.clear();
        assertEquals("the size of the list should be zero,after call the method",0, list.size());
    }
    
    /**
     * <p><b>Summary</b>: clear method test case.</p>
     * <p>Test Case Design: Invokes clear method on a list containing 1 element.</p>
     * <p>Test Description: Calls clear on the list. Now check if the method worked.
     * From Sommerville:" the with sequence of dimension 1"</p>
     * <p>Pre-Condition: List contains {100000}. All support method worked.</p>
     * <p>Post-Condition: List is empty.</p>
     * <p>Expected Results: isEmpty return true.The array return by toArray should be the same of empty array</p>
     */
    @Test
    public void test_Clear_1Element()
    {
        list.add(100000);
        list.clear();
        assertTrue("List should be empty.", list.isEmpty());
        assertArrayEquals("the array should be the same",list.toArray(), new Object[]{});
    }

    /**
     * <p><b>Summary</b>: clear method test case.
     * The test is based on verify the method clear from list in different case.</p>
     * <p>Test Case Design: Invokes clear method in different case of size and data.</p>
     * <p>Test Description: Calls clearin with various sequence.</p>
     * <p>Pre-Condition: List is empty. All support method worked. Coll contains {1-9}</p>
     * <p>Post-Condition: List is empty.</p>
     * <p>Expected Results: all time when the method is invoked worked correctly.</p>
     */
    @Test
    public void test_Clear_DifferentCase()
    {
        for(int i=1;i<10;i++)
            coll.add(i);
        list.clear();
        listWithData.clear();
        //list
        assertTrue("List should be empty.", list.isEmpty());
        assertArrayEquals("the array should be the same",list.toArray(), new Object[]{});
        //list with data
        assertTrue("List should be empty.", listWithData.isEmpty());
        assertArrayEquals("the array should be the same",listWithData.toArray(), new Object[]{});

        list.add("a");
        list.add("b");
        list.add("c");
        list.add(1);
        list.add(3);
        list.add(1891);

        assertFalse("List shouldnt be empty.", list.isEmpty());
        list.clear();
        //list
        assertTrue("List should be empty.", list.isEmpty());
        assertArrayEquals("the array should be the same",list.toArray(), new Object[]{});

        assertArrayEquals("the array should be the same",list.toArray(), listWithData.toArray());
    }

    /**
     * <p><b>Summary</b>: clear method test case.
     * The test is based on verify the method clear in critical case of empty list.</p>
     * <p>Test Case Design: Invokes clear method on a list empty.</p>
     * <p>Test Description: Calls clear in the critical case "empty list".</p>
     * <p>Pre-Condition: List is empty. All support method worked.</p>
     * <p>Post-Condition: List is empty.</p>
     * <p>Expected Results: isEmpty return true.The array return by toArray should be the same of empty array</p>
     */
    @Test
    public void test_Clear_Empty()
    {
        list.clear();
        assertTrue("List should be empty.", list.isEmpty());
        assertArrayEquals("the array should be the same",list.toArray(), new Object[]{});
    }

    //-----------------------------------------test of contains method------------------------------------
    
    /**
     * <p><b>Summary</b>: contains method test case.
     * The test case checks in various situation the list with contains().</p>
     * <p>Test Case Design: contains method is tested with the same
     * elements while adding them.</p>
     * <p>Test Description: First data is added and asserts are performed,
     * then second and third are added and asserts are performed.</p>
     * <p>Pre-Condition: All support method worked. The list is empty.</p>
     * <p>Post-Condition: The list contains {"a","b","c"}.</p>
     * <p>Expected Results: The list contains the element correct added during execution.</p>
     */
    @Test
    public void test_Contains_Elem()
    {
        assertFalse("The list contains 'a' should be false.", list.contains('a'));
        list.add('a');
        assertTrue("The list doesnt contain 'a' should be true.", list.contains('a'));
        assertEquals("The list shouldnt contain 'b'.", false, list.contains('b'));
        list.add('b');
        list.add('c');
        assertTrue("The list doesnt contain 'b' should be true.", list.contains('b'));
    }

    /**
     * <p><b>Summary</b>: contains method test case.
     * The test case checks in lists there is null value.</p>
     * <p>Test Case Design: Contains method is tested with critical case null element.
     * From Sommerville:"test with critical case,null element".</p>
     * <p>Test Description: The test verify if the value null is checked correctly by method contains(Object) </p>
     * <p>Pre-Condition: All support method worked. The list is empty.</p>
     * <p>Post-Condition: The list cointains {null}.</p>
     * <p>Expected Results: The list contains the element "null" and the isEmpty return false.</p>
     */
    @Test
    public void test_Contains_NullElem()
    {
        list.add(null);
        assertTrue("The list contains 'a' should be false.", list.contains(null));
        assertFalse("the size of list should be 1", list.isEmpty());
        
    }
    
    /**
     * <p><b>Summary</b>: contains method test case.
     * The test case checks in variuous situation the element contains in the list.</p>
     * <p>Test Case Design: Contains method is tested with critical case null element.
     * From Sommerville:"test method in different sequences of value".</p>
     * <p>Test Description: The test verify after some operation of add(fill with element from 100 to 200) 
     * the method contains in various range. Check the range before, current and after.</p>
     * <p>Pre-Condition: All support method worked. The list is empty.</p>
     * <p>Post-Condition: The list is not empty.</p>
     * <p>Expected Results: The list contains the element added with constructor for. 
     * The method contains return true when element is contains in the lists </p>
     */
    @Test
    public void test_Contains_Range()
    {
        for (int i = 100; i < 200; i++)
            list.add(i);
        for (int i = 0; i < 10; i++)
        {
            assertFalse("The list shouldnt include " + i, list.contains(i));
        }
        for (int i = 100; i < 200; i++)
        {
            assertTrue("The list should include " + i, list.contains(i));
        }
        for (int i = 300; i < 320; i++)
        {
            assertFalse("The list shouldnt include " + i, list.contains(i));
        }
        
    }
    
     /**
     * <p><b>Summary</b>: containsAll method test case.
     * The method tests containsAll when the collection have size=0</p>
     * <p>Test Case Design: The test case tests the critical case "empty collection".</p>
     * <p>Test Description: The collection is empty and the list is empty </p>
     * <p>Pre-Condition: The list and coll are empty.All support method worked.</p>
     * <p>Post-Condition: The list and coll are empty.</p>
     * <p>Expected Results: The containsAll method return true.</p>
     */
    @Test
    public void test_ContainsAll_EmptyColl()
    {
        assertEquals("The method should return true because the list is empty and also coll.", true, list.containsAll(coll)); 
    }
    
    /**
     * <p><b>Summary</b>: containsAll method test case.
     * The method tests when the coll doesnt point to anything</p>
     * <p>Test Case Design: The test case tests the critical case "null pointer collection".</p>
     * <p>Test Description: The collection is null and the method lunch an exception that are catch in the test</p>
     * <p>Pre-Condition: The list is empty. The coll is null.All support method worked.</p>
     * <p>Post-Condition: The list is empty. The coll unchange</p>
     * <p>Expected Results: The containsAll method lunch NullPointerException.</p>
     */
    @Test (expected = NullPointerException.class)
    public void test_ContainsAll_Nullcoll()
    {
        coll =null;
        list.containsAll(coll);
    }

    /**
     * <p><b>Summary</b>: containsAll method test case.
     * The method tests if an empty list contains the elements of another collection.</p>
     * <p>Test Case Design: The test case tests the limit case of checking an empty list.</p>
     * <p>Test Description: The collection contains 5 element.
     * The containsAll method used with list empty return false.</p>
     * <p>Pre-Condition: All support method worked. The list is empty.Coll contains {1-4}</p>
     * <p>Post-Condition: The list is empty.</p>
     * <p>Expected Results: The containsAll method return false because list is empty.</p>
     */
    @Test
    public void test_ContainsAll_NotElem()
    {
        for(int i=1;i<5;i++)
            coll.add(i);
        assertFalse("The method should return true because the list is empty and also coll.", list.containsAll(coll)); 
    }
    
    /**
     * <p><b>Summary</b>: containsAll method test case.
     * The test case tests different containsAll calls with different coll sequences.</p>
     * <p>Test Case Design: The tests calls containsAll in 4 different occasion(different size of coll).</p>
     * <p>Test Description: In the test containsAll is called with {0}, {10}, {26,30,34}, {3,4,6}.
     * After all assert valutation call the method clear() to empty the collection, after fill with new element </p>
     * <p>Pre-Condition: All support method worked. The list contains {0-10}}.
     * coll has different configurations during tests.</p>
     * <p>Post-Condition: The list contains {0-10}.</p>
     * <p>Expected Results: All containsAll calls return  the correct result in all occasion (true or false).</p>
     */
    @Test
    public void test_ContainsAll_TueOrFalse()
    {
        for(int i=0;i<11;i++)
            list.add(i);

        coll.add(0);
        assertTrue("The list contains 0.",list.containsAll(coll));
        
        coll.clear();
        coll.add(10);
        assertTrue("The list contains 10.",list.containsAll(coll));

        coll.clear();
        for(int i=25;i<35;i++)
            coll.add(i);
            assertFalse("The list doesnt contains 26, 30 and 34.", list.containsAll(coll));

        coll.clear();
        for(int i=3;i<7;i++)
            coll.add(i);
        coll.add(25);
        assertFalse("The list contains 3, 4 but not 25.",list.containsAll(coll));

    }
    
    //-----------------------------------------test of toArray------------------------------------

    /**
     * <p><b>Summary</b>: toArray test case.
     * The test add one element to the list and after call
     * toArray method(common operation).</p>
     * <p>Test Case Design: Test focuses on toArray behaviour when
     * it has only one element. 
     * From Sommerville: "Test software with sequences which have only a single value."</p>
     * <p>Test Description: Adds one to the list, calls toArray method
     * and checks the result(size,!isEmpty,the element).</p>
     * <p>Pre-Condition: The list is empty. All support method worked.</p>
     * <p>Post-Condition: The list has one element, and the array contains it.</p>
     * <p>Expected Results: The element is stored correctly in the array. The size is 1.</p>
     */
    @Test
    public void test_ToArray_ArrayArg_1()
    {
        Object[] temp = new Object[1];
        list.add(1);
        list.toArray(temp);
        assertEquals("The array size should be 1.", 1, temp.length);
        assertEquals("The element at the first position should be 1.", 1, temp[0]);
    }

    /**
     * <p><b>Summary</b>: toArray test case.
     * The test is based on toArray(arrayTarget) when arrayTarget is null.</p>
     * <p>Test Case Design: Test focuses on toArray(Objcet[]) ritical case (null point array) "</p>
     * <p>Test Description: The method test with the constructor try{}catch{} the critical case of ArrayTarget null pointer.</p>
     * <p>Pre-Condition: The list is empty.The temp array is null.All support method worked.</p>
     * <p>Post-Condition: The list has one element, and the array contains it.</p>
     * <p>Expected Results: The method lunch the NullPointerException.</p>
     */
    @Test
    public void test_ToArray_ArrayTarget_NULL()
    {
        Object[] temp = null;
        try{
            list.toArray(temp);
            throw new Exception();
        }catch(Exception e)
        {
            assertEquals(NullPointerException.class, e.getClass());
        }
    }

    /**
     * <p><b>Summary</b>: toArray method test case. 
     * The test case asserts that an empty list
     * should return an empty array when the method is call.</p>
     * <p>Test Case Design: The design is a simple assert of
     * a toArray with the critical case empty list.
     * From Sommerville: "Test with sequences of zero lenght."</p>
     * <p>Test Description: Test based on the critical case of empty list.</p>
     * <p>Pre-Condition: The list is empty. All support method worked.</p>
     * <p>Post-Condition: The list is still empty.</p>
     * <p>Expected Results: The toArray method return an empty array with size()=0.</p>
     */
    @Test
    public void test_ToArray_EmptyArray()
    {
        Object[] temp = list.toArray();
        assertEquals("Empty list return an empty array.", temp.length, 0);
        assertEquals("the size of the list is 0",0, list.size());

    }

    /**
     * <p><b>Summary</b>: toArray method test case. 
     * The test case asserts that after some operation of add the method worked(return the correct array).</p>
     * <p>Test Case Design: The design is add some data in the list and after call the method,compare the 
     * result with the specific array.
     * From Sommerville: "Use sequences of different sizes in different tests."</p>
     * <p>Test Description: Test </p>
     * <p>Pre-Condition: The list contains {1-9}. All support method worked.</p>
     * <p>Post-Condition: The list contains {1-5}.</p>
     * <p>Expected Results: The toArray method return the correct result in various occasion.</p>
     */
    @Test
    public void test_ToArray_FillWithData()
    {
        for(int i=1;i<10;i++)
            list.add(i);
        Object[] temp = list.toArray();
        Object[] temp2 = new Object[]{1,2,3,4,5,6,7,8,9};
        Object[] temp3 = new Object[]{1,2,3,4,5};
        assertArrayEquals("the array should be the same",temp, temp2);

        list.clear();
        for(int i=1;i<6;i++)
            list.add(i);
        temp = list.toArray();
        assertArrayEquals("the array should be the same",temp, temp3);
    }

    /**
     * <p><b>Summary</b>: toArray method test case.
     * The test adds element from 0 to 40 in the list and now check three generic position.</p>
     * <p>Test Case Design: The tests checks three random position of temp. 
     * From Sommerville: "Test with some different sequence ."</p>
     * <p>Test Description: Adds elements from 0 to 40 to the list. temp contains the result
     * of toArray method and after analised that.</p>
     * <p>Pre-Condition: The list contains {0-39}.</p>
     * <p>Post-Condition: The list contains {0-39} and the array contains all element of list in the same order.</p>
     * <p>Expected Results: The three random position is stored correctly in the array.</p>
     */
    @Test
    public void test_ToArray_0to39()
    {
        for(int i=0;i<40;i++)
            list.add(i);
        Object[] temp = list.toArray();
        assertEquals("Should return 39.", 39, temp[39]);
        assertEquals("Should return 16.", 16, temp[16]);
        assertEquals("Should return 1.", 1, temp[1]);
    }

    /**
     * <p><b>Summary</b>: toArray method test case.
     * The test is based on toArray(Collection) in the case when the coll is smaller than list size.</p>
     * <p>Test Case Design: The test checks the critical case of ArrayTarget smaller than list.size().</p>
     * <p>Test Description: Adds elements from 0 to 9 to the list. temp.length is 3, the method to array lunch an exception catch by 
     * the class test .</p>
     * <p>Pre-Condition: The list contains {0-9}, temp is empty. All support method worked.</p>
     * <p>Post-Condition: The list is unchanged, temp is still empty.</p>
     * <p>Expected Results: IllegalArgumentException is thrown.</p>
     */
    @Test 
    public void test_ToArray_ArrayTarget_Small()
    {
        for(int i=0;i<10;i++)
            list.add(i);

        Object[] temp = new Object[3];
        try{
            list.toArray(temp);
            throw new Exception();
        }catch(Exception e)
        {
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }
    
    /**
     * <p><b>Summary</b>: toArray() method test case.
     * The test is based on some generic test of method toArray.</p>
     * <p>Test Case Design: The test checks some case of call toArray after a sequence of other operation.</p>
     * <p>Test Description: The tes based on use other method(just verify ) for check the method toArray.</p>
     * <p>Pre-Condition: The list is empty, coll is empty.All support method worked.</p>
     * <p>Post-Condition: The list contains {1,2}.</p>
     * <p>Expected Results: THe method toArray return always the correct result.</p>
     */
    @Test
    public void testToArray() 
    {
        Object[] temp ={1,2,3,4,5};
        Object[] temp2 ={1,2};
        for(int i=1;i<6;i++)
            coll.add(i);
        list.addAll(coll);
        assertArrayEquals("the two array are same",list.toArray(), temp);
        list.clear();
        list.add(1);
        list.add(2);
        assertArrayEquals("the two array are same",list.toArray(), temp2);
                
    }

    //-----------------------------------------test of remove method------------------------------------

    /**
     * <p><b>Summary</b>: removeAll method test case.
     * The method test the method with some different input.</p>
     * <p>Test Case Design: The element ("a", "b", "c", "e") with its occurance is added to list. 
     * Also add to coll the same data and after call removeAll(coll).</p>
     * <p>Test Description: removeAll({"a", "b", "c", "e"}) is being called.</p>
     * <p>Pre-Condition: List contains {"a", "b", "c", "c", "a", "e"}.</p>
     * <p>Post-Condition: List is empty. All support method worked.</p>
     * <p>Expected Results: List has been changed and its size is zero.</p>
     */
    @Test
    public void test_RemoveAll_()
    {
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("a");
        list.add("e");

        coll.add("a");
        coll.add("b");
        coll.add("c");
        coll.add("e");

        assertTrue("The list has changed, it should return true.", list.removeAll(coll));
        assertEquals("list should be empty.", 0, list.size());
    }
    
    /**
     * <p><b>Summary</b>: removeAll method test case.
     * The test is based on verify the method removeAll from list in different case.</p>
     * <p>Test Case Design: removeAll method called with
     * empty collection as an argument(critical case of size==0).</p>
     * <p>Test Description: The test adds 3 elements to the list
     * and after call removeAll with an empty collection(critical case).</p>
     * <p>Pre-Condition: The list contains {1, 2, 3}. All support method worked.</p>
     * <p>Post-Condition: The list is unchaged.</p>
     * <p>Expected Results: The list and coll are unchanged.</p>
     */
    @Test
    public void test_RemoveAll_EmptyColl()
    {
        for(int i=1;i<4;i++)
            list.add(i);
        assertEquals("removeAll did not remove anything, therefore it should return false.", false, list.removeAll(coll));
        assertEquals("test a wrong list size.", 3, list.size());
        assertEquals("coll should be empty.", 0, coll.size());
    }

    /**
     * <p><b>Summary</b>: removeAll method test case.
     * Method is tested when the list is empty and coll have some element (3). The coll shouldnt modify with method</p>
     * <p>Test Case Design: the tets on critical case coll not empty and list empty.</p>
     * <p>Test Description: The test calls removeAll but the list isnt have any element to remove.</p>
     * <p>Pre-Condition: List is empty.All support method worked.</p>
     * <p>Post-Condition: List is still empty.</p>
     * <p>Expected Results: List is empty, coll is unchanged. The method size retun the correct value.</p>
     */
    @Test
    public void test_RemoveAll_EmptyList()
    {
        for(int i=1;i<4;i++)
            coll.add(i);
        assertEquals(false, list.removeAll(coll));
        assertEquals("list should be empty.", 0, list.size());
        assertEquals("coll' size should be 3.", 3, coll.size());
    }

    /**
     * <p><b>Summary</b>: removeAll and remove method test case.
     * The test is based on verify the method removeAll from subList in critical case with duplicate.</p>
     * <p>Test Case Design: Various add, remove and removeAll are used to check the method in stressed situation.</p>
     * <p>Test Description: First list contains {1, 2, 3, 3, 3}. 
     * Then the first 3 is removed with remove. 
     * The second and the third 3 is removed trough removeAll. 
     * Then 10 element 3 are added to the list.
     * {4, 5} being added to the list. Method removeAll is called with coll as an argument(for delete all exept {1,2,4}).</p>
     * <p>Pre-Condition: List contains {1, 2, 3, 3}. All support method worked</p>
     * <p>Post-Condition: List contains {1, 2, 4}.</p>
     * <p>Expected Results: list.toArray() matched with the specific array.</p>
     */
    @Test
    public void test_RemoveAll_Duplicates()
    {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);

        list.remove((Object)3);//remove one occurance
        coll.add(3);
        assertTrue("3 should be removed.", list.removeAll(coll));//remove all element in coll
        assertFalse("3 not present in the list.", list.removeAll(coll));//try again

        for (int i = 0; i < 10; i++)
            list.add(3);

        list.add(4);
        list.add(5);

        coll.add(5);
        assertEquals(true, list.removeAll(coll));//remove 
        assertArrayEquals("the list should be {1,2,4}",new Object[]{1,2,4}, list.toArray());
    }
    
    /**
     * <p><b>Summary</b>: removeAll method test case.
     * The method test removeAll(Collection) with collection fill and list fill.</p>
     * <p>Test Case Design: Removes elements from the list that are in coll.</p>
     * <p>Test Description: List contains element from 1 to 10 and also {3,4,5,3,6}.
     * The coll cotains {3,4,6} that is the parametre of removeAll(collection).</p>
     * <p>Pre-Condition: List contains the data insert. All support method worked.</p>
     * <p>Post-Condition: List contains the remains data after method calls. coll is unchanged.</p>
     * <p>Expected Results: The element {3,4,5} are removed from list. The coll is uncahnged.</p>
     */
    @Test
    public void test_RemoveAll_Range()
    {
        for (int i = 1; i < 10; i++)
            list.add(i);

        list.add(3);
        list.add(4);
        list.add(6);
        list.add(3);
        list.add(6);

        //remove
        coll.add(3);
        coll.add(4);
        coll.add(6);

        assertEquals(true, list.removeAll(coll));
        assertArrayEquals("the array should be the same", new Object[]{1,2,5,7,8,9},list.toArray());
        assertEquals(6, list.size());
        assertArrayEquals("the array should be the same", new Object[]{3,4,6},coll.toArray());
    }

    /**
     * <p><b>Summary</b>: remove method test case.
     * The test simply removes the first element of the list and after check the new position of specific element.</p>
     * <p>Test Case Design: Removing the first element from the list is a classic use.</p>
     * <p>Test Description: Adds number from 0 to 9 to the list, then
     * removes 0 (that is the first element before). First, middle and last elements are changed.</p>
     * <p>Pre-Condition: The list contains {0-9} and after i from 0 to 10. All support method worked.</p>
     * <p>Post-Condition: Number 0 is removed.</p>
     * <p>Expected Results: First number is 1, middle is 5 and last is 9. The size is initial-1</p>
     */
    @Test
    public void test_Remove_first()
    {
        for (int i = 0; i < 10; i++)
            list.add(i);
        int temp = list.size();
        assertTrue("Method should return true if the list contained 0 .",list.remove((Object)0));  
        assertEquals("the new first element after remove is 1.", 1, list.get(0));
        assertEquals("new middle element is 5.", 5, list.get(4));
        assertEquals("Last element after remove is 9.", 9, list.get(8));
        assertEquals("the size should be the first minus 1",temp-1, list.size());
        
    }

    /**
     * <p><b>Summary</b>: remove method test case.
     * test try to remove an element(null or 1) from empty list.</p>
     * <p>Test Case Design: Test the method remove from empty list.</p>
     * <p>Test Description: Try to remove null and 1 from an empty list.</p>
     * <p>Pre-Condition: List is empty.All support method worked.</p>
     * <p>Post-Condition: List is still empty.</p>
     * <p>Expected Results: remove method returns false.</p>
     */
    @Test
    public void test_Remove_fromEmpty()
    {
        assertEquals("List is empty therefore remove method must return false.", false, list.remove(null));
        assertEquals("List is empty therefore remove method must return false.", false, list.remove((Object)1));
    }

     /**
     * <p><b>Summary</b>: remove method test case.
     * test try to remove an element that isnt in the list.</p>
     * <p>Test Case Design: Test the method remove from empty list.</p>
     * <p>Test Description: Try to remove null and 1 from an empty list.</p>
     * <p>Pre-Condition: List contains {1-9}.All support method worked</p>
     * <p>Post-Condition: List contains the element added.</p>
     * <p>Expected Results: remove method returns false both.</p>
     */
    @Test
    public void test_Remove_notInLIst()
    {
        for(int i=1;i<10;i++)
            list.add(i);
        assertFalse("List is empty therefore remove method must return false.",  list.remove(null));
        assertFalse("List is empty therefore remove method must return false.", list.remove((Object)19));
    }

    /**
     * <p><b>Summary</b>: remove and add method test case.
     * The test is based on verify remove and add combination in different situation on list.</p>
     * <p>Test Case Design: The test calls different times
     * add and remove. A list scan should return the expected
     * string. This test stresses the list structure with
     * constant changes.</p>
     * <p>Test Description: Various add and remove calls alternate to stress the method remove.</p>
     * <p>Pre-Condition: The list is empty.All support method worked.</p>
     * <p>Post-Condition: The list contains {"The method is worked perfect"}.</p>
     * <p>Expected Results: The composed string matches with the expected string.</p>
     */
    @Test
    public void test_RemoveAddMixed()
    {
        list.add("the");
        list.add("witch");
        list.remove("witch");
        list.remove("the");
        list.add("The");
        list.add("method is");
        list.remove("is");
        list.add("worked");
        list.add("perfect");
        list.add("!");
        list.remove("!");
        String check = "";
        for (int i = 0; i < list.size(); i++)
            check += list.get(i) + " ";
        check = check.trim();
        assertEquals("Expected string does not match.", "The method is worked perfect", check);
    }

    //-----------------------------------------test of retain method------------------------------------

    /**
     * <p><b>Summary</b>: retainAll method test case.
     * retainAll is being called with an empty collection as an argument.</p>
     * <p>Test Case Design: Method retainAll being called with the critical case of empty collection .</p>
     * <p>Test Description: The list removes all because coll is empty</p>
     * <p>Pre-Condition: The list contains {1-9}. The coll is empty. All support method worked.</p>
     * <p>Post-Condition: The list and coll are empty.</p>
     * <p>Expected Results: The list is empty, retainAll returns true.</p>
     */
    @Test
    public void test_RetainAll_Empty()
    {
        for(int i=1;i<10;i++)
            list.add(i);
        assertTrue("The list changed,the method should return true.",list.retainAll(coll));
        assertEquals("list should be empty.", 0, list.size());
        assertEquals("coll should be empty.", 0, coll.size());
    }

    /**
     * <p><b>Summary</b>: retainAll method test case.
     * retainAll is being called with collection null.</p>
     * <p>Test Case Design: retainAll being called with the limit case of null pointer coll.</p>
     * <p>Test Description: The list method lunch retainAll(coll) but the coll is null and method catch NullPointerException </p>
     * <p>Pre-Condition: The list contains {1-9}. coll is null.All support method worked. </p>
     * <p>Post-Condition: The list and coll are empty.</p>
     * <p>Expected Results: The method lunch NullPointerException (NPE)</p>
     */
    @Test 
    public void test_RetainAll_Null()
    {
        coll = null;
        for(int i=1;i<10;i++)
            list.add(i);
        assertThrows("the method lunch an execption(NPE)", NullPointerException.class,()->{list.retainAll(coll);});

    }

    /**
     * <p><b>Summary</b>: retainAll method test case.
     * retainAll is being called with different collection.</p>
     * <p>Test Case Design: retainAll being called with different sequences of element</p>
     * <p>Test Description: The retainAll method is test in various occasion with different type of data ad sequence</p>
     * <p>Pre-Condition: The list contains {1-9}. The support method worked.</p>
     * <p>Post-Condition: The list contains the correct value.</p>
     * <p>Expected Results: The worked in all test case</p>
     */
    @Test 
    public void test_RetainAll_DifferentCase()
    {
        for(int i=1;i<10;i++)
            list.add(i);
        coll.add(1);
        assertTrue("the method should be return true", list.retainAll(coll));
        assertEquals("the size should 1",1, list.size());
        
        list.clear();
        for(int i=1;i<100;i++)
            list.add(i);

        for(int i=34;i<67;i++)
            coll.add(i);
        assertTrue("the method should be return true", list.retainAll(coll));
        assertEquals("the size should 34",34, list.size());

        coll.clear();
        assertTrue("the method should be return true", list.retainAll(coll));
        assertTrue("the size should 0",list.isEmpty());
    }

    /**
     * <p><b>Summary</b>: retainAll method test case.
     * The method is being tested with a collection containins duplicated elements and a list containing
     * duplicated elements.</p>
     * <p>Test Case Design: Coll and the list contains some duplicated. The method should delete only an occurrance.</p>
     * <p>Test Description: List contains {1-30,4,6,5}. Coll contains{4, 4, 5, 5, 6, 6}. now call the method.</p>
     * <p>Pre-Condition: List contains {1-30,4,6,6}. Coll contains {4, 4, 5, 5, 6, 6}.  All support method worked()</p>
     * <p>Post-Condition: List contains {4, 5, 6, 4, 6, 6}. Coll contains {4, 4, 5, 5, 6, 6}.</p>
     * <p>Expected Results: the assertTrue should be return true. The method toArray should be return an expected array</p>
     */
    @Test
    public void test_RetainAll_BothDuplicate()
    {
        for (int i = 0; i < 30; i++)
            list.add(i);
        for (int i = 4; i < 7; i++)
        {
            coll.add(i);
            coll.add(i);
        }
        list.add(4);
        list.add(6);
        list.add(5);
        assertTrue("The list has changed, it should return true.",list.retainAll(coll));
        assertArrayEquals("The array should be the same",new Object[]{4, 5, 6, 4, 6, 5},list.toArray());
    }

    /**
     * <p><b>Summary</b>: retainAll method test case.
     * The method is being tested with a collection containing duplicated and generic list.</p>
     * <p>Test Case Design: Coll contains some duplicated. The method should delete element that isnt in coll.</p>
     * <p>Test Description: List contains {1-30,}. Coll contains{4, 4, 5, 5, 6, 6}. now call the method.</p>
     * <p>Pre-Condition: List contains {1-30}. Coll contains {4, 4, 5, 5, 6, 6}. All support method worked().</p>
     * <p>Post-Condition: List contains {4, 5, 6}. Coll contains {4, 4, 5, 5, 6, 6}.</p>
     * <p>Expected Results: the assertTrue should be return true. The method toArray should be return an expected array</p>
     */
    @Test
    public void test_RetainAll_CollDuplicate()
    {
        for (int i = 0; i < 30; i++)
            list.add(i);
        for (int i = 4; i < 7; i++)
        {
            coll.add(i);
            coll.add(i);
        }
        assertTrue("The list has changed, it should return true.",list.retainAll(coll));
        assertArrayEquals("The array should be the same",new Object[]{4, 5, 6},list.toArray());

        list.clear();
        list.add(1);
        for (int i = 4; i < 7; i++)
        {
            coll.add(i);
            coll.add(i);
        }
        assertTrue("The list has changed, it should return true.",list.retainAll(coll));
        assertArrayEquals("The array should be the same",new Object[]{},list.toArray());
    }

    //------------------------------------------ hashCode method ------------------------------------------
    
    /**
     * <p><b>Summary</b>: hashCode test case.
     * Tests the method hash code apllied to this.</p>
     * <p>Test Case Design: Test the method in critical case. The list start empty. Use method add and try the method again.</p>
     * <p>Test Description: Use method hashcode in critical case "this==this"</p>
     * <p>Pre-Condition: Lists have same hashCode and they are equal.All support method worked.</p>
     * <p>Post-Condition: Lists have same hashCode and they are equal.</p>
     * <p>Expected Results: The method return the same hash code.</p>
     */
    @Test
    public void test_HashCode_Same()
    {
        assertNotEquals("the value shouldnt is equals", list.hashCode(),listWithData.hashCode());
        list.clear();
        listWithData.clear();
        assertEquals("the method should return the correct value", list.hashCode(),listWithData.hashCode());
    }

    /**
     * <p><b>Summary</b>: hashCode test case.
     * Tests the method hashcode applied to critical case with null value.</p>
     * <p>Test Case Design: Test the method in critical case for berify how work the method..</p>
     * <p>Test Description: Use method hashcode in critical case all element is null.</p>
     * <p>Pre-Condition: All list is empty. All support method worked.</p>
     * <p>Post-Condition: The list is null.</p>
     * <p>Expected Results: The method return the same hashcode.The method lunch an exception if list is null.</p>
     */
    @Test
    public void test_HashCode_Null()
    {
        listWithData.clear();
        listWithData.add(null);
        list.add(null);
        assertEquals("the method should return the correct value", list.hashCode(),listWithData.hashCode());
        list=null;
        assertThrows("the method should return an exception",NullPointerException.class,()->{list.hashCode();});

    }
    
    /**
     * <p><b>Summary</b>: hashCode test case.
     * Tests the method hash code in different case mixed.</p>
     * <p>Test Case Design: The same operations are applied to list 1 and 2,
     * so they must have the same elements each time, therefore they are equals.
     * If they are equals they must have the same hashCode.</p>
     * <p>Test Description: Use list and listWithData to check vary case of hashcode method</p>
     * <p>Pre-Condition: Lists have same hashCode and they are equal. All support method worked..</p>
     * <p>Post-Condition: Lists have same hashCode and they are equal.</p>
     * <p>Expected Results: All time that method is invoked they work perfect.</p>
     */
    @Test
    public void test_HashCode()
    {
        listWithData.clear();
        //empty
        assertTrue("Lists should be equal.", list.equals(listWithData));
        assertEquals("Hash codes should be equal.", list.hashCode(), listWithData.hashCode());

        //generic case
        for(int i=0;i<100;i++)
        {
            list.add(i);
            listWithData.add(i);
        }
        assertTrue("Lists should be equal.",list.equals(listWithData));
        assertEquals("Hash codes should be equal.", listWithData.hashCode(), list.hashCode());

        for(int i=45;i<62;i++)
        {
            list.remove(i);
            listWithData.remove(i);
        }

        assertTrue("Lists should be equal.",list.equals(listWithData));
        assertEquals("Hash codes should be equal.", listWithData.hashCode(), list.hashCode());

        for(int i=200;i<220;i++)
            coll.add(i);
        list.clear();
        listWithData.clear();
        list.addAll(coll);
        listWithData.addAll(coll);

        assertTrue("Lists should be equal.",list.equals(listWithData));
        assertEquals("Hash codes should be equal.", listWithData.hashCode(), list.hashCode());

        coll.clear();
        coll.add(202);

        list.retainAll(coll);
        listWithData.retainAll(coll);

        assertTrue("Lists should be equal.",list.equals(listWithData));
        assertEquals("Hash codes should be equal.", listWithData.hashCode(), list.hashCode());
        assertEquals("if the hash code is the same the size is the same",list.size(), listWithData.size());

    }

    //------------------------------------------set method-------------------------------------------------

    /**
     * <p><b>Summary</b>: set method test case.
     * Set all element of list to defined value(77) in all position.</p>
     * <p>Test Case Design: Test is based on a large number collection.</p>
     * <p>Test Description: List contains {0-100}. Invoke the method to set element to 77.</p>
     * <p>Pre-Condition: List contains {0-100}. .All support method worked.</p>
     * <p>Post-Condition: List contains 100 element of 77.</p>
     * <p>Expected Results: List elements are set correctly.</p>
     */
    @Test
    public void test_Set_Range()
    {
        for (int i=0; i < 100; i++)
            list.add(i);
        for (int i=0; i<list.size(); i++)
            list.set(i, 77);
        for (int i=0; i<list.size(); i++)
            assertEquals("The element should be 77", 77, list.get(i));
    }

    /**
     * <p><b>Summary</b>: set method test case.
     * Set data out of list bound(after and before).</p>
     * <p>Test Case Design:  Test is based on verify the critical case when lunch an exception (OOB).</p>
     * <p>Test Description: Verify the method set when the list is empty. 
     * Verify the method after method add(Object) in last position+1.</p>
     * <p>Pre-Condition: List contain is empty. The support method worked.</p>
     * <p>Post-Condition: List contains {0-10}.</p>
     * <p>Expected Results: List elements lunch the exception in both case.</p>
     */
    @Test 
    public void test_Set_Exception()
    {
        assertThrows("the method lunch an execption", IndexOutOfBoundsException.class,()->{ list.set(0, 1);});
       
        for (int i=0; i < 10; i++)
            list.add(i);
        assertThrows("the method lunch an execption", IndexOutOfBoundsException.class,()->{list.set(11, "a");});
            

    }

    
    /**
     * <p><b>Summary</b>: set method test case.
     * Set data in different case, with combination of some method.</p>
     * <p>Test Case Design: Test is based on stressed the method with possibile use of method.</p>
     * <p>Test Description: Verify if when the method is stressed it work done.</p>
     * <p>Pre-Condition: List contain is empty. The support method worked.</p>
     * <p>Post-Condition: List contains {1, 2, 3}.</p>
     * <p>Expected Results: The method worked perfect in all occasion.</p>
     */
    @Test
    public void test_Set_Generic()
    {
        for (int i=0; i < 10; i++)
            list.add(i);
        assertEquals("the method should return 9", 9, list.set(9, "a"));
        assertEquals("the method should return 0", 0, list.set(0, "0"));

        list.clear();
        list.add(1);
        list.add(77);
        list.add(3);
        list.set(1, 2);

        assertArrayEquals("the array should be the same",new Object[]{1,2,3}, list.toArray());



    }

    //------------------------------------------IndexOf-------------------------------------------------

    /**
     * <p><b>Summary</b>: indexOf method test case.
     * Test when the index search isnt in the list.</p>
     * <p>Test Case Design: Test is based on critical case when element isnt in the list.</p>
     * <p>Test Description: List contains {0-10}. Invoke the method to search the index 77.</p>
     * <p>Pre-Condition: List contains {0-10}. The support method worked.</p>
     * <p>Post-Condition: List contains {0-10}.</p>
     * <p>Expected Results: The method return -1.</p>
     */
    @Test 
    public void test_IndexOf_NotRange()
    {
        for (int i=0; i < 10; i++)
            list.add(i);
        assertEquals("the method should return 0.", -1, list.indexOf(77));;

    }

    /**
     * <p><b>Summary</b>: indexOf method test case.
     * Test when the data in the list is duplicated what occurace catch.</p>
     * <p>Test Case Design: Test is based on critical case list with duplicates.</p>
     * <p>Test Description: List contains {1,2,3,4,5,6,7,8,9}. Invoke the method to search an occurance the index 7.</p>
     * <p>Pre-Condition: List contains {1,2,3,4,5,6,7,8,9}. The support method worked.</p>
     * <p>Post-Condition: List contains {1,2,3,4,5,7,7,8,9}.</p>
     * <p>Expected Results: The method return the correct value.</p>
     */
    @Test 
    public void test_IndexOf_Duplicates()
    {
        for (int i=1; i < 10; i++)
            list.add(i);
        assertEquals(list.set(5, 7),6);
        assertEquals("the method should return 5.", 5, list.indexOf(7));

    }

    /**
     * <p><b>Summary</b>: indexOf method test case.
     * Test some differnt case of the method indexOf.</p>
     * <p>Test Case Design: Test is based on a different sequences of data.</p>
     * <p>Test Description: Invoke the method in different occasion with different sequences</p>
     * <p>Pre-Condition: List contains{1-100}. The support method worked.</p>
     * <p>Post-Condition: List is empty.</p>
     * <p>Expected Results: The method return the correct value all time.</p>
     */
    @Test 
    public void test_IndexOf_Generic()
    {
        for (int i=1; i < 100; i++)
            list.add(i);
        assertEquals(list.set(0, 7),1);
        assertEquals("the method should return 98.", 98, list.indexOf(99));

        for (int i=25; i < 29; i++)
            list.set(i, "a");

        assertEquals("the method should return 'a'.", 25, list.indexOf("a"));

        list.clear();
        list.add("testing with stringe");

        assertEquals("the method should return 'testing with stringe'.", 0, list.indexOf("testing with stringe"));


    }

    //------------------------------------------LastIndexOf-------------------------------------------------

    /**
     * <p><b>Summary</b>: LastindexOf method test case.
     * Test when the index search isnt in the list.</p>
     * <p>Test Case Design: Test is based on critical case elment isnt in the list.</p>
     * <p>Test Description: List contains {0-10}. Invoke the method to search the index 77.</p>
     * <p>Pre-Condition: List contains {0-10}. The support method worked.</p>
     * <p>Post-Condition: List contains {0-10}.</p>
     * <p>Expected Results: The method return -1.</p>
     */
    @Test 
    public void test_LastIndexOf_NotRange()
    {
        for (int i=0; i < 10; i++)
            list.add(i);
        assertEquals("the method should return 0.", -1, list.indexOf(77));;

    }

    /**
     * <p><b>Summary</b>: LastindexOf method test case.
     * Test when the data in the list is duplicated what occurace catch.</p>
     * <p>Test Case Design: Test is based on critical case list with duplicates.</p>
     * <p>Test Description: List contains {1,2,3,4,5,6,7,8,9}. Invoke the method to search an occurance the index 7.</p>
     * <p>Pre-Condition: List contains {1,2,3,4,5,6,7,8,9}. The support method worked.</p>
     * <p>Post-Condition: List contains {1,2,3,4,5,7,7,8,9}.</p>
     * <p>Expected Results: The method return 6.</p>
     */
    @Test 
    public void test_LastIndexOf_Duplicates()
    {
        for (int i=1; i < 10; i++)
            list.add(i);
        assertEquals(list.set(5, 7),6);
        assertEquals("the method should return 6(last occurance).", 6, list.lastIndexOf(7));

    }

    /**
     * <p><b>Summary</b>: LastindexOf method test case.
     * Test some different case of the method LastindexOf.</p>
     * <p>Test Case Design: Test is based on a different sequences of data.</p>
     * <p>Test Description: Invoke the method in different occasion with different sequences</p>
     * <p>Pre-Condition: List contains{1-100}. The support method worked.</p>
     * <p>Post-Condition: List List contains {1}.</p>
     * <p>Expected Results: The method return the correct value all time.</p>
     */
    @Test 
    public void test_LastIndexOf_Generic()
    {
        for (int i=1; i < 100; i++)
            list.add(i);
        assertEquals(list.set(0, 7),1);
        assertEquals("the method should return 98.", 98, list.lastIndexOf(99));

        for (int i=25; i < 29; i++)
            list.set(i, "a");

        assertEquals("the method should return 'a'.", 28, list.lastIndexOf("a"));

        list.clear();
        list.add("testing with stringe");

        assertEquals("the method should return 'testing with stringe'.", 0, list.lastIndexOf("testing with stringe"));

    }

    //------------------------------------------sublist-------------------------------------------------

    /**
     * <p><b>Summary</b>: sublist method test case.
     * Test the case of recursive call of sublist method.</p>
     * <p>Test Case Design: Test is based on verify the critical case of sublist recursive call.</p>
     * <p>Test Description: Invoke the method sublist in different ocasion to verify if worked</p>
     * <p>Pre-Condition: list is empty. The support method worked.</p>
     * <p>Post-Condition: List contain the value insert during the test.</p>
     * <p>Expected Results: The method sublist when it is call by a sublist. 
     * Also work when sublist of sublist call the method. </p>
     */
    @Test
	public void test_RecursiveSublist()
	{
		//System.out.println("TestRecursive SubListing");
		//System.out.println(list.size());
		
		assertEquals("List Starts not empty", list.size(), 0);
		int prev = list.size();
		for(int i=0;i<argv.length;i++)
		{
			list.add(argv[i]);
		}
		assertEquals("List add not working correctly", list.size(), (prev + argv.length));
		//System.out.println(list.size()); print size
		prev = list.size();
		for(int i=0;i<argv.length;i++)
		{
			list.add(argv[i]);
		}
		assertEquals("List add not working correctly", list.size(), (prev + argv.length));
		//System.out.println(list.size()); print size
		prev = list.size();
		for(int i=0;i<argv.length;i++)
		{
			list.add(argv[i]);
		}
		assertEquals("List add not working correctly", list.size(), (prev + argv.length));
		//System.out.println(list.size()); print size
		//iterate(list.iterator()); print sublist

		int after = 0;
		int count = 0;
		while(list.size()>=2)
		{
			count++;
			prev = list.size();
			list = list.subList(1, prev-1);
			after = list.size();
			//System.out.println(after); 
			assertEquals("Iterative Sublisting not working at " + count + " iteration", after, (prev-2));
			//iterate(list.iterator()); print sublist
		}
	}

    //------------------------------------------mixed test-------------------------------------------------

    /**
     * <p><b>Summary</b>: Test mixed of method.
     * Test the combination of some method.</p>
     * <p>Test Case Design: Test is based on verify the method combination.</p>
     * <p>Test Description: Invoke the method in casual order to verify if worked together</p>
     * <p>Pre-Condition: list is empty. The support method worked.</p>
     * <p>Post-Condition: List contain the value insert during the test.</p>
     * <p>Expected Results: The method combination worked in the correct mode. </p>
     */
    @Test
	public void test_Mixed1()
    {
        for (int i=0; i < 10; i++)
            assertTrue("add worked perfect",list.add(i));
        
        for (int i=5; i < 7; i++)
            assertTrue("remove worked perfect",list.remove((Object)i));
        
        for (int i=7; i < 9; i++)
            coll.add(i);
        assertTrue("the method retainAll worked",list.retainAll(coll));
        assertArrayEquals("the method to array worked",new Object[]{7,8}, list.toArray());

        list.clear();
        assertTrue("the method clear and isEmpty worked",list.isEmpty());

        coll=null;
        assertThrows("the method lunch an execption", NullPointerException.class,()->{list.addAll(coll);});//the method lunch NPE

        coll=new ListAdapter();
        coll.add(1);

        Object[] temp = new Object[]{1};
        assertTrue("the method addAll worked", list.addAll(coll));
        assertArrayEquals("the method toarray(Target ) worked", list.toArray(temp),list.toArray());
        
    }

    /**
     * <p><b>Summary</b>: Test mixed of method.
     * Test the combination of some method.</p>
     * <p>Test Case Design: Test is based on verify the method combination.</p>
     * <p>Test Description: Invoke the method in casual order to verify if worked together</p>
     * <p>Pre-Condition: list contains {0-11}. The support method worked.</p>
     * <p>Post-Condition: List contain the value insert during the test.</p>
     * <p>Expected Results: The method combination worked in the correct mode. </p>
     */
    @Test
	public void test_Mixed2()
    {
        for(int i=0;i<11;i++)
            list.add(i);
        assertEquals("the method indexOf worked",0, list.indexOf(0));
        list.set(2, 10);
        assertEquals("the method indexOf worked",2, list.indexOf(10));

        coll=null;
        try{
            list.addAll(coll);
            throw new Exception();
        }catch(Exception e)
        {
            assertEquals(NullPointerException.class, e.getClass());
        }

        list.clear();
        coll=new ListAdapter();
        for(int i=0;i<5;i++)
        {
            list.add(i);
            coll.add(i);
        }
        assertTrue("the method containsALL worked",list.containsAll(coll));
        
    }

    /**
     * <p><b>Summary</b>: Test mixed of method.
     * Test the combination of some method.</p>
     * <p>Test Case Design: Test is based on verify the method combination.</p>
     * <p>Test Description: Invoke the method in casual order to verify if worked together</p>
     * <p>Pre-Condition: list is empty. The support method worked.</p>
     * <p>Post-Condition: List contain the value insert during the test.</p>
     * <p>Expected Results: The method combination worked in the correct mode. </p>
     */
    @Test
	public void test_Mixed3()
    {
        for (int i=1; i < 10; i++)
            coll.add(i);
        
            assertTrue("addAll worked perfect",list.addAll(coll));
        
        for (int i=1; i < 10; i++)
        assertTrue("contains worked perfect",list.contains(i));
        
        assertTrue("containsAll worked perfect",list.containsAll(coll));

        for (int i=6; i < 10; i++)
            coll.remove(i);
        assertTrue("retainAll worked perfect",list.retainAll(coll));

        assertArrayEquals("toArray perfect",list.toArray(), listWithData.toArray());

        assertTrue("equals worked perfect",list.equals(listWithData));

        list.add(77);
        assertNotEquals("hashcode worked perfect",list.hashCode(),listWithData.hashCode());
        list.remove((Object)77);
        assertEquals("hashcode worked perfect",list.hashCode(),listWithData.hashCode());
    }

    /**
     * <p><b>Summary</b>: Test mixed of method.
     * Test the combination of some method.</p>
     * <p>Test Case Design: Test is based on verify the method combination.</p>
     * <p>Test Description: Invoke the method in casual order to verify if worked together</p>
     * <p>Pre-Condition: list contains{1-9}. The support method worked.</p>
     * <p>Post-Condition: List contain the value insert during the test.</p>
     * <p>Expected Results: The method combination worked in the correct mode. </p>
     */
    @Test
	public void test_Mixed4()
    {
        for (int i=1; i < 10; i++)
            list.add(i);
        int index=1;
        HIterator itr  = list.iterator();
        while(itr.hasNext())
        {
            assertEquals("hasNext and next worked perfect",itr.next(),index);
            index++;
        }
        itr=list.listIterator(0);
        assertEquals("next worked perfect",itr.next(),1);

        list.add(3);
        assertEquals("lastIndexOf worked perfect",list.lastIndexOf(3),9);
        assertEquals("IndexOf worked perfect",list.indexOf(3),2);
        assertEquals("Size worked perfect",list.size(),10);
        assertFalse("isEmpty worked perfect", list.isEmpty());

        coll=null;
        assertThrows("the method lunch an execption", NullPointerException.class,()->{list.addAll(coll);});
        assertThrows("the method lunch an execption", NullPointerException.class,()->{list.retainAll(coll);});

        
        
    }

    //----------------------------------------help method recursive sublist---------------------------------

    /** 
     * <p><b>Summary</b>:support method for sublist method.</p>
     * @param iter return an Hlistiterator 
     */
    public static void iterate(HListIterator iter)
	{
		System.out.print("{");
		while(iter.hasNext())
		{
			//System.out.print(iter.next() + "; ");
		}
		System.out.println("}");
	}


}