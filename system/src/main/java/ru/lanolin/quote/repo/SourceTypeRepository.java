package ru.lanolin.quote.repo;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lanolin.quote.domain.sourcetype.entity.SourceType;

import java.util.UUID;

/**
 * Репозиторий для работы с сущностью {@link SourceType}. Предоставляет методы для выполнения операций CRUD и
 * дополнительных запросов.
 */
@Repository
public interface SourceTypeRepository extends JpaRepository<SourceType, UUID> {

    /**
     * Проверяет существование источника типа по его названию.
     *
     * @param sourceType название источника типа для проверки
     *
     * @return true, если источник типа с таким названием существует, иначе false
     */
    boolean existsBySourceType(String sourceType);

    /**
     * Проверяет существование источника типа по его идентификатору.
     *
     * @param id идентификатор источника типа для проверки
     *
     * @return true, если источник типа с таким идентификатором существует, иначе false
     */
    boolean existsById(@NotNull UUID id);

}
