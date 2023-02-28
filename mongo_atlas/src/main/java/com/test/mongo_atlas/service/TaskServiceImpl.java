package com.test.mongo_atlas.service;

import com.test.mongo_atlas.document.Task;
import com.test.mongo_atlas.repository.TaskRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task addTask(Task task){
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return taskRepository.save(task);
    }
    @Override
    public List<Task> getTasks(){
        return taskRepository.findAll();
    }
    @Override
    public Task getTask(String taskId){
        return  taskRepository.findById(taskId).get();
    }
    @Override
    public List<Task> getTaskBySeverity(int severity){
        return taskRepository.findBySeverity(severity);
    }
    @Override
    public Task updateTask(Task taskRequest){
        Task dbTask = taskRepository.findById(taskRequest.getTaskId()).get();
        dbTask.setDescription(taskRequest.getDescription());
        dbTask.setAssignee(taskRequest.getAssignee());
        dbTask.setStoryPoint(taskRequest.getStoryPoint());
        dbTask.setSeverity(taskRequest.getSeverity());
        return taskRepository.save(dbTask);
    }
    @Override
    public String deleteTask(String taskId){
        taskRepository.deleteById(taskId);
        return "Task deleted : "+taskId;
    }
}
