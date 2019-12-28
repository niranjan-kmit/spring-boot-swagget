package com.trainning.demo.swaggerdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
public class CustomerController {

	private ConcurrentHashMap<String, Customer> concurrentHashMap = new ConcurrentHashMap<>();

	@PostMapping("/create")
	@ApiOperation(value = "Create the Customer record", response = Customer.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully creating the record."),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public Customer createCustomer(@RequestBody Customer customer) {
		concurrentHashMap.put(customer.getName(), customer);
		return concurrentHashMap.get(customer.getName());
	}

	@GetMapping("/customers")
	@ApiOperation(value = "Get The list of Customer records.", response = Customer.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully creating the record."),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public List<Customer> getCustomerList() {
		return new ArrayList<Customer>(concurrentHashMap.values());
	}

	@GetMapping("/customers/{customerName}")
	@ApiOperation(value = "Get The Customer record.", response = Customer.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully creating the record."),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public Customer getCustomer(@PathVariable("customerName") String customerName) {
		return concurrentHashMap.get(customerName);
	}

}
