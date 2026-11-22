package _DT.Oficina.Controller;

import _DT.Oficina.Repository.ClientRepository;
import _DT.Oficina.Entities.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Clients")
public class ClientController {
    private final ClientRepository repository;

    public ClientController(ClientRepository repository) {
       this.repository = repository;
    }

    @GetMapping
    public List<Client> List() { return repository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Client> searchId(
            @PathVariable Long id) {

        return repository.searchId(id);
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@Valid @RequestBody Client client) {
        Client save = repository.save(client);

        return ResponseEntity
                .status(httpsStatus.CREATED);
                .body(save);
    }

    
}
