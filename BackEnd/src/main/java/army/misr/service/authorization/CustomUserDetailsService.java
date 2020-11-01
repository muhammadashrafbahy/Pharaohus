package army.misr.service.authorization;



import army.misr.entity.customerUserDetails;
import army.misr.entity.employee;
import army.misr.exception.employeeNotFound;
import army.misr.reprositery.employeeReprositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private employeeReprositery employeeReprositery;

    public CustomUserDetailsService(army.misr.reprositery.employeeReprositery employeeReprositery) {
        this.employeeReprositery = employeeReprositery;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<employee> user = employeeReprositery.findByempName(username);
        customerUserDetails customerUserDetails =null;
        if(user == null){
            System.out.println(username+" is not found");
            throw new UsernameNotFoundException("Invalid username or password.");

        }

else {
            customerUserDetails = user.map(customerUserDetails::new).get();
            System.out.println("username -" + customerUserDetails.getUsername());
            System.out.println("password -" + customerUserDetails.getPassword());
        }
        return customerUserDetails;
    }
}