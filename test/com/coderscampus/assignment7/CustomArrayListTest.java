package com.coderscampus.assignment7;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import com.coderscampus.updatedarraylist.CustomArrayList;

class CustomArrayListTest {
// 1. Write a failing test 
	//2. write the business logic of the code to make it pass
	//3. refactor your code 
	@Test
	void should_return_true_if_item_is_added()  {
//Arrange
		CustomArrayList<String> sut= new CustomArrayList<>();
		
	
		
		//Act
		
		boolean ans= sut.add("I");
		//Assert
	assertEquals(true, ans);
	assertEquals(sut.get(0),"I");
	assertEquals(sut.getSize(),1);
	
	
	}
	
	@Test
	void should_add_item_at_index() {
		//Arrange
		CustomArrayList<String> sut= new CustomArrayList<String>();
		//Act
		sut.add("I");
		sut.add(0, "fat");
		sut.add(1, "fatter");
		sut.add("J");
		assertEquals(sut.get(0),"I");
		boolean ans=sut.add(0, "fat");
		
		//Assert
		assertEquals(true,ans);
	assertEquals(sut.get(0),"fat");
	assertEquals(sut.get(1),"I");
		
	}
	

}
