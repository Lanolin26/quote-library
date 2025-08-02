package ru.lanolin.common.service;

import ru.lanolin.common.domain.CommonEntity;

import java.io.Serializable;

/**
 * Типичный {@code Service} для прослойки между web и базой данных
 *
 * @param <Id>
 * @param <Entity>
 */
public interface CommonService<Id extends Serializable, Entity extends CommonEntity<Id>>
        extends FindCommonService<Id, Entity>,
        CreateCommonService<Id, Entity>,
        UpdateCommonService<Id, Entity>,
        DeleteCommonService<Id, Entity> {
}
