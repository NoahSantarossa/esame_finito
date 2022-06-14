package myTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


import org.junit.After;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import myAdapter.*;
/**
 * <p><b>Summary: </b>test suite of subList method.
 * All test is invoked in a SubListAdapter. All test is used for verify all method of this class.
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
 * <li>public void myTest.TestSuiteOfSubList.End()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Equals_DifferentSize()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_RetainAll_Duplicate()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_AddIndex_DifferentValue()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_ContainsAll_EmptyColl()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_LastIndexOf_Generic()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_RemoveAll_Duplicates()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Add_DifferentValue()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_ContainsAll_NotElem()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_SubList_Exception()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Clear_1Element()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_SubList_Exception_ToFrom()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_ToArray_ArrayTarget_Small()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_IndexOf_NotRange()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_RetainAll_Null()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_IndexOf_Generic()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Clear_DifferentCase()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Equals_ThisThis()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_ContainsAll_Nullcoll()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Contains_NullElem()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_LastIndexOf_Duplicates()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_ToArray_FillWithData()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_ToArray_ArrayArg_1()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_ToArray_EmptyArray()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_ContainsAll_TueOrFalse()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Contains_Range()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_ToArray_ArrayTarget_NULL()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_LastIndexOf_NotRange()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_IndexOf_Duplicates()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_RemoveAll_GenericCase()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Size_DifferentValue_SubList()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Size_1_SubList()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Remove_Elem0to10_NotContain()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_RemoveAll_EmptyList()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Remove_ExceptionRemove()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Remove_Elem0to10_Contain()</li>
 * <li>public static void myTest.TestSuiteOfSubList.beforeClassMethod()</li>
 * <li>public void myTest.TestSuiteOfSubList.beforeMethod()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_AddIndex_Mid()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_AddAll()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Add_1()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_isEmpty_0()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Add_1_Empty()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_AddAll_0()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_AddAll_Null()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Clean()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Contains_Elem()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_isEmpty()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Clear_Empty()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Size_SubList()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Size_EmptySub()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Constructor_()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Equals_Empty()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_HashCode()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_ToArray_0to39()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_HashCode_Same()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_ToArray()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Set_Exception()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Set_Generic()</li>
 * <li>public void myTest.TestSuiteOfSubList.test_Set_Range()</li>
 * </ul>
 * <p><b>Test Suite Execution Records:</b>
 * All test has been correctly execute.</p>
 * <p><b>Execution Variable:</b> There arent execution variables.</p>
 * @see TestSuiteOfList
 * @see TestSuiteOfSubListIterator
 * 
 */
public class  TestSuiteOfSubList 
{
    HList list, subList,list2;
    HCollection coll;
    static String[] argv = {"pippo", "qui", "pluto", "paperino", "qui", "ciccio"};
    HListIterator li;

    /**
     * <p><b>Summary</b>:The method for inizialized the variables.</p>
     */
    @Before
    public void beforeMethod()
    {
        list = new ListAdapter();
        coll = new ListAdapter();
        li=null;
    } 
    /* 
    @BeforeClass
    public static void beforeClassMethod()
    {

        try
        {
            Class tsli= TestSuiteOfSubList.class;
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
     * <p><b>Summary</b>:set to null all item used.</p>
     */
    @After
    public void End()
    {
        coll=null;
        list=null;
        list2=null;
        subList=null;
        li=null;
        argv=null;
    }
    
    // -----------------------------------------test of constructor----------------------------------------
    
    /**
     * <p><b>Summary</b>: costructor method test case. 
     * The test case is based on costructor check</p>
     * <p>Test Case Design:The design use assert to verify the costructor.</p>
     * <p>Test Description: Test check the default costructor.</p>
     * <p>Pre-Condition: The sublist is empty. All support method worked.</p>
     * <p>Post-Condition: the sublist is empty</p>
     * <p>Expected Results: The default costructor worked. The method toArray should return the same array.</p>
     */
    @Test
    public void test_Constructor_() 
    {
        subList = list.subList(0, 0);
        assertArrayEquals("the default constructor should be work", new Object[]{},subList.toArray());
    }
  
    //------------------------------------------ size method ------------------------------------------

    /**
     * <p><b>Summary</b>: size method test case.
     * The method is based on verify the method size in the critical case of empty subList.</p>
     * <p>Test Case Design: The size method is called
     * on a sublist created with from = to, which means
     * that the sublist is empty.</p>
     * <p>Test Description: The list contains numbers from 0 to 9, then subList is called with args (0, 0) that is (from=to)
     * <p>Pre-Condition: The list contains {0,1,2,3,4,5,6,7,8,9}.</p>
     * <p>Post-Condition: The sublist is generated and it is empty.The list is unchanged.</p>
     * <p>Expected Results: The subList has the size of 0 and isEmpty returns true.</p>
     */
    @Test
    public void test_Size_EmptySub()
    {
        int from=0,to=10; 
        if (coll == null)
            throw new NullPointerException();
        if (from > to)
            throw new IllegalArgumentException();

        coll.clear();

        for (int i = 0; i < to - from; i++)
            coll.add(i + from);

        subList = list.subList(0, 0);
        assertEquals("subList should be empty.", 0, subList.size());
        assertEquals("subList should be empty.", true, subList.isEmpty());
    }
    
   /**
     * <p><b>Summary</b>: size method test case. 
     * The test case assert if after some operation the method size return the correct value</p>
     * <p>Test Case Design:The design use assert to verify the method size(). 
     * Test the combination of various method and after invoke size.</p>
     * <p>Test Description: Test is used with a generic case of operation with list</p>
     * <p>Pre-Condition: The support method worked. The list is empty and the subList is null.</p>
     * <p>Post-Condition: The list and sublist are empty.</p>
     * <p>Expected Results: The size method returns the correct result in all of case tested.</p>
     */
    @Test
    public void test_Size_SubList() 
    {
        list.add(1);
        list.add(2);
        subList=list.subList(0, 2);
        assertEquals("the size of the list should be two",2, subList.size());
        assertArrayEquals("the array should be the same",new Object[]{1,2}, subList.toArray());
        subList.remove(0);
        assertEquals(subList.get(0), 2);
    }

    /**
     * <p><b>Summary</b>: size method test case. 
     * The test case asserts if in the sublist with 1000/100/10 elements the method worked</p>
     * <p>Test Case Design: The design is a simple assert of a size call with a large number of data. 
     * From Sommerville: "Test with sequences of different size."</p>
     * <p>Test Description: Test based on a specific sublist with 1000/100/10 elements</p>
     * <p>Pre-Condition: The support method worked. The list is empty. The sublist is empty</p>
     * <p>Post-Condition: The sublist and the list have 10 elements.</p>
     * <p>Expected Results: The size method returns 1000/100/10.</p>
     */
    @Test
    public void test_Size_DifferentValue_SubList()
    {
        for (int i = 1; i <= 1000; i++)//insert data
            list.add(i);
        subList = list.subList(0, 1000);
        assertEquals("the sublist size is 1000", 1000, subList.size());
        list.clear();

        for (int i = 1; i <= 100; i++)//insert data
            list.add(i);

        subList = list.subList(0, 100);
        assertEquals("the sublist size is 100", 100, subList.size());
        list.clear();

        for (int i = 1; i <= 10; i++)//insert data
            list.add(i);
        
        subList = list.subList(0, 10);
        assertEquals("the sublist size is 100", 10, subList.size());        
        }

