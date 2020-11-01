package army.misr.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@JsonPropertyOrder({"carID", "carNo","carLoad"})
public class car {
    public car() { super();    }

    public car(@JsonProperty("carID")int carID,
               @JsonProperty("carNo") String carNo,
               @JsonProperty("carLoad")String carLoad) {
        this.carID = carID;
        this.carNo = carNo;
        this.carLoad = carLoad;
    }

    @Id
    @Column(unique = true, nullable = false)
    private int carID;

    private String carNo , carLoad ;

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getCarLoad() {
        return carLoad;
    }

    public void setCarLoad(String carLoad) {
        this.carLoad = carLoad;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        car c= (car) o;
        return Objects.equals(carID , c.carID); }

    @Override
    public int hashCode() {

        return Objects.hash(carID);
    }
}
