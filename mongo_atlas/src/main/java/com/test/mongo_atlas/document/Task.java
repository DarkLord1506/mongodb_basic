package com.test.mongo_atlas.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {


    private Long id;
    private String description;
    private int severity;
    private String assignee;
    private int storyPoint;
    @Id
    private String newId;

}
