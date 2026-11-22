
package _DT.Oficina.Service;

import _DT.Oficina.Entities.Vehicle;
import _DT.Oficina.Repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository repository;

    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }

    public List<Vehicle> listAll() {
        return repository.findAll();
    }

    public Optional<Vehicle> searchId(int id) {
        return repository.findById(id);
    }

    public Vehicle save(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    public Vehicle update(int id, Vehicle updatedData) {

        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        vehicle.setModel(updatedData.getModel());
        vehicle.setType(updatedData.getType());
        vehicle.setMark(updatedData.getMark());
        vehicle.setColor(updatedData.getColor());
        vehicle.setYear(updatedData.getYear());
        vehicle.setKmr(updatedData.getKmr());

        return repository.save(vehicle);
    }

    public void delete(int id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Vehicle not found");
        }

        repository.deleteById(id);
    }
}