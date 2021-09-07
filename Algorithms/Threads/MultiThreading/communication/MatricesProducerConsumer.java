package MultiThreading.communication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Multiplies two matrices by implementing the consumer-producer model. This
 * exercise shows how to use a queue for the two threads communication and the
 * notify method when sharing a resource.
 * 
 * In the first version of this algorithm, it has been implemented without
 * Back-Pressure, but after increase the size of the matrices to multiply, the
 * application eventually crush and runs out of memory. Hereby it is needed to
 * create a Back-Pressure approach.
 * 
 * </br>
 * </br>
 * This exercise has been extracted from the course Java Multithreading,
 * Concurrency & Performance Optimization, instructed by Michael Progrebinsky
 * through Udemy, under MIT license.
 * 
 * @author luisa
 */
public class MatricesProducerConsumer {

	public static final String INPUT_FILE = "./resources/text/matrices";
	public static final String OUTPUT_FINAL = "./resources/output/matrices_results.txt";
	public static final int N = 10;
	public static final String DELIMITER = ",";

	public static void main(String[] args) throws IOException {

		File inputFile = new File(INPUT_FILE);
		File outputFile = new File(OUTPUT_FINAL);
		ThreadSafeQueue queue = new ThreadSafeQueue();

		MatricesReaderProducer producer = new MatricesReaderProducer(new FileReader(inputFile), queue);
		MatricesMultiplyConsumer consumer = new MatricesMultiplyConsumer(new FileWriter(outputFile), queue);

		producer.start();
		consumer.start();

	}

	/**
	 * Multiplies two matrices consuming them from a shared queue.
	 * 
	 */
	private static class MatricesMultiplyConsumer extends Thread {
		private FileWriter fileWriter;
		private ThreadSafeQueue queue;

		public MatricesMultiplyConsumer(FileWriter writer, ThreadSafeQueue queue) {
			this.fileWriter = writer;
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				MatrixPair matrices = this.queue.remove();
				if (matrices == null) {
					System.out.println("Consumer is over: No more matrices to read from the queue.");
					break;
				}

				float[][] result = multiplyMatrices(matrices.matrix1, matrices.matrix2);
				try {
					saveMatrixToFile(fileWriter, result);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException ex) {
				System.out.println("Error trying to close the file: Data ins corrupted");
			}
		}

		/**
		 * Multiply two given matrices.
		 */
		private float[][] multiplyMatrices(float[][] m1, float[][] m2) {
			float[][] result = new float[N][N];
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					for (int k = 0; k < N; k++)
						result[r][c] += m1[r][k] * m2[k][c];
				}
			}

			return result;
		}

		/**
		 * Saves a matrix into a file.
		 * 
		 * @param FileWriter
		 * @param float[][]
		 * @throws IOException
		 */
		private void saveMatrixToFile(FileWriter fileWriter, float[][] matrix) throws IOException {
			for (int r = 0; r < N; r++) {
				StringJoiner stringJoiner = new StringJoiner(DELIMITER);
				for (int c = 0; c < N; c++)
					stringJoiner.add(String.format("%.2f", matrix[r][c]));

				fileWriter.write(stringJoiner.toString());
				fileWriter.write("\n");
			}
		}

	}

	/**
	 * Produce matrices into a shared queue
	 * 
	 */
	private static class MatricesReaderProducer extends Thread {
		private Scanner scanner;
		private ThreadSafeQueue queue;

		public MatricesReaderProducer(FileReader reader, ThreadSafeQueue queue) {
			this.scanner = new Scanner(reader);
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				float[][] matrix1 = this.readMatrix();
				float[][] matrix2 = this.readMatrix();
				if (matrix1 == null || matrix2 == null) {
					this.queue.terminate();
					System.out.println("Producer Thread is over: No more matrices to read.");
					return;
				}

				MatrixPair matrices = new MatrixPair(matrix1, matrix2);
				this.queue.add(matrices);
			}
		}

		/**
		 * Reads a matrix from file.
		 */
		public float[][] readMatrix() {
			float[][] newMatrix = new float[N][N];
			for (int r = 0; r < N; r++) {
				if (!this.scanner.hasNext())
					return null;
				String line[] = this.scanner.nextLine().split(DELIMITER);
				for (int c = 0; c < N; c++)
					newMatrix[r][c] = Float.valueOf(line[c]);

			}
			this.scanner.nextLine();
			return newMatrix;
		}
	}

	/**
	 * Represents the shared queue between the producer and the consumer. It uses
	 * two fields to notify the consumer-producer: is Empty tells if there is any
	 * matrix left if the queue and isTerminate which notify to the consumer there
	 * is nothing else to consume.
	 * 
	 */
	public static class ThreadSafeQueue {
		private static final int CAPACITY = 5;
		private Queue<MatrixPair> queue = new LinkedList<MatrixPair>();
		private boolean isEmpty = true;
		private boolean isTerminate = false;

		/**
		 * Adds a pair of matrices. Called by the producer.
		 * 
		 */
		public synchronized void add(MatrixPair matrixPair) {
			while (this.queue.size() == CAPACITY) {
				try {
					wait();
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
			this.queue.add(matrixPair);
			this.isEmpty = false;
			this.notify();
		}

		/**
		 * Removes a pair of matrices. Called by the consumer.
		 * 
		 */
		public synchronized MatrixPair remove() {
			MatrixPair matricesPair = new MatrixPair();
			while (isEmpty && !isTerminate) {
				try {
					wait();
				} catch (InterruptedException ex) {
				}
			}

			// Once is awake
			if (this.queue.size() == 1)
				this.isEmpty = true;

			if (this.queue.size() == 0 && this.isTerminate)
				return null;

			System.out.println("Queue size is: " + this.queue.size());
			matricesPair = this.queue.remove();
			if (queue.size() == CAPACITY - 1) {
				notifyAll();
			}
			return matricesPair;

		}

		/**
		 * Lets the consumer know there is nothing to consume.
		 */
		public void terminate() {
			this.isTerminate = true;
			this.notify();
		}

	}

	/**
	 * Represents two matrix to operate with them.
	 */
	private static class MatrixPair {
		public MatrixPair() {

		}

		public MatrixPair(float[][] m1, float[][] m2) {
			this.matrix1 = m1;
			this.matrix2 = m2;
		}

		public float[][] matrix1;
		public float[][] matrix2;
	}
}
