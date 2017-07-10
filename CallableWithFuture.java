package com.subhjit.test.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableWithFuture {

	/*
	 * public CallableWithFuture() { // TODO Auto-generated constructor stub }
	 */

	public static void main(String args[]) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		List<Future<Long>> list = new ArrayList<Future<Long>>();
		System.out.println("submitted callable task to calculate factorial of 5-10");
		for (int i = 5; i < 10; i++) {
			Future<Long> submit = executor.submit(new FactorialCalculator(i));
			list.add(submit);
		}
		boolean listen = true;

		//while (listen) {
			long result = 0;
			for (Future<Long> future : list) {
				//if (future.isDone()) {
					//long result;
					try {
						result = future.get();
						//listen = false;
						System.out.println("factorial Result :" + result);
					} catch (InterruptedException | ExecutionException e) {
						e.printStackTrace();
					}
				//}
				//System.out.println("factorial Result :" + result);
			}
			executor.shutdown();

		//}

	}

}

class FactorialCalculator implements Callable<Long> {
	private int number;

	public FactorialCalculator(int number) {
		super();
		this.number = number;
	}

	@Override
	public Long call() throws Exception {
		// TODO Auto-generated method stub
		return factorial(number);
	}

	private Long factorial(int n) throws InterruptedException {
		long result = 1;
		while (n != 0) {
			result = n * result;
			n = n - 1;
			Thread.sleep(100);
		}
		return result;

	}

}
