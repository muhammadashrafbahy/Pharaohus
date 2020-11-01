package army.misr.loadData;

import army.misr.entity.employee;
import army.misr.service.employeeService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
@Profile("dev")
public class loadEmployeeTestData {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final employeeService employeeService ;
    private final ObjectMapper objectMapper ;

    public loadEmployeeTestData(employeeService employeeService) {

        this.employeeService = employeeService;
        this.objectMapper =new ObjectMapper();

    }

    public void load() throws Exception{
        loadEmployees("classpath:data/employee.json");

    }
    public void loadEmployees(String path) throws IOException {
        File file = ResourceUtils.getFile(path);
        byte[] fileContent = Files.readAllBytes(file.toPath());
        JsonNode rootNode = objectMapper.readTree(fileContent);
        rootNode.forEach(employee -> {

            log.debug("Loading employees json: {}", employee);
            employee entity = parseJSON(employee);

            employeeService.createAnEmployee(entity);
            });
    }


    public employee parseJSON(JsonNode jsonNode){
        employee node = new employee();
        node.setAddress(jsonNode.get("address").asText());
//        node.setBdate(jsonNode.get("bdate").asText());
        node.setEmpName(jsonNode.get("empName").asText());
        node.setHeadQuarter(jsonNode.get("headQuarter").asBoolean());
//        node.setJobDate(jsonNode.get("jobDate").asText());
        node.setPassword(BcryptEncode(jsonNode.get("password").asText()));
        node.setPhone(jsonNode.get("phone").asText());
        node.setRankID(jsonNode.get("rankID").asInt());
        node.setSocialState(jsonNode.get("socialState").asText());
        return node;
    }
    public String BcryptEncode(String password){
            return  new BCryptPasswordEncoder().encode(password);
    }


    private void clearData() {
        try {
            employeeService.deleteALlEmployee();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("****************LOAD DATA*******************");
//        boolean loadData = BooleanUtils.toBoolean(System.getProperty("loadData"));
//        if (loadData) {
//
//
//        }else{


            clearData();
            load();
//        }
    }

    }
