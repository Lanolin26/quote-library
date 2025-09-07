package ru.lanolin.quote.controller.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.lanolin.common.controller.CommonWebController;
import ru.lanolin.quote.domain.sourcetype.dto.SourceTypeInOutDto;
import ru.lanolin.quote.domain.sourcetype.entity.SourceType;
import ru.lanolin.quote.service.SourceTypeService;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/app/source-type")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SourceTypeWebController implements CommonWebController<SourceType> {

    private final SourceTypeService service;

    @GetMapping(value = {"", "/"})
    public String getPage(
            @PageableDefault(page = 0, size = 5) Pageable pageable,
            Model model
    ) {
        Page<SourceType> all = service.getAll(pageable);
        model.addAttribute("sourceTypes", all);
        return "sourcetype/getmany";
    }

    @GetMapping("/{id}")
    public String getOne(
            @PathVariable UUID id,
            Model model
    ) {
        Optional<SourceType> one = service.getOne(id);
        model.addAttribute("sourceType", one);
        return "sourcetype/getone";
    }

    @GetMapping(value = {"/save", "/save/{id}"})
    public String save(
            @PathVariable(required = false) UUID id,
            Model model
    ) {
        Optional.ofNullable(id)
                .flatMap(service::getOne)
                .ifPresent(e -> model.addAttribute("sourceType", e));
        return "sourcetype/save";
    }

    @PostMapping(value = {"/save", "/save/{id}"})
    public String saveAction(
            @PathVariable(required = false) UUID id,
            @RequestBody SourceTypeInOutDto dto,
            Model model
    ) {
//        Optional.ofNullable(id)
//                .flatMap(service::getOne)
//                .ifPresent(e -> model.addAttribute("sourceType", e));
        return "sourcetype/save";
    }

}
