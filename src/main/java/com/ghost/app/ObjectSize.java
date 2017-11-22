package com.ghost.app;

public class ObjectSize {

	private String className;
	private long defaultCapacity;
	private long emptySize;
	private long totalMemory;
	private long overhead;
	private long noOfElements;

	private int maxClassNameSize = 24;

	public ObjectSize(String className, long defaultCapacity, long emptySize, long totalMemory,
			int actualDataSizePerElementInKB, int noOfElements) {
		if (className.length() < maxClassNameSize) {
			className += emptySpace(maxClassNameSize - className.length());
		}
		this.className = className;
		this.defaultCapacity = defaultCapacity;
		this.emptySize = emptySize;
		this.totalMemory = totalMemory;
		this.overhead = totalMemory - (noOfElements * actualDataSizePerElementInKB);
		this.noOfElements = noOfElements;
	}

	public long getOverhead() {
		return overhead;
	}

	public long getNoOfElements() {
		return noOfElements;
	}

	public int getMaxClassNameSize() {
		return maxClassNameSize;
	}

	public String getClassName() {
		return className;
	}

	public long getDefaultCapacity() {
		return defaultCapacity;
	}

	public long getEmptySize() {
		return emptySize;
	}

	public long getTotalMemory() {
		return totalMemory;
	}

	private String emptySpace(int size) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < size; i++) {
			builder.append(' ');
		}

		return builder.toString();
	}
}
