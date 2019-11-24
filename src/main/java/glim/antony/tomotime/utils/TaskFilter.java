package glim.antony.tomotime.utils;

import glim.antony.tomotime.entities.Task;
import glim.antony.tomotime.repositories.specifications.TaskSpecification;
import org.springframework.data.jpa.domain.Specification;

import javax.servlet.http.HttpServletRequest;

public class TaskFilter {

    private Specification<Task> specification;
    private StringBuilder filtersString;

    public Specification<Task> getSpecification() {
        return specification;
    }

    public StringBuilder getFiltersString() {
        return filtersString;
    }

    public TaskFilter(HttpServletRequest request) {
        specification = Specification.where(null);
        filtersString = new StringBuilder();

        if (request.getParameter("word") != null && !request.getParameter("word").isEmpty()) {
            specification = specification.and(TaskSpecification.titleContains(request.getParameter("word")));
            filtersString.append("&word=" + request.getParameter("word"));
        }
    }
}
