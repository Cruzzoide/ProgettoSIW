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
    private String state;

    @Column(nullable = false)
    private String zipcode;

    @Column(nullable = false)
    private String country;

    public Address(){
    }

    public Address(String street, String city, String state, String zipcode, String country){
        this.street = street;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.country = country;
    }

    public Long getId() {return id;}

    public String getCity() {return city;}

    public String getCountry() {return country;}

    public String getState() {return state;}

    public String getStreet() {return street;}

    public String getZipcode() {return zipcode;}

    public void setCity(String city) {this.city = city;}

    public void setCountry(String country) {this.country = country;}

    public void setState(String state) {this.state = state;}

    public void setStreet(String street) {this.street = street;}

    public void setZipcode(String zipcode) {this.zipcode = zipcode;}


    public boolean equals(Object obj) {
        Address address = (Address)obj;
        return this.getZipcode().equals(address.getZipcode());
    }

    public int hashCode() {
        return this.zipcode.hashCode();
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Provider");
        sb.append("{id=").append(id);
        sb.append(", street='").append(street);
        sb.append(", city=").append(city);
        sb.append(", country='").append(country);
        sb.append(", state='").append(state);
        sb.append(", zipcode='").append(zipcode);
        sb.append("}\n");
        return sb.toString();
    }

}



