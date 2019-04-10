package Service;

import Domain.Eveniment;
import Domain.ValidatorException;
import Repository.IRepository;

import java.util.List;

public class EvenimentService {

    private IRepository<Eveniment> repository;

    public EvenimentService(IRepository<Eveniment> repository) {
        this.repository = repository;
    }

    public void addOrUpdate(String id, String name, String date, String duration, String startingTime) throws ValidatorException {
        Eveniment existing = repository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (name.isEmpty()) {
                name = existing.getName();
            }
            if (date.isEmpty()) {
                date = existing.getDate();
            }
            if (duration == String.valueOf(0)) {
                duration = existing.getDuration();
            }
            if (startingTime == String.valueOf(0)) {
                startingTime = existing.getStartingTime();
            }
        }
        Eveniment eveniment = new Eveniment(id, name, date, duration, startingTime);
        repository.upsert(eveniment);
    }

    public void remove(String id) {
        repository.remove(id);
    }

    public List<Eveniment> getAll() {
        return repository.getAll();
    }
}
