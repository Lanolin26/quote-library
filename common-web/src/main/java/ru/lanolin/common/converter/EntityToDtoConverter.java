package ru.lanolin.common.converter;

import ru.lanolin.common.domain.CommonEntity;

import java.io.Serializable;

/**
 * Интерфейс преобразования сущности в DTO.
 *
 * @param <Entity> Тип сущности, которая расширяет {@link CommonEntity}
 * @param <Dto>    Тип DTO, в который происходит преобразование
 */
public interface EntityToDtoConverter<
        Entity extends CommonEntity<? extends Serializable>,
        Dto> {

    /**
     * Преобразует сущность в DTO.
     *
     * @param entity Сущность для преобразования
     *
     * @return Преобразованная сущность в формате DTO
     */
    Dto convert(Entity entity);

}
