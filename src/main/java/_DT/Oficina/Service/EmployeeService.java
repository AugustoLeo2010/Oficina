package _DT.Oficina.Service;

import _DT.Oficina.Entities.Employee;
import _DT.Oficina.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> listAll() {
        return repository.findAll();
    }

    public Optional<Employee> searchId(int id) {
        return repository.findById(id);
    }

    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    public Employee update(int id, Employee updatedData) {

        Employee employee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setName(updatedData.getName());
        employee.setWage(updatedData.getWage());
        employee.setCpf(updatedData.getCpf());
        employee.setNumberPhone(updatedData.getNumberPhone());
        employee.setEmail(updatedData.getEmail());

        return repository.save(employee);
    }

    public void delete(int id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Employee not found");
        }

        repository.deleteById(id);
    }
}

