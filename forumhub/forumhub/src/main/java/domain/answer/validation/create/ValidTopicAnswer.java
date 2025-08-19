package domain.answer.validation.create;

import domain.answer.dto.CreateAnswerDTO;
import domain.topic.repository.TopicRepository;
import jakarta.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ValidTopicAnswer implements ValidCreatedAnswer {

    @Autowired
    public TopicRepository repository;

    @Override
    public void validate(CreateAnswerDTO date) throws ValidationException {
        var topicExists = repository.existsById(date.topic);

        if (!(boolean) topicExists) {
            throw new ValidationException("This topic no exist.");
        }

        var topicOpen = repository.findById(date.topic);

        if (topicOpen != domain.topic.State.OPEN) {
            throw new ValidationException("This topic is not open for replies.");
        }
    }


}
