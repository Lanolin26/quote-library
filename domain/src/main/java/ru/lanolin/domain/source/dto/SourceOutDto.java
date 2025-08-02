package ru.lanolin.domain.source.dto;

import ru.lanolin.domain.source.entity.Source;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link Source}
 */
public record SourceOutDto(UUID id, String sourceName) implements Serializable {
}