    /**
     * <p><b>Summary</b>: size method test case. 
     * The test case asserts if the method worked with the sublist with size 1. The sublist is modified before the asserts with add(Object).</p>
     * <p>Test Case Design: The design is a simple assert of a size call and expected 1 size and not being empty. 
     * From Sommerville: "Test software with sequences of a single value"</p>
     * <p>Test Description: Test based on the test of critical case "list with one element"</p>
     * <p>Pre-Condition: The support method worked. The list and sublist are empty.</p>
     * <p>Post-Condition: The list and sublist have 1 element.</p>
     * <p>Expected Results: The size method returns 1 and the isEmpty method returns false.</p>
     */
    @Test
    public void test_Size_1_SubList()
    {
        list.add(1);
        subList = list.subList(0, 1);
        assertEquals("the sublist have a size of one ", 1, subList.size());
        assertFalse("the method is empty return false because size of sublist is 1", subList.isEmpty());
    }
     
    //----------------------------------------- remove method ------------------------------------------
    
    /**
     * <p><b>Summary</b>: remove method test case.
     * The test is based on verify the method remove from subList in critical case(lunch IAE).</p>
     * <p>Test Case Design: The test of remove after an elimination
     * to the root list, which should cause an exception throw.</p>
     * <p>Test Description: Add element to the list and after invoked remove. 
     * Now try to invoked remove from the sublist but lunch an exception.</p>
     * <p>Pre-Condition: List and subList are valid.</p>
     * <p>Post-Condition: List is valid, subList is invalid becuase do a remove.</p>
     * <p>Expected Results: subList is invalid and IllegalArgumentException has been thrown by the method.</p>
     */
    @Test (expected = IllegalArgumentException.class)
    public void test_Remove_ExceptionRemove()
    {
        for(int i=0;i<5;i++)
            list.add(i);
        subList = list.subList(2, 5);
        list.remove((Object)2);//the parametre is -1
        subList.remove(6); //cause throw becaus eis invalid now
    }

    /**
     * <p><b>Summary</b>: remove method test case.
     * Tests if operation in sublist influence the list.</p>
     * <p>Test Case Design: Remove generic element from subList and after check if that influence the father list.</p>
     * <p>Test Description: List contains {0 - 9} invoked sublist in (5 - 10). 
     * Therefore subList contains {5,6,7,8,9}. Now invoked some remove and verify the effect to the list.</p>
     * <p>Pre-Condition: List contains {0 - 9}, the subList contains {5 - 9}. The method remove(Object) and size() worked.</p>
     * <p>Post-Condition: List contains {0,1,2,3,4,5,7}  and subList contains {5, 7}.</p>
     * <p>Expected Results: 6,8 and 9 are removed from both lists.</p>
     */
    @Test
    public void test_Remove_Elem0to10_Contain()
    {
        for(int i=0;i<10;i++)
            list.add(i);
        subList = list.subList(5, 10);
        assertTrue("List has changed, so it should had return true.",  subList.remove((Object)6));
        assertTrue("List has changed, so it should had return true.", subList.remove((Object)8));
        assertTrue("List has changed, so it should had return true.",subList.remove((Object)9));

        assertEquals("SubList size should be 2(size-3).", 2, subList.size());
        assertArrayEquals("the method to array should generate equals array.", new Object[]{5,7}, subList.toArray());
        assertEquals("List size should be 7(size-3)", 7, list.size());
    }

    /**
     * <p><b>Summary</b>: remove method test case.
     * Tests is based on verify the method remove in critical situation on try to remove index out of sublist(but in the list range).</p>
     * <p>Test Case Design: Remove generic element from subList and after check if that influence the father list.</p>
     * <p>Test Description: List contains {0 - 9} invoked sublist in (5 - 10).Invoked remove to sublist in two range.
     * Now analized the action of remove in the list and sublist.</p>
     * <p>Pre-Condition: List contains {0 - 9}, the subList contains {5 - 9}. The method remove(Object) and equals(list) worked.</p>
     * <p>Post-Condition: List and sublist is unchanged.</p>
     * <p>Expected Results: list doesnt change.</p>
     */
    @Test
    public void test_Remove_Elem0to10_NotContain()
    {
        for(int i=0;i<20;i++)
            list.add(i);
        subList = list.subList(10, 15);
        for (int i = 0; i < 10; i++)
            assertFalse("List has not changed, so it should had return false.", subList.remove((Object)i));
        for (int i = 15; i < 20; i++)
            assertFalse("List has not changed, so it should had return false.", subList.remove((Object)i));

        HList temp=new ListAdapter();
        for(int i=0;i<20;i++)
            temp.add(i);
        assertArrayEquals("the array should be the same",temp.toArray(), list.toArray());
        temp.clear();
        for(int i=0;i<20;i++)
            temp.add(i);
        list=list.subList(10, 15);
        assertArrayEquals("the array should be the same",subList.toArray(), list.toArray());

    }

    /**
     * <p><b>Summary</b>: removeAll method test case.
     * The method is called with the critical case sublist with size=0.</p>
     * <p>Test Case Design: removeAll method is called in an empty sublist. The method remove should return false</p>
     * <p>Test Description: removeAll is called on an empty sublist.</p>
     * <p>Pre-Condition: The subList is empty.</p>
     * <p>Post-Condition: The subList is still empty.</p>
     * <p>Expected Results: The list and the subList are unchanged, their size is zero( or isEmpty() return true).</p>
     */
    @Test
    public void test_RemoveAll_EmptyList()
    {
        subList = list.subList(0, 0);
        assertFalse("the sublist doesnt change, return false",subList.removeAll(coll));
        assertEquals("sublist remain empty.", 0, subList.size());
        assertEquals("coll should be empty after its use.", 0, coll.size());
    }
    
    /**
     * <p><b>Summary</b>: removeAll method test case.
     * The test is based on verify the method removeAll from subList in different case.</p>
     * <p>Test Case Design: Removes elements(single and multiple) from the sublist.</p>
     * <p>Test Description: subList contains {1, ..., 10,5, 4, 5, 4, 3} and
     * {3, 4, 5} removed with method. After check if all is done correctly.</p>
     * <p>Pre-Condition: subList contains some numbers.</p>
     * <p>Post-Condition: {3, 4, 5} are removed from list and subList. coll is unchanged. The method add(Object) and toArray() worked</p>
     * <p>Expected Results: {3, 4, 5} are removed, list and sublist have been changed. The coll is unchanged.</p>
     */
    @Test
    public void test_RemoveAll_GenericCase()
    {
        subList = list.subList(0, 0);//empty sublist
        for(int i=1;i<10;i++)
            subList.add(i);

        subList.add(5);
        subList.add(4);
        subList.add(5);
        subList.add(4);
        subList.add(3);

        for(int i=3;i<6;i++)
            coll.add(i);

        assertArrayEquals(new Object[]{3,4,5},coll.toArray());
        assertTrue(subList.removeAll(coll));//remove
        
        assertArrayEquals("the sublist should be the same ",new Object[]{1, 2, 6, 7, 8, 9}, subList.toArray());//sublist
        assertEquals(6, subList.size());

        assertArrayEquals("the list should be the same ",new Object[]{1, 2, 6, 7, 8, 9}, list.toArray());//list
        assertEquals(6, list.size());
    }
    
