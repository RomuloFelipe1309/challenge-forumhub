package domain.user.repository;

import jakarta.validation.constraints.NotNull;

public interface UserRepository {
    Object existsById(@NotNull Long aLong);
}
