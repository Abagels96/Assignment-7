package com.coderscampus.arraylist;

public class TestApplication {
	
	 public static void main(String[] args) {
		 
		 
		 CustomArrayList<String> customArrayList= new CustomArrayList<>();
		 
		 
		 for(int i=0; i<20; i++) {
			customArrayList.add("item " + i);

		}
customArrayList.add(20, "yuck");
	}

}
