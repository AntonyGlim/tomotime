package glim.antony.tomotime.repositories.specifications;

import glim.antony.tomotime.entities.Task;
import org.springframework.data.jpa.domain.Specification;

public class TaskSpecification {
    public static Specification<Task> titleContains(String word) {
        return (Specification<Task>) (root, criteriaQuery, criteriaBuilder)
                -> criteriaBuilder.like(root.get("title"), "%" + word + "%");
    }

    public static Specification<Task> titleContainsIgnoreCase(String word) {
        return (root, query, cb) -> {
            String containsLikePattern = getContainsLikePattern(word);
            return cb.like(cb.lower(root.get("title")), containsLikePattern);
        };
    }

    private static String getContainsLikePattern(String word) {
        return (word == null || word.isEmpty()) ? "%" : "%" + word.toLowerCase() + "%";
    }
}
