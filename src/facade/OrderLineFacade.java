package facade;

import model.OrderLine;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class OrderLineFacade {

    @PersistenceContext(unitName = "unit-jee-es1")
    private EntityManager em;

    public void aggiungiLinea(OrderLine ol) {
        em.persist(ol);
    }
}
