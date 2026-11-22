
package _DT.Oficina.Service;

import _DT.Oficina.Entities.Services;
import _DT.Oficina.Repository.ServicesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceService {

    private final ServicesRepository repository;

    public ServiceService(ServicesRepository repository) {
        this.repository = repository;
    }

    public List<Services> listAll() {
        return repository.findAll();
    }

    public Optional<Services> searchId(int id) {
        return repository.findById(id);
    }

    public Services save(Services Service) {
        return repository.save(Service);
    }

    public Services update(int id, Services updatedData) {

        Services service = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        service.setName(updatedData.getName());
        service.setType(updatedData.getType());
        service.setValue(updatedData.getValue());
        service.setDescription(updatedData.getDescription());

        return repository.save(service);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}

