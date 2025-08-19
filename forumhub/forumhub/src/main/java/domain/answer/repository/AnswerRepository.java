package domain.answer.repository;

import domain.answer.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnswerRepository  extends JpaRepository<Answer, Long> {
    Page<Answer> findAllByTopicId(Long topicId, Pageable pageable);

    Page<Answer> findAllByUserId(Long userId, Pageable pageable);

    Answer getReferenceByTopicId(Long id);

    Answer getReferenceById(Long id);

    Optional<Object> findAllByActiveTrue(Pageable pageable);
}
