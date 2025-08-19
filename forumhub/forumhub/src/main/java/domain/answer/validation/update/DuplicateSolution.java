package domain.answer.validation.update;

import domain.answer.Answer;
import domain.answer.dto.UpdateAnswerDTO;
import domain.answer.repository.AnswerRepository;
import domain.topic.repository.TopicRepository;
import domain.answer.validation.ValidUpdateAnswer;
import jakarta.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.plaf.nimbus.State;

@Component
public class DuplicateSolution implements ValidUpdateAnswer {

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void validate(UpdateAnswerDTO data, Long answerId) {
        if (data.solution()) {
            Answer answer = answerRepository.getReferenceById(answerId);
            var resoluteTopic = TopicRepository.getRefernceById(answer.getTopic().getId());
            if (resoluteTopic.getState() == State.CLOSED){
                throw new ValidationException("This topic is already solved");

            }
        }
    }
}
