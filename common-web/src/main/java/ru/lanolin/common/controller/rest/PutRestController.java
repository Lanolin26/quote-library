package ru.lanolin.common.controller.rest;

import ru.lanolin.common.controller.CommonRestController;
import ru.lanolin.common.domain.CommonEntity;

import java.io.Serializable;

/**
 * Создание объекта и сохранение в систему
 * <p>
 * Метод HTTP --- {@link org.springframework.http.HttpMethod#PUT PUT}
 *
 * @param <Entity> - Тип объекта
 * @param <In>     - Тип входного объекта
 * @param <Out>    - Тип выходного объекта
 */
public interface PutRestController<
        Id extends Serializable,
        Entity extends CommonEntity<Id>,
        In,
        Out
        > extends CommonRestController<Entity> {

    /**
     * TODO
     * @param entity
     * @return
     */
    Out put(In entity);

}
