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
		} else {
			items[size] = item;

			size++;
			return true;
		}

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

		if (index >= 0 && index < items.length) {
			if (items[index] != null) {
				items = shiftRight(items, index);
				items[index] = item;
				size++;
			} else {
				items[index] = item;
				size++;
			}

			return true;
		} else {
			return false;

		}

	}

	private Object[] shiftRight(Object[] items, int index) {
		Object last = items[items.length - 1];

		System.arraycopy(items, index, items, index + 1, items.length - index - 1);
		return items;

	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {f
		Object removed = items[index];
		if (index >= 0 && index < items.length) {
			System.arraycopy(items, index + 1, items, index, items.length - index - 1);
			items[size - 1] = null;
			size--;
		} else {

			return null;
		}
		return (T) removed;

	}

}
