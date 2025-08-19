package domain.topic.validation.update;

import domain.answer.dto.CreateAnswerDTO;
import domain.answer.validation.create.ValidCreatedAnswer;
import domain.topic.dto.CreateTopicDTO;
import domain.topic.repository.TopicRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DuplicateTopic implements ValidCreatedAnswer {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void validate(CreateTopicDTO date){
        var duplicateTopic = topicRepository.exitisByTitle(date.title(),date.message());
        if (duplicateTopic){
            throw new ValidationException("This topic already exits");
        }
    }

    @Override
    public void validate(CreateAnswerDTO date) throws jakarta.xml.bind.ValidationException {

    }
}
