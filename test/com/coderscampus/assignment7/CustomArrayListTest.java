package com.coderscampus.assignment7;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.coderscampus.updatedarraylist.CustomArrayList;

class CustomArrayListTest {
// 1. Write a failing test 
	// 2. write the business logic of the code to make it pass
	// 3. refactor your code
	@Test
	void should_return_true_if_item_is_added() {
//Arrange
		CustomArrayList<String> sut = new CustomArrayList<>();

		// Act

		boolean ans = sut.add("I");
		// Assert
		assertEquals(true, ans);
		assertEquals(sut.get(0), "I");
		assertEquals(sut.getSize(), 1);

	}

	@Test
	void should_add_item_at_index() {
		// Arrange
		CustomArrayList<String> sut = new CustomArrayList<String>();
		// Act
		sut.add("I");
		sut.add(0, "fat");
		sut.add(1, "fatter");
		sut.add(5, "J");
//		boolean ans=sut.add(0, "fat");

		// Assert
//		assertEquals(true,ans);
		assertEquals(sut.get(0), "fat");
		assertEquals(sut.get(1), "fatter");
		assertEquals(sut.get(5), "J");

	}

	@Test
	void should_count_items_in_array() {
		// Arrange
		CustomArrayList<String> sut = new CustomArrayList<String>();

		// Act
		for (int i = 0; i < 15; i++) {
			sut.add("cow" + i);
		}
		int result = sut.getSize();
		// Assert
		assertEquals(15, result);
		assertEquals(0, result);

	}

	@Test
	void should_retrieve_item_at_specified_index() {
		// Arrange
		CustomArrayList<String> sut = new CustomArrayList<String>();
		// Act
		for (int i = 0; i < 20; i++) {
			sut.add("pig" + i);
		}
		String itIsHere = sut.get(15);
		String rightHere = sut.get(5);

		// Assert
		assertEquals(itIsHere, "pig15");
		assertEquals(rightHere, "pig5");

	}

	@Test
	void should_remove_item_at_given_index() {
		// Arrange

		CustomArrayList<String> sut = new CustomArrayList<String>();
		// Act
		for (int i = 0; i < 22; i++) {
			sut.add("hot" + i);
		}

		sut.remove(7);

		// Assert
		assertEquals(sut.get(7), "hot8");
		assertEquals(sut.getSize(),20);

	}

}
