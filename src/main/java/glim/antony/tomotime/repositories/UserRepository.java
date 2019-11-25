package glim.antony.tomotime.repositories;

import glim.antony.tomotime.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findOneByEmail(String email);
    boolean existsByEmail(String email);
}
