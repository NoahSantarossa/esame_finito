package myAdapter;

import java.util.NoSuchElementException;
/**
 * ListAdapter adapts the list class from Java CLDC 1.1 to the
 * HList and HCollection interface. Therefore it is an Adapter
 * design pattern. Each instantiation can return a fail-fast
 * iterator to iterate through the list elements. Its elements
 * can be accessed also through indeces.
 */
public class ListAdapter implements HList
{
    /**
     * <p>the vector use to create the list.</p>
     */
    private Vector list;
    /**
     * counts the number of modifications.
     */
    protected int modificationCount;
    /**
     * index of first and last element of list.
     */
    private int from, to;
    //------------------------------------------------------------------PRIVATE SUB CLASS------------------------------------

    //-----------------------------------------LISTITERATOR ADAPTER------------------------------------
    /**
     * subclass for create the list iterator
     */
    private class ListAdapterIterator implements HListIterator
    {
        final private int expectedModificationCount;//number of modify that i attend
        private int pointedIndex;//pointer of elem
        private int prevPointIndex;//prev elem

        //-----------------------------------------COSTRUCTOR------------------------------------
        public ListAdapterIterator()
        {
            this(0);//pointer at the beginning
        }

        public ListAdapterIterator(int initialIndex)
        {
            checkIndexSizeIncluded(initialIndex);
            pointedIndex = initialIndex;
            prevPointIndex = -1;
            expectedModificationCount = modificationCount;
        }
        //-----------------------------------------METHOD------------------------------------
        /**
         * Returns true if this list iterator has more elements when
         * traversing the list in the forward direction. (In other words,
         * returns true if next would return an element rather
         * than throwing an exception.)
         *
         * @return true if the list iterator has more elements when
         *         traversing the list in the forward direction
         */
        public boolean hasNext()
        {
            return pointedIndex != size();//true if is not the last
        }

        /**
         * Returns the next element in the list and advances the cursor position.
         * This method may be called repeatedly to iterate through the list,
         * or intermixed with calls to previous to go back and forth.
         * (Note that alternating calls to next and previous
         * will return the same element repeatedly.)
         *
         * @return the next element in the list
         * @throws NoSuchElementException if the iteration has no next element
         */
        public Object next()
        {
            checkModificationCount();//number of modification
            if (!hasNext())
                throw new java.util.NoSuchElementException();//last elem
            
            prevPointIndex = pointedIndex;//set previous to the actual pointer
            Object next = list.elementAt(pointedIndex);//save element of next index
            pointedIndex++;
            return next;
        }

        /**
         * Returns true if this list iterator has more elements when
         * traversing the list in the reverse direction.  (In other words,
         * returns true if previous would return an element
         * rather than throwing an exception.)
         *
         * @return true if the list iterator has more elements when
         *         traversing the list in the reverse direction
         */
        public boolean hasPrevious()
        {
            return pointedIndex != 0;//false if im in first postion, true otherwise
        }

        /**
         * Returns the previous element in the list and moves the cursor
         * position backwards.  This method may be called repeatedly to
         * iterate through the list backwards, or intermixed with calls to
         * next to go back and forth.  (Note that alternating calls
         * to next and previous will return the same
         * element repeatedly.)
         *
         * @return the previous element in the list
         * @throws NoSuchElementException if the iteration has no previous
         *         element
         */
        public Object previous()
        {
            checkModificationCount();
            if (!hasPrevious())
                throw new java.util.NoSuchElementException();
            
            prevPointIndex = pointedIndex - 1;
            Object prev = list.elementAt(pointedIndex - 1);
            pointedIndex--;
            return prev;
        }

        /**
         * Returns the index of the element that would be returned by a
         * subsequent call to next. (Returns list size if the list
         * iterator is at the end of the list.)
         *
         * @return the index of the element that would be returned by a
         *         subsequent call to next, or list size if the list
         *         iterator is at the end of the list
         */
        public int nextIndex()
        {
            return pointedIndex;//next
        }

        /**
         * Returns the index of the element that would be returned by a
         * subsequent call to previous. (Returns -1 if the list
         * iterator is at the beginning of the list.)
         *
         * @return the index of the element that would be returned by a
         *         subsequent call to previous, or -1 if the list
         *         iterator is at the beginning of the list
         */
        public int previousIndex()
        {
            return pointedIndex - 1;//prev
        }

        /**
         * Removes from the list the last element that was returned by next
         * or previous (optional operation).  This call can
         * only be made once per call to next or previous.
         * It can be made only if next has not been
         * called after the last call to next or previous.
         *
         * @throws IllegalStateException if neither next nor
         *         previous have been called, or remove or
         *         add have been called after the last call to
         *         next or previous
         */
        public void remove()
        {
            if (prevPointIndex == -1)//if is -1 are not called the method next or prev. Method add or remove is called after next or prev.
            {
                throw new IllegalStateException();//impossible do remove operation
            }

            checkModificationCount();//number of modification
            
            list.removeElementAt(prevPointIndex);//remove element at pointer position
            pointedIndex = prevPointIndex;
            prevPointIndex = -1;//reset prev pointer
        }

        /**
         * Replaces the last element returned by next or
         * previous with the specified element (optional operation).
         * This call can be made only if neither remove nor add
         * have been called after the last call to next or
         * previous.
         *
         * @param obj the element with which to replace the last element returned by
         *          next or previous
         * @throws IllegalStateException if neither next nor
         *         previous have been called, or removed or
         *         add have been called after the last call to
         *         next or previous
         */
        public void set(Object obj)
        {
            if (prevPointIndex == -1)//if is -1 are not called the method next or prev. Method add or remove is called after next or prev.
            {
                throw new IllegalStateException();
            }
            checkModificationCount();

            ListAdapter.this.set(prevPointIndex, obj);//set element

        }

        /**
         * Inserts the specified element into the list (optional operation).
         * The element is inserted immediately before the element that
         * would be returned by next, if any, and after the element
         * that would be returned by previous, if any.  (If the
         * list contains no elements, the new element becomes the sole element
         * on the list.)  The new element is inserted before the implicit
         * cursor: a subsequent call to next would be unaffected, and a
         * subsequent call to previous would return the new element.
         * (This call increases by one the value that would be returned by a
         * call to nextIndex or previousIndex.)
         *
         * @param obj the element to insert
         */
        public void add(Object obj)
        {
            checkModificationCount();//check modify counter
            list.insertElementAt(obj, pointedIndex);//add in the last position
            pointedIndex ++;
            prevPointIndex = -1;//set pointed prev to invalid
        }

