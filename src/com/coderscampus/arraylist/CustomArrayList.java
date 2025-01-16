package com.coderscampus.arraylist;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	int size = 0;

	@Override
	public boolean add(T item) {

		if (size == items.length) {
			items = isArrayFull(items);
		}
		items[size] = item;
		size++;
		return true;

	}

	

	@Override
	public int getSize() {

		return size;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {

		int i = index;
		if (index >= 0 && index < size) {

			return (T) items[i];

		} else  {
			throw new IndexOutOfBoundsException();
		}

// test this method 
	}

	public Object[] isArrayFull(Object[] items) {

		items = Arrays.copyOf(items, items.length * 2);

		return items;
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
//items[index] = item; when index == size: This will fail if the index is equal to size because the array might not be resized, and you would try to access an out-of-bounds index. You need to handle the case of adding to the next available slot.
//
//The general structure of this method is incorrect. Let's break it down:
//

if(index<0|| index>size) {
	throw new IndexOutOfBoundsException();
	
}
	 if(size==index) {
		items= isArrayFull(items);
	}
	if(index<size) {
		items=shiftRight(items, index);
	}
			
			items[index]=item;
			size++;
			
			
			return true;
		

	}

	private Object[] shiftRight(Object[] items, int index) {
 if(index<size) {
		System.arraycopy(items, index, items, index + 1, size - index );}

		return items;
 
	}
	

	
	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		Object removed = items[index];
		if (index >= 0 && index < size) {
 			System.arraycopy(items, index + 1, items, index, size - index - 1);
			size--;

		}
		else if (index > size - 1) {
			throw new IndexOutOfBoundsException();
		}

		return (T) removed;
	}

}