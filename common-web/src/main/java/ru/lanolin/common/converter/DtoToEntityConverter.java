package ru.lanolin.common.converter;

import ru.lanolin.common.domain.CommonEntity;

import java.io.Serializable;

/**
 * Интерфейс преобразования объекта Data Transfer Object (DTO) в сущность.
 *
 * @param <Entity> Тип сущности, которая расширяет {@link CommonEntity}
 * @param <Dto>    Тип DTO, который будет преобразован в сущность
 */
public interface DtoToEntityConverter<
        Entity extends CommonEntity<? extends Serializable>,
        Dto> {

    /**
     * Преобразует объект Data Transfer Object (DTO) в сущность.
     *
     * @param dto объект DTO, который нужно преобразовать
     *
     * @return экземпляр сущности, созданный на основе данных из DTO
     */
    Entity convert(Dto dto);
}
