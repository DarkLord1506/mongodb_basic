package com.test.mongo_atlas.controller;

import com.test.mongo_atlas.document.Task;
import com.test.mongo_atlas.service.TaskService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        return new ResponseEntity<>(taskService.addTask(task), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        return new ResponseEntity<>(taskService.getTasks(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") String taskId){
        return new ResponseEntity<>(taskService.getTask(taskId),HttpStatus.OK);
    }

    @GetMapping("/severity/{severity}")
    public ResponseEntity<List<Task>> getTaskBySeverity(@PathVariable("severity") int severity){
        return new ResponseEntity<>(taskService.getTaskBySeverity(severity),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Task> updateTask(@RequestBody Task task){
        return new ResponseEntity<>(taskService.updateTask(task),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") String taskId){
        return new ResponseEntity<>(taskService.deleteTask(taskId),HttpStatus.OK);
    }
}
