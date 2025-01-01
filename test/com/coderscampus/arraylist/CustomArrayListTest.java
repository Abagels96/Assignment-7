package com.coderscampus.arraylist;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.coderscampus.arraylist.CustomArrayList;

// Basic Successful Cases
//Edge cases(empty list, full list)
//Potential error conditons
class CustomArrayListTest {
	@Test
	void should_add_item_to_array() {
		CustomArrayList<String> sut = new CustomArrayList<>();

		sut.add("sad");

		assertEquals("sad", sut.get(0));
		assertEquals(1, sut.getSize());

	}

	@Test
	void should_return_true_if_an_item_is_added_to_an_array() {
		CustomArrayList<String> sut = new CustomArrayList<String>();

		boolean ans = sut.add("add");

		assertTrue(ans);

	}

	@Test
	void add_multiple_items_to_array() {

		CustomArrayList<String> sut = new CustomArrayList<String>();

		for (int i = 0; i < 11; i++) {
			sut.add("item" + i);
		}
		assertEquals(11, sut.getSize());
		assertEquals("item10", sut.get(10));
	}

	@Test
	void add_null_to_array() {
		CustomArrayList<String> sut = new CustomArrayList<String>();
		boolean answer = sut.add(null);

		sut.add("heart");
		assertTrue(answer);
		assertEquals(2, sut.getSize());

	}

	@Test
	void should_add_items_at_index() {
		CustomArrayList<String> sut = new CustomArrayList<String>();
// this failed because it exceeded size. 
		 sut.add(0, "fat");

		assertEquals("fat", sut.get(0));
		assertEquals("fatter", sut.get(1));

	}
	@Test
	void should_add_items_at_index_zero() {
		CustomArrayList<String>sut= new CustomArrayList<String>();
		
		boolean ans= sut.add(0, "item");
		
		assertTrue(ans);
		assertEquals(1,sut.getSize());
		
		assertEquals("item", sut.get(0));
	}

	@Test
	void should_return_true_when_index_is_specified() {
		CustomArrayList<String> sut = new CustomArrayList<String>();

		boolean ans = sut.add(0, "that");

		assertTrue(ans);

	}

	@Test
	void should_count_items_in_array() {
		CustomArrayList<String> sut = new CustomArrayList<String>();

		for (int i = 0; i < 15; i++) {
			sut.add("cow" + i);
		}
		int result = sut.getSize();

		assertEquals(result, 15);

	}

	@Test
	void should_return_zero_if_empty() {
		CustomArrayList<String> sut = new CustomArrayList<String>();

		assertEquals(0, sut.getSize());
	}

	@Test
	void should_retrieve_item_at_specified_index() {
		CustomArrayList<String> sut = new CustomArrayList<String>();

		for (int i = 0; i < 10; i++) {
			sut.add("pig" + i);
		}
		String firstIndex = sut.get(0);
		String secondIndex = sut.get(1);
		String thirdndex = sut.get(2);
		String fourthIndex = sut.get(3);
		String fifthIndex = sut.get(4);
		String sixthIndex = sut.get(5);
		String seventhIndex = sut.get(6);
		String eighthIndex = sut.get(7);
		String ninthIndex = sut.get(8);
		String tenthIndex = sut.get(9);

		assertEquals("pig0", firstIndex);
		assertEquals("pig1", secondIndex);
		assertEquals("pig2", thirdndex);
		assertEquals("pig3", fourthIndex);
		assertEquals("pig4", fifthIndex);
		assertEquals("pig5", sixthIndex);
		assertEquals("pig6", seventhIndex);
		assertEquals("pig7", eighthIndex);
		assertEquals("pig8", ninthIndex);
		assertEquals("pig9", tenthIndex);

	}

	@Test
	void should_throw_exception_if_invalid_index_referenced() {
		CustomArrayList<String> sut = new CustomArrayList<String>();

		for (int i = 0; i < 5; i++) {
			sut.add("item" + i);

		}
		assertThrows(IndexOutOfBoundsException.class,()->{
			sut.get(-1);
		});
		assertThrows(IndexOutOfBoundsException.class,()->{
			sut.get(7);
		});
	}

	@Test
	void should_remove_item_at_given_index() {
		CustomArrayList<String> sut = new CustomArrayList<String>();
		for (int i = 0; i < 22; i++) {
			sut.add("hot" + i);
		}

		assertEquals(22, sut.getSize());
		sut.remove(7);

		assertEquals("hot8", sut.get(7));
		assertEquals(21, sut.getSize());

	}

	@Test

	void should_throw_exception_when_trying_to_remove_items_at_the_given_index() {
		CustomArrayList<String> sut = new CustomArrayList<String>();

		for (int i = 0; i < 10; i++) {
			sut.add("color" + i);
		}
		assertThrows(IndexOutOfBoundsException.class,()->{
			sut.remove(15);
		});
		
			
		}
	@Test
	void should_remove_items_at_the_given_index() {
		CustomArrayList<String> sut= new CustomArrayList<String>();
	 for(int i=0; i<15;i++) {
		 sut.add("pint"+i);
		
		
	}
	 sut.remove(14);
assertEquals(14,sut.getSize());
}

}
//Hey Abigail Bales, thanks for resubmitting your assignment! You’ve made some solid improvements, like better handling of index == size in the add(int index, T item) method and more consistent exception handling in remove(int index). However, there are still a few issues to address:
	//1.	In add(int index, T item): Resizing is not handled properly when adding at index == size. Make sure to assign the resized array back to items when calling isArrayFull(items).
//	2.	In remove(int index): The size is not decremented properly after removing an element, which leads to logical inconsistencies in the list.
	//3.	In shiftRight: The System.arraycopy call can shift elements out of bounds, especially when adding elements near the end of the list. Adjust the range to avoid this.
	//4.	Test Class: your CustomArrayListTest class is in the wrong package, which makes it complicated to run on my machine. I had to change the package name to com.coderscampus.arraylist (same as your main classes) and rebuild to be able to run your tests
	//5.	Test Failures: Your tests (should_add_items_at_index, should_remove_item_at_given_index, should_remove_items_at_the_given_index) are failing. These highlight flaws in the shifting and resizing logic. Review the scenarios these tests are trying to validate and adjust your methods accordingly.
// You’re very close! Focus on fixing these key areas, and you’ll be ready to resubmit. Let me know if you have questions or need clarification. Keep up the good work!