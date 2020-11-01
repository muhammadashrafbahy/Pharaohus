package army.misr.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@JsonPropertyOrder({"packTypeID", "packType"})
public class packType {
    public packType() {super();    }


    public packType(@JsonProperty("packTypeID") int packTypeID,
                    @JsonProperty("packType")  String packType) {
        this.packTypeID = packTypeID;
        this.packType = packType;
    }

    @Id
    @Column(unique = true, nullable = false)
    private int packTypeID;


    @Column( nullable = false)
    private String packType ;

    public int getPackTypeID() {
        return packTypeID;
    }

    public void setPackTypeID(int packTypeID) {
        this.packTypeID = packTypeID;
    }

    public String getPackType() {
        return packType;
    }

    public void setPackType(String packType) {
        this.packType = packType;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        packType pt= (packType) o;
        return Objects.equals(packTypeID , pt.packTypeID); }

    @Override
    public int hashCode() {

        return Objects.hash(packTypeID  );
    }
}
