package ru.lanolin.common.utils;

import org.hibernate.annotations.IdGeneratorType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для генерации UUID v7 значений. Используется для полей сущностей, которые должны иметь уникальный
 * идентификатор в формате UUID v7. UUID v7 обеспечивает лучшую порядковость по времени по сравнению с классическими
 * UUID версий 1 и 4.
 *
 * @author lanolin
 */
@IdGeneratorType(UUIDv7EntityGenerator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UUIDGenerator {
}
