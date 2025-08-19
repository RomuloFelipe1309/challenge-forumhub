package domain.answer.validation.create;

import domain.answer.dto.CreateAnswerDTO;
import domain.user.repository.UserRepository;
import jakarta.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.plaf.nimbus.State;

@Component
public class ValidUserAnswer implements ValidCreatedAnswer {
    @Autowired
    private UserRepository repository;
    @Override
    public void validate(CreateAnswerDTO date)  {
        var userExists = repository.existsById(date.user);

        if (!userExists) {
            throw new ValidationException("This user no exists.");
        }

        var userOpen = repository.findById(date.user);

        if (userOpen != State.OPEN) {
            throw new ValidationException("This user is not open for replies.");
        }
    }

}
