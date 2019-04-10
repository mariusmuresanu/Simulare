package Tests;

import Domain.Eveniment;
import Domain.EvenimentValidator;
import Domain.ValidatorException;
import Repository.IRepository;
import Repository.InMemoryRepository;

import static org.junit.jupiter.api.Assertions.*;

class EventRepositoryTest {

    @org.junit.jupiter.api.Test
    void findByIdWithExistingIdShouldReturnCorrectCake() throws ValidatorException {

        IRepository<Eveniment> repo = new InMemoryRepository<>(new EvenimentValidator());
        Eveniment added = new Eveniment("1", "test", "test","test" ,"test");
        repo.upsert(added);
        Eveniment found = repo.findById("1");
        assertNotNull(found, "Returned null for existing id!");
        assertEquals("1", found.getId(), String.format("Returned id %s instead of correct id=1!", found.getId()));
        assertEquals("test", found.getName(), String.format("Returned name=%s instead of %s", found.getName(), added.getName()));
        assertEquals("test", found.getDate(), String.format("Returned date=%s instead of %s", found.getDate(), added.getDate()));
        assertEquals("test", found.getDuration(), String.format("Returned duration=%s instead of %s", found.getDuration(), added.getDuration()));
        assertEquals("test", found.getStartingTime(), String.format("Returned starting Time=%s instead of %s", found.getStartingTime(), added.getStartingTime()));
        // ... so on
    }

    @org.junit.jupiter.api.Test
    void upsert() {
    }

    @org.junit.jupiter.api.Test
    void remove() {
    }

    @org.junit.jupiter.api.Test
    void getAll() {
    }
}