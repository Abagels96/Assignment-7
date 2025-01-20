package com.coderscampus.arraylist;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.coderscampus.arraylist.CustomArrayList;

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
	void should_add_when_array_is_at_capacity() {
		CustomArrayList<String> sut= new CustomArrayList<String>();
		
		for(int i=0; i<10;i++) {
			sut.add(i, "string"+i);
		}
	boolean ans= sut.add(10, "string10");
		assertTrue(ans);		
		assertEquals(11, sut.getSize());
		assertEquals("string10",sut.get(10));
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
		sut.add(0, "fat");
		sut.add(1, "fatter");
		assertEquals("fat", sut.get(0));
		assertEquals("fatter", sut.get(1));

	}

	@Test
	void should_throw_exception_adding_beyond_array() {
		CustomArrayList<String> sut = new CustomArrayList<String>();

		assertThrows(IndexOutOfBoundsException.class, () -> {
			sut.add(1, "happy");

		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			sut.add(-1, "happy");

		});

	}

	@Test
	void should_add_items_at_index_zero() {
		CustomArrayList<String> sut = new CustomArrayList<String>();
		boolean ans = sut.add(0, "item");
		assertTrue(ans);
		assertEquals(1, sut.getSize());

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
		assertThrows(IndexOutOfBoundsException.class, () -> {
			sut.get(-1);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
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
		assertThrows(IndexOutOfBoundsException.class, () -> {
			sut.remove(15);
		});

	}

	@Test
	void should_remove_items_at_the_given_index() {
		CustomArrayList<String> sut = new CustomArrayList<String>();
		for (int i = 0; i < 15; i++) {
			sut.add("pint" + i);

		}
		sut.remove(14);
		assertEquals(14, sut.getSize());
	}

}
