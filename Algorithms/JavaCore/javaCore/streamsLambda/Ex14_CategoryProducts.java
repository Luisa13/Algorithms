package javaCore.streamsLambda;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javaCore.streamsLambda.model.Product;


/**
 * Obtain a data map with the name of the category and its list of product name;
 * 
 * This exercise helps you get familiar with the way to transform the data
 * output of data map entries. If you only use
 * Collectors.groupingBy(Product::getCategory), then the output will be
 * Map<Category, List of Products> but the expected output should be
 * Map<Category, List of Product Name>. You can use Collectors.mapping() to
 * convert product objects to product names for the data map construction.
 */
public class Ex14_CategoryProducts {

	public static List<Product> init() {

		List<Product> products = new ArrayList<Product>();
		// Products
		Product p1 = new Product("Pet", "Toys", 115.3);
		Product p2 = new Product("Bouncer", "Baby", 300.50);
		Product p3 = new Product("Rb-200", "Robot", 250.00);
		Product p4 = new Product("chair", "Baby", 100.60);
		Product p5 = new Product("Castle", "Toys", 20.50);
		Product p6 = new Product("BasketBall", "Toys", 30.50);
		Product p7 = new Product("Shusher", "Baby", 30.50);

		Product[] arrayProducts = { p1, p2, p3, p4, p5, p6 };
		Collections.addAll(products, arrayProducts);

		return products;
	}

	public static void main(String[] args) {
		Map<String, List<String>> categoryProducts = init()
				.stream()
				.collect(Collectors.groupingBy(
						Product::getCategory,
						Collectors.mapping(p -> ((Product) p).getName(), Collectors.toList())
						));
		
		
		categoryProducts.forEach((c, p) -> System.out.println(c + ", " + p));

	}

}
