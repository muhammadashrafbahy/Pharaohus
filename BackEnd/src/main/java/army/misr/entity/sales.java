package army.misr.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonPropertyOrder({"salesID", "quantity", "unit", "productID", "saleDate"})
public class sales {

    public sales() {    super();  }

    @JsonCreator
    public sales(@JsonProperty("salesID") int salesID,
                 @JsonProperty("quantity")int quantity,
                 @JsonProperty("unit") String unit,
                 @JsonProperty("saleDate") Date saleDate,
                 @JsonProperty("productID") int productID) {
        this.salesID = salesID;
        this.quantity = quantity;
        this.unit = unit;
        this.saleDate = saleDate;
        this.productID = productID;
    }

    @Id
    @Column(unique = true, nullable = false)
    private int salesID ;

    @Column( nullable = false)
    private int quantity ;

    @Column( nullable = false)
    private String unit ;

    @Column( nullable = false)
    private Date saleDate ;

    @Column( nullable = false)
    private int productID ;

    public int getSalesID() {
        return salesID;
    }

    public void setSalesID(int salesID) {
        this.salesID = salesID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        sales s= (sales) o;
        return Objects.equals(salesID , s.salesID); }

    @Override
    public int hashCode() {

        return Objects.hash(salesID);
    }


}
