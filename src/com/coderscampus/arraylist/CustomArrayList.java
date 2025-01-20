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

		} else {
			throw new IndexOutOfBoundsException();
		}

	}

	public Object[] isArrayFull(Object[] items) {

		items = Arrays.copyOf(items, items.length * 2);
		return items;
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();

		}
		if (size == items.length) {
			items = isArrayFull(items);
		}
		if (index < size) {
			items = shiftRight(items, index);
		}

		items[index] = item;
		size++;

		return true;

	}

	private Object[] shiftRight(Object[] items, int index) {
		if (index < size) {
			System.arraycopy(items, index, items, index + 1, size - index);
		}

		return items;

	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException();
		}
		Object removed = items[index];
		System.arraycopy(items, index + 1, items, index, size - index - 1);
		items[size - 1] = null;

		size--;

		return (T) removed;
	}

}
