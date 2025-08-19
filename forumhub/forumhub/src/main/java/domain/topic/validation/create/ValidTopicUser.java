package domain.topic.validation.create;

import domain.course.repository.CourseRepository;
import domain.topic.dto.CreateTopicDTO;
import domain.user.repository.UserRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidTopicUser implements ValidCreatedTopic {
    @Autowired
    private UserRepository repository;

    @Override
    public void validate(CreateTopicDTO data) {
        var UserExists = repository.existsById(data.userId());
        if (!UserExists) {
            throw new ValidationException("This user no exits");
        }

        var enableUser = repository.findById(data.userId());
        if (!enableUser) {
            throw new ValidationException("This user is no enable");
        }

    }
}