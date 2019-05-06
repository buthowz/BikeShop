
/**
 * My own arraylist to be used for shop and order class.
 * 
 * @author Sujit Neupane 
 * @version 04/19/2017
 */
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.io.Serializable;
public class MyArrayList<E> implements MyArrayListInterface<E>, Iterable<E>, Serializable { //can use for each loop after implementing Iterable
    public Iterator <E> iterator() {
        return new ArrayListIterator();
    }

    /**
     * ArrayListIterator for MyArrayList<E>
     */
    private class ArrayListIterator implements Iterator<E> {
        private int position; 
        private boolean removeOk; 

        /**
         * Constructor for class ArrayListIterator
         */
        public ArrayListIterator() {
            position = 0;//points to the first element in the arraylist
            removeOk = false;// remove is permitted if it is true
        }

        /**
         * True if the arraylist has next element in it
         * @return  true if the arraylist has next element in it.
         */

        @Override
        public boolean hasNext() {
            return position < size();
        }

        /**
         * Gives us a next element from the arraylist
         * @return  next element from the arraylist
         */
        @Override
        public E next(){
            if(!hasNext()) {
                throw new NoSuchElementException("No more elements in the list");
            }
            E result = elementData[position];
            position++;//forwards the pointer in the arraylist
            removeOk = true;// ok to remove now as it has next element
            return result;
        }

        /**
         * Removes an element from the arraylist
         */
        @Override
        public void remove(){
            if (!removeOk) {
                throw new IllegalStateException("Attempted remove before next!");
            }
            MyArrayList.this.remove(position - 1);//calls remove(int index) method of MyArrayList
            position--;//removes the element
            removeOk = false;//sets it to false until the next method is called
        }
    }

    public static final int DEFAULT_SIZE = 50;
    private E[] elementData;
    private int size;

    /**
    * Constructor for MyArrayList objects
    */
    @SuppressWarnings("unchecked")
    public MyArrayList() {
        elementData = (E[])new Object[DEFAULT_SIZE];//only way to declare generic array
        size = 0;//arraylist is empty
    }

    /**
     * Gives us the size of the arraylist
     * @return  size of the array
     */
    public int size() {
        return size;
    }

    /**
     * Adds a element at a time to the arraylist
     * @param   element The element to be added to the arraylist
     * @return  true if the add is successful
     */
    public boolean add(E element) {
        ensureCapacity();
        elementData[size] = element;
        size++;
        return true;
    }

    /**
     * Adds element in the arraylist in the specified position of the arraylist
     * @param   index Index where the element is to be added
     * @param   element Element which needs to be added in the arraylist
     * @return  increased size of the arraylist  
     */
    public void add(int index, E element) {
        checkIndex(index);
        ensureCapacity();
        for (int idx = size; idx >= index + 1; idx--) {
            elementData[idx] = elementData[idx - 1];
        }
        elementData[index] = element;
        size++;
    }

    /**
     * Removes an element from the arraylist and gives it back to us
     * @param   index Index of the element which need to be removed from the arraylist
     * @return  Returns the element which is removed from the arraylist
     */
    public E remove(int index) {
        checkIndex(index);
        E returnElement = elementData[index];
        for (int idx = index; idx < size - 1; idx++) {
            elementData[idx] = elementData[idx + 1];
        }
        elementData[size-1] = null;
        size--;
        return returnElement;
    }

    /**
     * Checks if the index is within zero and size of arraylist
     * @param   index Index number which needs to be checked
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Invalid index! Must be between 0 and size");
        }
    }
    
    /**
     * Identifies the index number of the element
     * @param   element The element whose index need to be find out
     * @return  Index number of the element
     */
    private int indexOf(E element) {
        for (int index = 0; index < size; index++) {
            if (elementData[index] == element) {
                return index;
            }
        }
        return -1;
    }
    
    /**
     * Checks if the arraylist has the specified element in it
     * @param   element The element which needs to be checked in the arraylist for its presence
     * @return  true if the element is in the arraylist
     */
    public boolean contains(E element) {
        return (indexOf(element) >= 0);
    }

    /**
     * Gets us specified element in the arraylist
     * @param index number of the element which is to be retrieved from the arraylist
     * @return An element from the arraylist which is specified by the index number 
     */
    public E getElement(int index) {
        checkIndex(index);
        return elementData[index];
    }

    /**
     * Checks whether the arraylist is empty or not
     * @return true if the arraylist is empt
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Makes sure the capacity of the array is enough to hold added elements
     * @param   desiredCapacity The capacity by which the array needs to be increased
     * @return  a new capacity of the arraylist
     */
    private void ensureCapacity() {
        if (elementData.length == size()) {
            int newCapacity = elementData.length + elementData.length/2;
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    } 

    /**
     * Clears the whole arraylist and sets the size to zero
     */
    public void clear() {
        size = 0;
    } 
    
    /**
     * String representation of MyArrayList object
     * @return String representation of MyArrayList object
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            String result = "[" + elementData[0];//solved fence post problem here
            for (int index = 1; index < size; index++) {
                result += ", \n" + elementData[index];
            }
            return result + "]";
        }       
    }
}