    /**
     * <p><b>Summary</b>: removeAll and remove method test case.
     * The test is based on verify the method removeAll and remove combinatated in a sequences.</p>
     * <p>Test Case Design: Various add, remove and removeAll
     * are used to check the method in stressed situation.</p>
     * <p>Test Description: First list contains {1, 2, 3, 3, 3}. 
     * Then the first 3 is removed with remove. 
     * The second and the third 3 is removed trough removeAll. 
     * Then 10 element 3 are added to the list. 
     * {4, 5} being added to the list. Method removeAll is called with coll as an argument(for delete all exept {1,2,4}).</p>
     * <p>Pre-Condition: subList contains is empty.</p>
     * <p>Post-Condition: subList contains {1, 2, 4}.</p>
     * <p>Expected Results: subList.toArray() matched with the specific array given.</p>
     */
    @Test
    public void test_RemoveAll_Duplicates()
    {
        subList=list.subList(0, 0);
        subList.add(1);
        subList.add(2);
        subList.add(3);
        subList.add(3);
        subList.add(3);

        subList.remove((Object)3);//remove one occurance
        coll.add(3);
        assertTrue("3 should be removed.", subList.removeAll(coll));//remove all element in coll
        assertFalse("3 not present in the list.", subList.removeAll(coll));//try again

        for (int i = 0; i < 10; i++)
            subList.add(3);

        subList.add(4);
        subList.add(5);

        coll.add(5);
        assertEquals(true, subList.removeAll(coll));//remove 
        assertArrayEquals("the list should be {1,2,4}",new Object[]{1,2,4}, subList.toArray());
    }
    
    // ------------------------------------------ retain method ------------------------------------------


    /**
     * <p><b>Summary</b>: retainAll method test case.
     * the test is based on verify retainAll in the critical case when collection is null.</p>
     * <p>Test Case Design: retainAll being called with the limit case of null pointer coll.</p>
     * <p>Test Description: The subList method lunch retainAll(coll) but the coll is null and method catch NullPointerException </p>
     * <p>Pre-Condition: The subList contains {0-3}, the list contains {0-19}. coll is null</p>
     * <p>Post-Condition: the list and the sublist arent change.</p>
     * <p>Expected Results: The method lunch NullPointerException (NPE)</p>
     */
    @Test(expected = NullPointerException.class)
    public void test_RetainAll_Null()
    {
        coll = null;
        for(int i=0;i<20;i++)
            list.add(i);
        subList=list.subList(0,3);
        subList.retainAll(coll);
    }

    /**
     * <p><b>Summary</b>: retainAll method test case.
     * The method is being tested with a collection with duplicate.
     * The method eliminated all duplicates of one value. 
     * Method manteined only one elemement of one type</p>
     * <p>Test Case Design: Coll can contain duplicated element, and
     * this doesnt modify is work.</p>
     * <p>Test Description: subList contains {1-19}. 
     * Coll contains{4, 5, 4, 5, 4, 5}. 
     * retainAll is called and now the list became{4, 5}.</p>
     * <p>Pre-Condition: subList contains {1-19}. Coll contains {4, 4, 5, 5, 6, 6}. The method add(Object) worked.</p>
     * <p>Post-Condition: subList contains {4, 5}. Coll contains {4, 5, 4, 5, 4, 5}.</p>
     * <p>Expected Results: The arrays  are equal.</p>
     */
    @Test
    public void test_RetainAll_Duplicate()
    {
        for(int i=0;i<20;i++)
            list.add(i);
        subList = list.subList(0, 20);
        for (int i = 4; i < 7; i++)
        {
            coll.add(4);
            coll.add(5);
        }
        assertTrue("The list has changed, it should return true.", subList.retainAll(coll));
        assertArrayEquals("The arrays should match.", new Object[]{4,5}, subList.toArray());
    }

    // ------------------------------------------test of methods add ------------------------------------------

    /**
     * <p><b>Summary</b>: add method test case. 
     * The test case is based on add(Object) in the critical case of empty sublist</p>
     * <p>Test Case Design: The design is a simple assert of add call in empty sublist. 
     * From Sommerville: "Test software with sequences of a single value"</p>
     * <p>Test Description: Test based on the test of critical case "list with one element"</p>
     * <p>Pre-Condition: The method isEmpty() and size() worked. The sublist and the list are empty.</p>
     * <p>Post-Condition: The sublist and the list have 1 element.</p>
     * <p>Expected Results: The add(Object) method worked and isEmpty() return false.</p>

     */
    @Test
    public void test_Add_1()
    {
        subList= list.subList(0, 0);
        assertTrue("the sublist is empty if return true", subList.isEmpty());
        assertTrue("the method add should be return true",subList.add(10));
        assertFalse("the sublist is empty if return false", subList.isEmpty());
        assertEquals("the size of sublist should be 1", 1, subList.size());
    }

    /**
     * <p><b>Summary</b>: add method test case. 
     * The test case is based on verify add with different sequnces of element (1000/100/10)</p>
     * <p>Test Case Design: The design is a simple assert of add different number of datas. 
     * From Sommerville: "Test with sequences of different size."</p>
     * <p>Test Description: Test based on a specific sublist with 1000/100/10 elements</p>
     * <p>Pre-Condition: ALl support method worked. The sublist and list are empty.</p>
     * <p>Post-Condition: The  sublist and list have 10 element.</p>
     * <p>Expected Results: The add method worked in different type of add sequences.</p>
     */
    @Test
    public void test_Add_DifferentValue()
    {
        subList= list.subList(0, 0);
        for(int i=1;i<=1000;i++)
            assertTrue("the assert should return true",subList.add(i));
        
        subList.clear();
        for(int i=1;i<=100;i++)
            assertTrue("the assert should return true",subList.add(i));
        
        subList.clear();
        for(int i=1;i<=10;i++)
            assertTrue("the assert should return true",subList.add(i));
        assertEquals("the list size is 10",10, subList.size());
    }
    
    /**
     * <p><b>Summary</b>: add method test case. 
     * The test case of Add(index,Object)  in the critical case of empty sublist.</p>
     * <p>Test Case Design: The design is a simple assert of add call in empty sublist. 
     * From Sommerville: "Test software with sequences of a single value"</p>
     * <p>Test Description: Test based on the test of critical case "list with one element"</p>
     * <p>Pre-Condition: The support method worked. The list and sublist are empty.</p>
     * <p>Post-Condition: The sublist has 1 element.</p>
     * <p>Expected Results: The add method worked and isEmpty() return false.</p>

     */
    @Test
    public void test_Add_1_Empty()
    {
        subList = list.subList(0, 0);
        assertTrue("the sublist is empty if return true", subList.isEmpty());
        subList.add(10);
        assertEquals("the element should be 10",10, subList.get(0));

        subList.add(0,10);
        assertEquals("the element should be 10",10, subList.get(0));

    }

    /**
     * <p><b>Summary</b>: add method test case. 
     * The test case of Add(index,Object) use asserty to verify when add 1000/100/10</p>
     * <p>Test Case Design: The design is a simple assert of add number in different position. 
     * From Sommerville: "Test with sequences of different size."</p>
     * <p>Test Description: Test based on a list fill with data and after add element in position(1000/100/10) new data </p>
     * <p>Pre-Condition: The support method worked. The sublist and list are empty.</p>
     * <p>Post-Condition: The sublist has 11 element.</p>
     * <p>Expected Results: The add(index,Object) method worked with different type of add sequences.</p>
     */
    @Test
    public void test_AddIndex_DifferentValue()
    {
        
        for(int i=1;i<1001;i++)
            list.add(i);

        list.add(999,"a");
        subList = list.subList(0, 1000);
        assertEquals("the element at position 1000 is 'a' ","a", subList.get(999));
        list.clear();

        for(int i=1;i<101;i++)
            list.add(i);
        list.add(99, "a");
        subList = list.subList(0, 100);
        assertEquals("the element at position 1000 is 'a' ","a", subList.get(99));
        list.clear();

        for(int i=1;i<11;i++)
            list.add(i);
        list.add(9, "a");
        subList = list.subList(0, 11);
        assertEquals("the element at position 1000 is 'a' ","a", subList.get(9));
        assertEquals("the list should be size of 11", 11, subList.size());
        
    }

