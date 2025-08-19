package ru.lanolin.domain.sourcetype.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.type.SqlTypes;
import ru.lanolin.common.domain.CommonEntity;
import ru.lanolin.common.utils.UUIDGenerator;
import ru.lanolin.domain.source.entity.Source;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * Сущность, представляющая тип источника цитаты. Этот класс хранит информацию о различных типах источников, таких как
 * книги, статьи, веб-сайты и т.д., которые используются для категоризации и организации различных источников в
 * системе.
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "source_type", schema = "book", indexes = {
        @Index(name = "idx_sourcetype_sourcetype_unq", columnList = "sourceType")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uc_sourcetype_sourcetype", columnNames = {"sourceType"})
})
public class SourceType implements CommonEntity<UUID> {

    /**
     * Уникальный идентификатор типа источника. Этот UUID генерируется автоматически с использованием UUIDGenerator.
     */
    @Id
    @Column(nullable = false, name = "id")
    @JdbcTypeCode(SqlTypes.UUID)
    @UUIDGenerator
    private UUID id;

    /**
     * Название типа источника (например, "Книга", "Статья", "Веб-сайт"). Это поле обязательно для заполнения, не должно
     * быть пустым или содержать только пробелы, и имеет максимальную длину в 512 символов. Поле является уникальным
     * среди всех записей в таблице.
     */
    @Size(min = 1, max = 512)
    @NotNull
    @NotEmpty
    @NotBlank
    @Column(unique = true, length = 512, name = "sourceType")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String sourceType;

    /**
     * Коллекция источников, принадлежащих этому типу. Связь сопоставляется по полю 'sourceType' в сущности Source.
     * Удаление сирот (orphan removal) включено, что означает, что когда источник удаляется из этого набора, он также
     * будет удален из базы данных. Стратегия выборки LAZY используется для предотвращения ненужной загрузки связанных
     * данных.
     */
    @ToString.Exclude
    @OneToMany(mappedBy = "sourceType", orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Source> sources = new LinkedHashSet<>();

    /**
     * Сравнивает этот объект SourceType с другим объектом на предмет равенства. Равенство основывается на полях ID и
     * sourceType.
     *
     * @param o объект, с которым происходит сравнение
     *
     * @return true, если объекты равны, иначе false
     */
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy
                ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass()
                : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass()
                : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        SourceType that = (SourceType) o;
        return getId() != null
               && Objects.equals(getId(), that.getId())
               && Objects.equals(getSourceType(), that.getSourceType());
    }

    /**
     * Генерирует значение хэш-кода для объекта. Использует обработку прокси Hibernate для обеспечения корректной работы
     * с лениво загружаемыми сущностями.
     *
     * @return значение хэш-кода для данного объекта
     */
    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();
    }
}
