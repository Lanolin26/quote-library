package ru.lanolin.common.utils;

import com.github.f4b6a3.uuid.UuidCreator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * Генератор идентификаторов UUIDv7 для сущностей. Использует библиотеку UuidCreator для создания time-ordered UUIDs
 * версии 7, которые обеспечивают монотонное возрастание идентификаторов.
 */
public class UUIDv7EntityGenerator implements IdentifierGenerator {

    /**
     * Генерирует новый идентификатор UUIDv7.
     *
     * @param session Сессия Hibernate
     * @param object  Объект, для которого генерируется идентификатор
     *
     * @return Новый UUIDv7 в виде строки
     */
    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        return UuidCreator.getTimeOrderedEpoch();
    }

}