    /**
     * <p><b>Summary</b>: add method test case. 
     * The test case of Add(index,Object) use assert to verify the add in the middle position</p>
     * <p>Test Case Design: The design is a simple assert of add number in different position(middle). 
     * From Sommerville: "Test with sequences of different size."</p>
     * <p>Test Description: Test based on a list fill with data and after add element in position(middle)</p>
     * <p>Pre-Condition: All support method worked. The list and the sublist are empty.</p>
     * <p>Post-Condition: The sublist has 20 elements.</p>
     * <p>Expected Results: The add(index,Object) method worked with different type of add sequences.</p>
     */
    @Test
    public void test_AddIndex_Mid()
    {
        for(int i=1;i<20;i++)
            list.add(i);
        subList = list.subList(0, 19);
        int middle = 9;
        subList.add(middle, "a");
        assertEquals("the element in the middle position is 'a' ","a", subList.get(9));
        assertFalse("the list is empty return true", subList.isEmpty());
        
    }

    /**
     * <p><b>Summary</b>:add method test case. 
     * The test case  of add(Collection)  use asserts to verify when add collection of Object.</p>
     * <p>Test Case Design: The design is a simple assert with collection of number from 1 to 10. 
     * From Sommerville: "Test with sequences of different size."</p>
     * <p>Test Description: Test based on a collection fill with data and after with the method addAll(collection) 
     * put all data in the list.</p>
     * <p>Pre-Condition: The sublist and the collection are empty. All support method worked.</p>
     * <p>Post-Condition: The sublist contains all element of collection.</p>
     * <p>Expected Results: The method containsAll(Collection) return true. If i compare the result of add(collection) and a specific array 
     * with the same data the result of assertarrayEquals is true.</p>
     */
    @Test
    public void test_AddAll()
    {
        subList =list.subList(0, 0);
        for(int i=1;i<10;i++)
            coll.add(i);
        subList.addAll(coll);
        assertArrayEquals("if the method worked the arrays should be the same",new Object[]{1,2,3,4,5,6,7,8,9}, subList.toArray());
        assertTrue("the method contains(collection) should be return true", subList.containsAll(coll));
        
    }

    /**
     *<p><b>Summary</b>: add method test case. 
     * The test case  of AddAll(Collection coll) use asserts to verify add to empty collection.</p>
     * <p>Test Case Design: The design is a simple assert with collection empty and second check with hashCode(). 
     * From Sommerville: "Test with sequence of zero length"</p>
     * <p>Test Description: Test based on a collection with size=0.</p>
     * <p>Pre-Condition: The sublist and the collection are empty. All support method worked.</p>
     * <p>Post-Condition: The sublist and collection is empty.</p>
     * <p>Expected Results: The method containsAll(Collection) return true. The method with that parametre didnt modify the list.</p>
     */
    @Test
    public void test_AddAll_0()
    {
        HList temp = list.subList(0, 0);
        subList = list.subList(0, 0);
        subList.addAll(coll);
        assertArrayEquals("if the method worked the arrays should be the same",new Object[]{}, subList.toArray());
        assertTrue("the method contains(collection) should be return true", subList.containsAll(coll));
        assertEquals("the method hashcode should return the same value",temp.hashCode(), subList.hashCode());
        
    }
    
    /**
     * <p><b>Summary</b>: add method test case. 
     * The test case of AddAll(Collection coll) use asserts to verify when collection is null.</p>
     * <p>Test Case Design: The design is a simple assert with collection null. 
     * From Sommerville: "Test critical case(null poiter)"</p>
     * <p>Test Description: Test based on test if the collection passed as parametre didnt point to any object.</p>
     * <p>Pre-Condition: The sublist is empty. The collection is null.</p>
     * <p>Post-Condition: The sublist is empty and the coll is null.</p>
     * <p>Expected Results: The method catch the NUllPointerException lunch by addAll(collection).</p>
     */
    @Test (expected =  NullPointerException.class)
    public void test_AddAll_Null()
    {
        coll =null;
        subList = list.subList(0, 0);
        subList.addAll(coll);
        
    }

    //-----------------------------------------test of is empty method------------------------------------
    
    /**
     * <p><b>Summary</b>: isEmpty method test case. 
     * The test case asserts if the method worked after use some method that modify the sublist.</p>
     * <p>Test Case Design: The design is a simple assert of isEmpty(). 
     * From Sommerville: "Test method combination"</p>
     * <p>Test Description: Test based on combination of method for modify sublist and verify the method isEmpty()</p>
     * <p>Pre-Condition: ALl support method worked. The sublist is empty.</p>
     * <p>Post-Condition: The sublist is empty.</p>
     * <p>Expected Results: The method isEmpty() return true at the beginning. If the size of sublist is @lt 1 return false</p>
     */
    @Test
    public void test_isEmpty() 
    {
        subList= list.subList(0, 0);
        assertEquals("the list is empty",true, subList.isEmpty());
        subList.add(1);
        assertFalse("the method isEmpty should be return false", subList.isEmpty());
        subList.clear();
        assertEquals(true, subList.isEmpty());
    }

    /**
     * <p><b>Summary</b>: isEmpty method test case. 
     * The test its based on verify the method in critical case of empty subList.</p>
     * <p>Test Case Design: The design is a simple assert of isEmpty(). 
     * From Sommerville: "Test with critical case(empty list)"</p>
     * <p>Test Description: Test based on use assert to verify the method isEmpty().</p>
     * <p>Pre-Condition: THe method size() worked. The sublist is empty.</p>
     * <p>Post-Condition: The sublist is empty.</p>
     * <p>Expected Results: The method isEmpty() didnt modify the list. The method return true always.
     * The method size() return 0.</p>
     */
    @Test
    public void test_isEmpty_0() 
    {
        subList=list.subList(0, 0);
        assertTrue("the method isEmpty should be return true", subList.isEmpty());
        assertEquals("the method isEmpty should be return true",0, subList.size());
    }

    // ------------------------------------------ clear method ------------------------------------------

    /**
     * <p><b>Summary</b>: clear method test case.
     * The test case assert if after call the method clear() the sublist is empty</p>
     * <p>Test Case Design:The design use assert to verify the method size(). 
     * From Sommerville:"Test method combined with other method (size() and add(Object))</p>
     * <p>Test Description: Test is used with a generic case of operation with sublist</p>
     * <p>Pre-Condition: The method add(Object) and size() worked. 
     * The sublist is empty at the beginning.</p>
     * <p>Post-Condition: The sublist is empty at the end</p>
     * <p>Expected Results: The size method returns 0, that is correct because clear() delete all element from sublist</p>
     */
    @Test
    public void test_Clean() 
    {
        subList=list.subList(0,0);
        assertEquals("the size of the sublist should be zero, bacause sublist is empty",0, subList.size());
        subList.add(1);
        assertEquals("the size of the sublist should be one, because I add an element",1, subList.size());
        subList.clear();
        assertEquals("the size of the sublist should be zero,after call the method",0, subList.size());
    }
    
    /**
     * <p><b>Summary</b>: clear method test case.
     * Test is based on clear use assert to verify when sublist size is 1.</p>
     * <p>Test Case Design: Invokes clear method on a list containing 1 element.</p>
     * <p>Test Description: Calls clear on the list. Now check if the method worked.
     * From Sommerville:" the with sequnece of dimension 1"</p>
     * <p>Pre-Condition: List contains 1000000. All support method worked.</p>
     * <p>Post-Condition: List is empty.</p>
     * <p>Expected Results: isEmpty return true.The array return by toArray should be the same of empty array</p>
     */
    @Test
    public void test_Clear_1Element()
    {
        list.add(1000000);
        subList=list.subList(0, 1);
        subList.clear();
        assertTrue("SubList should be empty.", subList.isEmpty());
        assertArrayEquals("the array should be the same",subList.toArray(), new Object[]{});
    }

