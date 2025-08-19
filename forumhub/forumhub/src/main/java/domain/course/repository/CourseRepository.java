package domain.course.repository;

import domain.course.Course;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findAllActiveTrue(Pageable pageable);

    Optional<Object> findAllByActiveTrue(org.springframework.data.domain.Pageable pageable);
}
