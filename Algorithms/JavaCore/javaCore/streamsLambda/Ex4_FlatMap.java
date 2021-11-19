package javaCore.streamsLambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import javaCore.streamsLambda.model.Customer;
import javaCore.streamsLambda.model.Order;
import javaCore.streamsLambda.model.Product;

/**
 * Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021
 * and 01-Apr-2021.
 * 
 * This exercise illustrates the usage of flatMap(). You can firstly start from
 * an order list and then filter the list by customer tier and order date. Next,
 * get the product list from each order record and use flatMap() to emit product
 * records into the stream. For example, if we have 3 order records and each
 * order contains 10 products, then flatMap() will emit 10 data elements for
 * each order record, resulting in 30 (3 x 10) product record output in the
 * stream.
 * 
 * Since product list would contain duplicated product records if multiple
 * orders would include the same product. In order to generate a unique product
 * list, applying distinct() operation can help to produce the unique list.
 * 
 */
public class Ex4_FlatMap {

	public static final Integer TIER = 2;
	public static final LocalDate START_DELIVERYDATE = LocalDate.parse("2021-02-01");
	public static final LocalDate END_DELIVERYDATE = LocalDate.parse("2021-04-01");

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
		List<Product> products = init()
				.stream()
				.filter(o -> o.getCustomer().getTier().equals(TIER))
				.filter(o -> o.getDeliveryDate().isAfter(START_DELIVERYDATE))
				.filter(o -> o.getDeliveryDate().isBefore(END_DELIVERYDATE)) 
				.flatMap(o -> o.getProducts().stream())// Emit product records into the stream
				.distinct()
				.collect(Collectors.toList());
		
		products.forEach(System.out::println);

	}

}
