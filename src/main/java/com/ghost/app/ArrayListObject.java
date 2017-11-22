package com.ghost.app;

import java.util.ArrayList;

public class ArrayListObject extends GhostObject<ArrayList> {

	private static ArrayListObject instance = new ArrayListObject();
	
	public static void test(){
		ArrayListObject.printDefault();
		printSeparator();
		ArrayListObject.printObject(1);
		printSeparator();
		ArrayListObject.printObject(2);
		ArrayListObject.printInternalStructure();
	}
	
	public static void printDefault() {
		instance.printAll(new ArrayList());
	}

	public static void printObject(int size) {
		if (size > 0) {
			instance.printAll(getTestData(size));
		}
	}
	
	public static void printInternalStructure(){
//		out.println(ClassLayout.parseInstance(new Node<Integer>(null,1,null)).toPrintable());
//		out.println(GraphLayout.parseInstance(new Node<Integer>(null,1,null)).toPrintable());
//		out.println(GraphLayout.parseInstance(new Node<Integer>(null,1,null)).toFootprint());
	}

	private static ArrayList<Integer> getTestData(int size) {
		ArrayList<Integer> llist = new ArrayList<>();
		for (int i = 1; i <= size; i++) {
			llist.add(i);
		}

		return llist;
	}
	
}
