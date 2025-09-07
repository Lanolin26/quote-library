package ru.lanolin.quote.domain.source.entity;

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
import ru.lanolin.quote.domain.quote.entity.Quote;
import ru.lanolin.quote.domain.sourcetype.entity.SourceType;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(schema = "book", indexes = {
        @Index(name = "idx_source_source_name", columnList = "source_name")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uc_source_source_name", columnNames = {"source_name", "source_type_id"})
})
public class Source implements CommonEntity<UUID> {

    @Id
    @UUIDGenerator
    @Column(name = "id")
    @JdbcTypeCode(SqlTypes.UUID)
    private UUID id;

    @NotBlank
    @Size(min = 1, max = 1024)
    @NotEmpty
    @NotNull
    @Column(name = "source_name")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String sourceName;

    @NotNull
    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    @JoinColumn(name = "source_type_id", nullable = false)
    @JdbcTypeCode(SqlTypes.UUID)
    private SourceType sourceType;

    @ToString.Exclude
    @OneToMany(mappedBy = "source", orphanRemoval = true)
    private Set<Quote> quotes = new LinkedHashSet<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Source source = (Source) o;
        return getId() != null && Objects.equals(getId(), source.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
