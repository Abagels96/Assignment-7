package com.coderscampus.updatedarraylist;

public class UpdateArrayList {

//Your CustomArrayList implementation is functional but has some areas for improvement and potential issues. Here’s a detailed review and some suggested fixes:
//
//1. Issue in add(int index, T item)
//Problem: The condition index >= 0 && index < size incorrectly excludes cases where index == size (e.g., adding at the end of the list).
//
//Fix: Allow index == size to append an item at the end.
//
//Problem: The condition if (index < 0 || index > size) inside the else if block can never be reached since it contradicts the initial condition.
//
//Fix: Move the bounds check to the top of the method.
//
//Revised add(int index, T item)
//java
//Copy code
@Override
public boolean add(int index, T item) throws IndexOutOfBoundsException {
    // Check bounds upfront
    if (index < 0 || index > size) {
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    // Resize if array is full
    if (size == items.length) {
        items = isArrayFull(items);
    }

    // Shift elements if inserting in the middle
    if (index < size) {
        items = shiftRight(items, index);
    }

    items[index] = item;
    size++;
    return true;
}
2. Issue in remove(int index)
Problem: The bounds check index >= 0 && index < items.length uses items.length, which reflects the capacity of the array, not the number of valid elements.

Fix: Use size instead of items.length for bounds validation.

Problem: If index is invalid, the method returns null, which contradicts the expected exception-based behavior.

Fix: Throw IndexOutOfBoundsException when index is out of bounds.

Revised remove(int index)
java
Copy code
@Override
public T remove(int index) throws IndexOutOfBoundsException {
    // Validate index
    if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    T removed = (T) items[index];
    System.arraycopy(items, index + 1, items, index, size - index - 1);
    items[--size] = null; // Null out the last valid element and decrement size
    return removed;
}
3. Redundant Code in add(T item)
Problem: The if-else block has duplicate code for adding an item.
Fix: Consolidate the logic.
Revised add(T item)
java
Copy code
@Override
public boolean add(T item) {
    // Resize if array is full
    if (size == items.length) {
        items = isArrayFull(items);
    }
    items[size++] = item;
    return true;
}
4. Redundant Block in Class Body
Problem: There’s an empty block {} in your class after add method, which serves no purpose.
Fix: Remove the empty block.
5. Potential Performance Issue in shiftRight
Problem: While shiftRight works, directly using System.arraycopy inside the add(int index, T item) method simplifies the code.
Fix: Inline System.arraycopy in add(int index, T item) and remove shiftRight.
Final Revised CustomArrayList Class
java
Copy code
package com.coderscampus.updatedarraylist;

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
    Object[] items = new Object[10];
    int size = 0;

    @Override
    public boolean add(T item) {
        // Resize if array is full
        if (size == items.length) {
            items = isArrayFull(items);
        }
        items[size++] = item;
        return true;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) items[index];
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    public Object[] isArrayFull(Object[] items) {
        return Arrays.copyOf(items, items.length * 2);
    }

    @Override
    public boolean add(int index, T item) throws IndexOutOfBoundsException {
        // Check bounds upfront
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        // Resize if array is full
        if (size == items.length) {
            items = isArrayFull(items);
        }

        // Shift elements if inserting in the middle
        if (index < size) {
            System.arraycopy(items, index, items, index + 1, size - index);
        }

        items[index] = item;
        size++;
        return true;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        // Validate index
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        T removed = (T) items[index];
        System.arraycopy(items, index + 1, items, index, size - index - 1);
        items[--size] = null; // Null out the last valid element and decrement size
        return removed;
    }
}
//Key Improvements
//Cleaner add and remove Methods: Simplified logic and ensured proper bounds checking.
//Use of size for Validation: Consistently using size instead of items.length where appropriate.
//Robust Exception Handling: Replaced return null with IndexOutOfBoundsException where required.
//Consolidated Code: Removed redundant or unnecessary logic for better readability and maintainability.
//This final version is efficient, robust, and adheres to expected CustomList behavior.

}
