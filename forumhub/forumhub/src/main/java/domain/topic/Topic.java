package domain.topic;

import domain.course.Course;
import domain.topic.dto.CreateTopicDTO;
import domain.topic.dto.UpdateTopicDTO;
import domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "topics")
@Entity(name = "Topic")
@EqualsAndHashCode(of = "id")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;

    @Column(name = "creation_date")
    private LocalDateTime cretionDate;

    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

    @Enumerated(EnumType.STRING)
    private State state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    public Topic(CreateTopicDTO createTopicDTO, User user, Course course){
        this.title = createTopicDTO.title();
        this.message = createTopicDTO.message();
        this.cretionDate = LocalDateTime.now();
        this.lastUpdate = LocalDateTime.now();
        this.state = State.OPEN;
        this.user = user;
        this.course = course;
    }
    public void updateTopic(UpdateTopicDTO updateTopicDTO) {
        if (updateTopicDTO.title() != null) {
            this.title = updateTopicDTO.title();
        }
        if (updateTopicDTO.message() != null) {
            this.message = updateTopicDTO.message();
        }
        if (updateTopicDTO.state() != null) {
            this.state =updateTopicDTO.state();
        }
        if (updateTopicDTO.courseId() != null){
            this.course = course;
        }
        this.lastUpdate = LocalDateTime.now();
    }
    public void deleteTopic() {this.state = State.DELETED;}

    public void setState(State state) {
        this.state = state;
    }
}
