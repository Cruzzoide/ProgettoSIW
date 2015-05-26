package facade;

import model.Order;
import model.OrderLine;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Michele on 20/05/15.
 */

@Stateless
public class OrderLineFacade {

    @PersistenceContext(unitName = "unit-jee-es1")
    private EntityManager em;

    public void aggiungiLinea(OrderLine ol, Order o) {
        o.getOrderLines().add(ol);
        em.persist(ol);
    }
}
