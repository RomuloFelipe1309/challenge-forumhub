package domain.user.dto;

import domain.course.Category;

public record CreatorUserDTO(
        String username,
        Boolean enabled,
        String name,
        String surname,
        String email
) {

}
