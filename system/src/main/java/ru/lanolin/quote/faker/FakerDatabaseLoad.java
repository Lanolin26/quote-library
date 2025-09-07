package ru.lanolin.quote.faker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import ru.lanolin.quote.domain.sourcetype.entity.SourceType;
import ru.lanolin.quote.repo.SourceTypeRepository;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class FakerDatabaseLoad {

    @Autowired
    private SourceTypeRepository repository;

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        QuoteSystemFaker quoteSystemFaker = new QuoteSystemFaker();
        SourceTypeFaker sourceTypeFaker = quoteSystemFaker.sourceType();

        log.info("Load fake data {}", SourceType.class);
        List<SourceType> list = Arrays.stream(SourceTypeFaker.exampleSourceType)
                .map(sourceTypeFaker::object)
                .toList();
        repository.saveAllAndFlush(list);
    }

}