    /**
     * <p><b>Summary</b>: clear method test case.
     * Test is based on verify clear method in various occasion as different size sequences.</p>
     * <p>Test Case Design: Invokes clear method in different case of size and data.</p>
     * <p>Test Description: Calls clearin with various sequence.</p>
     * <p>Pre-Condition: subList is empty. All support method worked.</p>
     * <p>Post-Condition: subList is empty.</p>
     * <p>Expected Results: all time when the method is invoked worked correctly.</p>
     */
    @Test
    public void test_Clear_DifferentCase()
    {
        list2=list.subList(0, 0);
        subList=list.subList(0, 0);
        subList.clear();
        list2.clear();

        //list2(sublist2)
        assertTrue("subList should be empty.", list2.isEmpty());
        assertArrayEquals("the array should be the same",list2.toArray(), new Object[]{});
        //subList
        assertTrue("subList should be empty.", subList.isEmpty());
        assertArrayEquals("the array should be the same",subList.toArray(), new Object[]{});

        subList.add("a");
        subList.add("b");
        subList.add("c");
        subList.add(1);
        subList.add(3);
        subList.add(1891);

        assertFalse("subList shouldnt be empty.", subList.isEmpty());
        subList.clear();
        //list
        assertTrue("subList should be empty.", subList.isEmpty());
        assertArrayEquals("the array should be the same",subList.toArray(), new Object[]{});

        assertArrayEquals("the array should be the same",subList.toArray(), subList.toArray());
    }

    /**
     * <p><b>Summary</b>: clear method test case.
     * Test is based on clear use assert to verify when sublist is empty</p>
     * <p>Test Case Design: Invokes clear method on a sublist empty.</p>
     * <p>Test Description: Calls clear in the critical case "empty sublist".</p>
     * <p>Pre-Condition: sublist is empty. ALl support method worked.</p>
     * <p>Post-Condition: sublist is empty.</p>
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
     * The test case checks in various situation the sublist with contains().</p>
     * <p>Test Case Design: contains method is tested with the same
     * elements while adding them.</p>
     * <p>Test Description: First data is added and asserts are performed,
     * then second and third are added and asserts are performed.</p>
     * <p>Pre-Condition: All supporty method worked. The sublist is empty.</p>
     * <p>Post-Condition: The sublist is not empty.</p>
     * <p>Expected Results: The sublist contains the element correct added during execution.</p>
     */
    @Test
    public void test_Contains_Elem()
    {
        subList=list.subList(0, 0);
        assertFalse("The subList contains 'a' should be false.", subList.contains('a'));
        subList.add('a');
        assertTrue("The subList doesnt contain 'a' should be true.", subList.contains('a'));
        assertFalse("The sublist shouldnt contain 'b'.",subList.contains('b'));
        subList.add('b');
        subList.add('c');
        assertTrue("The sublist doesnt contain 'b' should be true.", subList.contains('b'));
    }

    /**
     * <p><b>Summary</b>: contains method test case.
     * The test case checks in sublist there is null value.</p>
     * <p>Test Case Design: Contains method is tested with critical case null element.
     * From Sommerville:"test with critical case,null element".</p>
     * <p>Test Description: The test verify if the value null is checked correctly by method contains(Object) </p>
     * <p>Pre-Condition: All support method worked. The subList is empty.</p>
     * <p>Post-Condition: The subList cointains null.</p>
     * <p>Expected Results: The subList contains the element "null" and the isEmpty return false.</p>
     */
    @Test
    public void test_Contains_NullElem()
    {
        subList=list.subList(0, 0);
        subList.add(null);
        assertTrue("The subList contains 'a' should be false.", subList.contains(null));
        assertFalse("the size of subList should be 1", subList.isEmpty());
        
    }
    
    /**
     * <p><b>Summary</b>: contains method test case.
     * The test case checks in variuous situation the element contains in the list.</p>
     * <p>Test Case Design: Contains method is tested with critical case null element.
     * From Sommerville:"test method in different sequences of value".</p>
     * <p>Test Description: The test verify after some operation of add(fill with element from 100 to 200) 
     * the method contains in various range. Check the range before, current and after.</p>
     * <p>Pre-Condition: The method add(Object) worked. The list is empty.</p>
     * <p>Post-Condition: The list is not empty.</p>
     * <p>Expected Results: The list contains the element added with constructor for. 
     * The method contains return true when element is contains in the lists </p>
     */
    @Test
    public void test_Contains_Range()
    {
        subList=list.subList(0, 0);
        for (int i = 100; i < 200; i++)
            subList.add(i);
        
        for (int i = 0; i < 10; i++)
        {
            assertFalse("The subList shouldnt include " + i,subList.contains(i));
        }
        for (int i = 100; i < 200; i++)
        {
            assertTrue("The subList should include " + i, subList.contains(i));
        }
        for (int i = 300; i < 320; i++)
        {
            assertFalse("The subList shouldnt include " + i, subList.contains(i));
        }
        
    }
    
     /**
     * <p><b>Summary</b>: containsAll method test case.
     * The method tests containsAll when the collection have size=0</p>
     * <p>Test Case Design: The test case tests the critical case "empty collection".</p>
     * <p>Test Description: The collection is empty and the sublist is empty </p>
     * <p>Pre-Condition: The sublist and coll are empty.</p>
     * <p>Post-Condition: The sublist and coll are empty.</p>
     * <p>Expected Results: The containsAll method return true.</p>
     */
    @Test
    public void test_ContainsAll_EmptyColl()
    {
        subList=list.subList(0, 0);
        assertEquals("The method should return true because the subList is empty and also coll.", true, subList.containsAll(coll)); 
    }
    
    /**
     * <p><b>Summary</b>: containsAll method test case.
     * The method tests when the coll doesnt point to anything</p>
     * <p>Test Case Design: The test case tests the critical case "null pointer collection".</p>
     * <p>Test Description: The collection is null and the method lunch an exception that are catch in the test</p>
     * <p>Pre-Condition: The sublist is empty. The coll is null.</p>
     * <p>Post-Condition: The sublist is empty. The coll unchange</p>
     * <p>Expected Results: The containsAll method return NullPointerException.class.</p>
     */
    @Test (expected = NullPointerException.class)
    public void test_ContainsAll_Nullcoll()
    {
        coll =null;
        subList=list.subList(0, 0);
        subList.containsAll(coll);
    }

    /**
     * <p><b>Summary</b>: containsAll method test case.
     * The method tests if an empty sublist contains the elements of another collection.</p>
     * <p>Test Case Design: The test case tests the limit case of checking an empty sublist.</p>
     * <p>Test Description: The collection contains 5 element.
     * The containsAll method used with list empty return false.</p>
     * <p>Pre-Condition: The method isEmpty() and add(Object) worked. The sublist is empty.</p>
     * <p>Post-Condition: The sublist is empty.</p>
     * <p>Expected Results: The containsAll method return false because sublist is empty.</p>
     */
    @Test
    public void test_ContainsAll_NotElem()
    {
        for(int i=1;i<5;i++)
            coll.add(i);
        subList=list.subList(0, 0);
        assertFalse("The method should return true because the subList is empty and also coll.",subList.containsAll(coll)); 
    }
    
