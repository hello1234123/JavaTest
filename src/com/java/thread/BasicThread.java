package com.java.thread;

public class BasicThread {

	public BasicThread() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
//		Thread thread = new Thread(new LiftOff());
//		thread.start();
			new LiftOff().run();
		}
		System.out.println("Waiting for LiftOff...");
	}

}
