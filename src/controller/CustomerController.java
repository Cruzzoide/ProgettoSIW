package controller;

import facade.CustomerFacade;
import model.Address;
import model.Customer;
import model.Order;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;
import java.util.List;

@ManagedBean(name="customerController")
@SessionScoped
public class CustomerController {

    @EJB(name="cFacade")
    private CustomerFacade customerFacade;

    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private String password;
    private Customer customer;
    private List<Order> orders;

    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String country;
    private Address address;
    private List<Customer> customers;

    public String createCustomer(){
        this.address = new Address(street,city,state,zipcode,country);
        this.customer = customerFacade.createCustomer(firstName,lastName,email,dateOfBirth,password,address);

        return "customer";
    }

    public String findCustomer(Long id){
        this.customer = customerFacade.getCustomer(id);
        return "customer";

    }

    public String allCustomer() {
        this.customers = customerFacade.getAllCustomer();

        return "customers";
    }

    public String deleteCustomer(Long id){
        customerFacade.deleteCustomer(id);
        this.customers = customerFacade.getAllCustomer();

        return "customers";
    }

    public String customerAddress(Long id){
        this.address = customerFacade.getCustomer(id).getAddress();
        return "address";
    }

    public String customerOrders(Long id){
        this.orders = customer.getOrders();

        if(orders!=null)
            return "customerOrders";
        else
            return "index";
    }




    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public CustomerFacade getCf() {
        return customerFacade;
    }

    public void setCf(CustomerFacade cf) {
        this.customerFacade = cf;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public List<Customer> getCustomers() {return customers;}

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Order> getOrders() {return orders;}

    public void setCustomerFacade(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;
    }

    public void setOrders(List<Order> orders) {this.orders = orders;}

    public CustomerFacade getCustomerFacade() {return customerFacade;}
}
