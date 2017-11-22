package com.ghost.app;

import static java.lang.System.out;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;

public class GhostObject<E> {

	public void printAll(E instance) {
		printInternal(instance);
		printExternal(instance);
		printFootprint(instance);
	}
	
	public void printExternalAndFootprint(E instance) {
		printExternal(instance);
		printFootprint(instance);
	}

	public void printInternal(E objToPrint) {
		out.println("Internal: Show the object internals: field layout and default contents, object header");
		out.println(ClassLayout.parseInstance(objToPrint).toPrintable());
	}

	public void printArray(E[] objToPrint) {
		out.println("Internal: Show the object internals: field layout and default contents, object header");
		out.println(ClassLayout.parseInstance(objToPrint).toPrintable());
	}

	public void printExternal(E objToPrint) {
		out.println("External: Show the object externals: the objects reachable from a given instance.");
		out.println(GraphLayout.parseInstance(objToPrint).toPrintable());
	}

	public void printFootprint(E objToPrint) {
		out.println("Footprint: Estimate the footprint of all objects reachable from a given instance");
		out.println(GraphLayout.parseInstance(objToPrint).toFootprint());
	}
	
	public static void printSeparator(){
		out.println("------------------------------------------------------------------------------------------------");
	}
	
	public void printVMDetails() {
		out.println(VM.current().details());
	}
	
	public long getTotalSize(E objToPrint) throws Exception {
		return GraphLayout.parseInstance(objToPrint).totalSize();
	}

}
