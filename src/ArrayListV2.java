import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;

import javax.lang.model.element.Element;

public class ArrayListV2 implements Collection<Object> {

	private int size;
	private int capacity;
	private Object[] elementData;
	private final static int DEFAULTCAPACITY = 8;

	/*
	 *
	 */
	public ArrayListV2(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Illegal capacity: " + capacity);
		}
		this.size = 0;
		this.capacity = capacity;
		this.elementData = new Object[capacity];
	}

	/*
	 * Default Constructor
	 */
	public ArrayListV2() {
		this.size = 0;
		this.capacity = DEFAULTCAPACITY;
		this.elementData = new Object[capacity];
	}

	/*
	 * Appends the specified element to the end of this list
	 */
	@Override
	public boolean add(Object element) {
		if (size >= capacity){
		Object[] elementDataCopy = new Object[capacity * 2];
		System.arraycopy(elementData, 0, elementDataCopy, 0, size);
		elementData = elementDataCopy;
		capacity *= 2;
		}
		elementData[size++] = element;
		return true;
	}

	/*
	 * Inserts the specified element at the specified position in this list
	 * 
	 */
	public void add(Object element, int index) {
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException("Illegal index:" + index);
		else {
			System.arraycopy(elementData, index, elementData, index + 1, size - index);
			elementData[index] = element;
			size++;
		}
	}

	/*
	 * Removes the first occurrence of the specified element from this list, if
	 * it is present
	 * 
	 */
	public boolean remove(Object element) {
		if (element == null) {
			for (int index = 0; index < size; index++) {
				if (elementData[index] == null)
					return remove(index);
			}
		} else {
			for (int index = 0; index < size; index++) {
				if (elementData[index] != null)
					if (elementData[index].equals(element))
						return remove(index);
			}
		}
		return false;
	}

	/*
	 * Removes the element at the specified position in this list
	 */
	public boolean remove(int index) {
		if (index >= size|| index < 0)
			throw new IndexOutOfBoundsException("llegal index:" + index);
		else
			System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
		size--;
		return true;
	}

	/*
	 * Returns the element at the specified position in this list
	 */
	public Object get(int index) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException("llegal index:" + index);
		else
			return elementData[index];
	}

	/*
	 * Replaces the element at the specified position in this list with the
	 * specified element
	 */
	public void set(Object element, int index) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException("llegal index:" + index);
		else
			elementData[index] = element;

	}

	/*
	 * Returns the number of elements in this list.
	 */
	public int getSize() {
		return size;
	}

	/*
	 * Returns a view of the portion of this list between the specified
	 * fromIndex, inclusive, and toIndex
	 */
	public void removeRange(int fromIndex, int toIndex) {
		if (fromIndex >= size || fromIndex < 0)
			throw new IndexOutOfBoundsException("llegal fromIndex: " + fromIndex);
		else if (toIndex >= size || toIndex < 0)
			throw new IndexOutOfBoundsException("llegal toIndex: " + toIndex);
		else if (fromIndex > toIndex)
			throw new IndexOutOfBoundsException("llegal: fromIndex > toIndex");
		else {
			if (toIndex < size - 1)
				System.arraycopy(elementData, toIndex + 1, elementData, fromIndex, size - (toIndex - fromIndex + 1));
			else
				System.arraycopy(elementData, 0, elementData, 0, size - fromIndex + 1);

			size = size - (toIndex - fromIndex + 1);
		}
	}

	/*
	 * 
	 */
	public void print() {
		for (int i = 0; i < this.getSize(); i++)
			System.out.print("A[" + i + "]=" + this.get(i) + "; ");
		System.out.println();
	}


	@Override
	public boolean addAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray(Object[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
