package com.java.thread;

public class LiftOff implements Runnable {
	private int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOff() {
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + ")";
	}

	@Override
	public void run() {
		while (countDown-- > 0) {
			System.out.println(status());
			Thread.yield();
		}
	}

}