        /**
         * support method for check the modificationCount
         */
        private void checkModificationCount()
        {
            if (expectedModificationCount != modificationCount)//true if is the same false otherwise
                throw new IllegalArgumentException();
        }
    }
    
    //-----------------------------------------SUBLIST ADAPTER------------------------------------
    /**
     * subclass for create the sublist
     */
    private class SubListAdapter implements HList
    {
        private ListAdapter root;//principal list
        private SubListAdapter parent;//eventual sublist of a principal list
        private int from, to;//index of start and last
        private int subListmodificationCount;//number of modification
        //-----------------------------------------COSTRUCTOR------------------------------------
        /**
         * Construct a subList with root as the backing list, from as
         * lower bound and to as upper bound (escluded). This constructor is
         * called by ListAdapter.subList() only, making it a Factory Method design
         * pattern.
         * @param root backing list of the subList
         * @param from lower bound (included) of the subList
         * @param to upper bound (escluded) of the subList
         */
        public SubListAdapter(ListAdapter root, int from, int to)
        {
            this.root = root;
            this.parent = null;
            this.from = from;
            this.to = to;
            this.subListmodificationCount = root.modificationCount;
        }
        
        /**
         * Construct a subList with parent.root as the backing list, from as
         * lower bound and to as upper bound (escluded). This constructor is
         * called by SubList.subList() only, making it a Factory Method design
         * pattern.
         * @param parent parent subList of the subList in the subList hierarchy
         * @param from lower bound (included) of the subList
         * @param to upper bound (escluded) of the subList
         */
        public SubListAdapter(SubListAdapter parent, int from, int to)
        {
            this.root = parent.root;
            this.parent = parent;
            this.from = from;
            this.to = to;
            this.subListmodificationCount = root.modificationCount;
        }
        //-----------------------------------------METHOD------------------------------------
        /**
         * Returns the number of elements in this list. If this list contains more than
         * Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
         *
         * @return the number of elements in this list.
         */
        public int size()
        {
            checkModificationCountSubList();
            return to - from;//element size of sublist
        }

        /**
         * Returns true if this list contains no elements.
         *
         * @return true if this list contains no elements.
         */
        public boolean isEmpty()
        {
            checkModificationCountSubList();

            return to == from;//no element
        }

         /**
         *
         * Returns true if this list contains the specified element. More formally,
         * returns true if and only if this list contains at least one element e such
         * that (o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e)).
         *
         * @param obj element whose presence in this list is to be tested.
         * @return true if this list contains the specified element.
         */
        public boolean contains(Object obj)
        {
            checkModificationCountSubList();

            int indexOfObj = root.indexOf(obj);//check an occurance
            return indexOfObj < to && indexOfObj >= from;//check if this occurance is in the range
        }

        /**
         * Returns an iterator over the elements in this list in proper sequence.
         * 
         * The iterator is a fail-fast iterator, that means that any modification to
         * the list through ListAdapter methods and not throgh the iterator ones will
         * invalidate the iterator. Every iterator's method then throws
         * {@code HConcurrentModificationException}
         * @see IllegalStateException
         *
         * @return an iterator over the elements in this list in proper sequence.
         */
        public HIterator iterator()
        {
            checkModificationCountSubList();

            return new SubListIterator();//new sublistiterator
        }

         /**
         * Returns an array containing all of the elements in this list in proper
         * sequence. Obeys the general contract of the Collection.toArray method.
         *
         * @return an array containing all of the elements in this list in proper
         *         sequence.
         */
        public Object[] toArray()
        {
            checkModificationCountSubList();

            return ListAdapter.this.toArray(from, to);//use the method of ListAdapter with the two index
        }

        /**
         * Returns an array containing all of the elements in this list in proper
         * sequence. If arrayTarget is not big enough to hold ListAdapter's elements
         * the method throws IllegalArgumentException.
         *
         * @param arrayTarget the array into which the elements of this list are to be
         *                    stored, if it is big enough; otherwise, a new array of the
         *                    same runtime type is allocated for this purpose.
         * @return an array containing the elements of this list.
         *
         * @throws NullPointerException if the specified array is null.
         * @throws IllegalArgumentException if rrayTarget.size() < this.size().
         */
        public Object[] toArray(Object[] arrayTarget)
        {
            checkModificationCountSubList();

            if (arrayTarget == null)//target null
                throw new NullPointerException();

            if (arrayTarget.length < this.size())//the capacity of arrayTarget is not enough
                throw new IllegalArgumentException();
    
            for (int i = 0; i < size(); i++)
                arrayTarget[i] = this.get(i);//copy element
            
            return arrayTarget;
        }
    
        /**
         * Appends the specified element to the end of this list (optional operation).
         * <p>
         *
         *
         * @param obj element to be appended to this list.
         * @return true (as per the general contract of the Collection.add method).
         *
         */
        public boolean add(Object obj)
        {
            checkModificationCountSubList();

            ListAdapter.this.add(to, obj);
            subListmodificationCount = root.modificationCount;
            to++;//size of sublist++
            return true;
        }
    
        /**
         * Removes the first occurrence in this list of the specified element (optional
         * operation). If this list does not contain the element, it is unchanged. More
         * formally, removes the element with the lowest index i such that (o==null ?
         * get(i)==null : o.equals(get(i))) (if such an element exists).
         *
         * @param obj element to be removed from this list, if present.
         * @return true if this list contained the specified element.
         */
        public boolean remove(Object obj)
        {
            checkModificationCountSubList();

            for (int i = 0; i < this.size(); i++)
            {
                if (this.get(i).equals(obj))
                {
                    ListAdapter.this.remove(obj);//remove of list
                    this.subListmodificationCount = root.modificationCount;
                    to--;//size of sublist--
                    return true;
                }
            }
            return false;
        }
    
        /**
         *
         * Returns true if this list contains all of the elements of the specified
         * collection.
         *
         * @param coll collection to be checked for containment in this list.
         * @return true if this list contains all of the elements of the specified
         *         collection.
         * @throws NullPointerException if the specified collection is null.
         * @see #contains(Object)
         */
        public boolean containsAll(HCollection coll)
        {
            checkModificationCountSubList();

            if (coll == null)
                throw new NullPointerException();
    
            if (coll.isEmpty())//check if is empty,true because insert of 0 element is done
                return true;
    
            if (this.isEmpty())
                return false;
    
            HIterator iterator = coll.iterator();
            while (iterator.hasNext())
            {
                Object current = iterator.next();
                if (!this.contains(current))//false if at most one occurance isnt in list
                    return false;
            }
            return true;
        }
    
