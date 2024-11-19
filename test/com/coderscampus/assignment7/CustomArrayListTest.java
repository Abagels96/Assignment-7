package com.coderscampus.assignment7;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.coderscampus.arraylist.CustomArrayList;

class CustomArrayListTest {
	@Test
	void should_return_true_if_item_is_added() {
		CustomArrayList<String> sut = new CustomArrayList<>();

		boolean ans= sut.add("sad");
for(int i=0;i<20;i++) {
	sut.add("happy"+i);
}
		assertEquals(true, ans);
		assertEquals(sut.get(14),"happy13");
		assertEquals(sut.getSize(),21);

	}

	@Test
	void should_add_item_at_index() {
		CustomArrayList<String> sut = new CustomArrayList<String>();
		
		boolean ans=sut.add(0, "fat");
		sut.add("I");
		sut.add(1, "fatter");
		sut.add(5, "J");

		assertEquals(true,ans);
		assertEquals(sut.get(0), "fat");
		assertEquals(sut.get(1), "fatter");
		assertEquals(sut.get(5), "J");
		assertEquals(sut.getSize(),4);

	}

	@Test
	void should_count_items_in_array() {
		CustomArrayList<String> sut = new CustomArrayList<String>();

		for (int i = 0; i < 15; i++) {
			sut.add("cow" + i);
		}
		int result = sut.getSize();
		
		assertEquals(15, result);

	}

	@Test
	void should_retrieve_item_at_specified_index() {
		CustomArrayList<String> sut = new CustomArrayList<String>();
		
		
		for (int i = 0; i < 20; i++) {
			sut.add("pig" + i);
		}
		String itIsHere = sut.get(15);
		String rightHere = sut.get(5);

		assertEquals(itIsHere, "pig15");
		assertEquals(rightHere, "pig5");

	}

	@Test
	void should_remove_item_at_given_index() {

		CustomArrayList<String> sut = new CustomArrayList<String>();
		for (int i = 0; i < 22; i++) {
			sut.add("hot" + i);
		}

		assertEquals(sut.getSize(),22);
		sut.remove(7);

		assertEquals(sut.get(7), "hot8");
		assertEquals(sut.getSize(),21);

	}

}
