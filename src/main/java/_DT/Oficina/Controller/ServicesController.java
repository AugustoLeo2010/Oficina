package _DT.Oficina.Controller;

import _DT.Oficina.Entities.Services;
import _DT.Oficina.Service.ServicesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServicesController {

    private final ServicesService service;

    public ServicesController(ServicesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Services> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Services> searchId(@PathVariable int id) {
        return service.searchId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Services save(@RequestBody Services services) {
        return service.save(services);
    }

    @PutMapping("/{id}")
    public Services update(
            @PathVariable int id,
            @RequestBody Services Services) {

        return service.update(id, Services);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}
