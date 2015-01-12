package com.java.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 有返回值的任务，需要由Executor提交调用，返回值为Future
 * 
 * @author WuYf
 * @Date 2015-1-12
 */
public class TaskWithResult implements Callable<String> {
	private int id;

	public TaskWithResult(int id) {
		this.id = id;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		List<Future<String>> results = new ArrayList<Future<String>>();
		for (int i = 0; i < 5; i++)
			results.add(exec.submit(new TaskWithResult(i)));
		for (Future<String> result : results)
			try {
				System.out.println(result.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			} finally {
				exec.shutdown();
			}
	}

	@Override
	public String call() throws Exception {
		return "result of TaskWithResult: " + id;
	}

}
