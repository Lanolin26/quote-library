package ru.lanolin.common.exception;

/**
 * Исключение, которое возникает при ошибке сохранения сущности в базе данных.
 */
public class SaveEntityException extends RuntimeException {
    /**
     * Конструктор класса SaveEntityException.
     *
     * @param message сообщение об ошибке, описывающее детали исключения
     */
    public SaveEntityException(String message) {
        super(message);
    }
}
