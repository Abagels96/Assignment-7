package com.coderscampus.assignment7;

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
		
		assertEquals(sut.get(0),"sad");
		assertEquals(sut.getSize(),1);
		
	
	}
	@Test
	void should_return_true_if_an_item_is_added_to_an_array() {
		CustomArrayList<String> sut= new CustomArrayList<String>();
	
		boolean ans= sut.add("add");
		
		assertTrue(ans);
	
	}
	@Test
	 void add_multiple_items_to_array() {
		
		CustomArrayList<String> sut= new CustomArrayList<String>();
		
		
		for(int i=0;i<11;i++) {
			sut.add("item"+i);
		}
		assertEquals(sut.getSize(),11);
		assertEquals(sut.get(10),"item10");
	}
@Test
void add_null_to_array() {
	CustomArrayList<String>sut= new CustomArrayList<String>();
	boolean answer=sut.add(null);
	
	sut.add("heart");
	assertTrue(answer);
	assertEquals(sut.getSize(),2);

}
	@Test
	void should_add_items_at_index() {
		CustomArrayList<String> sut = new CustomArrayList<String>();
		
		boolean ans=sut.add(0, "fat");
		sut.add(1, "fatter");
		sut.add(5, "J");

		assertEquals(sut.get(0), "fat");
		assertEquals(sut.get(1), "fatter");

	}
	@Test
	void should_return_true_when_index_is_specified() {
		CustomArrayList< String> sut= new CustomArrayList<String>();
		
	boolean ans=sut.add(0, "that");
	
	assertTrue(ans);
	
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
	void should_return_zero_if_empty() {
		CustomArrayList<String>sut= new CustomArrayList<String>();
		
	assertEquals(sut.getSize(),0);
	}

	@Test
	void should_retrieve_item_at_specified_index() {
		CustomArrayList<String> sut = new CustomArrayList<String>();
		
		
		for (int i = 0; i < 10; i++) {
			sut.add("pig" + i);
		}
		String firstIndex= sut.get(0);
		String secondIndex= sut.get(1);
		String thirdndex= sut.get(2);
		String fourthIndex= sut.get(3);
		String fifthIndex= sut.get(4);
		String sixthIndex= sut.get(5);
		String seventhIndex= sut.get(6);
		String eighthIndex= sut.get(7);
		String ninthIndex= sut.get(8);
		String tenthIndex= sut.get(9);
		

		assertEquals(firstIndex, "pig0");
		assertEquals(secondIndex, "pig1");
		assertEquals(thirdndex, "pig2");
		assertEquals(fourthIndex, "pig3");
		assertEquals(fifthIndex, "pig4");
		assertEquals(sixthIndex, "pig5");
		assertEquals(seventhIndex, "pig6");
		assertEquals(eighthIndex, "pig7");
		assertEquals(ninthIndex, "pig8");
		assertEquals(tenthIndex, "pig9");

	}
	
	@Test
	void should_throw_exception_if_invalid_index_referenced() {
		CustomArrayList<String> sut= new CustomArrayList<String>();
		
		for(int i=0; i<5; i++) {
			sut.add("item"+i);
			
		}
		assertEquals(sut.get(5),"item5");
//		assertEquals(sut.get(6),"item6");
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
	@Test
	
	void should_throw_exception_when_trying_to_remove_items_at_the_given_index() {
		CustomArrayList<String> sut= new CustomArrayList<String>();
		
		for(int i=0; i<10; i++) {
			sut.add("color"+i);
		}
		sut.remove(15);
	}

}
