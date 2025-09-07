package ru.lanolin.quote.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.lanolin.common.exception.EntityNotFoundException;
import ru.lanolin.common.service.CommonService;
import ru.lanolin.quote.domain.quote.entity.Quote;
import ru.lanolin.quote.domain.user.entity.User;
import ru.lanolin.quote.repo.QuoteRepository;
import ru.lanolin.quote.utils.HelperUtils;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class QuoteService implements CommonService<UUID, Quote> {

    private final QuoteRepository repository;

    private final SourceService sourceService;
    private final SourceTypeService sourceTypeService;
    private final UserService userService;

    @Override
    public Page<Quote> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Quote> getOne(UUID uuid) {
        return repository.findById(uuid);
    }

    @Override
    public Quote create(Quote entity) {
        Objects.requireNonNull(entity, "source entity must not be null");
        entity.setId(null);

        // check

        return repository.save(entity);
    }

    @Override
    public Quote update(UUID uuid, Quote entity) {
        Objects.requireNonNull(uuid, "Source Type Id must not be null");
        Objects.requireNonNull(entity, "Source Type must not be null");

        if (repository.existsById(uuid)) {
            throw new EntityNotFoundException("Quote with id='{0}' does not exist", uuid);
        }

        entity.setId(uuid);

        //check

        return repository.save(entity);
    }

    @Override
    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }
}
