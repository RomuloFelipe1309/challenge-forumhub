package domain.answer.validation.create;

import domain.answer.dto.CreateAnswerDTO;
import domain.topic.dto.CreateTopicDTO;
import jakarta.xml.bind.ValidationException;

public interface ValidCreatedAnswer {
    void validate(CreateTopicDTO date);

    void validate(CreateAnswerDTO date) throws ValidationException;
}
