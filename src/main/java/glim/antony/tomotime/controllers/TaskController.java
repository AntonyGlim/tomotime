package glim.antony.tomotime.controllers;

import glim.antony.tomotime.entities.Task;
import glim.antony.tomotime.services.TaskService;
import glim.antony.tomotime.utils.TaskFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public String showTasksList(
            Model model,
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(name = "pageSize", required = false) Integer pageSize,
            @CookieValue(name = "pageSizeInCookie", required = false) Integer pageSizeInCookie,
            @RequestParam(name = "pageNumber", required = false) Integer pageNumber
    ){
        if (pageSizeInCookie == null) pageSizeInCookie = pageSize == null ? 5 : pageSize;
        if (pageSize != null) pageSizeInCookie = pageSize;
        response.addCookie(new Cookie("pageSizeInCookie", String.valueOf(pageSizeInCookie)));

        if (pageNumber == null || pageNumber < 1) pageNumber = 1;
        TaskFilter taskFilter = new TaskFilter(request);
        Page<Task> page = taskService.findAllByPagingAndFiltering(
                taskFilter.getSpecification(),
                PageRequest.of(pageNumber - 1, pageSizeInCookie, Sort.Direction.ASC, "id")
        );
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("page", page);
        return "tasks";
    }

    @GetMapping("/{id}")
    public String showTask(
            Model model,
            @PathVariable(name = "id") Long id
    ){
        Task task = taskService.findById(id);
        model.addAttribute("task", task);
        return "task";
    }
}
