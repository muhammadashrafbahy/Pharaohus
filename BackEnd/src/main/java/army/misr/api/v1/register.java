package army.misr.api.v1;

import army.misr.entity.employee;
import army.misr.service.employeeService;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/register")
@Api(description = "register or create new entity")
public class register {
    private final employeeService employeeService;

    public register(army.misr.service.employeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Transactional
    @ApiOperation(value = "create new employee")
    @PostMapping(value = "/employee")
    public ResponseEntity createNewEmployee(@Valid @RequestBody employee employee ){
        this.employeeService.createAnEmployee(employee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .replacePath("/misroliaa/employee")
                .path("/" + employee.getEmpID())
                .buildAndExpand().toUri();

        return  ResponseEntity.created(location).contentType(MediaType.APPLICATION_JSON).build();


    }

}