        /**
         * Appends all of the elements in the specified collection to the end of
         * this list, in the order that they are returned by the
         * specified collection's Iterator.  The behavior of this operation is
         * undefined if the specified collection is modified while the operation
         * is in progress.  (This implies that the behavior of this call is
         * undefined if the specified collection is this list, and this
         * list is nonempty.)
         *
         * @param coll collection containing elements to be added to this list
         * @return true if this list changed as a result of the call
         * @throws NullPointerException if the specified collection is null
         */
        public boolean addAll(HCollection coll)
        {
            checkModificationCountSubList();
            
            if (coll == null)
                throw new NullPointerException();
            
            if (coll.isEmpty())
                return false;
    
            HIterator iterator = coll.iterator();
            while (iterator.hasNext())
            {
                Object current = iterator.next();
                this.add(current);
            }
            return true;
        }
    
        /**
         * Inserts all of the elements in the specified collection into this
         * list at the specified position (optional operation).  Shifts the
         * element currently at that position (if any) and any subsequent
         * elements to the right (increases their indices).  The new elements
         * will appear in this list in the order that they are returned by the
         * specified collection's iterator.  The behavior of this operation is
         * undefined if the specified collection is modified while the
         * operation is in progress.  (Note that this will occur if the specified
         * collection is this list, and it's nonempty.)
         *
         * @param index index at which to insert the first element from the
         *              specified collection
         * @param coll collection containing elements to be added to this list
         * @return true if this list changed as a result of the call
         * @throws NullPointerException if the specified collection contains one
         *         or more null elements and this list does not permit null
         *         elements, or if the specified collection is null
         * @throws IndexOutOfBoundsException if the index is out of range
         *         (index < 0 || index > size())
         */
        public boolean addAll(int index, HCollection coll)
        {
            checkModificationCountSubList();
            checkIndexSubListSizeIncluded(index);

            if (coll == null)
                throw new NullPointerException();
    
            if (coll.isEmpty())
                return false;

            if (index == size())
                return this.addAll(coll);//index==size add at the end of collection
                
            ListAdapter.this.addAll(index + from, coll);//addall of list adapter
            to += coll.size();//sublist size =size+coll.size
            subListmodificationCount = root.modificationCount;
    
            return true;
        }
    
        /**
         * Removes from this list all of its elements that are contained in the
         * specified collection.
         *
         * @param coll collection containing elements to be removed from this list
         * @return true if this list changed as a result of the call
         * @throws NullPointerException if the specified collection is null
         * @see HCollection#contains(Object)
         */
        public boolean removeAll(HCollection coll)
        {
            checkModificationCountSubList();

            if (isEmpty() || coll.isEmpty())//coll is empty
                return false;
                
            boolean listChanged = false;
    
            HIterator iterator = coll.iterator();
            while (iterator.hasNext())
            {
                Object current = iterator.next();
                while (this.contains(current))//remove 
                {
                    this.remove(current);
                    listChanged = true;//change the sublist size
                }
            }
            return listChanged;//size--
        }
    
        /**
         * Retains only the elements in this list that are contained in the
         * specified collection. In other words, removes from this list all
         * of its elements that are not contained in the specified collection.
         *
         * @param coll collection containing elements to be retained in this list
         * @return true if this list changed as a result of the call
         * @throws NullPointerException if the specified collection is null
         * @see HCollection#contains(Object)
         */
        public boolean retainAll(HCollection coll)
        {
            checkModificationCountSubList();

            if (coll == null)
                throw new NullPointerException();
    
            if (this.isEmpty())
                return false;
    
            if (coll.isEmpty())
            {
                clear();//clear list
                return true;
            }

            HCollection temp = new ListAdapter();
            for (int i = from; i < to; i++)
                temp.add(get(i));

            temp.removeAll(coll);//remove all element of coll from list
            return this.removeAll(temp);
        }
    
        /**
         * Removes all of the elements from this list.  The list will
         * be empty after this call returns.
         */
        public void clear()
        {
            checkModificationCountSubList();
            int initialSize = this.size();
            for (int i = 0; i < initialSize; i++)
                this.remove(0);//removes all
        }
    
        /**
         * Compares the specified object with this list for equality.  Returns
         * true if and only if the specified object is also a list, both
         * lists have the same size, and all corresponding pairs of elements in
         * the two lists are <i>equal</i>.  (Two elements e1 and
         * e2 are <i>equal</i> if Objects.equals(e1, e2).)
         * In other words, two lists are defined to be
         * equal if they contain the same elements in the same order.  This
         * definition ensures that the equals method works properly across
         * different implementations of the HList interface.
         *
         * @param obj the object to be compared for equality with this list
         * @return true if the specified object is equal to this list
         */
        public boolean equals(Object obj)
        {
            checkModificationCountSubList();//check  the number of modification of sublist

            if (!(obj instanceof HList))
                throw new RuntimeException();

            HList listO = (HList)obj;
            for (int i = 0; i < listO.size(); i++)
            {
                if (listO.get(i) != this.get(i))//compare with this method of with hashcode
                    return false;
            }
            return true;
        }
    
        /**
         * Returns the hash code value for this list.  The hash code of a list
         * is defined to be the result of temp.hashCode(), where temp
         * is a vector containing only the subList elements.
         * This ensures that list1.equals(list2) implies that
         * ist1.hashCode()==list2.hashCode() for any two lists,
         * list1 and list2, as required by the general
         * contract of {@link Object#hashCode}.
         *
         * @return the hash code value for this list
         * @see Object#equals(Object)
         * @see #equals(Object)
         */
        public int hashCode()
        {
            checkModificationCountSubList();//check  the number of modification of sublist

            Vector temp = new Vector();
            for (int i = 0; i < this.size(); i++)
                temp.addElement(this.get(i));

            return temp.hashCode();
        }
    
        /**
         * Returns the element at the specified position in this list.
         *
         * @param index index of the element to return
         * @return the element at the specified position in this list
         * @throws IndexOutOfBoundsException if the index is out of range
         *         (index < 0 || index >= size())
         */
        public Object get(int index)
        {
            checkModificationCountSubList();//check  the number of modification of sublist

            checkIndexSubList(index);//check if the index of sublist is in range
            return ListAdapter.this.get(index + from);
        }
    
