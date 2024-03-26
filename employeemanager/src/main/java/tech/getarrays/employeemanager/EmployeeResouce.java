package tech.getarrays.employeemanager;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResouce {
    private final EmployeeService employeeService;

    public EmployeeResouce(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")//nu e necesar all
    public ResponseEntity<List<Employee>> getAllEmployee(){
      List<Employee> employees=  employeeService.findAllEmployees();
      return new ResponseEntity<>(employees, HttpStatus.OK) ;
    }
    @GetMapping("/find/{id}")//in /employee/find/id da return la employee cu id ul cerut
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")Long id){
        Employee employee=  employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK) ;
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
         Employee newEmployee=  employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.OK) ;
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee newEmployee=  employeeService.updateEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.OK) ;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable("id")Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK); //punem ? pentru ca nu retrunam niciun obiect doar status

    }
}
