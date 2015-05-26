package controller;

import facade.OrderFacade;
import model.Customer;
import model.Order;
import model.OrderLine;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name="orderController")
@SessionScoped
public class OrderController {

    @EJB(name="oFacade")
    private OrderFacade orderFacade;

    private Date creationTime;
    private Date evasionTime;
    private Date closeTime;
    private OrderLine orderLine;
    private List<OrderLine> orderLines;
    private List<Order> orders;
    private Order order;
    private Customer customer_id;

    @ManagedProperty(value="#{customerController}")
    private CustomerController customerController;


    public OrderController(){
        this.orderLines = new ArrayList<OrderLine>();
    }


    public String createOrder(Customer c){
        this.customer_id = c;
        this.creationTime = new Date();
        this.order = orderFacade.createOrder(this.creationTime,this.customer_id);
        return "newOrder";
    }

    public String closeOrder(){
        this.closeTime = new Date();
        this.orderFacade.closeOrder(order,closeTime);

        if(this.customerController.getOrders() == null){
            this.customerController.setOrders(new ArrayList<Order>());
        }

        this.customerController.getOrders().add(order);

        return "order";
    }

    public String byeOrder(){
        this.order=null;
        return "indexCustomer";

    }

    public String findOrder(Long id){
        this.order = this.customerController.getCustomerFacade().getOrder(id);
        return "order";
    }

    public double calculateTotal(){
        double tot = 0;

        for(OrderLine ol : this.orderLines)
            tot += ol.getUnitPrice() * ol.getQuantity();

        return tot;
    }

    public String evasionOrder(Long id){
        this.order = orderFacade.getOrder(id);
        orderFacade.evasionOrder(order);

        return "orders";
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public CustomerController getCustomerController() {
        return customerController;
    }

    public void setCustomerController(CustomerController customerController) {
        this.customerController = customerController;
    }

    public Date getEvasionTime() {
        return evasionTime;
    }

    public void setEvasionTime(Date evasionTime) {
        this.evasionTime = evasionTime;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderLine getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLine orderLine) {
        this.orderLine = orderLine;
    }

    public List<OrderLine> getOrderLines(){
        return this.orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}