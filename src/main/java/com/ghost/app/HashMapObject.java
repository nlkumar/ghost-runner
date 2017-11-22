package com.ghost.app;

import java.util.HashMap;

public class HashMapObject extends GhostObject<HashMap>{

	public static HashMapObject instance = new HashMapObject();
	
	public static void test(){
		HashMapObject.printDefault();
		printSeparator();
		HashMapObject.printAllExceptInternal(1);
		printSeparator();
		HashMapObject.printAllExceptInternal(2);
	}
	
	public static void printDefault() {
		instance.printAll(getDefaultHashMap());
	}

	public static void printObject(int size) {
		HashMap<Integer, Integer> map = getHashMap(size);
		instance.printAll(map);
	}
	
	public static void printAllExceptInternal(int size){
		HashMap<Integer, Integer> map = getHashMap(size);
		instance.printExternalAndFootprint(map);
	}

	public static HashMap<Integer, Integer> getHashMap(int size) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= size; i++) {
			map.put(i, i * 10);
		}
		return map;
	}
	
	public static long getDefaultSize() throws Exception{
		return instance.getTotalSize(new HashMap());
	}
	
	public static HashMap<Integer, Integer> getDefaultHashMap(){
		return new HashMap<Integer,Integer>();
	}

}
