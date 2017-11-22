package com.ghost.app;

import static java.lang.System.out;

import java.util.LinkedList;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

public class LinkedListObject extends GhostObject<LinkedList> {

	private static LinkedListObject instance = new LinkedListObject();

	public static void test(){
		LinkedListObject.printDefault();
		printSeparator();
		LinkedListObject.printObject(1);
		printSeparator();
		LinkedListObject.printObject(2);
		LinkedListObject.printInternalStructure();
	}
	
	
	public static void printDefault() {
		instance.printAll(new LinkedList());
	}

	public static void printObject(int size) {
		if (size > 0) {
			instance.printAll(getTestData(size));
		}
	}
	
	public static void printInternalStructure(){
		out.println(ClassLayout.parseInstance(new Node<Integer>(null,1,null)).toPrintable());
		out.println(GraphLayout.parseInstance(new Node<Integer>(null,1,null)).toPrintable());
		out.println(GraphLayout.parseInstance(new Node<Integer>(null,1,null)).toFootprint());
	}

	public static LinkedList<Integer> getTestData(int size) {
		LinkedList<Integer> llist = new LinkedList<>();
		for (int i = 1; i <= size; i++) {
			llist.add(i);
		}

		return llist;
	}
	
	public static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
