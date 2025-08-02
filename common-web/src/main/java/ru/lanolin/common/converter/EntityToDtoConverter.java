package ru.lanolin.common.converter;

import ru.lanolin.common.domain.CommonEntity;

import java.io.Serializable;

/**
 * @param <Entity>
 * @param <Dto>
 */
public interface EntityToDtoConverter<
        Entity extends CommonEntity<? extends Serializable>,
        Dto> {

    /**
     * @param entity
     *
     * @return
     */
    Dto convert(Entity entity);

}
