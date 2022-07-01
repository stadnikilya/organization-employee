package employees;

import org.springframework.stereotype.Service;
import organizations.Organization;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    public EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> list() {
        return employeeRepository.findAll();
    }
    public void add(Employee employee) {
        employeeRepository.save(employee);
    }

    public void delete(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public void update(Employee employee) {
        Optional<Employee> employeeRow = employeeRepository.findById(employee.getId());
        if (employeeRow.isPresent()) {
            Employee item = employeeRow.get();
            if (!employee.getName().isEmpty()) {
                item.setName(employee.getName());
            }
            if (employee.getBirthDate() != null) {
                item.setBirthDate(employee.getBirthDate());
            }
            if (employee.getOrganization() != null) {
                item.setOrganization(employee.getOrganization());
            }
            if (!employee.getPosition().isEmpty()) {
                item.setPosition(employee.getPosition());
            }
            employeeRepository.save(item);
        }
    }
}
