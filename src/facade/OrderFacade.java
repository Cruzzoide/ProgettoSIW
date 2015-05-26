package facade;

import model.Customer;
import model.Order;
import model.OrderLine;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

/**
 * Created by Michele on 20/05/15.
 */
@Stateless
public class OrderFacade {

    @PersistenceContext(unitName = "unit-jee-es1")
    private EntityManager em;


    public Order createOrder(Date creationTime, Customer customer_id) {
        Order o = new Order(creationTime, customer_id);
        em.persist(o);
        return o;
    }

    public void closeOrder(Order order, Date closeTime) {
        order.setCloseTime(closeTime);

        for(OrderLine ol : order.getOrderLines()){
            Integer newQuantity = ol.getProduct().getQuantity() - ol.getQuantity();
            ol.getProduct().setQuantity(newQuantity);
        }

    }

    public Order getOrder(Long id){
        return em.find(Order.class, id);
    }

    public void evasionOrder(Order order) {
        order.dispatched();
    }
}
