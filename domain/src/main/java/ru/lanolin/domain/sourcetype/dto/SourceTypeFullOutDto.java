package ru.lanolin.domain.sourcetype.dto;

import ru.lanolin.domain.source.dto.SourceOutDto;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

/**
 * DTO for {@link ru.lanolin.domain.sourcetype.entity.SourceType}
 */
public record SourceTypeFullOutDto(UUID id, String sourceType, Set<SourceOutDto> sources)
        implements Serializable {
}
