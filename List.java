/*
 * A simple, generic implementation of a List 
 * using an array. 
 * 
 * Written by Tarif Haque
 * Data Structures & Algorithms
 */

import java.util.Arrays;

public class List<Type> {

	private int size;
	private Object array[];
	private static final int DEFAULT_SIZE = 10;

	public List() {
		array = new Object[DEFAULT_SIZE];
	}

	public void add(Type element) {
		if (size == array.length) {
			doubleArraySize();
		}
		array[size++] = element;
	}

	private void doubleArraySize() {
		int newSize = array.length * 2;
		array = Arrays.copyOf(array, newSize);
	}
	
	public int getSize() {
		return size;
	}

	@SuppressWarnings("unchecked")
	public Type get(int index) {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + ", "
					+ "Size " + index);
		}
		return (Type) array[index];
	}
}
