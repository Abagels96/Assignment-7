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
	assertEquals(false, ans);
	
	}

}
