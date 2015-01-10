package com.java.thread;

public class FallAlight implements Runnable {
	private static int taskCount = 0;
	private final int id = taskCount++;

	public FallAlight() {
		System.out.println("init FallAlight");
		System.out.println("end FallAlight");
	}
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(id+"("+i+")");
			Thread.yield();
		}
	}

}
