package domain.answer.validation;

import domain.answer.dto.UpdateAnswerDTO;

public interface ValidUpdateAnswer {
    void validate(UpdateAnswerDTO date, Long answerId);
}
