package ru.lanolin.quote.service;

import org.jspecify.annotations.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.lanolin.common.exception.DuplicateEntityException;
import ru.lanolin.common.exception.EntityNotFoundException;
import ru.lanolin.common.service.CommonService;
import ru.lanolin.quote.domain.sourcetype.entity.SourceType;
import ru.lanolin.quote.repo.SourceTypeRepository;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SourceTypeService implements CommonService<UUID, SourceType> {

    private final SourceTypeRepository repository;

    /**
     * Получает страницу всех типов источников с пагинацией.
     *
     * @param pageable параметры страницы
     *
     * @return страница с типами источников
     */
    @Override
    public Page<SourceType> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Получает {@link SourceType} по его идентификатору.
     *
     * @param uuid идентификатор типа источника
     *
     * @return Optional с типом источника, если найден
     */
    @Override
    public Optional<SourceType> getOne(UUID uuid) {
        return repository.findById(uuid);
    }

    /**
     * Проверяет существование {@link SourceType} по его типу.
     *
     * @param type строковое представление типа источника
     *
     * @return true, если тип источника существует, иначе false
     */
    public boolean existByType(String type) {
        return repository.existsBySourceType(type);
    }

    /**
     * Проверяет существование {@link SourceType} по его идентификатору.
     *
     * @param id идентификатор типа источника
     *
     * @return true, если тип источника существует, иначе false
     */
    public boolean existById(UUID id) {
        return repository.existsById(id);
    }

    /**
     * Создаёт новый {@link SourceType}.
     *
     * @param entity тип источника для создания
     *
     * @return созданный тип источника
     *
     * @throws DuplicateEntityException если тип источника с таким же {@link SourceType#getSourceType()} уже существует
     */
    @Override
    public @NonNull SourceType create(@NonNull SourceType entity) {
        Objects.requireNonNull(entity, "Source Type must not be null");

        entity.setId(null);

        String sourceType = entity.getSourceType();
        if (repository.existsBySourceType(sourceType)) {
            throw new DuplicateEntityException("Source Type '{0}' already exists", sourceType);
        }

        return repository.save(entity);
    }

    /**
     * Обновляет {@link SourceType} по его идентификатору.
     *
     * @param uuid   идентификатор типа источника для обновления
     * @param entity тип источника с обновлёнными данными
     *
     * @return обновлённый тип источника
     *
     * @throws EntityNotFoundException  если тип источника с указанным идентификатором не существует
     * @throws DuplicateEntityException если тип источника с таким же {@link SourceType#getSourceType()} уже существует
     */
    @Override
    public @NonNull SourceType update(@NonNull UUID uuid, @NonNull SourceType entity) {
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

    /**
     * Удаляет источник по его идентификатору.
     *
     * @param uuid идентификатор источника, который необходимо удалить
     */
    @Override
    public void delete(@NonNull UUID uuid) {
        repository.deleteById(uuid);
    }

}
