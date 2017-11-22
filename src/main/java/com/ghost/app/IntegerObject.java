package com.ghost.app;

import org.openjdk.jol.info.ClassLayout;

public class IntegerObject{

	private static IntegerObject instance = new IntegerObject();

	// 16 bytes -
	// first 4 bytes - reference to class,
	// next 4 bytes - flags, hashcode, shape(array or not), etc
	// next 4 bytes - flat lock or pointer to inflated monitor. object Lock used
	// in sync,
	// last 4 bytes actual integer data
	private static Integer no = new Integer(10);

	// 24 bytes in total.
	// first 12 bytes same as above, except it has a flag to set its an array
	// next 4 bytes - size of array (up until here its 16 bytes)
	// next 4 bytes - actual data
	// last 4 bytes - empty space as memory is allocated on 8 bytes
	private static Integer[] nos1 = new Integer[1];

	// 24 bytes in total
	// same as above except the last 4 bytes are not wasted, its will be used
	// for the 2nd element in array
	private static Integer[] nos2 = new Integer[2];

	// 32 bytes in total.
	// first 16 bytes with header
	// next 8 bytes to store data at index 0 and 1 as each index takes 4 bytes
	// last 8 bytes - first 4 bytes are used for index 2 and the last 4 bytes
	// are not used, left as empty
	private static Integer[] nos3 = new Integer[3];

	// same as above, except the last 4 bytes are allocated to be used by
	// element at index 3
	private static Integer[] nos4 = new Integer[4];

	// 40 bytes - same story as above
	private static Integer[] nos5 = new Integer[5];

	// 32 bytes. 16 bytes header. another 8 bytes to store 5, 10 and another 4
	// bytes to store 15, as the memory is allocated at
	// increments of 8 bytes, last 4 bytes are unused
	private static Integer[] arrayNos = { 5, 10, 15 };

	public static void printDefaultMemoryUsage() {
//		long objectSizeInBytes = getObjectSize(no);
//		out.println("Size = " + objectSizeInBytes + " bytes or " + (objectSizeInBytes * 8) + " bits");
	}

	public static void printMemoryUsage() {
		ClassLayout.parseInstance(no).toPrintable();
		ClassLayout.parseInstance(nos1).toPrintable();
		ClassLayout.parseInstance(nos2).toPrintable();
		ClassLayout.parseInstance(nos3).toPrintable();
		ClassLayout.parseInstance(nos4).toPrintable();
		ClassLayout.parseInstance(nos5).toPrintable();
		ClassLayout.parseInstance(arrayNos).toPrintable();

	}
}
