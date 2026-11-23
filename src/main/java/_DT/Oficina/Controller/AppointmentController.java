package _DT.Oficina.Controller;

import _DT.Oficina.Entities.Appointment;
import _DT.Oficina.Service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Appointment> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> searchId(@PathVariable int id) {
        return service.searchId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Appointment save(@RequestBody Appointment appointment) {
        return service.save(appointment);
    }

    @PutMapping("/{id}")
    public Appointment update(
            @PathVariable int id,
            @RequestBody Appointment Appointment) {

        return service.update(id, Appointment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}