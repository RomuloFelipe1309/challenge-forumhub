package domain.topic.validation.create;

import domain.topic.dto.CreateTopicDTO;
import org.springframework.stereotype.Component;

@Component
public interface ValidCreatedTopic {
    void validate(CreateTopicDTO data);
}
