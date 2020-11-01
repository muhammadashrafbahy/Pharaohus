package army.misr.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@JsonPropertyOrder({"rankID", "rankType"})
public class rank {
    public rank() { super();    }

    public rank(@JsonProperty("rankID") int rankID,
                @JsonProperty("rankType") String rankType) {
        this.rankID = rankID;
        this.rankType = rankType;
    }

    @Id
    @Column(unique = true, nullable = false)
    private int rankID;


    @Column( nullable = false)
    private String rankType ;

    public int getRankID() {
        return rankID;
    }

    public void setRankID(int rankID) {
        this.rankID = rankID;
    }

    public String getRankType() {
        return rankType;
    }

    public void setRankType(String rankType) {
        this.rankType = rankType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        rank r= (rank) o;
        return Objects.equals(rankID , r.rankID); }

    @Override
    public int hashCode() {

        return Objects.hash(rankID);
    }

}
