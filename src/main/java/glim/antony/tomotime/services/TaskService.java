package glim.antony.tomotime.services;

import glim.antony.tomotime.entities.Task;
import glim.antony.tomotime.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
