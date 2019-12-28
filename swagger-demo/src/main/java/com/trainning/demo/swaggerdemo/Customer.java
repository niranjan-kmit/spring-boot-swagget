package com.trainning.demo.swaggerdemo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Customer Model")
public class Customer {

	@ApiModelProperty(notes ="Name of the Customer",required = true)
	private String name;

	@ApiModelProperty(notes ="Description of the Customer")
	private String description;

	@ApiModelProperty(notes ="Phone Number of the Customer")
	private long phone;

	public Customer() {

	}

	public Customer(String name, String description, long phone) {
		super();
		this.name = name;
		this.description = description;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

}
