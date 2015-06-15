package facade;

import model.Address;
import model.Customer;
import model.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Stateless(name="cFacade")
public class CustomerFacade {

    @PersistenceContext(unitName = "unit-progetto-siw")
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

    public Customer checkPassword(String email, String password) throws Exception {
        Customer c ;

        try {
            Query query = this.em.createQuery("SELECT c FROM Customer c WHERE c.email=:email");
            query.setParameter("email", email);
            c = (Customer) query.getSingleResult();

        }catch (Exception e){
            throw new Exception("Cliente inesistente!");
        }
        if(!c.checkPassword(password))
            throw new Exception("Password non corretta!");

        return c;
    }

    public List<Order> customerOrders(Customer c) {
        Query query = em.createQuery("SELECT o FROM Order o WHERE o.customer_id=:c");
        query.setParameter("c",c);

        return query.getResultList();
    }

}