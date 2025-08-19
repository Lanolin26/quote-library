package ru.lanolin.common.exception;

import java.text.MessageFormat;

/**
 * Исключение, которое выбрасывается при попытке создания дубликата сущности. Обычно используется в случае, когда уже
 * существует сущность с такими же уникальными полями, например, при попытке создать пользователя с уже существующим
 * id.
 */
public class DuplicateEntityException extends RuntimeException {

    /**
     * Конструктор, создающий исключение с указанным сообщением.
     *
     * @param message сообщение об ошибке
     */
    public DuplicateEntityException(String message) {
        super(message);
    }

    /**
     * Конструктор, создающий исключение с форматированным сообщением.
     *
     * @param message шаблон сообщения с аргументами форматирования
     * @param args    аргументы для форматирования сообщения
     */
    public DuplicateEntityException(String message, Object... args) {
        super(MessageFormat.format(message, args));
    }

}
