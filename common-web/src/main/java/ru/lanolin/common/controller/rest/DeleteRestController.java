package ru.lanolin.common.controller.rest;

import ru.lanolin.common.controller.CommonRestController;
import ru.lanolin.common.domain.CommonEntity;

import java.io.Serializable;

/**
 * Удаление объекта из системы
 * <p>
 * Метод HTTP - {@link org.springframework.http.HttpMethod#DELETE DELETE}
 *
 * @param <Id>     Тип идентификатора объекта
 * @param <Entity> Тип объекта
 */
public interface DeleteRestController<
        Id extends Serializable,
        Entity extends CommonEntity<Id>
        > extends CommonRestController<Entity> {

    /**
     * Удаляет элемент из системы по его {@code id}
     * Используется в связке с {@link org.springframework.web.bind.annotation.DeleteMapping @DeleteMapping}
     *
     * @param id идентификатор объекта на удаление
     */
    void deleteById(Id id);

}
