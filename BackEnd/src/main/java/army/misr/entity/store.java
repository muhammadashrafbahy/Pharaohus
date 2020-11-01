package army.misr.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
//@Table(name = "store")
@JsonPropertyOrder({"storeID", "quantity", "unit", "productID", "packTypeID"})
public class store {
    public store() {  super();    }

    @JsonCreator
    public store(@JsonProperty("storeID") int storeID,
                 @JsonProperty("quantity") int quantity,
                 @JsonProperty("unit") String unit,
                 @JsonProperty("productID") int productID,
                 @JsonProperty("packTypeID") int packTypeID) {
        this.storeID = storeID;
        this.quantity = quantity;
        this.unit = unit;
        this.productID = productID;
        this.packTypeID = packTypeID;
    }

    @Id
    @Column(unique = true, nullable = false)
    private int storeID ;

    @Column( nullable = false)
    private int quantity ;

    @Column( nullable = false)
    private String unit ;

    @Column( nullable = false)
    private int productID ;

    @Column( nullable = false)
    private int packTypeID ;

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
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

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getPackTypeID() {
        return packTypeID;
    }

    public void setPackTypeID(int packTypeID) {
        this.packTypeID = packTypeID;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        store s= (store) o;
        return Objects.equals(storeID , s.storeID); }

    @Override
    public int hashCode() {

        return Objects.hash(storeID);
    }

}
