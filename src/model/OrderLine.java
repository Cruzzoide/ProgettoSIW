package model;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name = "order_line")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Float unitPrice;

    @Column(nullable = false)
    private Integer quantity;

    @OneToOne
    private Product product;

    public OrderLine(){
    }

    public OrderLine(Float unitPrice, Integer quantity, Product product){
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.product = product;
    }

    public Long getId() {return id;}

    public Integer getQuantity() {return quantity;}

    public Float getUnitPrice() {return unitPrice;}

    public Product getProduct() {return product;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    public void setUnitPrice(Float unitPrice) {this.unitPrice = unitPrice;}

    public void setProduct(Product product) {this.product = product;}

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("OrderLine");
        sb.append("{id=").append(id);
        sb.append(", unitPrice='").append(unitPrice);
        sb.append(", quantity=").append(quantity);
        sb.append(", product=").append(product);
        sb.append("}\n");
        return sb.toString();
    }

}
