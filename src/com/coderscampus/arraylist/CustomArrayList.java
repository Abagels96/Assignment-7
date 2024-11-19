package com.coderscampus.arraylist;

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
			// takes index and item and then adds the item at the index.Everything else it
			// shifts to the right and it doesn't leave behind null when it is moved
			// somewhere else and then
			// the items array goes back to normal.

			if (index >= 0 && index < items.length) {
				if (items[index] != null) {
					items = shiftRight(items, index);
					items[index] = item;
					System.out.println(Arrays.toString(items));
				} else {
					items[index] = item;
				}

				return true;
			} else {
				return false;

			}


		}

		private Object[] shiftRight(Object[] items, int index) {
			Object last = items[items.length - 1];

			System.arraycopy(items, index, items, index + 1, items.length - index - 1);
//			System.out.println(Arrays.toString(items));
			return items;

		}

		@Override
		public T remove(int index) throws IndexOutOfBoundsException {
			if (index >= 0 && index < items.length) {
				Object last = items.length - index - 1;
				System.arraycopy(items, index + 1, items, index, items.length - index - 1);
				last = items[index];
				Arrays.toString(items);
			System.out.println(items[index]);
			if (index >= 0 ||index < items.length) {
				removeIndex(index);
			} else {

				return null;
			}
			
			// this might be returning the items at the index after the removeIndex method has run. I wonder if I could see what
			// it is returning at the start of the method. yep that is what is happening.now how do I fix it? That is the real question.
			return (T) items[index];
		}}

		public void removeIndex(int index) {
			System.arraycopy(items, index + 1, items, index, items.length - index-1);
			


}
	}