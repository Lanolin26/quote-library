package utils.faker;

import com.github.f4b6a3.uuid.UuidCreator;
import net.datafaker.providers.base.AbstractProvider;
import net.datafaker.providers.base.BaseProviders;
import ru.lanolin.quote.domain.sourcetype.entity.SourceType;

import java.util.UUID;

public class SourceTypeFaker extends AbstractProvider<BaseProviders> {

    protected SourceTypeFaker(BaseProviders faker) {
        super(faker);
    }

    static final String[] exampleSourceType = {
            "Anime",
            "Film",
            "Multfilm",
            "Serial",
            "Books"
    };

    public SourceType object() {
        SourceType sourceType = new SourceType();
        sourceType.setId(id());
        sourceType.setSourceType(sourceType());
        return sourceType;
    }

    public String sourceType() {
        int i = faker.random().nextInt(0, exampleSourceType.length-1);
        return exampleSourceType[i];
    }

    public UUID id() {
        return UuidCreator.getTimeOrderedEpoch();
    }

}
