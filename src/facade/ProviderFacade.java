package facade;

import model.Address;
import model.Provider;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Michele on 28/05/15.
 */
@Stateless
public class ProviderFacade {

    @PersistenceContext(unitName = "unit-jee-es1")
    private EntityManager em;

    public Provider createProvider(String name, String phoneNumber, String email, String vatin, Address address) {
        Provider provider = new Provider(name,phoneNumber,email,vatin,address);
        em.persist(provider);

        return provider;
    }
}
