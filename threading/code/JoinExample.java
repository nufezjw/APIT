/**
* Creates multiple threads to find a maximum value
*/
import java.util.Random;

public class JoinExample {

	private static class MyThread extends Thread {
		int max = Integer.MIN_VALUE;
		int[] myArray;
		public MyThread(int[] myArray) {
			this.myArray = myArray;
		}
		public void run() {
			for(int i=0;i<myArray.length;i++) {
				max = Math.max(max,myArray[i]);
			}
		}
		public int getMax() {
			return max;
		}
	}

	public static void main(String[] args) {
		MyThread[] allThreads = new MyThread[10];
		int[][] nastyMatrix = new int[10][1000];

		
		Random r = new Random();
		// Create the matrix
		for(int i=0;i<10;i++) {
			for(int j=0;j<1000;j++) {
				nastyMatrix[i][j] = r.nextInt();
			}
		}

		// Start each thread
		for(int i=0;i<10;i++) {
			allThreads[i] = new MyThread(nastyMatrix[i]);
			allThreads[i].start();
		}

		// Wait for each to finish and find the max
		int max = Integer.MIN_VALUE;
		try {
			for(int i=0;i<10;i++) {
				allThreads[i].join();
				max = Math.max(max,allThreads[i].getMax());
			}
		} catch (InterruptedException e) {
			// Nothing
		}
		System.out.println("Max: " + max);
	}
}