package domain.answer.dto;

import domain.answer.Answer;

import java.time.LocalDateTime;

public record DetailAnswerDTO<message, creationDate, lastUpdate, solution, topicId, topic, username>(
        Long id;
        String message;
        LocalDateTime creationDate;
        LocalDateTime lastUpdate;
        Boolean solution,
        Boolean erased;
        Long topicId;
        String username;
        Long topicId;
        String topic;
) {

    public DetailAnswerDTO(Answer answer) {
        answer.getId(),
        answer.getMessage(),
        answer.getCreationDate(),
        answer.getLastUpdate(),
        answer.getSolution(),
        answer.getErased(),
        answer.getUser().getId(),
        answer.getUser().getUsername(),
        answer.getTopic().getId(),
        answer.getTopic().getTitle();
    }

}
