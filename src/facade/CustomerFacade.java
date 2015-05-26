package facade;

import model.Address;
import model.Customer;
import model.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Created by Michele on 20/05/15.
 */
@Stateless(name="cFacade")
public class CustomerFacade {

    @PersistenceContext(unitName = "unit-jee-es1")
    private EntityManager em;

    public Customer createCustomer(String firstName, String lastName, String email, Date dateOfBirth, String password, Address address) {
        Customer customer = new Customer(firstName,lastName,email,dateOfBirth,address,password);
        em.persist(customer);
        return customer;
    }


    public Customer getCustomer(Long id) {
        return em.find(Customer.class,id);
    }

    public List<Customer> getAllCustomer() {
        return em.createQuery("SELECT customer FROM Customer customer", Customer.class).getResultList();
    }

    public void deleteCustomer(Long id) {
        Customer c = getCustomer(id);
        em.remove(c);
    }

    public Order getOrder(Long id) {
        return em.find(Order.class,id);
    }

}