package com.subhjit.test.thread;
/*
 * There are 2 threads, EvenThread and OddThread.
These 2 threads are trying to get lock on Printer object.

We use a boolean variable isEvenPrinted to check if even number is
printed or not.
isEvenPrinted is initialized to true

If EvenThread get lock on Printer  // synchronized
   If isEvenPrinted is true
      wait for OddThread to print  // Lock on Printer is released
   End If
   
   // Once the odd number is printed. Lock on Printer is acquired.
   print even number
   set isEvenPrinted to false
   Notify OddThread that it is done // Lock on Printer is released
End if

If OddThread get lock on Printer  // synchronized
   If isEvenPrinted is false
      wait for EvenThread to print  // Lock on Printer is released
   End If
   
   // Once the even number is printed. Lock on Printer is acquired.
   Print oddnumber
   Set isEvenPrinted to true
   Notify EvenThread that it is done // Lock on Printer is released
End if
 * 
 */

public class EvenOddNumberPrinter {

	private static class NumberPrinter {

		// To check if even number is printed or not.
		private boolean isEvenPrinted = true;

		public void printOdd(int number) throws InterruptedException {
			// Get a lock on NumberPrinter
			synchronized (this) {

				// Wait until even is not printed.
				if (!isEvenPrinted)
					wait();

				System.out.println(number);

				isEvenPrinted = false;

				// Notify the other waiting thread which is waiting on
				// NumberPrinter
				// Other thread will get out of waiting state
				notify();
			}
		}

		public void printEven(int number) throws InterruptedException {
			synchronized (this) {
				if (isEvenPrinted)
					wait();

				System.out.println(number);
				isEvenPrinted = true;
				notify();
			}
		}
	}

	private static class OddNumberGenerator implements Runnable {
		private NumberPrinter q;
		private int max;

		public OddNumberGenerator(NumberPrinter q, int max) {
			this.q = q;
			this.max = max;
		}

		@Override
		public void run() {
			for (int i = 1; i < max; i = i + 2) {
				try {
					q.printOdd(i);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	private static class EvenNumberGenerator implements Runnable {
		private NumberPrinter printer;
		private int max;

		public EvenNumberGenerator(NumberPrinter printer, int max) {
			this.printer = printer;
			this.max = max;
		}

		@Override
		public void run() {
			for (int i = 2; i <= max; i = i + 2) {
				try {
					printer.printEven(i);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		int maxNumber = 10;
		NumberPrinter printer = new NumberPrinter();

		new Thread(new EvenNumberGenerator(printer, maxNumber)).start();
		new Thread(new OddNumberGenerator(printer, maxNumber)).start();
	}
}