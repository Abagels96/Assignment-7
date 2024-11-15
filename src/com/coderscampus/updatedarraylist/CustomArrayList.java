package com.coderscampus.updatedarraylist;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	//
	int size = 0;

	@Override
	public boolean add(T item) {

		if (size == items.length) {
			items = isArrayFull(items);
			items[size] = item;
			size++;
			return true;
		} else {
			items[size] = item;

			size++;
			return true;
		}

	}

	{
	}

	@Override
	public int getSize() {

		return size;

	}

	@Override
	public T get(int index) {

		int i = index;
		if (index >= 0 && index < size) {

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

		if (index >= 0 && index < size) {
			if (items[index] != null) {
				items = shiftRight(items, index);
				items[index] = item;
				size++;
				return true;
			} else if (index == 0) {
				items[index] = item;
				size++;
				return true;
			} else if (index < 0 || index > size) {
				throw new IndexOutOfBoundsException();
			}

		}
		return false;

	}

	private Object[] shiftRight(Object[] items, int index) {

		System.arraycopy(items, index, items, index + 1, items.length - index - 1);
		return items;

	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		Object removed;
		if (index >= 0 && index < items.length) {
			removed = items[index];
			System.arraycopy(items, index + 1, items, index, items.length - index - 1);
			items[size - 1] = null;
			size--;
		} else {

			return null;
		}
		return (T) removed;

	}

}
