package com.test.mongo_atlas.service;

import com.test.mongo_atlas.document.Task;
import com.test.mongo_atlas.exceptions.MongoException;
import com.test.mongo_atlas.repository.TaskRepository;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Task addTask(Task task){
        task.setNewId(task.getId().toString());
        return taskRepository.save(task);
    }
    @Override
    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    @Override
    public Task getTask(Long taskId) {
        return null;
    }

    @Override
    public Task getTask(BigInteger taskId) {
        return  taskRepository.findById(taskId).get();
    }


    @Override
    public Task getTask(String taskId){
        log.info("[id] {}",taskId);
        return  null;
    }
    @Override
    public List<Task> getTaskBySeverity(int severity){
        return taskRepository.findBySeverity(severity);
    }

    @Override
    public Task getTaskByNewId(String newId){
        return taskRepository.findByNewId(newId);
    }
    @Override
    public Task updateTask(Task taskRequest){
        Task dbTask = taskRepository.findByNewId(taskRequest.getNewId());
        dbTask.setDescription(taskRequest.getDescription());
        dbTask.setAssignee(taskRequest.getAssignee());
        dbTask.setStoryPoint(taskRequest.getStoryPoint());
        dbTask.setSeverity(taskRequest.getSeverity());
        return taskRepository.save(dbTask);
    }
    @Override
    public String deleteTask(String taskId){
        taskRepository.deleteByNewId(taskId);
        return "Task deleted : "+taskId;
    }

    @Override
    public Task getTaskByAnyField(String id) {
        Optional<Task> result = taskRepository.findInDocument(id);
        if(!result.isPresent()){
            throw new MongoException("Value not present");
        }
        return result.get();
    }
    @Override
    public Task addTaskThroughTemplate(Task task){
        task.setNewId(task.getId().toString());
        return mongoTemplate.insert(task,"tasks");
    }

    @Override
    public Task getTaskByIdTemplate(BigInteger id){
        return mongoTemplate.findById(id,Task.class);
    }
}