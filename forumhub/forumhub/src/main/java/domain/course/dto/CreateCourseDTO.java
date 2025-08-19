package domain.course.dto;

import domain.course.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCourseDTO(
        @NotBlank String name,
        @NotNull Category category) {
}
