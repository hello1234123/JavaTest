package com.java.thread;

/**
 * 后台线程
 * 
 * @author WuYf
 * @Date 2015-1-12
 */
public class SimpleDaemons implements Runnable {

	public SimpleDaemons() {
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true);
			daemon.start();
		}
		System.out.println("all daemons started");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
