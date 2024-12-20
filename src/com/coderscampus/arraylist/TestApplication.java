package com.coderscampus.arraylist;

public class TestApplication {
	
	 public static void main(String[] args) {
		 
		 
		 CustomArrayList<String> customArrayList= new CustomArrayList<>();
		 
		 
		 for(int i=0; i<20; i++) {
			customArrayList.add("item " + i);

		}
		System.out.println(customArrayList.add(null));
		System.out.println(customArrayList.add("Peanuts"));
	System.out.println(customArrayList.add(22, "item22"));
		System.out.println(customArrayList.remove(15));

	}

}
