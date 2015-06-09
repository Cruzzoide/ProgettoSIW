package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "findAllProducts", query = "SELECT p FROM Product p")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Float price;

    @Column(length = 2000)
    private String description;

    @Column(nullable = false)
    private Integer quantity;

    @Column(unique = true, nullable = false)
    private String code;

    @ManyToMany
    private List<Provider> providers;

    public Product() {
    }

    public Product(String name, Float price, String description, String code, Integer quantity) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.code = code;
        this.quantity = quantity;
        this.providers = new ArrayList<Provider>();
    }

    //          Getters & Setters        

    public Long getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public List<Provider> getProviders() {return providers;}

    public void setProviders(List<Provider> providers) {this.providers = providers;}

    public boolean equals(Object obj) {
        Product product = (Product)obj;
        return this.getCode().equals(product.getCode());
    }

    public int hashCode() {
        return this.code.hashCode();
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Product");
        sb.append("{id=").append(id);
        sb.append(", name='").append(name);
        sb.append(", price=").append(price);
        sb.append(", description='").append(description);
        sb.append(", code='").append(code);
        sb.append("}\n");
        return sb.toString();
    }

}