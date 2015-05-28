package controller;

import facade.AdminFacade;
import model.Admin;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;

/**
 * Created by Michele on 26/05/15.
 */

@ManagedBean(name="adminController")
@SessionScoped
public class AdminController {

    @EJB(name="adFacade")
    private AdminFacade adminFacade;

    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfBirth;
    private String password;
    private Admin admin;

    private String message;


    public String adminLogin(){

        try{
            this.admin = adminFacade.checkPassword(this.email, this.password);
            return "homePageAdmin";

        }catch (Exception e){

            this.message = e.getMessage();
            return "loginErr";
        }
    }

    public String adminLogout(){
        this.admin = null;
        return "loginAdmin";
    }


    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public AdminFacade getAdminFacade() {
        return adminFacade;
    }

    public void setAdminFacade(AdminFacade adminFacade) {
        this.adminFacade = adminFacade;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
