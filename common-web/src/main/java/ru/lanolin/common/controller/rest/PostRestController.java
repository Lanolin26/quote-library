package ru.lanolin.common.controller.rest;

import ru.lanolin.common.controller.CommonRestController;
import ru.lanolin.common.domain.CommonEntity;

import java.io.Serializable;

/**
 * Изменяет объект в хранилище
 * <p>
 * Метод HTTP --- {@link org.springframework.http.HttpMethod#POST PЩЫЕ}
 *
 * @param <Id>     - Тип идентификатора объекта
 * @param <Entity> - Тип объекта
 * @param <In>     - Тип входного объекта
 * @param <Out>    - Тип выходного объекта
 */
public interface PostRestController<
        Id extends Serializable,
        Entity extends CommonEntity<Id>,
        In,
        Out
        > extends CommonRestController<Entity> {

    /**
     * TODO
     * @param id
     * @param entity
     * @return
     */
    Out post(Id id, In entity);

}
