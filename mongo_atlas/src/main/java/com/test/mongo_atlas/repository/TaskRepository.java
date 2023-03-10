package com.test.mongo_atlas.repository;

import com.test.mongo_atlas.document.Task;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskRepository extends MongoRepository<Task, BigInteger> {

    List<Task> findBySeverity(int severity);

    Task findByNewId(String newId);

    void deleteByNewId(String taskId);

    @Query(value = "{}", fields = "{_id:1}")
    List<Task> getAllIds();

    //    @Query(value = "{'_id': :#{#id}, 'newId': :#{#id} }")
    @Query(value = "{'$or':[ {'_id': :#{#id}}, {'newId': :#{#id}} ] }")
    Optional<Task> findInDocument(@Param("id") String id);
}