        /**
         * Replaces the element at the specified position in this list with the
         * specified element (optional operation).
         *
         * @param index index of the element to replace
         * @param element element to be stored at the specified position
         * @return the element previously at the specified position
         * @throws NullPointerException if the specified element is null
         * @throws IndexOutOfBoundsException if the index is out of range
         *         (index < 0 || index >= size())
         */
        public Object set(int index, Object element)
        {
            checkModificationCountSubList();//check  the number of modification of sublist
            checkIndexSubList(index);//check if the index of sublist is in range

            Object overwritten = this.get(index);
            ListAdapter.this.set(index + from, element);
            return overwritten;
        }
    
        /**
         * Inserts the specified element at the specified position in this list
         * (optional operation).  Shifts the element currently at that position
         * (if any) and any subsequent elements to the right (adds one to their
         * indices).
         *
         * @param index index at which the specified element is to be inserted
         * @param element element to be inserted
         * @throws IndexOutOfBoundsException if the index is out of range
         *         (index < 0 || index > size())
         */
        public void add(int index, Object element)
        {
            checkModificationCountSubList();//check  the number of modification of sublist
            checkIndexSubList(index);//check if the index of sublist is in range

            ListAdapter.this.add(index + from, element);
            this.subListmodificationCount = root.modificationCount;
        }
    
        /**
         * Removes the element at the specified position in this list (optional
         * operation).  Shifts any subsequent elements to the left (subtracts one
         * from their indices).  Returns the element that was removed from the
         * list.
         *
         * @param index the index of the element to be removed
         * @return the element previously at the specified position
         * @throws IndexOutOfBoundsException if the index is out of range
         *         (index @lt 0 || index @gt= size())
         */
        public Object remove(int index)
        {
            checkModificationCountSubList();//check
            checkIndexSubList(index);//check
    
            Object temp = this.get(index);//save remove obj to return 
            ListAdapter.this.remove(index + from);//remove
            this.subListmodificationCount = root.modificationCount;//addmodification
            to--;//size--
            return temp;
        }
    
        /**
         * Returns the index of the first occurrence of the specified element
         * in this list, or -1 if this list does not contain the element.
         * More formally, returns the lowest index i such that
         * (o==null ? get(i)==null : o.equals(get(i))),
         * or -1 if there is no such index.
         *
         * @param o element to search for
         * @return the index of the first occurrence of the specified element in
         *         this list, or -1 if this list does not contain the element
         * @throws NullPointerException if the specified element is null and this
         *         list does not permit null elements
         */
        public int indexOf(Object o)
        {
            for (int i = 0; i < this.size(); i++)
            {
                if (this.get(i).equals(o))
                    return i;
            }
            return -1;
        }
    
        /**
         * Returns the index of the last occurrence of the specified element
         * in this list, or -1 if this list does not contain the element.
         * More formally, returns the highest index i such that
         * (o==null ? get(i)==null : o.equals(get(i))),
         * or -1 if there is no such index.
         *
         * @param o element to search for
         * @return the index of the last occurrence of the specified element in
         *         this list, or -1 if this list does not contain the element
         * @throws NullPointerException if the specified element is null and this
         *         list does not permit null elements
         */
        public int lastIndexOf(Object o)
        {
            for (int i = this.size() - 1; i >= 0; i--)
            {
                if (o.equals(this.get(i)))
                    return i;
            }
            return -1;
        }
    
        /**
         * Returns a list iterator over the elements in this list (in proper
         * sequence).
         *
         * @return a list iterator over the elements in this list (in proper
         *         sequence)
         */
        public HListIterator listIterator()
        {
            return this.listIterator(0);
        }
    
        /**
         * Returns a list iterator over the elements in this list (in proper
         * sequence), starting at the specified position in the list.
         * The specified index indicates the first element that would be
         * returned by an initial call to next.
         * An initial call to previous would
         * return the element with the specified index minus one.
         *
         * @param index index of the first element to be returned from the
         *        list iterator (by a call to next)
         * @return a list iterator over the elements in this list (in proper
         *         sequence), starting at the specified position in the list
         * @throws IndexOutOfBoundsException if the index is out of range
         *         (index < 0 || index > size())
         */
        public HListIterator listIterator(int index)
        {
            checkModificationCountSubList();
            checkIndexSubListSizeIncluded(index);

            return new SubListIterator(index);
        }
    
        /**
         * Returns a view of the portion of this list between the specified
         * fromIndex, inclusive, and toIndex, exclusive.  (If
         * fromIndex and toIndex are equal, the returned list is
         * empty.)  The returned list is backed by this list, so non-structural
         * changes in the returned list are reflected in this list, and vice-versa.
         * The returned list supports all of the optional list operations supported
         * by this list.<p>
         *
         * This method eliminates the need for explicit range operations (of
         * the sort that commonly exist for arrays).  Any operation that expects
         * a list can be used as a range operation by passing a subList view
         * instead of a whole list.  For example, the following idiom
         * removes a range of elements from a list:
         * <pre>{@code
         *      list.subList(from, to).clear();
         * }</pre>
         * Similar idioms may be constructed for indexOf and
         * lastIndexOf, and all of the algorithms in the
         * HCollection class can be applied to a subList.<p>
         *
         * The semantics of the list returned by this method become undefined if
         * the backing list (i.e., this list) is <i>structurally modified</i> in
         * any way other than via the returned list.  (Structural modifications are
         * those that change the size of this list, or otherwise perturb it in such
         * a fashion that iterations in progress may yield incorrect results.)
         *
         * @param fromIndex low endpoint (inclusive) of the subList
         * @param toIndex high endpoint (exclusive) of the subList
         * @return a view of the specified range within this list
         * @throws IndexOutOfBoundsException for an illegal endpoint index value
         *         (fromIndex < 0 || toIndex > size ||
         *         fromIndex > toIndex)
         */
        public HList subList(int fromIndex, int toIndex)
        {
            return new SubListAdapter(this, fromIndex, toIndex);
        }

        /**
         * the method check if the root has structural modification.
         * 
         * @throws IllegalStateException if sublist became invalid
         */
        private void checkModificationCountSubList()
        {
            if (root.modificationCount != subListmodificationCount)
                throw new IllegalArgumentException();
        }

