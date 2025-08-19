package ru.lanolin.domain.sourcetype.dto;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link ru.lanolin.domain.sourcetype.entity.SourceType}
 */
public record SourceTypeInOutDto(UUID id, String sourceType)
        implements Serializable {

    /**
     * Создает экземпляр SourceTypeInOutDto с указанным идентификатором и типом источника.
     *
     * @param id         идентификатор источника
     * @param sourceType тип источника
     *
     * @return новый экземпляр SourceTypeInOutDto
     */
    @Contract("_, _ -> new")
    public static @NotNull SourceTypeInOutDto create(UUID id, @NotNull String sourceType) {
        return new SourceTypeInOutDto(id, sourceType);
    }

    /**
     * Создает экземпляр SourceTypeInOutDto с указанным типом источника.
     *
     * @param sourceType тип источника
     *
     * @return новый экземпляр SourceTypeInOutDto
     */
    @Contract("_ -> new")
    public static @NotNull SourceTypeInOutDto create(@NotNull String sourceType) {
        return new SourceTypeInOutDto(null, sourceType);
    }
}
