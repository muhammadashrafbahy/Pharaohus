package army.misr.service.validation;

import army.misr.entity.employee;
import army.misr.exception.employeeNotFound;
import army.misr.reprositery.employeeReprositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class employeeValidator {

    private employeeReprositery  employeeReprositery;
    @Autowired
    public employeeValidator(employeeReprositery employeeReprositery) {
        this.employeeReprositery = employeeReprositery;
    }

    /**
     * returns a valid employee the database
     * @param empID the given employeeID
     * @return the employee object
     */

    public employee getValidEmployee(int empID) {
        employee employee = this.employeeReprositery.findById(empID).orElse(null);
        if (employee == null){

            throw new employeeNotFound(empID);
        }else {

            return employee;
        }
    }

    /**
     * return true if  employee already exist in the database
     * @param empID the given employeeID
     * @return true or false
     */

    public boolean checkExistOfEmployeeForCreation(int empID) {
        employee employee = this.employeeReprositery.findById(empID).orElse(null);
        if (employee == null){

            return false;
        }else {

            return true;
        }
    }
}
