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

    @Id
    @Column(nullable = false, name = "id")
    @JdbcTypeCode(SqlTypes.UUID)
    @UUIDGenerator
    private UUID id;

    @Size(min = 1, max = 512)
    @NotNull
    @NotEmpty
    @NotBlank
    @Column(unique = true, length = 512, name = "sourceType")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String sourceType;

    @ToString.Exclude
    @OneToMany(mappedBy = "sourceType", orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Source> sources = new LinkedHashSet<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        SourceType that = (SourceType) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
