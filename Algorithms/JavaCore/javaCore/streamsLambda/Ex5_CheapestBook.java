package javaCore.streamsLambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javaCore.streamsLambda.model.Product;

/**
 * Get the cheapest product of “Books” category
 * 
 * */
public class Ex5_CheapestBook {

	public static final String CATEGORY = "Book";
	
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
		
	
	
	public static void main(String args[]) {
		Product product = init()
				.stream()
				.filter(p ->p.getCategory().equals(CATEGORY))
				.min(Comparator.comparing(Product::getPrice))
				.get();
		
		System.out.print("The cheapest book: " + product);
	}
}
