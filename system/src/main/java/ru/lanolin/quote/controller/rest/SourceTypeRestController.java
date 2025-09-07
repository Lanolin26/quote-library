package ru.lanolin.quote.controller.rest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lanolin.quote.domain.sourcetype.dto.SourceTypeInOutDto;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/rest/source-type")
public class SourceTypeRestController {

    public Optional<SourceTypeInOutDto> getOne(UUID uuid) {
        return Optional.empty();
    }

    public Page<SourceTypeInOutDto> getAll(Pageable pageable) {
        return null;
    }

}