    /**
     * <p><b>Summary</b>: containsAll method test case.
     * The test case tests different containsAll calls with different collection of number.</p>
     * <p>Test Case Design: The tests calls containsAll in 4 different occasion(different size of coll).</p>
     * <p>Test Description: In the test containsAll is called with {0}, {10}, {26,30,34}, {3,4,6}.
     * After all assert valutation call the method clear() to empty the collection, after fill with new element </p>
     * <p>Pre-Condition: All support method worked. The subList contains numbers from 0 to 10 included.
     * coll has different configurations during tests.</p>
     * <p>Post-Condition: The subList contains numbers from 0 to 10.</p>
     * <p>Expected Results: All containsAll calls return  the correct result in all occasion (true or false).</p>
     */
    @Test
    public void test_ContainsAll_TueOrFalse()
    {
        subList=list.subList(0, 0);
        for(int i=0;i<11;i++)
            subList.add(i);
        coll.add(0);
        assertTrue("The subList contains 0.",subList.containsAll(coll));
        
        coll.clear();
        coll.add(10);
        assertTrue("The sublist contains 10.",subList.containsAll(coll));

        coll.clear();
        for(int i=25;i<35;i++)
            coll.add(i);
        assertFalse("The subList doesnt contains 26, 30 and 34.", subList.containsAll(coll));

        coll.clear();
        for(int i=3;i<7;i++)
            coll.add(i);
        coll.add(25);
        assertFalse("The list contains 3, 4 but not 25.",list.containsAll(coll));

    }
    
    //-----------------------------------------test of toArray------------------------------------

    /**
     * <p><b>Summary</b>: toArray method test case.
     * The test adds one element to the list and after call toArray method.</p>
     * <p>Test Case Design: Test focuses on toArray behaviour when it has only one element. 
     * From Sommerville: "Test software with sequences which have only a single value."</p>
     * <p>Test Description: Adds one to the list, calls toArray method and checks the result(size,!isEmpty,the element).</p>
     * <p>Pre-Condition: The subList is empty. All support method worked.</p>
     * <p>Post-Condition: The subList has one element, and the array contains it.</p>
     * <p>Expected Results: The element is stored correctly in the array. The size is 1.</p>
     */
    @Test
    public void test_ToArray_ArrayArg_1()
    {
        Object[] temp = new Object[1];
        subList=list.subList(0, 0);
        subList.add(1);
        subList.toArray(temp);
        assertEquals("The array size should be 1.", 1, temp.length);
        assertEquals("The element at the first position should be 1.", 1, temp[0]);
    }

    /**
     * <p><b>Summary</b>: toArray method test case.
     * The test is based on check the if arrayTarget is null.</p>
     * <p>Test Case Design: Test focuses on toArray(Object[]) ritical case (null point array) "</p>
     * <p>Test Description: The method test with the constructor try{}catch{} the critical case of ArrayTarget null pointer.</p>
     * <p>Pre-Condition: The list is empty.The temp array is null.</p>
     * <p>Post-Condition: The list has one element, and the array contains it.</p>
     * <p>Expected Results: The method catch the NullPointerEXception.</p>
     */
    @Test (expected = NullPointerException.class)
    public void test_ToArray_ArrayTarget_NULL()
    {
        Object[] temp = null;
        subList=list.subList(0, 0);
        subList.toArray(temp);
        
    }

    /**
     * <p><b>Summary</b>: toArray method test case. 
     * The test case asserts that an empty list
     * should return an empty array when the method is call.</p>
     * <p>Test Case Design: The design is a simple assert of
     * a toArray with the critical case empty subList.
     * From Sommerville: "Test with sequences of zero lenght."</p>
     * <p>Test Description: Test based on the critical case of empty subList.</p>
     * <p>Pre-Condition: The subList is empty. All support method worked.</p>
     * <p>Post-Condition: The subList is still empty.</p>
     * <p>Expected Results: The toArray method return an empty array with size()=0.</p>
     */
    @Test
    public void test_ToArray_EmptyArray()
    {
        subList=list.subList(0, 0);
        Object[] temp = subList.toArray();
        assertEquals("Empty subList return an empty array.", temp.length, 0);
        assertEquals("the size of the subList is 0",0, subList.size());

    }

    /**
     * <p><b>Summary</b>: toArray method test case. 
     * The test case asserts that after some operation of add the method worked(return the correct array).</p>
     * <p>Test Case Design: The design is add some data in the subList and after call the method,compare the 
     * result with the specific array.</p>
     * <p>Test Description: Test </p>
     * <p>Pre-Condition: The subList is empty. All support method worked.</p>
     * <p>Post-Condition: The subList has 5 element.</p>
     * <p>Expected Results: The toArray method return the correct result in various occasion.</p>
     */
    @Test
    public void test_ToArray_FillWithData()
    {
        subList=list.subList(0, 0);
        for(int i=1;i<10;i++)
            subList.add(i);
        Object[] temp = subList.toArray();
        Object[] temp2 = new Object[]{1,2,3,4,5,6,7,8,9};
        Object[] temp3 = new Object[]{1,2,3,4,5};
        assertArrayEquals("the array should be the same",temp, temp2);

        subList.clear();
        for(int i=1;i<6;i++)
            subList.add(i);
        temp = subList.toArray();
        assertArrayEquals("the array should be the same",temp, temp3);
    }

    /**
     * <p><b>Summary</b>: toArray method test case.
     * The test adds element from 0 to 40 in the subList and now check three generic position.</p>
     * <p>Test Case Design: The tests checks three random position of temp after call toArray.</p>
     * <p>Test Description: Adds elements from 0 to 40 to the subList. temp contains the result
     * of toArray method and after analised that.</p>
     * <p>Pre-Condition: The subList is empty.</p>
     * <p>Post-Condition: The subList has 40 elements, and the array contains them all element of subList in the same order.</p>
     * <p>Expected Results: The three random position is stored correctly in the array.</p>
     */
    @Test
    public void test_ToArray_0to39()
    {
        subList=list.subList(0, 0);
        for(int i=0;i<40;i++)
            subList.add(i);
        Object[] temp = subList.toArray();
        assertEquals("Should return 39.", 39, temp[39]);
        assertEquals("Should return 16.", 16, temp[16]);
        assertEquals("Should return 1.", 1, temp[1]);
    }

    /**
     * <p><b>Summary</b>: toArray method test case.
     * The test is based on toArray(HCollection). Adds element from 0 to 10 to the subList and checks the array.</p>
     * <p>Test Case Design: The test checks the critical case of ArrayTarget smaller than subList.size().</p>
     * <p>Test Description: Adds elements from 0 to 9 to the subList. temp.length is 3, 
     * the method to array lunch an exception catch by the class test .</p>
     * <p>Pre-Condition: The subList is empty, temp is empty.</p>
     * <p>Post-Condition: The subList has 10 elements, temp is still empty.</p>
     * <p>Expected Results: IllegalArgumentException (IAE) is thrown.</p>
     */
    @Test (expected = IllegalArgumentException.class)
    public void test_ToArray_ArrayTarget_Small()
    {
        subList=list.subList(0, 0);
        for(int i=0;i<10;i++)
            subList.add(i);

        Object[] temp = new Object[3];
        subList.toArray(temp);
    }
    
    /**
     * <p><b>Summary</b>: toArray method test case.
     * The test is based on some generic test of method toArray.</p>
     * <p>Test Case Design: The test checks some case of call toArray after use of varoius sequence of method and data.</p>
     * <p>Test Description: The tes based on use support method for check the method toArray in stressed occasion.</p>
     * <p>Pre-Condition: The subList is empty, coll is empty.All support method worked.</p>
     * <p>Post-Condition: The subList has 2 elements.</p>
     * <p>Expected Results: THe method toArray return always the correct result.</p>
     */
    @Test
    public void test_ToArray() 
    {
        Object[] temp ={1,2,3,4,5};
        for(int i=1;i<6;i++)
            coll.add(i);
        
        subList=list.subList(0, 0);

        subList.addAll(coll);
        assertArrayEquals("the two array are same",subList.toArray(), temp);
        subList.clear();
        subList.add(1);
        subList.add(2);
        assertArrayEquals("the two array are same",subList.toArray(), new Object[]{1,2});
                
    }
  
    //------------------------------------------LastIndexOf-------------------------------------------------

