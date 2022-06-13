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
     * @param obj 
     * @param index 
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
     * @param elem 
     * @return int 
     */
    public int lastIndexOf(Object elem){
        return vector.lastIndexOf(elem);
    }

    
    /** 
     * @param elem 
     * @param index 
     * @return int 
     */
    public int lastIndexOf(Object elem, int index){
        return vector.lastIndexOf(elem, index);
    }

    public void removeAllElements(){
        vector.removeAllElements();
    }

    
    /** 
     * @param obj 
     * @return boolean 
     */
    public boolean removeElement(Object obj){
        return vector.removeElement(obj);
    }

    
    /** 
     * @param index
     */
    public void removeElementAt(int index){
        vector.removeElementAt(index);
    }

    
    /** 
     * @param obj 
     * @param index 
     */
    public void setElementAt(Object obj, int index){
        vector.setElementAt(obj, index);
    }

    
    /** 
     * @param newSize 
     */
    public void setSize(int newSize){
        vector.setSize(newSize);
    }

    
    /** 
     * @return int 
     */
    public int size(){
        return vector.size();
    }

    
    /** 
     * @return String 
     */
    public String toString(){
        return vector.toString();
    }

    public void trimToSize(){
        vector.trimToSize();
    }

    
    /** 
     * @param obj 
     * @return boolean 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector vector1 = (Vector) obj;
        return Objects.equals(vector, vector1.vector);
    }

    
    /** 
     * @return int 
     */
    @Override
    public int hashCode() {
        return Objects.hash(vector);
    }

    
    /** 
     * @param object the 
     */
    public void add(Object object) {
    }
}
