package javaCore.streamsLambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javaCore.streamsLambda.model.Product;

/**
 * Obtain a list of products belongs to category “Books” with price > 100.
 * This exercise implies filter by two filed from the same entity (Product)
 * 
 */
public class Ex1_Filter1 {

	public static List<Product> init() {
		List<Product> products = new ArrayList<Product>();
		Product p1 = new Product("MacBeth" , "Book" , 115.3);
		Product p2 = new Product("The silmarillion" , "Book" , 300.50);
		Product p3 = new Product("Rb-200" , "Robot" , 250.00);
		Product p4 = new Product("Velo4100" , "Sport" , 100.60);
		Product p5 = new Product("Apples" , "Food" , 20.50);
		Product p6 = new Product("Where the wild things are" , "Book" , 30.50);
		Product[] arrayProducts = {p1, p2, p3, p4, p5, p6};
		Collections.addAll(products, arrayProducts);
		
		return products;
	}
	
	public static void main(String[] args) {
		List<Product> products = init().stream()
		.filter(p -> p.getCategory().equals("Book"))
		.filter(p -> p.getPrice() > 100)
		.collect(Collectors.toList());
		
		products.forEach(System.out::println);

	}

}
