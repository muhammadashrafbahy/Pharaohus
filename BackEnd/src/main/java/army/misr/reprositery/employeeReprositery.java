package army.misr.reprositery;

import army.misr.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface employeeReprositery extends JpaRepository<employee, Integer> {

    Optional<employee> findByempName(String empName);
}
