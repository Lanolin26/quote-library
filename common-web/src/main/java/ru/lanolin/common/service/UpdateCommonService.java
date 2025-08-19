package ru.lanolin.common.service;

import ru.lanolin.common.domain.CommonEntity;
import ru.lanolin.common.exception.DuplicateEntityException;
import ru.lanolin.common.exception.SaveEntityException;

import java.io.Serializable;

/**
 * Интерфейс сервиса для обновления сущностей.
 *
 * @param <Id>     тип идентификатора сущности
 * @param <Entity> тип сущности, реализующей CommonEntity
 */
public interface UpdateCommonService<Id extends Serializable, Entity extends CommonEntity<Id>> {

    /**
     * Обновляет сущность по идентификатору.
     *
     * @param id     идентификатор сущности для обновления
     * @param entity новая версия сущности
     *
     * @return обновленная сущность
     *
     * @throws DuplicateEntityException если при обновлении будет обнаружено, что сущность с такими ключевыми
     *                                  параметрами уже существует
     * @throws SaveEntityException      если произошла ошибка при сохранении изменений в базе данных через Hibernate
     */
    Entity update(Id id, Entity entity);

}
