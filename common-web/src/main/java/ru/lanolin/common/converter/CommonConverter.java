package ru.lanolin.common.converter;

import ru.lanolin.common.domain.CommonEntity;

import java.io.Serializable;

/**
 * Общий интерфейс конвертера, предоставляющий методы для преобразования сущности в Dto и наоборот. Интерфейс расширяет
 * два других интерфейса: EntityToDtoConverter и DtoToEntityConverter, что позволяет реализовать оба направления
 * преобразования в одном классе.
 *
 * @param <Entity> тип сущности, которая должна расширять CommonEntity с параметром типа Serializable
 * @param <Dto>    тип Data Transfer Object, в который происходит преобразование
 */
public interface CommonConverter<Entity extends CommonEntity<? extends Serializable>, Dto>
        extends EntityToDtoConverter<Entity, Dto>, DtoToEntityConverter<Entity, Dto> {
}
