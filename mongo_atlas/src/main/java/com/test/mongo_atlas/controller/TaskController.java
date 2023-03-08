package com.test.mongo_atlas.controller;

import com.test.mongo_atlas.document.Task;
import com.test.mongo_atlas.service.TaskService;
import java.math.BigInteger;
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
    @GetMapping("/any/{id}")
    public ResponseEntity<Task> getTaskThroughAnyField(@PathVariable("id") String id){
        return new ResponseEntity<>(taskService.getTaskByAnyField(id),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable("id") BigInteger taskId){
        return new ResponseEntity<>(taskService.getTask(taskId),HttpStatus.OK);
    }

    @GetMapping("/severity/{severity}")
    public ResponseEntity<List<Task>> getTaskBySeverity(@PathVariable("severity") int severity){
        return new ResponseEntity<>(taskService.getTaskBySeverity(severity),HttpStatus.OK);
    }

    @GetMapping("/newId/{newId}")
    public ResponseEntity<Task> getTaskByNewId(@PathVariable("newId") String newId){
        return new ResponseEntity<>(taskService.getTaskByNewId(newId),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Task> updateTask(@RequestBody Task task){
        return new ResponseEntity<>(taskService.updateTask(task),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") String taskId){
        return new ResponseEntity<>(taskService.deleteTask(taskId),HttpStatus.OK);
    }

    @PostMapping("/template")
    public ResponseEntity<Task> addTaskByTemplate(@RequestBody Task task){
        return new ResponseEntity<>(taskService.addTaskThroughTemplate(task),HttpStatus.OK);
    }

    @GetMapping("/template/{id}")
    public ResponseEntity<Task> getTaskByTemplate(@PathVariable("id") BigInteger id){
        return new ResponseEntity<>(taskService.getTaskByIdTemplate(id),HttpStatus.OK);
    }
}
