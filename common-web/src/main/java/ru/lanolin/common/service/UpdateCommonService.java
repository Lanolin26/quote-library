package ru.lanolin.common.service;

import ru.lanolin.common.domain.CommonEntity;
import ru.lanolin.common.exception.DuplicateEntityException;
import ru.lanolin.common.exception.SaveEntityException;

import java.io.Serializable;

public interface UpdateCommonService<Id extends Serializable, Entity extends CommonEntity<Id>> {

    /**
     * @param id
     * @param entity
     * @return
     * @throws DuplicateEntityException уже создан такой эе элемент по ключевым параметрам
     * @throws SaveEntityException      ошибка при создании в Hibernate
     */
    Entity update(Id id, Entity entity);

}
