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

	{
	}

	@Override
	public int getSize() {

		return size;
	}

	@Override
	public T get(int index) throws IndexOutOfBoundsException {

		int i = index;
		if (index >= 0 && index <= size - 1) {

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

		if (index >= 0 && index < size) {
				items = shiftRight(items, index);
				items[index] = item;
				size++;
			} else if(index==size) {
				isArrayFull(items);
				items[index] = item;
				size++;
				System.out.println(Arrays.toString(items));
			}
			else {
		throw new IndexOutOfBoundsException();
			}
			return true;
		

	}

	private Object[] shiftRight(Object[] items, int index) {

		System.arraycopy(items, index, items, index + 1, items.length - index - 1);
		return items;

	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		Object removed = items[index];
		if (index >= 0 && index <= size - 1) {
 			System.arraycopy(items, index + 1, items, index, items.length - index - 1);
			Arrays.toString(items);

		} else if (index > size - 1) {
			throw new IndexOutOfBoundsException();
		}

		return (T) removed;
	}

}