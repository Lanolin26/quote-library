package ru.lanolin.common.service;

import ru.lanolin.common.domain.CommonEntity;
import ru.lanolin.common.exception.DuplicateEntityException;
import ru.lanolin.common.exception.SaveEntityException;

import java.io.Serializable;

/**
 * Интерфейс сервиса для создания сущностей. Предоставляет метод для создания новой сущности и сохранения её в базе
 * данных. При сохранении устанавливает ID согласно правилам.
 *
 * @param <Id>     тип идентификатора сущности
 * @param <Entity> тип сущности, реализующей интерфейс {@link CommonEntity}
 */
public interface CreateCommonService<Id extends Serializable, Entity extends CommonEntity<Id>> {

    /**
     * Создает элемент и сохраняет его в базу данных. При сохранении устанавливает ID согласно правилам.
     *
     * @param entity - объект для сохранения
     *
     * @return созданный объект с установленным идентификатором {@code <Id>} и сохраненным в базе данных
     *
     * @throws DuplicateEntityException уже существует элемент с такими же ключевыми параметрами
     * @throws SaveEntityException      ошибка при создании в Hibernate
     */
    Entity create(Entity entity);

}
