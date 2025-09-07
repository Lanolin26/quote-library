package ru.lanolin.quote.controller.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.lanolin.common.controller.CommonWebController;
import ru.lanolin.quote.domain.source.entity.Source;

@Controller
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SourceWebController implements CommonWebController<Source> {
}
