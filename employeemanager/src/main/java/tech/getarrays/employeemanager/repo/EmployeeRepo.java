package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import tech.getarrays.employeemanager.model.Employee;

import java.util.Optional;

//extindem jparepository ca sa avem acces la comenzile lui
@CrossOrigin("http://localhost:4200")
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);//punem optional in caz ca nu avem employee cu id ul ala sa arunce exceptia data
}
