package ru.lanolin.common.domain;

import java.io.Serializable;

/**
 * Типичный представитель Entity объектов для базы данных
 *
 * @param <Id> Тип идентификатора объекта
 */
public interface CommonEntity<Id extends Serializable> {

    /**
     * Устанавливает идентификатор объекта
     *
     * @param id идентификатор объекта
     */
    void setId(Id id);

    /**
     * Возвращает идентификатор объекта
     *
     * @return идентификатор объекта
     */
    Id getId();
}
