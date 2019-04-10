package Repository;

import Domain.Entity;
import Domain.ValidatorException;

import java.util.List;

public interface IRepository<T extends Entity> {

    T findById(String id);
    void upsert(T eveniment) throws ValidatorException;

    void remove(String id);
    List<T> getAll();
}
