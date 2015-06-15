package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"firstName","lastName"}))
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
    private Address address;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "customer_id", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Order> orders;

    public Customer(){
    }

    public Customer(String firstName, String lastName, String email, Date dateOfBirth, Address address, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.registrationDate = new Date();
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.password = password;
    }

    public Long getId() {return this.id;}

    public String getFirstName() {return firstName;}

    public String getLastName() {return lastName;}

    public String getEmail() {return email;}

    public Date getDateOfBirth() {return dateOfBirth;}

    public Date getRegistrationDate() {return registrationDate;}

    public Address getAddress() {return address;}

    public void setAddress(Address address) {this.address = address;}

    public void setOrders(List<Order> orders) {this.orders = orders;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public List<Order> getOrders() {return orders;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public void setEmail(String email) {this.email = email;}

    public void setDateOfBirth(Date dateOfBirth) {this.dateOfBirth = dateOfBirth;}

    public void setRegistrationDate(Date registrationDate) {this.registrationDate = registrationDate;}

    public void setAddress_id(Address address) {this.address = address;}

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Customer");
        sb.append("{id=").append(id);
        sb.append(", firstName='").append(firstName);
        sb.append(", lastName=").append(lastName);
        sb.append(", email=").append(email);
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", registrationDate=").append(registrationDate);
        sb.append(", address=").append(address);
        sb.append("}\n");
        return sb.toString();
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}



