package ru.lanolin.common.service;

import ru.lanolin.common.domain.CommonEntity;

import java.io.Serializable;
import java.util.Objects;

/**
 * Интерфейс сервиса для выполнения операций удаления сущностей.
 *
 * @param <Id>     тип идентификатора сущности
 * @param <Entity> тип сущности, реализующей интерфейс CommonEntity
 */
public interface DeleteCommonService<Id extends Serializable, Entity extends CommonEntity<Id>> {

    /**
     * Удаляет сущность по идентификатору.
     *
     * @param id идентификатор удаляемой сущности
     */
    void delete(Id id);

    /**
     * Удаляет указанную сущность.
     *
     * @param entity сущность для удаления, не должна быть null
     *
     * @throws NullPointerException если entity равен null
     */
    default void delete(Entity entity) {
        Entity notNullEntity = Objects.requireNonNull(entity, "Entity is null when delete operation is executed");
        delete(notNullEntity.getId());
    }

}
