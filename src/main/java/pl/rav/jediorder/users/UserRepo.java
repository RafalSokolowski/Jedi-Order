package pl.rav.jediorder.users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.rav.jediorder.users.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    User findByUsername(String username);

//    User findById(long id);

}
