package army.misr.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonPropertyOrder({"prodID", "prodName", "prodPrice", "earn","prodDate", "expireDate"})
public class product {
    public product() { super();    }

    public product(@JsonProperty("prodID")int prodID,
                   @JsonProperty("prodName")String prodName,
                   @JsonProperty("prodPrice")String prodPrice,
                   @JsonProperty("earn")String earn,
                   @JsonProperty("prodDate")Date prodDate,
                   @JsonProperty("expireDate")Date expireDate) {
        this.prodID = prodID;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.earn = earn;
        this.prodDate = prodDate;
        this.expireDate = expireDate;
    }

    @Id
    @Column(unique = true, nullable = false)
    private int prodID ;

    @Column( nullable = false)
    private String prodName;

    @Column( nullable = false)
    private String prodPrice;

    @Column( nullable = false)
    private String earn;

    @Column( nullable = false)
    private Date prodDate;

    @Column( nullable = false)
    private Date expireDate;

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(String prodPrice) {
        this.prodPrice = prodPrice;
    }

    public String getEarn() {
        return earn;
    }

    public void setEarn(String earn) {
        this.earn = earn;
    }

    public Date getProdDate() {
        return prodDate;
    }

    public void setProdDate(Date prodDate) {
        this.prodDate = prodDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        product p= (product) o;
        return Objects.equals(prodID , p.prodID); }

    @Override
    public int hashCode() {

        return Objects.hash(prodID);
    }
}
