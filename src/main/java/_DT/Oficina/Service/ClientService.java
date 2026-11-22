
package _DT.Oficina.Service;

import _DT.Oficina.Entities.Client;
import _DT.Oficina.Repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<Client> listAll() {
        return repository.findAll();
    }

    public Optional<Client> searchId(int id) {
        return repository.findById(id);
    }

    public Client save(Client client) {
        return repository.save(client);
    }

    public Client update(int id, Client updatedData) {

        Client client = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        client.setName(updatedData.getName());
        client.setCpf(updatedData.getCpf());
        client.setNumberPhone(updatedData.getNumberPhone());
        client.setEmail(updatedData.getEmail());

        return repository.save(client);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}

