package ru.lanolin.quote.converter;

import ru.lanolin.common.converter.CommonConverter;
import ru.lanolin.quote.domain.sourcetype.dto.SourceTypeInOutDto;
import ru.lanolin.quote.domain.sourcetype.entity.SourceType;

public class SourceTypeConverter implements CommonConverter<SourceType, SourceTypeInOutDto> {

    @Override
    public SourceType convert(SourceTypeInOutDto sourceTypeInOutDto) {
        return null;
    }

    @Override
    public SourceTypeInOutDto convert(SourceType entity) {
        return null;
    }
}
