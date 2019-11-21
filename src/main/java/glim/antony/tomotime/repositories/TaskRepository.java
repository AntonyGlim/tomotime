package glim.antony.tomotime.repositories;

import glim.antony.tomotime.entities.Task;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends
        PagingAndSortingRepository<Task, Long>,
        JpaSpecificationExecutor<Task> {
}
