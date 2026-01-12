package com.app.todolife.controller;

import com.app.todolife.models.Task;
import com.app.todolife.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public String getTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping
    public String createTasks(@RequestParam String title) {
        System.out.println("TITLE >>>> "+title);
        taskService.createTask(title);
        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @PostMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/";
    }
}
