package com.coderscampus.updatedarraylist;

public class TestApplication {

	public static void main(String[] args) {

		CustomArrayList<String> customArrayList = new CustomArrayList<String>();

		for (int i = 0; i < 20; i++) {
			customArrayList.add("item " + i);

		}

		System.out.println(customArrayList.add(null));
		System.out.println(customArrayList.add("Peanuts"));
		System.out.println(customArrayList.get(4));
		System.out.println(customArrayList.get(6));
		System.out.println(customArrayList.get(10));
		System.out.println(customArrayList.getSize());
		System.out.println(customArrayList.get(0));
		System.out.println(customArrayList.add(10, "fat"));
//		System.out.println(customArrayList.remove(10));

	}

}
