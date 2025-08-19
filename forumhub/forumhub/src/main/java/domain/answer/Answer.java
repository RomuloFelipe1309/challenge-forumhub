package domain.answer;

import domain.answer.dto.CreateAnswerDTO;
import domain.answer.dto.UpdateAnswerDTO;
import domain.topic.Topic;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "answers")
@Entity(name = "Answer")
@EqualsAndHashCode(of = "id")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    private Boolean solution;
    private Boolean erased;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    public Answer(CreateAnswerDTO createAnswerDTO, User user, Topic topic) {
        this.message = createAnswerDTO.message();
        this.creationDate = LocalDateTime.now();
        this.lastUpdate = LocalDateTime.now();
        this.solution = false;
        this.erased = false;
        this.user = user;
        this.topic = topic;
    }

    public Answer(@Valid CreateAnswerDTO createAnswerDTO) {
    }

    public void updateAnswer(UpdateAnswerDTO updateAnswerDTO) {
        if (updateAnswerDTO.message()!= null) {
            this.message = updateAnswerDTO.message();
        }
        if (updateAnswerDTO.solution() != null) {
            this.solution = updateAnswerDTO.solution();
        }
        this.lastUpdate = LocalDateTime.now();
    }

    public void deleteAnswer() {this.erased = true;}


}
