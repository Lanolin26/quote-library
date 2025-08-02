package utils.faker;

import net.datafaker.Faker;

public final class QuoteSystemFaker extends Faker {

    public SourceTypeFaker sourceType() {
        return getProvider(SourceTypeFaker.class, SourceTypeFaker::new);
    }

}
