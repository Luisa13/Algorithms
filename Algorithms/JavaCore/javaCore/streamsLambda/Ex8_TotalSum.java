package javaCore.streamsLambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javaCore.streamsLambda.model.Customer;
import javaCore.streamsLambda.model.Order;
import javaCore.streamsLambda.model.Product;

/**
 * Calculate total lump sum of all orders placed in Feb 2021
 * 
 * */
public class Ex8_TotalSum {
	public static final LocalDate ORDERDATE_START = LocalDate.parse("2021-01-31");
	public static final LocalDate ORDERDATE_END = LocalDate.parse("2021-03-01");

	public static List<Order> init() {

		List<Order> orders = new ArrayList<>();
		// Products
		Product p1 = new Product("MacBeth", "Book", 115.3);
		Product p2 = new Product("Bouncer", "Baby", 300.50);
		Product p3 = new Product("Rb-200", "Robot", 250.00);
		Product p4 = new Product("chair", "Baby", 100.60);
		Product p5 = new Product("Apples", "Food", 20.50);
		Product p6 = new Product("Where the wild things are", "Book", 30.50);
		Product p7 = new Product("Shusher", "Baby", 30.50);

		// Set the orders

		Order o1 = new Order(LocalDate.parse("2021-02-08"), LocalDate.parse("2021-02-18"), "Ordered",
				new HashSet(Arrays.asList(new Product[] { p1, p2, p3 })));
		o1.setCustomer(new Customer("James W", 2));
		orders.add(o1);

		Order o2 = new Order(LocalDate.parse("2021-03-15"), LocalDate.parse("2021-03-25"), "Ordered",
				new HashSet(Arrays.asList(new Product[] { p3, p6, p1 })));
		o2.setCustomer(new Customer("Marion", 2));
		orders.add(o2);

		Order o3 = new Order(LocalDate.parse("2021-05-26"), LocalDate.parse("2021-05-30"), "Ordered",
				new HashSet(Arrays.asList(new Product[] { p4, p5 })));
		o3.setCustomer(new Customer("Matthew", 2));
		orders.add(o3);

		Order o4 = new Order(LocalDate.parse("2021-02-18"), LocalDate.parse("2021-02-28"), "Ordered",
				new HashSet(Arrays.asList(new Product[] { p7, p1 })));
		o4.setCustomer(new Customer("Laura", 3));
		orders.add(o4);

		return orders;
	}
	
	
	public static void main(String[] args) {
		Double price = init()
				.stream()
				.filter(o -> o.getOrderDate().isAfter(ORDERDATE_START)) // 1. All the orders ordered after January
				.filter(o -> o.getOrderDate().isBefore(ORDERDATE_END))  // 2. All the orders ordered before March
				.flatMap(o -> o.getProducts().stream())					// 3. Get every item of the list into a stream
				.peek(System.out::println)								// Off-exercise: print every product that will be counted
				.mapToDouble(p -> p.getPrice())							// 4. Turn every previous stream into Double
				.sum();													// 5. Sum all up 
		
		System.out.print("\nThe total price is: " + price);
	}
}
