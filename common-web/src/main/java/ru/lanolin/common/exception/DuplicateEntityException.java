package ru.lanolin.common.exception;

import java.text.MessageFormat;

/**
 * TODO
 */
public class DuplicateEntityException extends RuntimeException {
    public DuplicateEntityException(String message) {
        super(message);
    }

    public DuplicateEntityException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }

}
