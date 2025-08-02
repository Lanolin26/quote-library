package ru.lanolin.quote.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.lanolin.common.exception.DuplicateEntityException;
import ru.lanolin.common.exception.EntityNotFoundException;
import ru.lanolin.common.service.CommonService;
import ru.lanolin.domain.sourcetype.entity.SourceType;
import ru.lanolin.quote.repo.SourceTypeRepository;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SourceTypeService implements CommonService<UUID, SourceType> {

    private final SourceTypeRepository repository;

    @Override
    public Page<SourceType> getALl(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<SourceType> getOne(UUID uuid) {
        return repository.findById(uuid);
    }

    @Override
    public SourceType create(SourceType entity) {
        Objects.requireNonNull(entity, "Source Type must not be null");

        entity.setId(null);

        String sourceType = entity.getSourceType();
        if (repository.existsBySourceType(sourceType)) {
            throw new DuplicateEntityException("Source Type '{0}' already exists", sourceType);
        }

        return repository.save(entity);
    }

    @Override
    public SourceType update(UUID uuid, SourceType entity) {
        Objects.requireNonNull(uuid, "Source Type Id must not be null");
        Objects.requireNonNull(entity, "Source Type must not be null");

        if (!repository.existsById(uuid)) {
            throw new EntityNotFoundException("Source Type with id='{0}' does not exist", uuid);
        }

        entity.setId(uuid);

        String sourceType = entity.getSourceType();
        if (repository.existsBySourceType(sourceType)) {
            throw new DuplicateEntityException("Source Type '{0}' already exists", sourceType);
        }

        return repository.save(entity);
    }

    @Override
    public void delete(UUID uuid) {
        repository.deleteById(uuid);
    }
}
