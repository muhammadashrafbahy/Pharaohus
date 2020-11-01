package army.misr.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@JsonPropertyOrder({"factoryID", "execCompany", "startDate", "executeDate",
        "prodPerDay", "prodPerYear", "salesList", "storeList"
        , "reSalesList", "productList","employeeList","expensesList"})
public class factory {

    public factory() {super();    }

    public factory(@JsonProperty("factoryID")int factoryID,
                   @JsonProperty("execCompany")String execCompany,
                   @JsonProperty("startDate")Date startDate,
                   @JsonProperty("executeDate")Date executeDate,
                   @JsonProperty("prodPerDay")int prodPerDay,
                   @JsonProperty("prodPerYear")int prodPerYear,
                   @JsonProperty("salesList")ArrayList<sales> salesList,
                   @JsonProperty("storeList")ArrayList<store> storeList,
                   @JsonProperty("reSalesList")ArrayList<reSales> reSalesList,
                   @JsonProperty("productList")ArrayList<product> productList,
                   @JsonProperty("employeeList")ArrayList<employee> employeeList,
                   @JsonProperty("expensesList") ArrayList<expenses> expensesList) {
        this.factoryID = factoryID;
        this.execCompany = execCompany;
        this.startDate = startDate;
        this.executeDate = executeDate;
        this.prodPerDay = prodPerDay;
        this.prodPerYear = prodPerYear;
        this.salesList = salesList;
        this.storeList = storeList;
        this.reSalesList = reSalesList;
        this.productList = productList;
        this.employeeList = employeeList;
        this.expensesList = expensesList;
    }

    @Id
    @Column(unique = true, nullable = false)
    private int factoryID ;

    private  String execCompany ;
    private Date startDate  , executeDate ;
    private  int prodPerDay , prodPerYear ;

    //////////////////relations\\\\\\\\\\\\\\\\\\\
    @OneToMany(cascade = CascadeType.ALL , targetEntity = sales.class)
    @JoinTable(name = "factory_sales" ,joinColumns = {@JoinColumn(name = "factoryID")}
            ,inverseJoinColumns ={@JoinColumn(name   = "salesID")} )
    private List<sales> salesList =  new ArrayList<sales>();
    @OneToMany(cascade = CascadeType.ALL , targetEntity = store.class)
    @JoinTable(name = "factory_store" ,joinColumns = {@JoinColumn(name = "factoryID")}
            ,inverseJoinColumns ={@JoinColumn(name   = "storeID")} )
    private  List<store> storeList = new ArrayList<store>() ;
    @OneToMany(cascade = CascadeType.ALL , targetEntity = reSales.class)
    @JoinTable(name = "factory_resales" ,joinColumns = {@JoinColumn(name = "factoryID")}
            ,inverseJoinColumns ={@JoinColumn(name   = "reSalesID")} )
    private  List<reSales> reSalesList = new ArrayList<reSales>() ;
    @OneToMany(cascade = CascadeType.ALL , targetEntity = product.class)
    @JoinTable(name = "factory_product" ,joinColumns = {@JoinColumn(name = "factoryID")}
            ,inverseJoinColumns ={@JoinColumn(name   = "productID")} )
    private  List<product> productList = new ArrayList<product>() ;
    @OneToMany(cascade = CascadeType.ALL , targetEntity = employee.class)
    @JoinTable(name = "factory_employee" ,joinColumns = {@JoinColumn(name = "factoryID")}
            ,inverseJoinColumns ={@JoinColumn(name   = "employeeID")} )
    private  List<employee> employeeList = new ArrayList<employee>() ;
    @OneToMany(cascade = CascadeType.ALL , targetEntity = expenses.class)
    @JoinTable(name = "factory_expenses" ,joinColumns = {@JoinColumn(name = "factoryID")}
            ,inverseJoinColumns ={@JoinColumn(name   = "expensesID")} )
    private  List<expenses> expensesList = new ArrayList<expenses>() ;

    public int getFactoryID() {
        return factoryID;
    }

    public void setFactoryID(int factoryID) {
        this.factoryID = factoryID;
    }

    public String getExecCompany() {
        return execCompany;
    }

    public void setExecCompany(String execCompany) {
        this.execCompany = execCompany;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getExecuteDate() {
        return executeDate;
    }

    public void setExecuteDate(Date executeDate) {
        this.executeDate = executeDate;
    }

    public int getProdPerDay() {
        return prodPerDay;
    }

    public void setProdPerDay(int prodPerDay) {
        this.prodPerDay = prodPerDay;
    }

    public int getProdPerYear() {
        return prodPerYear;
    }

    public void setProdPerYear(int prodPerYear) {
        this.prodPerYear = prodPerYear;
    }

    public List<sales> getSalesList() {
        return salesList;
    }

    public void setSalesList(List<sales> salesList) {
        this.salesList = salesList;
    }

    public List<store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<store> storeList) {
        this.storeList = storeList;
    }

    public List<reSales> getReSalesList() {
        return reSalesList;
    }

    public void setReSalesList(List<reSales> reSalesList) {
        this.reSalesList = reSalesList;
    }

    public List<product> getProductList() {
        return productList;
    }

    public void setProductList(List<product> productList) {
        this.productList = productList;
    }

    public List<employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<expenses> getExpensesList() {
        return expensesList;
    }

    public void setExpensesList(List<expenses> expensesList) {
        this.expensesList = expensesList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        factory f= (factory) o;
        return Objects.equals(factoryID , f.factoryID); }

    @Override
    public int hashCode() {

        return Objects.hash(factoryID);
    }
}
