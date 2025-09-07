package ru.lanolin.quote.service;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.lanolin.common.exception.EntityNotFoundException;
import ru.lanolin.common.service.CommonService;
import ru.lanolin.quote.domain.user.entity.User;
import ru.lanolin.quote.repo.UserRepository;
import ru.lanolin.quote.utils.HelperUtils;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService implements CommonService<UUID, User> {

    private final UserRepository repository;

    @Override
    public @NonNull Optional<User> getOne(@NonNull UUID id) {
        return repository.findById(id);
    }

    @Override
    public @NonNull Page<User> getAll(@NonNull Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public @NonNull User create(@NonNull User entity) {
        Objects.requireNonNull(entity, "Entity User not be a null");

        entity.setId(null);

        // check to equals

        return repository.save(entity);
    }

    @Override
    public @NonNull User update(@NonNull UUID uuid, @NonNull User entity) {
        Objects.requireNonNull(uuid, "Entity User not be a null");
        Objects.requireNonNull(entity, "Entity User not be a null");

        if (repository.existsById(uuid)) {
            throw new EntityNotFoundException("User with id='{0}' does not exist", uuid);
        }

        entity.setId(uuid);

        //check

        return repository.save(entity);
    }

    @Override
    public void delete(@NonNull UUID id) {
        repository.deleteById(id);
    }

}
