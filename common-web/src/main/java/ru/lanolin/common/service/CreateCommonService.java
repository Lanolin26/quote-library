package ru.lanolin.common.service;

import ru.lanolin.common.domain.CommonEntity;
import ru.lanolin.common.exception.DuplicateEntityException;
import ru.lanolin.common.exception.SaveEntityException;

import java.io.Serializable;

public interface CreateCommonService<Id extends Serializable, Entity extends CommonEntity<Id>> {

    /**
     * Создает элемент и сохраняет его в базу
     * При сохранении устанавливает ID согласно правилам
     *
     * @param entity - объект для сохранения результат
     * @return созданный объект с установленным {@code <Id>} и сохраненным
     * @throws DuplicateEntityException уже создан такой эе элемент по ключевым параметрам
     * @throws SaveEntityException      ошибка при создании в Hibernate
     */
    Entity create(Entity entity);

}
