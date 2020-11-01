package army.misr.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonPropertyOrder({"expID", "item", "quantity", "unit","date", "price"})
public class expenses {
    public expenses() { super();    }

    public expenses(@JsonProperty("expID") int expID,
                    @JsonProperty("item") String item,
                    @JsonProperty("quantity") String quantity,
                    @JsonProperty("unit") String unit,
                    @JsonProperty("date") Date date,
                    @JsonProperty("price") int price) {
        this.expID = expID;
        this.item = item;
        this.quantity = quantity;
        this.unit = unit;
        this.date = date;
        this.price = price;
    }

    @Id
    @Column(unique = true, nullable = false)
    private int expID;


    @Column( nullable = false)
    private String item ;


    @Column( nullable = false)
    private String quantity;


    @Column( nullable = false)
    private String unit ;


    @Column( nullable = false)
    private Date date ;


    @Column( nullable = false)
    private int price ;

    public int getExpID() {
        return expID;
    }

    public void setExpID(int expID) {
        this.expID = expID;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        expenses e= (expenses) o;
        return Objects.equals(expID , e.expID); }

    @Override
    public int hashCode() {

        return Objects.hash(expID);
    }
}
