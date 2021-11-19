package javaCore.streamsLambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javaCore.streamsLambda.model.Customer;
import javaCore.streamsLambda.model.Order;
import javaCore.streamsLambda.model.Product;

/**
 * Get the 3 most recent placed order
 * */
public class Ex6_MostRecentOrders {

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

		Order o2 = new Order(LocalDate.parse("2021-04-08"), LocalDate.parse("2021-04-18"), "Ordered",
				new HashSet(Arrays.asList(new Product[] { p3, p6, p1 })));
		o2.setCustomer(new Customer("Marion", 2));
		orders.add(o2);

		Order o3 = new Order(LocalDate.parse("2021-05-26"), LocalDate.parse("2021-05-30"), "Ordered",
				new HashSet(Arrays.asList(new Product[] { p4, p5 })));
		o3.setCustomer(new Customer("Matthew", 2));
		orders.add(o3);

		Order o4 = new Order(LocalDate.parse("2021-03-18"), LocalDate.parse("2021-03-28"), "Ordered",
				new HashSet(Arrays.asList(new Product[] { p7, p1 })));
		o4.setCustomer(new Customer("Laura", 3));
		orders.add(o4);

		return orders;
	}

	public static void main(String[] args) {
		
		List<Order> orders = init()
				.stream()
				.sorted(Comparator.comparing(Order::getOrderDate).reversed())
				.limit(3).collect(Collectors.toList());
		
		orders.forEach(System.out::println);
	}
}
