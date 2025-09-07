package ru.lanolin.quote.converter;

import ru.lanolin.common.converter.CommonConverter;
import ru.lanolin.quote.domain.source.dto.SourceOutDto;
import ru.lanolin.quote.domain.source.entity.Source;

public class SourceConverter implements CommonConverter<Source, SourceOutDto> {
    @Override
    public Source convert(SourceOutDto sourceOutDto) {
        return null;
    }

    @Override
    public SourceOutDto convert(Source entity) {
        return null;
    }
}
