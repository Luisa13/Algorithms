package javaCore.streamsLambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javaCore.streamsLambda.model.Product;

/**
 * Obtain a list of product with category = “Toys” and then apply 10% discount.
 * 
 * After you’ve obtained a product list with a category that belongs to “Toys” 
 * using filter(), you can then apply a 10% discount to the product price by 
 * using map() to modify them.
 * 
 * 
 * */
public class Ex3_FilterMap {
public static final String CATEGORY = "Toys"; 
public static final Double DISCOUNT = 0.1; 
	

	public static List<Product> init() {
		
		List<Product> products = new ArrayList<Product>();
		// Products 
		Product p1 = new Product("Pet" , "Toys" , 115.3);
		Product p2 = new Product("Bouncer" , "Baby" , 300.50);
		Product p3 = new Product("Rb-200" , "Robot" , 250.00);
		Product p4 = new Product("chair" , "Baby" , 100.60);
		Product p5 = new Product("Castle" , "Toys" , 20.50);
		Product p6 = new Product("BasketBall" , "Toys" , 30.50);
		Product p7 = new Product("Shusher" , "Baby" , 30.50);
		
		Product[] arrayProducts = {p1, p2, p3, p4, p5, p6};
		Collections.addAll(products, arrayProducts);
		
		return products;
	}
	
	public static void main(String[] args) {
		List<Product> products = init()
				.stream()
				.filter(p -> p.getCategory().equals(CATEGORY))
				.map(m -> {
					Product newP = m;
					newP.setPrice(newP.getPrice() * (1-DISCOUNT));
					return newP;
				})
				.collect(Collectors.toList());
		
		
		products.forEach(System.out::println);
	}
}
