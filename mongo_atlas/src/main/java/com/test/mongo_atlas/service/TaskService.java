package com.test.mongo_atlas.service;

import com.test.mongo_atlas.document.Task;
import java.math.BigInteger;
import java.util.List;
import org.springframework.stereotype.Service;

public interface TaskService {

    Task addTask(Task task);

    List<Task> getTasks();

    Task getTask(Long taskId);

    Task getTask(BigInteger taskId);

    Task getTask(String taskId);

    List<Task> getTaskBySeverity(int severity);

    Task getTaskByNewId(String newId);

    Task updateTask(Task taskRequest);

    String deleteTask(String taskId);

    Task getTaskByAnyField(String id);
}
