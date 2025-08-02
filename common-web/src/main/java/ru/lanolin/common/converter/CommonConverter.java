package ru.lanolin.common.converter;

import ru.lanolin.common.domain.CommonEntity;

import java.io.Serializable;

/**
 * @param <Entity>
 * @param <Dto>
 */
public interface CommonConverter<Entity extends CommonEntity<? extends Serializable>, Dto>
        extends EntityToDtoConverter<Entity, Dto>, DtoToEntityConverter<Entity, Dto> {
}
