package javaCore.streamsLambda.model;

import java.util.Set;

/**
 * Data model. Product to be shipped in a order.
 * 
 */
public class Product {

	private Long id;

	private String name;
	private String category;
	private Double price;

	private Set<Order> orders;
	
	public Product(String name, String category, Double price) {
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	public String toString() {
		return this.name + " " + this.category + " " + this.getPrice() + "$";
	}
}