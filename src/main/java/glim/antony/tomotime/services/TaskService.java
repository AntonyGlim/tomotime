package glim.antony.tomotime.services;

import glim.antony.tomotime.entities.Task;
import glim.antony.tomotime.entities.User;
import glim.antony.tomotime.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return (List<Task>) taskRepository.findAll();
    }

    public List<Task> findAllByUser(User user) {
        return (List<Task>) taskRepository.findAllByUser(user);
    }

    public Page<Task> findAllByPagingAndFiltering(Specification<Task> specification, Pageable pageable) {
        return taskRepository.findAll(specification, pageable);
    }

    public Task findById(Long id) {
        return taskRepository.findById(id).get();
    }

    public Task save(Task task){
        return taskRepository.save(task);
    }

}
