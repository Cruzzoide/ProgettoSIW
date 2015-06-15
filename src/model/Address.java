package model;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String cap;

    @Column(nullable = false)
    private String country;

    public Address(){
    }

    public Address(String street, String city, String cap, String country){
        this.street = street;
        this.city = city;
        this.cap = cap;
        this.country = country;
    }

    public Long getId() {return id;}

    public String getCity() {return city;}

    public String getCountry() {return country;}


    public String getStreet() {return street;}

    public String getcap() {return cap;}

    public void setCity(String city) {this.city = city;}

    public void setCountry(String country) {this.country = country;}


    public void setStreet(String street) {this.street = street;}

    public void setcap(String cap) {this.cap = cap;}


    public boolean equals(Object obj) {
        Address address = (Address)obj;
        return this.getcap().equals(address.getcap());
    }

    public int hashCode() {
        return this.cap.hashCode();
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Provider");
        sb.append("{id=").append(id);
        sb.append(", street='").append(street);
        sb.append(", city=").append(city);
        sb.append(", country='").append(country);
        sb.append(", cap='").append(cap);
        sb.append("}\n");
        return sb.toString();
    }

}