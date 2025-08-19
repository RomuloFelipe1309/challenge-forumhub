package domain.course.dto;

import domain.course.Category;
import domain.course.Course;

public record DetailCourseDTO(
        Long id,
        String name,
        Category category,
        Boolean active) {

    public DetailCourseDTO(Course course){
        this(
                course.getId(),
                course.getName(),
                course.getCategory(),
                course.getActive());
    }


    public DetailCourseDTO(@org.jetbrains.annotations.NotNull Object o) {
    }
}
