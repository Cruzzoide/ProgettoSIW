package facade;

import model.Address;
import model.Provider;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ProviderFacade {

    @PersistenceContext(unitName = "unit-progetto-siw")
    private EntityManager em;

    public Provider createProvider(String name, String phoneNumber, String email, String vatin, Address address) {
        Provider provider = new Provider(name,phoneNumber,email,vatin,address);
        em.persist(provider);

        return provider;
    }

    public List<Provider> getAllProviders() {
        return em.createQuery("SELECT prov FROM Provider prov", Provider.class).getResultList();
    }

    public Provider findProvider(Long id) {
        return em.find(Provider.class,id);
    }

    public Address getProviderAddress(Provider p) {
        return em.find(Provider.class,p.getId()).getAddress();
    }
}
