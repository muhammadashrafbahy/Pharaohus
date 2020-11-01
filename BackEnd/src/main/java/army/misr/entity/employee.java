package army.misr.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonPropertyOrder({ "empName   ", "rankID", "bdate",
        "jobDate", "address", "phone", "socialState", "headQuarter", "password"})

public class employee {
    public employee() { super();    }
    public employee(employee employee) { super();    }


    public employee(@JsonProperty("empName")String empName,
                    @JsonProperty("rankID")int rankID,
                    @JsonProperty("bdate")Date bdate,
                    @JsonProperty("jobDate")Date jobDate,
                    @JsonProperty("address")String address,
                    @JsonProperty("phone")String phone,
                    @JsonProperty("socialState")String socialState,
                    @JsonProperty("headQuarter")boolean headQuarter,
                    @JsonProperty("password")String password ){

        this.empName = empName;
        this.rankID = rankID;
        Bdate = bdate;
        this.jobDate = jobDate;
        this.address = address;
        this.phone = phone;
        this.socialState = socialState;
        this.headQuarter = headQuarter;
        this.password =password;
    }

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empID;

    @Column( nullable = false)
    private String empName;

    @Column( nullable = false)
    private int rankID ;
    @Column
    private Date Bdate;

@Column
    private Date jobDate;
    @Column
    private String address;
    @Column
    private String phone;
    @Column
    private String socialState;


    @Column( nullable = false)
    private boolean headQuarter;
    @Column
    private String password;


//    @OneToMany(cascade = CascadeType.REMOVE, targetEntity = Role.class)
//    @JoinTable(name = "employee_role" ,joinColumns = {@JoinColumn(name = "empID")}
//            ,inverseJoinColumns ={@JoinColumn(name   = "role_id")} )
//    private List<Role> roles;

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getRankID() {
        return rankID;
    }

    public void setRankID(int rankID) {
        this.rankID = rankID;
    }

    public Date getBdate() {
        return Bdate;
    }

    public void setBdate(Date bdate) {
        Bdate = bdate;
    }

    public Date getJobDate() {
        return jobDate;
    }

    public void setJobDate(Date jobDate) {
        this.jobDate = jobDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSocialState() {
        return socialState;
    }

    public void setSocialState(String socialState) {
        this.socialState = socialState;
    }

    public boolean isHeadQuarter() {
        return headQuarter;
    }

    public void setHeadQuarter(boolean headQuarter) {
        this.headQuarter = headQuarter;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public List<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<Role> roles) {
//        this.roles = roles;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        employee e= (employee) o;
        return Objects.equals(empID , e.empID); }

    @Override
    public int hashCode() {

        return Objects.hash(empID);
    }
}
