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
        this.orderFacade.closeOrder(order,closeTime,orderLines);

        if(this.customerController.getCustomer().getOrders() == null) {
            this.customerController.getCustomer().setOrders(new ArrayList<Order>());
        }else
            this.orderFacade.addOrder(this.customerController.getCustomer(),order);

        this.orderLines.clear();
        return "order";
    }

    public String allOrders(){
        this.orders = orderFacade.allOrders();

        return "orders";

    }

    public String findOrder(Long id){
        this.order = this.customerController.getCustomerFacade().getOrder(id);
        this.orderLines = order.getOrderLines();
        return "order";
    }

    public double calculateTotal(){
        double tot = 0;

        for(OrderLine ol : this.order.getOrderLines())
            if(ol!=null)
                tot += ol.getUnitPrice() * ol.getQuantity();

        return tot;
    }

    public String evadeOrder(Order o){
        this.orderFacade.evadeOrder(o);
        return "orders";
    }

    public boolean checkEvade(Order o){

        for(OrderLine ol : o.getOrderLines()) {
            Integer newQta = ol.getProduct().getQuantity() - ol.getQuantity();
            if(newQta < 0)
                return false;
        }

        return true;
    }

    public String orderNull(){
        this.order = null;
        return "homePage";
    }

    public String deleteProductFromOrder(OrderLine ol){
        this.orderLines.remove(ol);

        return "basket";

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