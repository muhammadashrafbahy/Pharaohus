package army.misr.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonPropertyOrder({"reSaleID", "quantity", "unit", "reSaleDate", "productID"})
public class reSales {
    public reSales() { super(); }

    public reSales(@JsonProperty("reSaleID")int reSaleID,
                   @JsonProperty("quantity") int quantity,
                   @JsonProperty("unit") String unit,
                   @JsonProperty("reSaleDate") Date reSaleDate,
                   @JsonProperty("productID")int productID) {
        this.reSaleID = reSaleID;
        this.quantity = quantity;
        this.unit = unit;
        this.reSaleDate = reSaleDate;
        this.productID = productID;
    }

    @Id
    @Column(unique = true, nullable = false)
    private int reSaleID ;

    @Column( nullable = false)
    private int quantity ;

    @Column( nullable = false)
    private String unit ;

    @Column( nullable = false)
    private Date reSaleDate;

    @Column( nullable = false)
    private int productID ;

    public int getReSaleID() {
        return reSaleID;
    }

    public void setReSaleID(int reSaleID) {
        this.reSaleID = reSaleID;
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

    public Date getReSaleDate() {
        return reSaleDate;
    }

    public void setReSaleDate(Date reSaleDate) {
        this.reSaleDate = reSaleDate;
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
        reSales rs= (reSales) o;
        return Objects.equals(reSaleID , rs.reSaleID); }

    @Override
    public int hashCode() {

        return Objects.hash(reSaleID);
    }
}
