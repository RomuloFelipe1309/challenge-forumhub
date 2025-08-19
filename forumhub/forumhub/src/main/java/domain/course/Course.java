package domain.course;


import domain.course.dto.CreateCourseDTO;
import domain.course.dto.UpdateCourseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
@Entity(name = "Course")
@EqualsAndHashCode(of = "id")
public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean active;

    @Enumerated(EnumType.STRING)
    private Category category;


    @Enumerated(EnumType.STRING)
    private String name;


    public Course(CreateCourseDTO createCourseDTO) {
        this.name = createCourseDTO.name().toString();
        this.category = createCourseDTO.category();
        this.active = true;
    }

    public void updateCourse(UpdateCourseDTO updateCourseDTO) {
        if (updateCourseDTO.name() != null) {
            this.name = updateCourseDTO.name();
        }
        if (updateCourseDTO.category() != null) {
            this.category = updateCourseDTO.category();
        }
        if (updateCourseDTO.active() != null) {
            this.active = updateCourseDTO.active();
        }
    }

    public void deleteCourse() {
        this.active = false;
        {

        }
    }
}
