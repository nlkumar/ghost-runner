package com.ghost.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openjdk.jol.info.GraphLayout;

public class TestData {

	private static final int SIZE_OF_INT = 4;
	private static List<ObjectSize> memSizes = new ArrayList<>();

	public static void addObject(int size, Object obj) {
		long totalSize = GraphLayout.parseInstance(obj).totalSize();

		memSizes.add(new ObjectSize(obj.getClass().getName(), -1, totalSize, -1l,SIZE_OF_INT,size));
	}
	
	public static void addMap(int size, Class<?> className) throws Exception {

		Map<Integer, Integer> emptyInstance = getMap(0, className);
		Map<Integer, Integer> tenKInstance = getMap(size, className);

		long emptyInstanceMemorySize = GraphLayout.parseInstance(emptyInstance).totalSize();
		long tenKInstanceMemorySize = GraphLayout.parseInstance(tenKInstance).totalSize();
		int defaultSize = emptyInstance.size();

		memSizes.add(new ObjectSize(className.getName(), defaultSize, emptyInstanceMemorySize, tenKInstanceMemorySize, SIZE_OF_INT, size));
	}

	public static void addSet(int size, Class<?> className) throws Exception {

		Set<Integer> emptyInstance = getSet(0, className);
		Set<Integer> tenKInstance = getSet(size, className);

		long emptyInstanceMemorySize = GraphLayout.parseInstance(emptyInstance).totalSize();
		long tenKInstanceMemorySize = GraphLayout.parseInstance(tenKInstance).totalSize();
		int defaultSize = emptyInstance.size();

		memSizes.add(new ObjectSize(className.getName(), defaultSize, emptyInstanceMemorySize, tenKInstanceMemorySize, SIZE_OF_INT, size));
	}
	
	public static void addList(int size, Class<?> className) throws Exception {

		List<Integer> emptyInstance = getList(0, className);
		List<Integer> tenKInstance = getList(size, className);

		long emptyInstanceMemorySize = GraphLayout.parseInstance(emptyInstance).totalSize();
		long tenKInstanceMemorySize = GraphLayout.parseInstance(tenKInstance).totalSize();
		int defaultSize = emptyInstance.size();

		memSizes.add(new ObjectSize(className.getName(), defaultSize, emptyInstanceMemorySize, tenKInstanceMemorySize, SIZE_OF_INT, size));
	}

	public static Map<Integer, Integer> getMap(int size, Class<?> className) throws Exception {
		if (size == 0) {
			return (Map<Integer, Integer>) className.newInstance();
		} else {
			Map<Integer, Integer> map = (Map<Integer, Integer>) className.newInstance();
			for (int i = 1; i <= size; i++) {
				map.put(i, i * 10);
			}
			return map;
		}
	}

	public static Set<Integer> getSet(int size, Class<?> className) throws Exception {

		if (size == 0) {
			return (Set<Integer>) className.newInstance();
		} else {

			Set<Integer> set = (Set<Integer>) className.newInstance();
			for (int i = 1; i <= size; i++) {
				set.add(i);
			}
			return set;
		}
	}

	public static List<Integer> getList(int size, Class<?> className) throws Exception {

		if (size == 0) {
			return (List<Integer>) className.newInstance();
		} else {

			List<Integer> set = (List<Integer>) className.newInstance();
			for (int i = 1; i <= size; i++) {
				set.add(i);
			}
			return set;
		}
	}

	public static void printMemSizes() {
		String header = "\n\n   Collection\t\t\tDefault Capacity(size)\t\t\tDefault Size(Bytes)\t\t10K Overhead (KBytes)\t\t10K Actual Data Size (KBytes)";

		System.out.println(header);
		System.out.println(
				"----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		Iterator<ObjectSize> iterator = memSizes.iterator();
		while (iterator.hasNext()) {
			ObjectSize objMemSize = iterator.next();
			System.out.println(objMemSize.getClassName() + "\t\t" + objMemSize.getDefaultCapacity() + "\t\t\t\t\t"
					+ objMemSize.getEmptySize() + "\t\t\t\t" + (objMemSize.getOverhead()/1024)+"\t\t\t\t"+((objMemSize.getTotalMemory() - objMemSize.getOverhead())/1024));
		}

	}
}