        /**
         * Throws IndexOutOfBoundsException if (index @gt= size() || index @lt 0)
         * @param index index to be checked
        */
        private void checkIndexSubList(int index)
        {
            int shiftedIndex = index + from;
            if (shiftedIndex >= to || shiftedIndex < from)
                throw new IndexOutOfBoundsException();
        }

        /**
         * Throws IndexOutOfBoundsException if (index @gt size() || index @lt 0)
         * @param index index to be checked
        */
        private void checkIndexSubListSizeIncluded(int index)
        {
            int shiftedIndex = index + from;
            if (shiftedIndex > to || shiftedIndex < from)
                throw new IndexOutOfBoundsException();
        }


        private class SubListIterator implements HListIterator//class for menage the sublist as a normal list
        {
            private int pointedIndex;//element pointed
            private int prevPointIndex;//prev of pointed 
            private int expectedModificationCount;//for check the number of modification

            public SubListIterator()
            {
                this(from);//created SubListIterator pointed on the beginning
            }
    
            public SubListIterator(int initialIndex)//created SubListIterator in a specific position in the Sublist
            {
                checkIndexSizeIncluded(initialIndex);//check the index
                pointedIndex = initialIndex;
                prevPointIndex = -1;
                expectedModificationCount = root.modificationCount;
            }

            /**
             * Returns true if this list iterator has more elements when
             * traversing the list in the forward direction. (In other words,
             * returns true if next would return an element rather
             * than throwing an exception.)
             *
             * @return true if the list iterator has more elements when
             *         traversing the list in the forward direction
             */
            public boolean hasNext()
            {
                return pointedIndex != to;//check if is the last element
            }
    
            /**
             * Returns the next element in the list and advances the cursor position.
             * This method may be called repeatedly to iterate through the list,
             * or intermixed with calls to previous to go back and forth.
             * (Note that alternating calls to next and previous
             * will return the same element repeatedly.)
             *
             * @return the next element in the list
             * @throws NoSuchElementException if the iteration has no next element
             */
            public Object next()
            {
                checkSubListIteratorModificationCount();//check if is possible modify
                if (!hasNext())//exception if is just in the last position
                    throw new java.util.NoSuchElementException();
                
                prevPointIndex = pointedIndex;
                Object next = list.elementAt(pointedIndex);
                pointedIndex++;
                return next;//return next element
            }
    
            /**
             * Returns true if this list iterator has more elements when
             * traversing the list in the reverse direction.  (In other words,
             * returns true if previous would return an element
             * rather than throwing an exception.)
             *
             * @return true if the list iterator has more elements when
             *         traversing the list in the reverse direction
             */
            public boolean hasPrevious()
            {
                return pointedIndex != from;//return false if im in the first position, true in other case
            }
    
            /**
             * Returns the previous element in the list and moves the cursor
             * position backwards.  This method may be called repeatedly to
             * iterate through the list backwards, or intermixed with calls to
             * next to go back and forth.  (Note that alternating calls
             * to next and previous will return the same
             * element repeatedly.)
             *
             * @return the previous element in the list
             * @throws NoSuchElementException if the iteration has no previous
             *         element
             */
            public Object previous()
            {
                checkSubListIteratorModificationCount();
                if (!hasPrevious())//check if im in first position
                    throw new java.util.NoSuchElementException();
                
                prevPointIndex = pointedIndex - 1;
                Object prev = list.elementAt(pointedIndex - 1);
                pointedIndex--;
                return prev;//return prev element
            }
    
            /**
             * Returns the index of the element that would be returned by a
             * subsequent call to next. (Returns list size if the list
             * iterator is at the end of the list.)
             *
             * @return the index of the element that would be returned by a
             *         subsequent call to next, or list size if the list
             *         iterator is at the end of the list
             */
            public int nextIndex()
            {
                return pointedIndex;//pointedIndex pointed all time the next element
            }
    
            /**
             * Returns the index of the element that would be returned by a
             * subsequent call to previous. (Returns -1 if the list
             * iterator is at the beginning of the list.)
             *
             * @return the index of the element that would be returned by a
             *         subsequent call to previous, or -1 if the list
             *         iterator is at the beginning of the list
             */
            public int previousIndex()
            {
                return pointedIndex - 1;//prev
            }
    
            /**
             * Removes from the list the last element that was returned by next
             * or previous (optional operation).  This call can
             * only be made once per call to next or previous.
             * It can be made only if next has not been
             * called after the last call to next or previous.
             *
             * @throws IllegalStateException if neither next nor
             *         previous have been called, or remove or
             *         add have been called after the last call to
             *         next or previous
             */
            public void remove()
            {
                if (prevPointIndex == -1)//check if is an invalid position
                {
                    throw new IndexOutOfBoundsException();
                }

                if (isEmpty())
                    checkSubListIteratorModificationCount();
                
                list.removeElementAt(prevPointIndex);//remove index beacuse im check if the index is correct
                pointedIndex = prevPointIndex;
                prevPointIndex = -1;
                to--;//size of list --
            }
    
            /**
             * Replaces the last element returned by next or
             * previous with the specified element (optional operation).
             * This call can be made only if neither remove nor add
             * have been called after the last call to next or
             * previous.
             *
             * @param obj the element with which to replace the last element returned by
             *          next or previous
             * @throws IllegalStateException if neither next nor
             *         previous have been called, or removed or
             *         add have been called after the last call to
             *         next or previous
             */
            public void set(Object obj)
            {
                if (prevPointIndex == -1)//check if is the first position
                {
                    throw new IndexOutOfBoundsException();
                }
                checkSubListIteratorModificationCount();//check if is possible modify
    
                ListAdapter.this.set(prevPointIndex, obj);//use the method set in the prev position
    
            }
    
            /**
             * Inserts the specified element into the list (optional operation).
             * The element is inserted immediately before the element that
             * would be returned by next, if any, and after the element
             * that would be returned by previous, if any.  (If the
             * list contains no elements, the new element becomes the sole element
             * on the list.)  The new element is inserted before the implicit
             * cursor: a subsequent call to next would be unaffected, and a
             * subsequent call to previous would return the new element.
             * (This call increases by one the value that would be returned by a
             * call to nextIndex or previousIndex.)
             *
             * @param obj the element to insert
             */
            public void add(Object obj)
            {
                //is possible add in all position of sublist
                checkSubListIteratorModificationCount();//check if is possible modify
                list.insertElementAt(obj, pointedIndex);//insert elemenent at pointedIndex
                pointedIndex ++;//to next element
                prevPointIndex = -1;
                to++;//sublist size++
            }
    
