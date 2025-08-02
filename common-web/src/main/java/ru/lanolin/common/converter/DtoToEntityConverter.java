package ru.lanolin.common.converter;

import ru.lanolin.common.domain.CommonEntity;

import java.io.Serializable;

/**
 * @param <Entity>
 * @param <Dto>
 */
public interface DtoToEntityConverter<Entity extends CommonEntity<? extends Serializable>, Dto> {

    /**
     * @param dto
     *
     * @return
     */
    Entity convert(Dto dto);
}
