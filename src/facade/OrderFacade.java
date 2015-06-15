package facade;

import model.Customer;
import model.Order;
import model.OrderLine;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

@Stateless
public class OrderFacade {

    @PersistenceContext(unitName = "unit-progetto-siw")
    private EntityManager em;


    public Order createOrder(Date creationTime, Customer customer_id) {
        Order o = new Order(creationTime, customer_id);
        return o;
    }

    public Order getOrder(Long id){
        return em.find(Order.class, id);
    }

    public List<Order> allOrders() {
        return em.createNamedQuery("findAllOrders").getResultList();
    }

    public void closeOrder(Order order, Date closeTime, List<OrderLine> orderLines) {
        order.setCloseTime(closeTime);
        order.setOrderLines(orderLines);

        em.persist(order);
    }

    public void addOrder(Customer customer, Order order) {
        customer.getOrders().add(order);
        em.merge(customer);
    }

    public void evadeOrder(Order o) {

        for(OrderLine ol : o.getOrderLines()) {
            Integer newQta = ol.getProduct().getQuantity() - ol.getQuantity();
            ol.getProduct().setQuantity(newQta);
            em.merge(ol.getProduct());
        }

        o.dispatched();
        em.merge(o);
    }

}
