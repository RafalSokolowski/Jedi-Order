package pl.rav.jediorder.warrior.repository;

import org.springframework.data.repository.CrudRepository;
import pl.rav.jediorder.warrior.Warrior;

public interface WarriorRepo extends CrudRepository<Warrior, String> {

//    Iterable<Warrior> findAll();
//    Warrior findById(String name);
//    Warrior save(Warrior warrior);

}
