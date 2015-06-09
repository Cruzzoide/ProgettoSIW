package controller;

import facade.ProductFacade;
import model.Product;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name="productController")
@SessionScoped
public class ProductController {

    @EJB(name="pFacade")
    private ProductFacade productFacade;

    private String name;
    private Float price;
    private String description;
    private String code;
    private Integer quantity;
    private Product product;

    private List<Product> products;

    public String createProduct() {
        this.product = productFacade.createProduct(name, code, price, description,quantity);
        return "product";
    }

    public String findProduct(Long id){
        product = productFacade.getProduct(id);
        return "product";
    }


    public String catalogProducts() {
        this.products = productFacade.getAllProducts();
        return "products";
    }

    public String deleteProductFromCatalog(Long id){
        productFacade.deleteProduct(id);
        this.products = productFacade.getAllProducts();

        return "products";
    }

    public String addProduct(Product p){
        this.product = p;
        return "newOrderLine";
    }

    public String goModify(Product p){
        this.product = p;
        this.price = p.getPrice();
        this.description = p.getDescription();
        this.quantity = p.getQuantity();

        return "modifyProduct";
    }

    public String modifyProduct(){
        productFacade.modifyProduct(product,price,quantity,description);

        return "product";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductFacade getProductFacade() {
        return productFacade;
    }

    public Integer getQuantity() {return quantity;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}

    public void setProductFacade(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }

    public void setProducts(List<Product> products) {this.products = products;}

    public List<Product> getProducts() {return products;}

}
