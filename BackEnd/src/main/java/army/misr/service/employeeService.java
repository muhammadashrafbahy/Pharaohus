package army.misr.service;
import army.misr.entity.employee;

import army.misr.exception.employeeAlreadyExist;
import army.misr.exception.employeeNotFound;
import army.misr.reprositery.employeeReprositery;
import army.misr.service.validation.employeeValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeeService {
    private employeeReprositery employeeReprositery ;
    private employeeValidator employeeValidation;
    private ModelMapper modelMapper;
    @Autowired
    public employeeService(army.misr.reprositery.employeeReprositery employeeReprositery) {
        this.employeeReprositery = employeeReprositery;
    }



    /**
     * return all employee
     * @return a list of all employee
     */

    public List<employee> getAllEmployee(){

        return employeeReprositery.findAll();
    }

    /**
     * returns the details of a given employee
     * @param empID the id of the employee
     * @return employee details
     */
    public employee getAnEmployee(int empID){

            try {
                return  this.employeeValidation.getValidEmployee(empID);
            }catch (Exception e){
                throw new employeeNotFound(empID);
            }

    }

    /**
     * delete an employee
     * @param empID the id of the employee

     */
    public void deleteAnEmployee(int empID){

        try {
            employee employee = this.employeeValidation.getValidEmployee(empID);
            if (employee!= null ){

                this.employeeReprositery.delete(employee);
            }
        }catch (Exception e){
            throw new employeeNotFound(empID);
        }

    }

    /**
     * update data in an employee in the database
     * @param empID the id of the employee to update
     * @param newEmployee the payload of the employee to update

     */
    public void updateAnEmployee(int empID , employee newEmployee){

        try {
            newEmployee.setEmpID(empID);
            employee oldEmployee = this.employeeValidation.getValidEmployee(empID);
            modelMapper.map(newEmployee ,oldEmployee);
            this.employeeReprositery.save(oldEmployee);
        }catch (Exception e){
            throw new employeeNotFound(empID);
        }

    }

    /**
     * create new employee in the database
     * @param newEmployee the payload of the employee to update

     */
    public void createAnEmployee(employee newEmployee){
            String enCodedPassword = new BCryptPasswordEncoder().encode(newEmployee.getPassword());
        newEmployee.setPassword(enCodedPassword);

          this.employeeReprositery.save(newEmployee);


    }





    public void deleteALlEmployee(){this.employeeReprositery.deleteAll();}



}
