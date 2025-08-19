package ru.lanolin.common.exception;

import java.text.MessageFormat;

/**
 * Исключение, выбрасываемое в случае, если сущность не найдена.
 *
 * @version 1.0
 */
public class EntityNotFoundException extends RuntimeException {

    /**
     * Конструктор, создающий исключение с заданным сообщением.
     *
     * @param message сообщение об ошибке
     */
    public EntityNotFoundException(String message) {
        super(message);
    }

    /**
     * Конструктор, создающий исключение с форматированным сообщением.
     *
     * @param message шаблон сообщения с аргументами форматирования
     * @param args    аргументы для форматирования сообщения
     */
    public EntityNotFoundException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }
}
