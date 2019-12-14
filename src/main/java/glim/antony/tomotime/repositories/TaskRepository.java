package glim.antony.tomotime.repositories;

import glim.antony.tomotime.entities.Task;
import glim.antony.tomotime.entities.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends
        PagingAndSortingRepository<Task, Long>,
        JpaSpecificationExecutor<Task> {

    List<Task> findAllByUser(User user);

    List<Task> findAllByUserAndStatus(User user, Task.Status status);

}
