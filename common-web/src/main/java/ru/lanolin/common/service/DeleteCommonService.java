package ru.lanolin.common.service;

import ru.lanolin.common.domain.CommonEntity;

import java.io.Serializable;
import java.util.Objects;

public interface DeleteCommonService<Id extends Serializable, Entity extends CommonEntity<Id>> {

    /**
     * @param id
     */
    void delete(Id id);

    /**
     * @param entity
     */
    default void delete(Entity entity) {
        Entity notNullEntity = Objects.requireNonNull(entity, "Entity is null when delete operation is executed");
        delete(notNullEntity.getId());
    }

}