            /**
             * Throw IllegalStateException when the modification of sublist is different of that 
             * modification in the root list.
             * @throws IllegalStateException expectedModificationCount!= root.modificationCount
             */
            private void checkSubListIteratorModificationCount()
            {
                if (expectedModificationCount != root.modificationCount)//check if is different
                    throw new IllegalArgumentException();
            }
        }
    }

    //------------------------------------------COSTRUCTOR-----------------------------------
    /**
     * Default constructor with no arguments.
     */
    public ListAdapter()//default constructor
    {
        from = to = 0;
        modificationCount = 0;
        list = new Vector();
    }

     /**
     * Constructor with collection.
      * @param coll collection to create the list
     */
    public ListAdapter(HCollection coll) //constructor with Collection
    {
        if(coll==null)
            throw new NullPointerException();
        list =new Vector(coll.size());//create new list with collection size
        Object[] elem = coll.toArray();//convert collection to array
        for(int i=0;i<coll.size();i++)
        {
            Object obj = elem[i];
            this.add(obj);//add all elem of collection in the list(list)
        }
    }
    
    //------------------------------------------GENERIC METHOD-------------------------------
    /**
     * Returns the number of elements in this list. If this list contains more than
     * Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
     *
     * @return the number of elements in this list.
     */
    public int size()
    {
        if(list.size()>Integer.MAX_VALUE)//check if is out of integer range (more or less 70GB)
            return Integer.MAX_VALUE;
        return list.size();//return size of vector
    }
  
    /**
     * Returns true if this list contains no elements.
     *
     * @return true if this list contains no elements.
     */
    public boolean isEmpty()
    {
        return list.isEmpty();//reuse vector method or is possible use "return size()==0"
    }
    
    
    //-----------------------------------------CONTAINS METHOD-------------------------------
     /**
     *
     * Returns true if this list contains the specified element. More formally,
     * returns true if and only if this list contains at least one element e such
     * that (o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e)).
     *
     * @param obj element whose presence in this list is to be tested.
     * @return true if this list contains the specified element.
     */
    public boolean contains(Object obj)
    {
        return list.contains(obj);//reuse method of vector
    }
    
    /**
     *Returns true if this list contains all of the elements of the specified
     * collection.
     *
     * @param coll collection to be checked for containment in this list.
     * @return true if this list contains all of the elements of the specified
     *         collection.
     * @throws NullPointerException if the specified collection is null.
     * @see #contains(Object)
     */
    public boolean containsAll(HCollection coll)
    {
        if (coll == null)//check ifcollection is null
            throw new NullPointerException();

        if (coll.isEmpty())//check if teh size of collection is 0. In that case consider collection just added
            return true;

        if (isEmpty())//return false if before the method the list is empty
            return false;

        HIterator iterator = coll.iterator();
        while (iterator.hasNext())
        {
            Object current = iterator.next();//use iterator to visit all element of list
            if (!list.contains(current))
                return false;//if one element is not in coll return false
        }
        return true;//all element in list is contains in collection and otherwise
    }
    
    //-----------------------------------------ITERATOR--------------------------------------
   /**
     * Returns an iterator over the elements in this list in proper sequence.
     * 
     * The iterator is a fail-fast iterator, that means that any modification to
     * the list through ListAdapter methods and not throgh the iterator ones will
     * invalidate the iterator. Every iterator's method then throws
     * {@code IllegalStateException}
     *
     * @return an iterator over the elements in this list in proper sequence.
     */
    public HIterator iterator()
    {
        return listIterator();//return iterator located in the beginning
    }
    
