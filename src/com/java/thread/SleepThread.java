package com.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ˯��1��10s֮�����������ʱ�䣬Ȼ����ʾ˯��ʱ�䲢�˳�
 * 
 * @author WuYf
 * @Date 2015-1-12
 */
public class SleepThread implements Runnable {

	public static final long BASE = 1000;
	public static final long RANGE = 9000;
	private long sleepTime;

	public SleepThread() {
		sleepTime = (long) (BASE + Math.random() * RANGE);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(sleepTime);
			System.out.println(sleepTime);
			Thread.yield();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
			exec.execute(new SleepThread());
		exec.shutdown();
	}
}
