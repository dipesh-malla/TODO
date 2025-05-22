package com.dipesh.todolist.controller;

import com.dipesh.todolist.models.Task;
import com.dipesh.todolist.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService todoService) {
        this.taskService = todoService;
    }


    @GetMapping("/get")
    public String getTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping
    public String createTask(String title) {
        taskService.createTask(title);
        return "redirect:/tasks/get";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks/get";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        taskService.toogleTask(id);
        return "redirect:/tasks/get";
    }

    // for postman restapi
    @PostMapping("/add")
    @ResponseBody
    public String addTask(@RequestBody Task task) {
      return  taskService.addTask(task);
    }

}


