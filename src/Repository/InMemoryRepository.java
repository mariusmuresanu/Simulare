package Repository;

import Domain.Entity;
import Domain.IValidator;
import Domain.ValidatorException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T extends Entity> implements IRepository<T> {
    private Map<String, T> storage = new HashMap<>();
    private IValidator<T> validator;

    public InMemoryRepository(IValidator<T> validator) {
        this.validator = validator;
    }

    public T findById(String id) {
        return storage.get(id);
    }

    public void upsert(T eveniment) throws ValidatorException {
        validator.validate(eveniment);
        storage.put(eveniment.getId(), eveniment);
    }

    public void remove(String id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no event with the given id to remove.");
        }

        storage.remove(id);
    }

    public List<T> getAll() {
        return new ArrayList<>(storage.values());
    }

}
