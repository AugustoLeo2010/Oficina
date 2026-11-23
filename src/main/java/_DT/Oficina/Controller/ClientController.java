package _DT.Oficina.Controller;

import _DT.Oficina.Entities.Client;
import _DT.Oficina.Service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public List<Client> listAll() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> searchId(@PathVariable int id) {
        return service.searchId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Client save(@RequestBody Client client) {
        return service.save(client);
    }

    @PutMapping("/{id}")
    public Client update(
            @PathVariable int id,
            @RequestBody Client client) {

        return service.update(id, client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

}