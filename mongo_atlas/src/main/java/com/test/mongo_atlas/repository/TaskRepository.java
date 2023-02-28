package com.test.mongo_atlas.repository;

import com.test.mongo_atlas.document.Task;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task,String> {

    List<Task> findBySeverity(int severity);
}
