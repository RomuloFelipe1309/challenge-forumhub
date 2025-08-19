package domain.topic.repository;

import domain.topic.State;
import domain.topic.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    Page<Topic> findAll(Pageable pageable);

    Page<Topic> findAllByStateIsNot(State state, Pageable pageable);

    Boolean exitisByTitle(String title, String message);

    Topic findByTitle(String title);
}
