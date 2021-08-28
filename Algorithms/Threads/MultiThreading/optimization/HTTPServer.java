package MultiThreading.optimization;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * Simulates a HTTP server where each request is addressed by a thread pool. The server will load 
 * a very long book and then, search specific words on it as well as count how many times they 
 * appears in the book. To create this server, we will use the {@link com.sun.net.httpserver.HttpServer HttpServer}
 * instead of building from scratch. This server receive a context as a parameter to handle each 
 * http request and send the corresponding response. Finally the {@link java.util.concurrent.Executor Executor} 
 * object will schedule each incoming http request to a pool of worker threads. 
 * To make the server works, look up in the browser: http://localhost:8000/search?word=<specific word>
 * </br>
 * The goal of this exercise is to leverage the throughput of a process by applying the Thread Pool 
 * technique.
 * 
 * </br></br>
 * This exercise has been extracted from the course Java Multithreading,
 * Concurrency & Performance Optimization, instructed by Michael Progrebinsky
 * through Udemy, under MIT license.
 * 
 * @author luisa
 */
public class HTTPServer {

	private static final String BOOK_RESOURCE = "./resources/text/war_and_peace.txt";
	private static final int PORT = 8000;
	private static final int NTHREAD = 4;
	private static final int NOT_FOUND_RESPONSE = 400;
	private static final int SUCCESS_RESPONSE = 200;
	
	public static void main(String[] args) {
		try {
			String text = new String(Files.readAllBytes(Paths.get(BOOK_RESOURCE)));
			System.out.println("Staring server...");
			startServer(text);
			
		} catch (IOException e) {
			System.out.println("Error trying to access the file: " + e.getMessage());
		}
	}
	
	/**
	 * Starts the server creating the object for it, and the associated context which 
	 * define how to handle each request. The server will be listening the request in 
	 * the port 8000.
	 * 
	 * @param String The query for the server.
	 * */
	public static void startServer(String text) {
		HttpServer server;
		try {
			server = HttpServer.create(new InetSocketAddress(PORT), 0);
			server.createContext("/search", new WordCounter(text));
			Executor executor = Executors.newFixedThreadPool(NTHREAD);
			server.setExecutor(executor);
			server.start();	
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	/**
	 * This class implements the logic of searching and counting the words, as well as 
	 * handle the requests the server will receive.
	 * 
	 * */
	private static class WordCounter implements HttpHandler{
		private String text;
		 public WordCounter(String text) {
			 this.text = text;
		 }
		
		@Override
		public void handle(HttpExchange exchange) throws IOException {
			System.out.print("Handling the request...");
			String query = exchange.getRequestURI().getQuery();
			String keyValue[] = query.split("=");
			String action = keyValue[0]; // We actually expect the word 'word' here
			String word = keyValue[1];
			if( !action.equals("word") ) {
				System.out.println("Error handling the request: Malformed query");
				exchange.sendResponseHeaders(NOT_FOUND_RESPONSE, 0);
				return;
			} 
			long count = countWord(word);
			byte response[] = Long.toString(count).getBytes();
			exchange.sendResponseHeaders(SUCCESS_RESPONSE, response.length);
			OutputStream output = exchange.getResponseBody();
			output.write(response);
			output.close();
		}
		
		/**
		 * Counts the word given as the parameter in the text.
		 * 
		 * @param String Word to search
		 * @return long
		 * */
		public long countWord(String word) {
			long counter = 0;
			int index = 0;
			while(index >= 0) {
				index = text.indexOf(word, index);
				
				if(index >= 0 ) {
					counter ++;
					index ++;
				}
			}
			
			return counter;
		}
		
	}
}
