package _DT.Oficina.Controller;

import _DT.Oficina.Entities.Vehicle;
import _DT.Oficina.Service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Vehicle> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> searchId(@PathVariable int id) {
        return service.searchId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Vehicle save(@RequestBody Vehicle vehicle) {
        return service.save(vehicle);
    }

    @PutMapping("/{id}")
    public Vehicle update(
            @PathVariable int id,
            @RequestBody Vehicle Vehicle) {

        return service.update(id, Vehicle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}
