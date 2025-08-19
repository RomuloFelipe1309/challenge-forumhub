package domain.topic.dto;

import domain.course.Category;
import domain.topic.State;
import domain.topic.Topic;

import java.time.LocalDateTime;

public record DetailTopicDTO(
        Long id,
        String title,
        String message,
        LocalDateTime creationdate,
        LocalDateTime lastupdate,
        State state,
        String user,
        String course,
        Category categoryCourse
) {
    public DetailTopicDTO(Topic topic){
        this(topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCretionDate(),
                topic.getLastUpdate(),
                topic.getState(),
                topic.getUser().getUsername(),
                topic.getCourse().getName(),
                topic.getCourse().getCategory()
        );
    }
}
