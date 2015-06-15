package controller;

import facade.OrderLineFacade;
import model.OrderLine;
import model.Product;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="orderLineController")
@SessionScoped
public class OrderLineController {

    @EJB(name = "olFacade")
    private OrderLineFacade orderLineFacade;
    private Product product;
    private Integer quantity;
    private OrderLine ol;

    @ManagedProperty(value = "#{orderController}")
    private OrderController orderController;

    @ManagedProperty(value = "#{productController}")
    private ProductController productController;

    public String createOrderLine(Product p) {
        OrderLine orderLine = new OrderLine(p.getPrice(),quantity,p);

            this.orderController.getOrderLines().add(orderLine);
            return "basket";
    }


    public OrderLine getOl() {
        return ol;
    }

    public void setOl(OrderLine ol) {
        this.ol = ol;
    }

    public OrderController getOrderController() {
        return orderController;
    }

    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }

    public OrderLineFacade getOrderLineFacade() {
        return orderLineFacade;
    }

    public void setOrderLineFacade(OrderLineFacade orderLineFacade) {
        this.orderLineFacade = orderLineFacade;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product p) {
        this.product = p;
    }

    public ProductController getProductController() {
        return productController;
    }

    public void setProductController(ProductController productController) {
        this.productController = productController;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
