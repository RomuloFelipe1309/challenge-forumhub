package domain.course.dto;

import domain.course.Category;

public record UpdateCourseDTO(
        String name,
        Category category,
        Boolean actvive) {

    public Boolean active() {
    return actvive;}
}
