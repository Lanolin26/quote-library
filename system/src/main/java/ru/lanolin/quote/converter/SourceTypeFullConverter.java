package ru.lanolin.quote.converter;

import ru.lanolin.common.converter.CommonConverter;
import ru.lanolin.quote.domain.sourcetype.dto.SourceTypeFullOutDto;
import ru.lanolin.quote.domain.sourcetype.dto.SourceTypeInOutDto;
import ru.lanolin.quote.domain.sourcetype.entity.SourceType;

public class SourceTypeFullConverter implements CommonConverter<SourceType, SourceTypeFullOutDto> {

    @Override
    public SourceType convert(SourceTypeFullOutDto sourceTypeFullOutDto) {
        return null;
    }

    @Override
    public SourceTypeFullOutDto convert(SourceType entity) {
        return null;
    }
}
