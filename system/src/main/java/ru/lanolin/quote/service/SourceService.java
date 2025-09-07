package ru.lanolin.quote.service;

import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.lanolin.common.exception.DuplicateEntityException;
import ru.lanolin.common.exception.EntityNotFoundException;
import ru.lanolin.common.service.CommonService;
import ru.lanolin.quote.domain.source.entity.Source;
import ru.lanolin.quote.repo.SourceRepository;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SourceService implements CommonService<UUID, Source> {

    private final SourceRepository repository;
    private final SourceTypeService sourceTypeService;

    @Override
    public Optional<Source> getOne(UUID uuid) {
        return repository.findById(uuid);
    }

    @Override
    public Page<Source> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Source create(Source entity) {
        Objects.requireNonNull(entity, "source entity must not be null");
        entity.setId(null);

        if (sourceTypeService.existById(entity.getSourceType().getId())) {
            throw new EntityNotFoundException("source type id=" + entity.getSourceType().getId() + " not found");
        }

        if (repository.existsBySourceNameAndSourceTypeId(entity.getSourceName(), entity.getSourceType().getId())) {
            throw new DuplicateEntityException("Source have duplicate");
        }

        return repository.save(entity);
    }

    @Override
    public @NonNull Source update(@NonNull UUID uuid, @NonNull Source entity) {
        Objects.requireNonNull(uuid, "Source Type Id must not be null");
        Objects.requireNonNull(entity, "Source Type must not be null");

        if (!repository.existsById(uuid)) {
            throw new EntityNotFoundException("Source with id='{0}' does not exist", uuid);
        }

        entity.setId(uuid);

        if (repository.existsBySourceNameAndSourceTypeId(entity.getSourceName(), entity.getSourceType().getId())) {
            throw new DuplicateEntityException("Source have duplicate");
        }

        return repository.save(entity);
    }

    @Override
    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }
}
