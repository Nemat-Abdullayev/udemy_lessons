package az.barama.springdemo.dao;

import java.util.List;

import az.barama.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int id);

	public void deleteCustomer(int theId);

	public List<Customer> searchCustomers(String theSearchName);

}
