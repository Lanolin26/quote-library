package ru.lanolin.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.lanolin.common.domain.CommonEntity;

import java.io.Serializable;
import java.util.Optional;

/**
 * Интерфейс сервиса для выполнения операций поиска сущностей.
 *
 * @param <Id>     тип идентификатора сущности
 * @param <Entity> тип сущности, реализующей {@link CommonEntity}
 */
public interface FindCommonService<Id extends Serializable, Entity extends CommonEntity<Id>> {

    /**
     * Получить один рабочий элемент. Возвращается {@link Optional} элемент, который может быть пустым.
     *
     * @param id Идентификационный код элемента
     *
     * @return {@link Optional}<{@link Entity}> возможный элемент {@code Entity}
     *
     * @throws IllegalArgumentException если идентификатор равен null
     */
    Optional<Entity> getOne(Id id);

    /**
     * Получить все элементы с пагинацией.
     *
     * @param pageable параметры пагинации
     *
     * @return {@link Page}<{@link Entity}> страница элементов {@code Entity}
     */
    Page<Entity> getAll(Pageable pageable);

}
