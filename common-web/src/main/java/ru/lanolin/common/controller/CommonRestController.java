package ru.lanolin.common.controller;

import ru.lanolin.common.domain.CommonEntity;

/**
 * Общий интерфейс для создания REST контроллеров
 * @param <Entity>
 */
public interface CommonRestController<
        Entity extends CommonEntity<?>
        > {
}
