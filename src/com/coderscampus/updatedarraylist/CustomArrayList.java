package com.coderscampus.updatedarraylist;



import java.util.Arrays;

// to add an element to an array we need to 
//make sure that it is still the same array 
//a. check and see if there is an index that we can add to 
//b.find where the first empty space would be
//c. we now need to determine if the current array is full
// d. then have it double in size somehow probably with newItems

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

}
