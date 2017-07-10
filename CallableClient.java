/*package com.subhjit.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableClient {

	public static void main(String[] args) {
		Callable callableTask = new Callable();

		ExecutorService executor = Executors.newFixedThreadPool(5);
		Future<String> future = executor.submit(callableTask);
		boolean listen = true;

		while (listen) {
			if (future.isDone()) {
				String result;

				try {
					result = future.get();
					listen = false;
					System.out.println(result);
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class CallableTask implements Callable {
	 
	@Override
	public Object call() throws Exception {
		String s="Callable Task Run at "+System.currentTimeMillis();
		return s;
	}

}*/