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
 *  Calculate order average payment placed on 14-Mar-2021
 *  
 * */
public class Ex9_OrderAverage {
	public static final LocalDate ORDERDATE_START = LocalDate.parse("2021-03-14");

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

		Order o4 = new Order(LocalDate.parse("2021-03-14"), LocalDate.parse("2021-03-24"), "Ordered",
				new HashSet(Arrays.asList(new Product[] { p7, p1 })));
		o4.setCustomer(new Customer("Laura", 3));
		orders.add(o4);

		return orders;
	}
	
	
	public static void main(String[] args) {
		Double avgPrice = init()
				.stream()
				.filter(o -> o.getOrderDate().equals(ORDERDATE_START))
				.flatMap(o -> o.getProducts().stream())
				.mapToDouble(p -> p.getPrice())
				.average().getAsDouble();
		
		System.out.println("Average: " + avgPrice);
	}
}
