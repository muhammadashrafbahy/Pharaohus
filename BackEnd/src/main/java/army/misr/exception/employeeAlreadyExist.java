package army.misr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class employeeAlreadyExist extends RuntimeException {

    private static final String errorNumber ="APP1-EMPLOYEE-ERROR-002";

    private  int empID ;

    public employeeAlreadyExist(int empID) {
        super(String.format("the employee whose id is %s is already exist ",empID));
        this.empID = empID;
    }

    public  int getemployeeID() {
        return this.empID ;
    }
    public  String getErrorNumber() {
        return errorNumber;
    }
}
