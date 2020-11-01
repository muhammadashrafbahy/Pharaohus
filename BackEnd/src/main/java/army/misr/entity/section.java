package army.misr.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;

import army.misr.entity.*;

import java.util.ArrayList;
import java.util.List;

@Entity
//@JsonPropertyOrder({"prodID", "prodName", "prodPrice", "earn","prodDate", "expireDate"})
public class section {
    public section() {super();    }


    @Id
    @Column(unique = true, nullable = false)
    private int sectionID;

    @Column( nullable = false)
    private String sectionName;

    ///////////////relations\\\\\\\\\\\\
    @OneToMany(cascade = CascadeType.ALL , targetEntity = store.class)
    @JoinTable(name = "section_store" ,joinColumns = {@JoinColumn(name = "sectionID")}
            ,inverseJoinColumns ={@JoinColumn(name   = "storeID")} )
    private List<sales> salesL =  new ArrayList<sales>();
    @OneToMany(cascade = CascadeType.ALL , targetEntity = sales.class)
    @JoinTable(name = "section_sales" ,joinColumns = {@JoinColumn(name = "sectionID")}
            ,inverseJoinColumns ={@JoinColumn(name   = "salesID")} )
    private  List<store> storeL = new ArrayList<store>() ;
    @OneToMany(cascade = CascadeType.ALL , targetEntity = reSales.class)
    @JoinTable(name = "section_reSales" ,joinColumns = {@JoinColumn(name = "sectionID")}
            ,inverseJoinColumns ={@JoinColumn(name   = "reSalesID")} )
    private  List<reSales> reSaleL = new ArrayList<reSales>() ;
    @OneToMany(cascade = CascadeType.ALL , targetEntity = product.class)
    @JoinTable(name = "section_product" ,joinColumns = {@JoinColumn(name = "sectionID")}
            ,inverseJoinColumns ={@JoinColumn(name   = "productID")} )
    private  List<product> productL = new ArrayList<product>() ;
    @OneToMany(cascade = CascadeType.ALL , targetEntity = employee.class)
    @JoinTable(name = "section_employee" ,joinColumns = {@JoinColumn(name = "sectionID")}
            ,inverseJoinColumns ={@JoinColumn(name   = "employeeID")} )
    private  List<employee> employeeL = new ArrayList<employee>() ;
    @OneToMany(cascade = CascadeType.ALL , targetEntity = expenses.class)
    @JoinTable(name = "section_expenses" ,joinColumns = {@JoinColumn(name = "sectionID")}
            ,inverseJoinColumns ={@JoinColumn(name   = "expensesID")} )
    private  List<expenses> expensesL = new ArrayList<expenses>() ;

    public int getSectionID() {
        return sectionID;
    }

    public void setSectionID(int sectionID) {
        this.sectionID = sectionID;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }


    public List<sales> getSalesL() {
        return salesL;
    }

    public void setSalesL(List<sales> salesL) {
        this.salesL = salesL;
    }

    public List<store> getStoreL() {
        return storeL;
    }

    public void setStoreL(List<store> storeL) {
        this.storeL = storeL;
    }

    public List<reSales> getReSaleL() {
        return reSaleL;
    }

    public void setReSaleL(List<reSales> reSaleL) {
        this.reSaleL = reSaleL;
    }

    public List<product> getProductL() {
        return productL;
    }

    public void setProductL(List<product> productL) {
        this.productL = productL;
    }

    public List<employee> getEmployeeL() {
        return employeeL;
    }

    public void setEmployeeL(List<employee> employeeL) {
        this.employeeL = employeeL;
    }

    public List<expenses> getExpensesL() {
        return expensesL;
    }

    public void setExpensesL(List<expenses> expensesL) {
        this.expensesL = expensesL;
    }
}
