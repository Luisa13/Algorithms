package javaCore.streamsLambda.model;

import java.time.LocalDate;
import java.util.Set;


/**
 *  Data model.
 *  One order might have more than one product, so they hold a many-to-many relationship.
 *  
 * */
public class Order {

	private Long id;

	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private String status;

	private Customer customer;

	Set<Product> products;

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
