package myAdapter;


import java.util.Enumeration;
import java.util.Objects;

/**
 * Class Vector of Java Micro Edition, CLDC1.1<br>
 *
 * <p>
 * The object {@link myAdapter.Vector} is used to save e manage data, the porpouse of this class is only to 
 * filter the methods of vector in order to use only methods from CLDC1.1
 *
 */
public class Vector {

    java.util.Vector vector;

    public Vector() {
        vector = new java.util.Vector();
    }

    public Vector(int initialCapacity) {
        vector = new java.util.Vector(initialCapacity);
    }

    public Vector(int initialCapacity, int capacityIncrement) {
        vector = new java.util.Vector(initialCapacity, capacityIncrement);
    }

    
    /** 
     * @param obj
     */
    public void addElement(Object obj){
        vector.addElement(obj);
    }

    
    /** 
     * @return int
     */
    public int capacity(){
        return vector.capacity();
    }

    
    /** 
     * @param elem
     * @return boolean
     */
    public boolean contains(Object elem){
        return vector.contains(elem);
    }

    
    /** 
     * @param anArray
     */
    public void copyInto(Object[] anArray){
        vector.copyInto(anArray);
    }

    
    /** 
     * @param index
     * @return Object
     */
    public Object elementAt(int index){
        return vector.elementAt(index);
    }

    
    /** 
     * @return Enumeration
     */
    public Enumeration elements(){
        return vector.elements();
    }

    
    /** 
     * @param minCapacity
     */
    public void ensureCapacity(int minCapacity){
        vector.ensureCapacity(minCapacity);
    }

    
    /** 
     * @return Object
     */
    public Object firstElement(){
        return vector.firstElement();
    }

    
    /** 
     * @param elem
     * @return int
     */
    public int indexOf(Object elem){
        return vector.indexOf(elem);
    }

    
    /** 
     * @param elem
     * @param index
     * @return int
     */
    public int indexOf(Object elem, int index){
        return vector.indexOf(elem, index);
    }

    
    /** 
     * @param obj the object to add
     * @param index of position to add
     */
    public void insertElementAt(Object obj, int index){
        vector.insertElementAt(obj, index);
    }

    
    /** 
     * @return boolean
     */
    public boolean isEmpty(){
        return vector.isEmpty();
    }

    
    /** 
     * @return Object
     */
    public Object lastElement(){
        return vector.lastElement();
    }

    
    /** 
     * @param elem the elem to search
     * @return int the position of lastindex of elem
     */
    public int lastIndexOf(Object elem){
        return vector.lastIndexOf(elem);
    }

    
    /** 
     * @param elem the element to remove
     * @param index the index to remove
     * @return int the index of elem
     */
    public int lastIndexOf(Object elem, int index){
        return vector.lastIndexOf(elem, index);
    }

    public void removeAllElements(){
        vector.removeAllElements();
    }

    
    /** 
     * @param obj element to remove
     * @return boolean return true if is done false otherwise
     */
    public boolean removeElement(Object obj){
        return vector.removeElement(obj);
    }

    
    /** 
     * @param index the index to remove
     */
    public void removeElementAt(int index){
        vector.removeElementAt(index);
    }

    
    /** 
     * @param obj value to set
     * @param index index of element to set
     */
    public void setElementAt(Object obj, int index){
        vector.setElementAt(obj, index);
    }

    
    /** 
     * @param newSize the value to resize
     */
    public void setSize(int newSize){
        vector.setSize(newSize);
    }

    
    /** 
     * @return int return the size of vector
     */
    public int size(){
        return vector.size();
    }

    
    /** 
     * @return String return string
     */
    public String toString(){
        return vector.toString();
    }

    public void trimToSize(){
        vector.trimToSize();
    }

    
    /** 
     * @param obj the param object to verify
     * @return boolean return true if is equals else otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector vector1 = (Vector) obj;
        return Objects.equals(vector, vector1.vector);
    }

    
    /** 
     * @return int the hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(vector);
    }

    
    /** 
     * @param object the object to insert in vector
     */
    public void add(Object object) {
    }
}
