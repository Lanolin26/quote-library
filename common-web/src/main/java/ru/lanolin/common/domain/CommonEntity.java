package ru.lanolin.common.domain;

import java.io.Serializable;

/**
 * Типичный представитель Entity объектов для базы данных
 *
 * @param <Id> Тип идентификатора объекта
 */
public interface CommonEntity<Id extends Serializable> {

    /**
     * @param id
     */
    void setId(Id id);

    /**
     * @return
     */
    Id getId();
}
