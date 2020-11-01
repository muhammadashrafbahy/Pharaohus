package army.misr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class employeeNotFound extends RuntimeException {

    private static final String errorNumber ="APP1-EMPLOYEE-ERROR-001";

    private  int empID ;

    public employeeNotFound(int empID) {
        super(String.format("the employee whose id is %s is not found",empID));
        this.empID = empID;
    }

    public  int getemployeeID() {
        return this.empID ;
    }
    public  String getErrorNumber() {
        return errorNumber;
    }
}
