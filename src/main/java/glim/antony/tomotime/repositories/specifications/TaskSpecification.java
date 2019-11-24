package glim.antony.tomotime.repositories.specifications;

import glim.antony.tomotime.entities.Task;
import org.springframework.data.jpa.domain.Specification;

public class TaskSpecification {
    public static Specification<Task> titleContains(String word) {
        return (Specification<Task>) (root, criteriaQuery, criteriaBuilder)
                -> criteriaBuilder.like(root.get("title"), "%" + word + "%");
    }
}
