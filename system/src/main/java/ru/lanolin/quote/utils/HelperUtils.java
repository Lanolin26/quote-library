package ru.lanolin.quote.utils;

import org.jspecify.annotations.NonNull;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class HelperUtils {

    public static <E, D> void updateField(
            @NonNull Supplier<D> getFunction,
            @NonNull Consumer<D> setFunction
    ) {
        Optional.ofNullable(getFunction.get()).ifPresent(setFunction);
    }

}
