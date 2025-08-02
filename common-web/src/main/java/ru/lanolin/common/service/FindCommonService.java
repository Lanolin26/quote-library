package ru.lanolin.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.lanolin.common.domain.CommonEntity;

import java.io.Serializable;
import java.util.Optional;

public interface FindCommonService<Id extends Serializable, Entity extends CommonEntity<Id>> {

    /**
     * Получить один рабочий элемент. Возвращается {@link Optional} элемент, который может быть пустым.
     *
     * @param id Идентификационный код элемента
     * @return {@link Optional}<{@link Entity}> возможный элемент {@code Entity}
     */
    Optional<Entity> getOne(Id id);

    /**
     * @param pageable
     * @return
     */
    Page<Entity> getALl(Pageable pageable);


}
