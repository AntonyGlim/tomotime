package glim.antony.tomotime.repositories;

import glim.antony.tomotime.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
