package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "provider")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String vatin;

    @ManyToMany
    private List<Product> products;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private Address address;

    public Provider(){
    }

    public Provider(String name, String phoneNumber, String email, String vatin, Address address){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.vatin = vatin;
        this.address = address;
        this.products = new ArrayList<Product>();
    }

    public Long getId() {return this.id;}

    public String getName() {return name;}

    public String getEmail() {return email;}

    public String getPhoneNumber() {return phoneNumber;}

    public String getVatin() {return vatin;}

    public List<Product> getProducts() {return products;}

    public Address getAddress() {return address;}

    public void setName(String name) {this.name = name;}

    public void setEmail(String email) {this.email = email;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public void setVatin(String vatin) {this.vatin = vatin;}

    public void setAddress(Address address) {this.address = address;}

    public void setProducts(List<Product> products) {this.products = products;}

    public boolean equals(Object obj) {
        Provider provider = (Provider)obj;
        return this.getVatin().equals(provider.getVatin());
    }

    public int hashCode() {
        return this.vatin.hashCode();
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Provider");
        sb.append("{id=").append(id);
        sb.append(", name='").append(name);
        sb.append(", email=").append(email);
        sb.append(", phoneNumber='").append(phoneNumber);
        sb.append(", vatin='").append(vatin);
        sb.append(", address='").append(address);
        sb.append("}\n");
        return sb.toString();
    }

}