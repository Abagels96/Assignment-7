package com.coderscampus.updatedarraylist;



import java.util.Arrays;


public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	//
	int size = 0;

	@Override
	public boolean add(T item) {

		//

		if (size == items.length) {
			System.out.println("Array is full");
			items = isArrayFull(items);
			items[size] = item;
			size++;
		} else {
			items[size] = item;

			size++;
			return true;
		}

		// if array is full then double the items

		return false;

	}

	{
	}

	@Override
	public int getSize() {

		for (Object item : items) {

			if (item != null || size > 0) {
				return size;

			} else if (item == null) {
				break;
			}

		}

		return 0;
	}

	@Override
	public T get(int index) {

		int i = index;
		if (index >= 0 && index < items.length) {

			return (T) items[i];

		}

		return null;
	}

	public Object[] isArrayFull(Object[] items) {

		items = Arrays.copyOf(items, items.length * 2);

		return items;
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
if(index>=0&& index<items.length) {
	if(items[index]!= null) {
		shiftRight(items);
		items[index]=item;
	}
		
		//need a method to move what is already there to the right one place 
		System.out.println(Arrays.toString(items));
		return true;
}
else {
	return false;
	
}
	}

	private void shiftRight(Object[] items) {

	Object last= items[items.length-1];
System.arraycopy(items, 0, items, 1, items.length-1);
items[0]=last;
System.out.println(items);
	
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

}
