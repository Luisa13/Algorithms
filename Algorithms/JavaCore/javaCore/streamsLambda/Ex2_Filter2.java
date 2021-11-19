package javaCore.streamsLambda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javaCore.streamsLambda.model.Order;
import javaCore.streamsLambda.model.Product;

/**
 * Obtain a list of order with products belong to category “Baby”.
 * 
 * This exercise implies to extrac a list of object filtering by the field of one its items. 
 * It is a second grade filtering
 * 
 * */
public class Ex2_Filter2 {
	public static final String CATEGORY = "Baby"; 
	

	public static List<Order> init() {
		
		List<Order> orders= new ArrayList<>();
		// Products 
		Product p1 = new Product("MacBeth" , "Book" , 115.3);
		Product p2 = new Product("Bouncer" , "Baby" , 300.50);
		Product p3 = new Product("Rb-200" , "Robot" , 250.00);
		Product p4 = new Product("chair" , "Baby" , 100.60);
		Product p5 = new Product("Apples" , "Food" , 20.50);
		Product p6 = new Product("Where the wild things are" , "Book" , 30.50);
		Product p7 = new Product("Shusher" , "Baby" , 30.50);
		
		//Set the orders
		
		Order o1 = new Order(LocalDate.parse("2021-01-08"), LocalDate.parse("2021-01-18"), "Ordered",
				new HashSet(Arrays.asList(new Product[] { p1, p2, p3 })));
		orders.add(o1);
		

		Order o2 = new Order(LocalDate.parse("2021-04-08"), LocalDate.parse("2021-04-18"), "Ordered", 
				new HashSet(Arrays.asList(new Product[] {p3, p6, p1 })));
		orders.add(o2);
		

		Order o3 = new Order(LocalDate.parse("2021-05-08"), LocalDate.parse("2021-05-18"), "Ordered", 
				new HashSet(Arrays.asList(new Product[] {p4, p5})));
		orders.add(o3);

		
		Order o4 = new Order(LocalDate.parse("2021-09-18"), LocalDate.parse("2021-09-28"), "Ordered", 
				new HashSet(Arrays.asList(new Product[] {p7, p1})));
		orders.add(o4);
		
		
		
		return orders;
	}
	
	public static void main(String[] args) {
		
		List<Order> orders = init()
				.stream()
				.filter(o -> o.getProducts()
						.stream()
						.anyMatch(p -> p.getCategory().equals(CATEGORY)))
				.collect(Collectors.toList());
		
		orders.forEach(System.out::println);
	}
}
