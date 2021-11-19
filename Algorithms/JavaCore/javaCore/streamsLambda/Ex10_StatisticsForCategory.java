package javaCore.streamsLambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import javaCore.streamsLambda.model.Product;

/**
 * Obtain a collection of statistic figures (i.e. sum, average, max, min, count)
 * for all products of category “Books”.
 * 
 * This exercise introduces to a data type DoubleSummaryStatistics which
 * contains all the required figures to get them all at the same time.
 * 
 */
public class Ex10_StatisticsForCategory {
	public static final String CATEGORY = "Book";

	public static List<Product> init() {
		List<Product> products = new ArrayList<Product>();
		Product p1 = new Product("MacBeth", "Book", 115.3);
		Product p2 = new Product("The silmarillion", "Book", 300.50);
		Product p3 = new Product("Rb-200", "Robot", 250.00);
		Product p4 = new Product("Velo4100", "Sport", 100.60);
		Product p5 = new Product("Apples", "Food", 20.50);
		Product p6 = new Product("Where the wild things are", "Book", 30.50);
		Product[] arrayProducts = { p1, p2, p3, p4, p5, p6 };
		Collections.addAll(products, arrayProducts);

		return products;
	}

	public static void main(String[] args) {
		DoubleSummaryStatistics statistics = init().stream().filter(p -> p.getCategory().equals(CATEGORY))
				.mapToDouble(p -> p.getPrice()).summaryStatistics();

		String strStats = statistics.getCount() + " products: \nAverage: " + statistics.getAverage() + "\nTotal sum: "
				+ statistics.getSum() + "\nMax price: " + statistics.getMax() + "\nMin price: " + statistics.getMin();
		
		System.out.println(strStats);

	}

}
