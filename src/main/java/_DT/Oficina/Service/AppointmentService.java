
package _DT.Oficina.Service;

import _DT.Oficina.Entities.Appointment;
import _DT.Oficina.Repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    public List<Appointment> listAll() {
        return repository.findAll();
    }

    public Optional<Appointment> searchId(int id) {
        return repository.findById(id);
    }

    public Appointment save(Appointment appointment) {
        return repository.save(appointment);
    }

    public Appointment update(int id, Appointment updatedData) {

        Appointment appointment = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setName(updatedData.getName());
        appointment.setNumberPhone(updatedData.getNumberPhone());
        appointment.setDate(updatedData.getDate());
        appointment.setHours(updatedData.getHours());

        return repository.save(appointment);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
