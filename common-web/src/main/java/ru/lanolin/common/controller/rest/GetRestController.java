package ru.lanolin.common.controller.rest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.lanolin.common.controller.CommonRestController;
import ru.lanolin.common.domain.CommonEntity;

import java.io.Serializable;
import java.util.Optional;

/**
 * Получение объекта {@code <Entity>}
 * <p>
 * Метод HTTP - {@link org.springframework.http.HttpMethod#GET GET}
 *
 * @param <Id>     Тип идентификатора объекта
 * @param <Entity> Тип объекта
 * @param <Out>    Тип возвращаемого объекта
 */
public interface GetRestController<
        Id extends Serializable,
        Entity extends CommonEntity<Id>,
        Out
        > extends CommonRestController<Entity> {

    /**
     * Получение одного элемента из хранилища
     * <p>
     * Используется в связке с {@link org.springframework.web.bind.annotation.GetMapping @GetMapping}
     *
     * @param id идентификатор объекта
     * @return {@link Optional}&lt;{@link Out}&gt; возможный объекта
     */
    Optional<Out> getOne(Id id);

    /**
     * Получение списка элементов из хранилища
     * <p>
     * Используется в связке с {@link org.springframework.web.bind.annotation.GetMapping @GetMapping}
     *
     * @param pageable объект типа {@link Pageable} для получение ограниченного списка объекта
     * @return {@link Page}&lt;{@link Out}&gt;
     */
    Page<Out> getAll(Pageable pageable);

}