    //-----------------------------------------TO ARRAY METHOD-------------------------------
    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence starting from index from (included) to index to
     * (excluded).
     * @param from lower bound index (included).
     * @param to upper bound index (escluded)
     * @return an array containing the ListAdapter elements from from index to
     * to index.
     */
    private Object[] toArray(int from, int to)
    {
        Object[] arr = new Object[to - from];
        for (int i = from; i < to; i++)
        {
            arr[i - from] = list.elementAt(i);
        }
        return arr;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence. Obeys the general contract of the Collection.toArray method.
     *
     * @return an array containing all of the elements in this list in proper
     *         sequence.
     */
    public Object[] toArray()
    {
        Object[] temp = new Object[list.size()];//create Object array with list size
        for(int i=0;i<temp.length;i++)
            temp[i] =list.elementAt(i);//save all element of list in the new array
        return temp;
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence. If arrayTarget size is lower than list.size() the method lunch an 
     * exception {IllegalArgumentException}.
     *
     * @param arrayTarget the array into which the elements of this list are to be
     *                    stored, if it is big enough; otherwise, a new array of the
     *                    same runtime type is allocated for this purpose.
     * @return an array containing the elements of this list.
     *
     * @throws NullPointerException if the specified array is null.
     * @throws IllegalArgumentException if arrayTarget.size() @lt this.size().
     */
    public Object[] toArray(Object[] arrayTarget)
    {
        if (arrayTarget == null)
            throw new NullPointerException();
        // If c is smaller than the list throw HIAE
        if (arrayTarget.length < size())
            throw new IllegalArgumentException();
        
        // Call to list method
        list.copyInto(arrayTarget);
        
        // Return the array
        return arrayTarget;
    }
    
    //-----------------------------------------ADD AND REMOVEE-------------------------------
    /**
     * Appends the specified element to the end of this list (optional operation).<p>
     * @param obj element to be appended to this list.
     * @return true (as per the general contract of the Collection.add method).
     *
     */
    public boolean add(Object obj)
    {
        list.addElement(obj);//use method add of Vector
        modificationCount ++;//list is modify
        return true;//done
    }

    /**
     * Removes the first occurrence in this list of the specified element (optional
     * operation). If this list does not contain the element, it is unchanged. More
     * formally, removes the element with the lowest index i such that (o==null ?
     * get(i)==null : o.equals(get(i))) (if such an element exists).
     *
     * @param obj element to be removed from this list, if present.
     * @return true if this list contained the specified element.
     */
    public boolean remove(Object obj)
    {
        boolean hasBeenRemoved =  list.removeElement(obj);//check if is remove. TRUE remove or FALSE not remove
        if (hasBeenRemoved)
            modificationCount ++;//if remove element the list is modify
        return hasBeenRemoved;//return boolean
    }

    /**
     * Appends all of the elements in the specified collection to the end of
     * this list, in the order that they are returned by the
     * specified collection's Iterator.  The behavior of this operation is
     * undefined if the specified collection is modified while the operation
     * is in progress.  (This implies that the behavior of this call is
     * undefined if the specified collection is this list, and this
     * list is nonempty.)
     *
     * @param c collection containing elements to be added to this list
     * @return true if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     */
    public boolean addAll(HCollection c)
    {
        if (c == null)//check ifcollection is null
            throw new NullPointerException();

        if (c.isEmpty())//didnt add element off collection beacuse is empty
            return false;

        HIterator iterator = c.iterator();
        while (iterator.hasNext())
        {
            Object current = iterator.next();
            list.addElement(current);//ad at the end of list the element
        }
        modificationCount++;//list is modify 
        return true;
    }
  
    /**
     * Inserts all of the elements in the specified collection into this
     * list at the specified position (optional operation).  Shifts the
     * element currently at that position (if any) and any subsequent
     * elements to the right (increases their indices).  The new elements
     * will appear in this list in the order that they are returned by the
     * specified collection's iterator.  The behavior of this operation is
     * undefined if the specified collection is modified while the
     * operation is in progress.  (Note that this will occur if the specified
     * collection is this list, and it's nonempty.)
     *
     * @param index index at which to insert the first element from the
     *              specified collection
     * @param coll collection containing elements to be added to this list
     * @return true if this list changed as a result of the call
     * @throws NullPointerException if the specified collection contains one
     *         or more null elements and this list does not permit null
     *         elements, or if the specified collection is null
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (index @lt 0 || index @gt size())
     */
    public boolean addAll(int index, HCollection coll)
    {
        if (coll == null)//check ifcollection is null
            throw new NullPointerException();

        if (coll.isEmpty())//didnt add element off collection beacuse is empty
            return false;

        if (index == size())//if is size add at the end of list
            return addAll(coll);

        checkIndex(index);//check index

        ListAdapter tempBackList = new ListAdapter();
        int initialSize = size();

        for (int i = index; i < initialSize; i++)
            tempBackList.add(remove(index));
        
        addAll(coll);//add element
        addAll(tempBackList);//put now all element in the initial list
        return true;//done!
    }

    /**
     * Removes from this list all of its elements that are contained in the
     * specified collection.
     *
     * @param coll collection containing elements to be removed from this list
     * @return true if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     * @see HCollection#contains(Object)
     */
    public boolean removeAll(HCollection coll)
    {
        if (coll == null)//check ifcollection is null
            throw new NullPointerException();

        if (isEmpty() || coll.isEmpty())//check if collection is empty
            return false;
            
        boolean listChanged = false;//bool as the method remove

        HIterator iterator = coll.iterator();
        while (iterator.hasNext())
        {
            Object current = iterator.next();
            while (contains(current))
            {
                list.removeElement(current);
                listChanged = true;//if remove at least one element
            }
        }
        if(listChanged)
            modificationCount ++;//modify because remove element
        return listChanged;
    }
    
    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation). Shifts the element currently at that position
     * (if any) and any subsequent elements to the right (adds one to their
     * indices).
     *
     * @param index index at which the specified element is to be inserted
     * @param obj element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (index @lt 0 || index @gt size())
     */
    public void add(int index, Object obj)
    {
        checkIndexSizeIncluded(index);//check index
        list.insertElementAt(obj, index);//insert obj
    }

    /**
     * Removes the element at the specified position in this list (optional
     * operation). Shifts any subsequent elements to the left (subtracts one
     * from their indices).  Returns the element that was removed from the
     * list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     *         ({@code index < 0 || index >= size()})
     */
    public Object remove(int index)
    {
        checkIndex(index);//check if index is ok

        Object removed = list.elementAt(index);
        list.removeElement(removed);
        modificationCount ++;//if list is modify in structur
        return removed;//return element remove
    }
    
    //-----------------------------------------RETAIN METHOD--------------------------------
    /**
     * Retains only the elements in this list that are contained in the
     * specified collection. In other words, removes from this list all
     * of its elements that are not contained in the specified collection.
     *
     * @param coll collection containing elements to be retained in this list
     * @return true if this list changed as a result of the call
     * @throws NullPointerException if the specified collection is null
     * @see HCollection#contains(Object)
     */
    public boolean retainAll(HCollection coll)
    {
        if (coll == null)
            throw new NullPointerException();

        if (isEmpty())//if is empty didnt remove element,just with size==0
            return false;

        if (coll.isEmpty())//if the collection is empty clear the list. List became empty
        {
            clear();
            return true;
        }
        HListIterator iter = this.listIterator();
        boolean flag = false;
        while (iter.hasNext()) 
        {
            Object o = iter.next();
            if (!coll.contains(o)) 
            {
                iter.remove();
                flag = true;
            }
        }
        modificationCount ++;
        return flag;
    }
    
    //-----------------------------------------CLEAR METHOD---------------------------------
    /**
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    public void clear()
    {
        modificationCount ++;
        Object[] temp =this.toArray();
        for (int i = 0; i < temp.length; i++)
            this.remove(temp[i]);//remove all elem of list
    }
    
    //-------------------------------------EQUALS AND HASHCODE-------------------------------
    /**
     * Compares the specified object with this list for equality.  Returns
     * true if and only if the specified object is also a list, both
     * lists have the same size, and all corresponding pairs of elements in
     * the two lists are <i>equal</i>.  (Two elements e1 and
     * e2 are <i>equal</i> if Objects.equals(e1, e2).)
     * In other words, two lists are defined to be
     * equal if they contain the same elements in the same order.  This
     * definition ensures that the equals method works properly across
     * different implementations of the HList interface.
     *
     * @param obj the object to be compared for equality with this list
     * @return true if the specified object is equal to this list
     */
    public boolean equals(Object obj)
    {
        if (!(obj instanceof HList))
            return false;
        HList objListAdapter = (HList)obj;

        if (this.size() != objListAdapter.size())
            return false;

        for (int i = 0; i < this.size(); i++)
        {
            if (!this.get(i).equals(objListAdapter.get(i)))//check if index is match
                return false;
        }

        return true;//equals
    }
    
    /**
     * Returns the hash code value for this list.  The hash code of a list
     * is defined to be the result of vector.hashCode().
     * This ensures that list1.equals(list2) implies that
     * ist1.hashCode()==list2.hashCode() for any two lists,
     * list1 and list2, as required by the general
     * contract of {@link Object#hashCode}.
     *
     * @return the hash code value for this list
     * @see Object#equals(Object)
     * @see #equals(Object)
     */
    public int hashCode()
    {
        int hashCode = 1;
        Object[] temp= this.toArray();
        for(int i=0;i<this.size();i++) 
        {
            Object obj = temp[i];
            hashCode = 31 * hashCode + (obj == null ? 0 : obj.hashCode());//calculate new hash code
        }
        return hashCode;
    }
    
    //-----------------------------------------GET AND SET------------------------------------
    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (index @lt 0 || index &#8805; size())
     */
    public Object get(int index)
    {
        checkIndex(index);//check index
        return list.elementAt(index);//return elem at index position
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     * @param index index of the element to replace
     * @param obj element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws NullPointerException if the specified element is null
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (index @lt 0 || index &#8805; size())
     */
    public Object set(int index, Object obj)
    {
        Object temp = get(index);//save elem at index position
        list.setElementAt(obj, index);//set the data given by method
        return temp;
    }
    
   
    //-----------------------------------------INDEXOF METHOD------------------------------------
    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index i such that
     * (o==null ? get(i)==null : o.equals(get(i))),
     * or -1 if there is no such index.
     *
     * @param obj element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    public int indexOf(Object obj)
    {
        return IndexOfRange(obj,0,list.size());//return first index of obj
    }

    /**
     * method ausiliary to search the indexOf(obj) 
     * @param obj element to search
     * @param start first index
     * @param end end index
     * @return int the position of first occurance
     */
    private int IndexOfRange(Object obj, int start, int end)
    {
        Object[] temp = this.toArray();
        if (obj == null) 
        {
            for (int i = start; i < end; i++) 
            {
                if (temp[i] == null)
                    return i;   
            }
        }else 
        {
            for (int i = start; i < end; i++) 
            {
                if (obj.equals(temp[i])) 
                    return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the highest index i such that
     * (o==null ? get(i)==null : o.equals(get(i))),
     * or -1 if there is no such index.
     *
     * @param obj element to search for
     * @return the index of the last occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    public int lastIndexOf(Object obj)
    {
        return LastIndexOfRange(obj,0,list.size());//return last index of obj
    }

    /**
     * method ausiliary to search the LastindexOf(obj) 
     * @param obj the elment to find
     * @param start the first index
     * @param end the last index
     * @return int the position of last occurance or -1
     */
    private int LastIndexOfRange(Object obj, int start, int end)
    {
        Object[] temp = this.toArray();
        if (obj == null) 
        {
            for (int i = end - 1; i >= start; i--) 
            {
                if (temp[i] == null) 
                {
                    return i;
                }
            }
        }else 
        {
            for (int i = end - 1; i >= start; i--) 
            {
                if (obj.equals(temp[i])) 
                {
                    return i;
                }
            }
        }
        return -1;

    }
    
    //-----------------------------------------HLISTITERATOR------------------------------------
    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence).
     *
     * @return a list iterator over the elements in this list (in proper
     *         sequence)
     */
    public HListIterator listIterator()
    {
        return listIterator(0);
    }

    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence), starting at the specified position in the list.
     * The specified index indicates the first element that would be
     * returned by an initial call to {@link HListIterator#next next}.
     * An initial call to {@link HListIterator#previous previous} would
     * return the element with the specified index minus one.
     *
     * @param index index of the first element to be returned from the
     *        list iterator (by a call to {@link HListIterator#next next})
     * @return a list iterator over the elements in this list (in proper
     *         sequence), starting at the specified position in the list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (index @lt 0 || index @gt size())
     */
    public HListIterator listIterator(int index)
    {
        checkIndexSizeIncluded(index);
        return new ListAdapterIterator(index);
    }
    
    //-----------------------------------------SUBLIST METHOD------------------------------------
    /**
     * Returns a view of the portion of this list between the specified
     * fromIndex, inclusive, and toIndex, exclusive.  (If
     * fromIndex and toIndex are equal, the returned list is
     * empty.)  The returned list is backed by this list, so non-structural
     * changes in the returned list are reflected in this list, and vice-versa.
     * The returned list supports all of the optional list operations supported
     * by this list.<p>
     *
     * This method eliminates the need for explicit range operations (of
     * the sort that commonly exist for arrays).  Any operation that expects
     * a list can be used as a range operation by passing a subList view
     * instead of a whole list.  For example, the following idiom
     * removes a range of elements from a list:
     * <pre>{@code
     *      list.subList(from, to).clear();
     * }</pre>
     * Similar idioms may be constructed for indexOf and
     * lastIndexOf, and all of the algorithms in the
     * HCollection class can be applied to a subList.<p>
     *
     * The semantics of the list returned by this method become undefined if
     * the backing list (i.e., this list) is <i>structurally modified</i> in
     * any way other than via the returned list.  (Structural modifications are
     * those that change the size of this list, or otherwise perturb it in such
     * a fashion that iterations in progress may yield incorrect results.)
     *
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     * @throws IndexOutOfBoundsException for an illegal endpoint index value
     *         ({@code fromIndex < 0 || toIndex > size ||
     *         fromIndex > toIndex})
     */
    public HList subList(int fromIndex, int toIndex)
    {
        //size is allow
        checkIndexSizeIncluded(fromIndex);
        checkIndexSizeIncluded(toIndex);
        if (fromIndex > toIndex)
            throw new IndexOutOfBoundsException();
        return new SubListAdapter(this, fromIndex, toIndex);
    }
    
    //---------------------------------------AUSILIARY METHOD------------------------------------
    /**
     * Throws IndexOutOfBoundsException if (index @gt= size() || index @lt 0)
     * @param index index to be checked
    */
    private void checkIndex(int index)
    {
        if (index >= size() || index < 0)
            throw new IndexOutOfBoundsException();
    }

    /**
     * Throws IndexOutOfBoundsException if (index @gt size() || index @lt 0)
     * @param index index to be checked
    */
    private void checkIndexSizeIncluded(int index)
    {
        if (index > size() || index < 0)
            throw new IndexOutOfBoundsException();
    }

   
}