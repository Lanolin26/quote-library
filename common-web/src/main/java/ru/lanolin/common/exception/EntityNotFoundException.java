package ru.lanolin.common.exception;

import java.text.MessageFormat;

/**
 * TODO
 */
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
