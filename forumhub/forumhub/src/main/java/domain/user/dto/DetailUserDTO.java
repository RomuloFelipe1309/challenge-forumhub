package domain.user.dto;

import domain.user.Role;
import domain.user.User;

public record DetailUserDTO(
        Long id,
        String username,
        Role role,
        String name,
        String surname,
        Boolean enabled
) {
    public DetailUserDTO (User user) {
        this(user.getId(),
                user.getUsername(),
                user.getRole(),
                user, user.getName(),
                user.getSurname(),
                user.getEmail(),
                user.getEnabled()
        );
    }
}
