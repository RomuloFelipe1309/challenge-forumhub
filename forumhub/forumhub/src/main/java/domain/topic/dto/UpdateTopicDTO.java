package domain.topic.dto;

import domain.topic.State;

public record UpdateTopicDTO(
        String title,
        String message,
        State state,
        Long courseId
) {

}
