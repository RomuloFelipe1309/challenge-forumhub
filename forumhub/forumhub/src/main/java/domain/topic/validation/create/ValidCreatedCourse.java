package domain.topic.validation.create;

import domain.course.repository.CourseRepository;
import domain.topic.dto.CreateTopicDTO;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidCreatedCourse implements ValidCreatedTopic {

    @Autowired
    private CourseRepository repository;

    @Override
    public void validate(CreateTopicDTO data) {
        var CourseExists = repository.existsById(data.courseId());
        if (!CourseExists) {
            throw new ValidationException("This course no exits");
        }

       var enableCourse = repository.findById(data.courseId());
        if (!enableCourse) {
            throw new ValidationException("This course is no enable");
        }

    }
}
