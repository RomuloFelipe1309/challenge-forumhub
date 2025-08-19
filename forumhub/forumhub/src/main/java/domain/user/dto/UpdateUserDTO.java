package domain.user.dto;

import domain.course.Category;

public record UpdateUserDTO(
        String name,
        Category category

) {

    public Boolean active() {
        return active();
    }
}
