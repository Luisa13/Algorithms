package javaCore.streamsLambda.model;

/**
 *  Data model.
 *  Customers can place multiple orders and so it holds a relationship one-to-many.
 *  
 * */
public class Customer {
	private Long id;

	private String name;
	private Integer tier;

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

	public Integer getTier() {
		return tier;
	}

	public void setTier(Integer tier) {
		this.tier = tier;
	}

}
