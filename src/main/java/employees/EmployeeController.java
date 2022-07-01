package employees;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {
    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("list")
    public List<Employee> getEmployees() {
        return employeeService.list();
    }

    @PostMapping("item")
    public void add(@RequestBody Employee employee) {
        employeeService.add(employee);
    }

    @DeleteMapping("item/{employeeId")
    public void delete(@PathVariable Long employeeId) {
        employeeService.delete(employeeId);
    }

    @PutMapping("item")
    public void update(@RequestBody Employee employee) {
        employeeService.update(employee);
    }
}
