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


if(index<0|| index>size) {
	throw new IndexOutOfBoundsException();
	
}
	 if(size==items.length) {
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
		 if ( index<0 ||index >size-1) {
			throw new IndexOutOfBoundsException();
		}
		 Object removed = items[index];
 			System.arraycopy(items, index + 1, items, index, size - index - 1);
 			items[size-1]= null;
 			
			size--;


		return (T) removed;
	}

}

//Hi Abigail,
//Thanks for resubmitting your assignment! You’ve made good progress, especially with exception handling and resizing logic. However, I had to reject your submission again as a few key issues remain:
//1. Resizing in add(int index, T item)
//When adding at index == size, your method calls isArrayFull(items) but doesn’t reassign the returned array to items. This needs to be fixed.
//2. Shifting Logic in shiftRight
//Your System.arraycopy uses items.length as the range, but it should only use the current size of the array. This can cause out-of-bounds errors.
//3. Cleanup in remove(int index)
//After shifting elements, you’re not clearing the last element (items[size]), which may leave stale data. Be sure to set it to null.
//
//5. Test Failures
//should_add_items_at_index fails. I see that you wrote a comment about it but there's a proper way for writing tests that should return an exception. You'll need to research this.
//6. Clean up your project
//You have a lot of comments in there that need to be removed (e.g. my last rejection comment in CustomArrayListTest). You also need to follow java conventions for line breaks and indentation. Finally your CustomList.java class should have the exact same javadoc comment as what is provided to you by Trevor. (you're missing the one for add(int index, T item)
//Next Steps:
//Fix these areas, rerun your tests, and verify that everything works. Let me know if you have questions—you’re very close! Keep it up!
//





