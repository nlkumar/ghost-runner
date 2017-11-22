package com.ghost.app;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

public class GhostRunner {

	public static void printExternal(Object objToPrint){
		ClassLayout.parseInstance(objToPrint).toPrintable();
	}
	
	public static void printInternal(Object objToPrint){
		GraphLayout.parseInstance(objToPrint).toPrintable();
	}
	
	public static void printEstimate(Object objToPrint){
		GraphLayout.parseInstance(objToPrint).toFootprint();
	}
	
	
	
}
