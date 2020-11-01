package army.misr.entity;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@JsonPropertyOrder({"prodID", "prodName", "prodPrice", "earn","prodDate", "expireDate"})
public class supplier {
    public supplier() { super(); }


    @Id
    @Column(unique = true, nullable = false)
    private int supplierID;

    private String supplierName , supplierHeader  ;


    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierHeader() {
        return supplierHeader;
    }

    public void setSupplierHeader(String supplierHeader) {
        this.supplierHeader = supplierHeader;
    }
}