    /**
     * <p><b>Summary</b>: LastindexOf method test case.
     * Test is based on verify method when the index searched isnt in the subList.</p>
     * <p>Test Case Design: Test is based on critical case elment isnt in the subList.</p>
     * <p>Test Description: subList contains {0-10}. Invoke the method to search the index 77.</p>
     * <p>Pre-Condition: subList contains {0-10}. The support method worked.</p>
     * <p>Post-Condition: subList contains {0-10}.</p>
     * <p>Expected Results: The method return -1.</p>
     */
    @Test 
    public void test_LastIndexOf_NotRange()
    {
        subList=list.subList(0, 0);
        for (int i=0; i < 10; i++)
            subList.add(i);
        assertEquals("the method should return 0.", -1, subList.indexOf(77));;

    }

    /**
     * <p><b>Summary</b>: LastindexOf method test case.
     * Test when the data in the subList is duplicated what occurace catch.</p>
     * <p>Test Case Design: Test is based on critical case subList with duplicates.</p>
     * <p>Test Description: subList contains {1,2,3,4,5,6,7,8,9}. Invoke the method to search an occurance the index 7.</p>
     * <p>Pre-Condition: subList contains {1,2,3,4,5,6,7,8,9}. The support method worked.</p>
     * <p>Post-Condition: subList contains {1,2,3,4,5,7,7,8,9}.</p>
     * <p>Expected Results: The method return 6.</p>
     */
    @Test 
    public void test_LastIndexOf_Duplicates()
    {
        subList=list.subList(0, 0);
        for (int i=1; i < 10; i++)
        subList.add(i);
        assertEquals(subList.set(5, 7),6);
        assertEquals("the method should return 6(last occurance).", 6, subList.lastIndexOf(7));

    }

    /**
     * <p><b>Summary</b>: LastindexOf method test case.
     * Test some different case of the method LastindexOf.</p>
     * <p>Test Case Design: Test is based on a different sequences of data.
     * Test the method LastIndexOf after some other method call</p>
     * <p>Test Description: Invoke the method in different occasion with different sequences</p>
     * <p>Pre-Condition: subList contains{1-100}. The support method worked.</p>
     * <p>Post-Condition: subList contains {1}.</p>
     * <p>Expected Results: The method return the correct value all time.</p>
     */
    @Test 
    public void test_LastIndexOf_Generic()
    {
        subList=list.subList(0, 0);
        for (int i=1; i < 100; i++)
        subList.add(i);
        assertEquals(list.set(0, 7),1);
        assertEquals("the method should return 98.", 98, subList.lastIndexOf(99));

        for (int i=25; i < 29; i++)
        subList.set(i, "a");

        assertEquals("the method should return 'a'.", 28, subList.lastIndexOf("a"));

        subList.clear();
        subList.add("testing with string");

        assertEquals("the method should return 'testing with string'.", 0, subList.lastIndexOf("testing with string"));

    }

    //------------------------------------------IndexOf-------------------------------------------------

    /**
     * <p><b>Summary</b>: indexOf method test case.
     * Test when the index search isnt in the subList.</p>
     * <p>Test Case Design: Test is based on critical case when element isnt in the subList.</p>
     * <p>Test Description: subList contains {0-10}. Invoke the method to search the index 77.</p>
     * <p>Pre-Condition: subList contains {0-10}. The support method worked.</p>
     * <p>Post-Condition: subList contains {0-10}.</p>
     * <p>Expected Results: The method return -1.</p>
     */
    @Test 
    public void test_IndexOf_NotRange()
    {
        subList=list.subList(0, 0);
        for (int i=0; i < 10; i++)
            subList.add(i);
        assertEquals("the method should return 0.", -1, subList.indexOf(77));;

    }

    /**
     *<p><b>Summary</b>: indexOf method test case.
     * Test when the data in the subList is duplicated what occurace catch.</p>
     * <p>Test Case Design: Test is based on critical case subList with duplicates.</p>
     * <p>Test Description: subList contains {1,2,3,4,5,6,7,8,9}. Invoke the method to search an occurance the index 7.</p>
     * <p>Pre-Condition: subList contains {1,2,3,4,5,6,7,8,9}. The support method worked.</p>
     * <p>Post-Condition: subList contains {1,2,3,4,5,7,7,8,9}.</p>
     * <p>Expected Results: The method return the correct value.</p>
     */
    @Test 
    public void test_IndexOf_Duplicates()
    {
        subList=list.subList(0, 0);
        for (int i=1; i < 10; i++)
            subList.add(i);
        assertEquals(subList.set(5, 7),6);
        assertEquals("the method should return 5.", 5, subList.indexOf(7));

    }

    /**
     * <p><b>Summary</b>: indexOf method test case.
     * Test some differnt case of the method indexOf.</p>
     * <p>Test Case Design: Test is based on a different sequences of data.</p>
     * <p>Test Description: Invoke the method in different occasion with different sequences</p>
     * <p>Pre-Condition: subList contains{1-100}. The support method worked.</p>
     * <p>Post-Condition: subList is empty.</p>
     * <p>Expected Results: The method return the correct value all time.</p>
     */
    @Test 
    public void test_IndexOf_Generic()
    {
        subList=list.subList(0, 0);
        for (int i=1; i < 100; i++)
            subList.add(i);
        assertEquals(subList.set(0, 7),1);
        assertEquals("the method should return 98.", 98, subList.indexOf(99));

        for (int i=25; i < 29; i++)
        subList.set(i, "a");

        assertEquals("the method should return 'a'.", 25, subList.indexOf("a"));

        subList.clear();
        subList.add("testing with string");

        assertEquals("the method should return 'testing with string'.", 0, subList.indexOf("testing with string"));


    }

    //------------------------------------------set method-------------------------------------------------

    /**
     * <p><b>Summary</b>: set method test case.
     * Set all element of subList to defined value(77) in all position.</p>
     * <p>Test Case Design: Test is based on a large number collection.</p>
     * <p>Test Description: subList contains {0-100}. Invoke the method to set element to 77.</p>
     * <p>Pre-Condition: subList contains {0-100}. The support method worked.</p>
     * <p>Post-Condition: subList contains 100 elemnet of 77.</p>
     * <p>Expected Results: subList elements are set correctly.</p>
     */
    @Test
    public void test_Set_Range()
    {
        subList=list.subList(0, 0);
        for (int i=0; i < 100; i++)
            subList.add(i);
        for (int i=0; i<list.size(); i++)
            subList.set(i, 77);
        for (int i=0; i<list.size(); i++)
            assertEquals("The element should be 77", 77, subList.get(i));
    }

    /**
     * <p><b>Summary</b>: set method test case.
     * Set data out of subList bound(after and before).</p>
     * <p>Test Case Design: Test is based on verify the critical case when lunch an exception (OOB).</p>
     * <p>Test Description: Verify the method set when the subList is empty. 
     * Verify the method after method add(Object) in last position+1.</p>
     * <p>Pre-Condition: subList contain is empty. The support method worked.</p>
     * <p>Post-Condition: subList contains 10 element.</p>
     * <p>Expected Results: subList elements lunch the exception in both case.</p>
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void test_Set_Exception()
    {
        subList=list.subList(0, 0);
        subList.set(0, 1);
        for (int i=0; i < 10; i++)
            subList.add(i);

        subList.set(11, "a");

    }

    
    /**
     * <p><b>Summary</b>: set method test case.
     * Set data in different case, with combination of some method.</p>
     * <p>Test Case Design: Test is based on stressed the method with possibile use of method.</p>
     * <p>Test Description: Verify if when the method is stressed it work done.</p>
     * <p>Pre-Condition: subList contain is empty. The support method worked.</p>
     * <p>Post-Condition: subList contains {1, 2, 3}.</p>
     * <p>Expected Results: The method worked perfect in all occasion.</p>
     */
    @Test
    public void test_Set_Generic()
    {
        subList=list.subList(0, 0);
        for (int i=0; i < 10; i++)
        subList.add(i);
        assertEquals("the method should return 9", 9, subList.set(9, "a"));
        assertEquals("the method should return 0", 0, subList.set(0, "0"));

        subList.clear();
        subList.add(1);
        subList.add(77);
        subList.add(3);
        subList.set(1, 2);

        assertArrayEquals("the array should be the same",new Object[]{1,2,3}, subList.toArray());



    }

