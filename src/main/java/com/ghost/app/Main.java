package com.ghost.app;

import static com.ghost.app.TestData.addList;
import static com.ghost.app.TestData.addMap;
import static com.ghost.app.TestData.addObject;
import static com.ghost.app.TestData.addSet;
import static com.ghost.app.TestData.printMemSizes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws Exception {
		addMap(10000, HashMap.class);
		addMap(10000, LinkedHashMap.class);
		addMap(10000, IdentityHashMap.class);
		addMap(10000, TreeMap.class);
		addSet(10000, HashSet.class);
		addSet(10000, TreeSet.class);
		addSet(10000, LinkedHashSet.class);
		addList(10000, ArrayList.class);
		addList(10000, LinkedList.class);
		addObject(1, new StringBuilder());
		
		
		printMemSizes();
	}

}
