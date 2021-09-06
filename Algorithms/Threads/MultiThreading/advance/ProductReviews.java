package MultiThreading.advance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * A database keeps the product with an associated list of reviews of such product. The 
 * proper ReentrantReadWrite lock is used to prevent race conditions on the operations.
 * 
 * </br>
 * </br>
 * This exercise has been extracted from the course Java Multithreading,
 * Concurrency & Performance Optimization, instructed by Michael Progrebinsky
 * through Udemy, under MIT license.
 * 
 * @author luisa
 * */
public class ProductReviews {

	public static void main(String[] args) {
		// ...
	}
	
	public static class ProductReviewService{
		private final Map<Integer, List<String>> productIdToReview = new HashMap<>();
		private ReentrantReadWriteLock readWriteLocker = new ReentrantReadWriteLock();
		private Lock writelock = this.readWriteLocker.writeLock();
		private Lock readlock = this.readWriteLocker.readLock();
		
		public void addProduct(int idProduct) {
			Lock lock = getLockToAddProdcut();
			lock.lock();
			try {
				if(! this.productIdToReview.containsKey(idProduct))
					this.productIdToReview.put(idProduct, new ArrayList<String>());
			}finally {
				lock.unlock();
			}
		}
		
		public void removeProduct(int idProduct) {
			Lock lock = getLockToRemoveProdcut();
			lock.lock();
			try {
				if(this.productIdToReview.containsKey(idProduct))
					this.productIdToReview.remove(idProduct);
			}finally{
				lock.unlock();
			}
		}
		
		public void addReviewToProduct(int idProduct, String review) {
			Lock lock = getLockToAddReview();
			lock.lock();
			try {
				if(this.productIdToReview.containsKey(idProduct)) {
					List<String> reviews = this.productIdToReview.get(idProduct);
					reviews.add(review);
					this.productIdToReview.put(idProduct, reviews);
				}
			}finally{
				lock.unlock();
			}
		}
		
		public List<String> getAllProductReviews(int idProduct){
			Lock lock = getLockToGetAllProductReviews();
			lock.lock();
			try {
				if(this.productIdToReview.containsKey(idProduct)) {
					return Collections.unmodifiableList(this.productIdToReview.get(idProduct));
				}
				return Collections.emptyList();
			}finally{
				lock.unlock();
			}
		}
		
		public Optional<String> getLatestReview(int idProduct) {
			Lock lock = getLockToGetLatestReview();
			lock.lock();
			try {
				if(this.productIdToReview.containsKey(idProduct)) {
					List<String> reviews = this.productIdToReview.get(idProduct);
					return Optional.of(reviews.get(reviews.size() -1));
				}
				return Optional.empty();
			}finally{
				lock.unlock();
			}
		}
		
		public List<Integer> getAllProductWithReviews(){
			Lock lock = getLockToGetAllProductWithReviews();
			lock.lock();
			try {
				Set <Integer> products = new HashSet<>();
				for(Map.Entry<Integer, List<String>> product: this.productIdToReview.entrySet()) {
					if(! product.getValue().isEmpty())
						products.add(product.getKey());
				}
				return (List<Integer>) products;
				
			}finally{
				lock.unlock();
			}
		}
		
		private Lock getLockToAddProdcut() {
			return this.writelock;
		}
		
		private Lock getLockToRemoveProdcut() {
			return this.writelock;
		}
		
		private Lock getLockToAddReview() {
			return this.writelock;
		}
		
		private Lock getLockToGetAllProductReviews() {
			return this.readlock;
		}
		
		private Lock getLockToGetLatestReview() {
			return this.readlock;
		}
		
		private Lock getLockToGetAllProductWithReviews() {
			return this.readlock;
		}
	}
	
	
}