    //------------------------------------------ hashCode method ------------------------------------------
    
    /**
     * <p><b>Summary</b>: hashCode test case.
     * Test is based on verify the method hash code in critical case list.hashCode(list).</p>
     * <p>Test Case Design: Test the method in critical case. The subList start empty. Use method add and try the method again.</p>
     * <p>Test Description: Use method hashcode in critical case "this==this"</p>
     * <p>Pre-Condition: subList have same hashCode and they are equal.All support method worked.</p>
     * <p>Post-Condition: subList have same hashCode and they are equal.</p>
     * <p>Expected Results: The method return the same hash code.</p>
     */
    @Test
    public void test_HashCode_Same()
    {
        subList=list.subList(0, 0);
        assertTrue("the method should be return a correct value",subList.equals(list));
        subList.add(1);
        assertTrue("the method should be return a correct value",subList.equals(list));

    }
    
    /**
     * <p><b>Summary</b>: hashCode test case.
     * Tests the method hash code in different case mixed.</p>
     * <p>Test Case Design: The same operations are applied to subList 1 and 2,
     * so they must have the same elements each time, therefore they are equals.
     * If they are equals they must have the same hashCode.</p>
     * <p>Test Description: Use list and list2 to check vary case of hashcode method</p>
     * <p>Pre-Condition: subList have same hashCode and they are equal. The support method worked.</p>
     * <p>Post-Condition: subList have same hashCode and they are equal.</p>
     * <p>Expected Results: All time that method is invoked they work perfect.</p>
     */
    @Test
    public void test_HashCode()
    {
        subList=list.subList(0, 0);
        list2 =new ListAdapter();
        list2=list2.subList(0, 0);
        //empty
        assertTrue("Lists should be equal.", list.equals(list2));
        assertEquals("Hash codes should be equal.", subList.hashCode(), list2.hashCode());

        //generic case
        for(int i=0;i<100;i++)
        {
            subList.add(i);
            list2.add(i);
        }
        assertTrue("Lists should be equal.",subList.equals(list2));
        assertEquals("Hash codes should be equal.", list2.hashCode(), subList.hashCode());

        for(int i=200;i<220;i++)
            coll.add(i);

        subList.clear();
        list2.clear();

        subList.addAll(coll);
        list2.addAll(coll);

        assertTrue("Lists should be equal.",subList.equals(list2));
        assertEquals("Hash codes should be equal.", list2.hashCode(), subList.hashCode());

        coll.clear();
        coll.add(202);

        subList.retainAll(coll);
        list2.retainAll(coll);

        assertTrue("Lists should be equal.",subList.equals(list2));
        assertEquals("Hash codes should be equal.", list2.hashCode(), subList.hashCode());
        assertEquals("if the hash code is the same the size is the same",subList.size(), list2.size());

    }

    //------------------------------------------sublist-------------------------------------------------

    /*
     * the method sublist recursive isnt control because is the same of list.sublist
     */

    /**
     * <p><b>Summary</b>: subList method test case.
     * The method expects IOOBE because try to create sublist with wrong index.</p>
     * <p>Test Case Design: The test case consider the critical case of "index out of bound".</p>
     * <p>Test Description: The list is filled with elements. Now call the method with a wrong index.</p>
     * <p>Pre-Condition: list contains {1,2,3,4,5,6,7,8,9,10}. All support method worked.</p>
     * <p>Post-Condition: list contains {1,2,3,4,5,6,7,8,9,10}, subList is not created.</p>
     * <p>Expected Results:  the exception IndexOutOfBoundsException(IOOBE) is being thrown.</p>
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void test_SubList_Exception()
    {
        for(int i=0;i<11;i++)
            list.add(i);
        subList = list.subList(15, 18);
    }

    /**
     * <p><b>Summary</b>: subList method test case.
     * The method expects IOOBE because try to create sublist with from index @gt to index.</p>
     * <p>Test Case Design: The test case consider the critical case of "index inverted".</p>
     * <p>Test Description: The list is filled with elements. Now call the method with from @gt to.</p>
     * <p>Pre-Condition: list contains {1,2,3,4,5,6,7,8,9,10}. All support method worked.</p>
     * <p>Post-Condition: list contains {1,2,3,4,5,6,7,8,9,10}, subList is not created.</p>
     * <p>Expected Results:  the exception IndexOutOfBoundsException(IOOBE) is being thrown.</p>
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void test_SubList_Exception_ToFrom()
    {
        for(int i=0;i<11;i++)
            list.add(i);
        subList = list.subList(15, 7);
    }

    //----------------------------------------equals method-----------------------------------------------
    
    /**
     * <p><b>Summary</b>: equals method test case. 
     * Test on critical case two empty list.</p>
     * <p>Test Case Design: equals method is tested two empty sublist.</p>
     * <p>Test Description: Invoked the method with empty list</p>
     * <p>Pre-Condition: subList and list are empty.All support method worked.</p>
     * <p>Post-Condition: subList and list are empty.</p>
     * <p>Expected Results: The method equals return true.</p>
     */
    @Test
    public void test_Equals_Empty()
    {
        subList = list.subList(0, 0);
        list2 = new ListAdapter();
        list2 = list2.subList(0, 0);
        assertTrue(subList.equals(list2));
    }

    /**
     * <p><b>Summary</b>: equals method test case.
     * The test is based on verify the method equals from subList in different case.</p>
     * <p>Test Case Design: equals method is tested with three different case of list adapter(same,bigger, lower size)</p>
     * <p>Test Description: List is initialized, then different equals invoke all time and verify with the assert the method.</p>
     * <p>Pre-Condition: subList contains {10-20}, list contains {0-30}.All support method worked.</p>
     * <p>Post-Condition: subList is unchanged, list is unchanged.</p>
     * <p>Expected Results: The equals method work with all case tested.</p>
     */
    @Test
    public void test_Equals_DifferentSize()
    {
        for(int i=0;i<31;i++)
            list.add(i);

        subList = list.subList(9,19 );
        list2=list.subList(9, 19);
        assertTrue("the method should return true,same",subList.equals(list2));

        list2=list.subList(21, 25);
        assertFalse("the method should return false,lower", subList.equals(list2));

        list2=list.subList(0, 25);
        assertFalse("the method should return false,bigger", subList.equals(list2));
    }

    /**
     * <p><b>Summary</b>: equals method test case.
     * the method test equals with the reflective property</p>
     * <p>Test Case Design: equals is test in the critical case this.equals(this)</p>
     * <p>Test Description: subList is initialized,the invoked the method in different case. Use support method to check equals.</p>
     * <p>Pre-Condition: subList contains {0-30}, list is empty. All support method worked.</p>
     * <p>Post-Condition: subList contains {"a"}, list is unchanged.</p>
     * <p>Expected Results: The method equals return all time the correct value.</p>
     */
    @Test
    public void test_Equals_ThisThis()
    {
        subList = list.subList(0,0 );
        for(int i=0;i<31;i++)
            subList.add(i);

        assertTrue("the method should return true,same",subList.equals(subList));

        subList.clear();
        assertTrue("the method should return true,same",subList.equals(subList));

        subList.add("a");
        assertTrue("the method should return true,same",subList.equals(subList));


    }

}
