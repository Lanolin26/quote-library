package ru.lanolin.quote.domain.quote.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.type.SqlTypes;
import org.hibernate.validator.constraints.Length;
import ru.lanolin.common.domain.CommonEntity;
import ru.lanolin.common.utils.UUIDGenerator;
import ru.lanolin.quote.domain.source.entity.Source;
import ru.lanolin.quote.domain.user.entity.User;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "quote", schema = "book", indexes = {
        @Index(name = "idx_quote_source_id", columnList = "source_id")
})
public class Quote implements CommonEntity<UUID> {

    @Id
    @Column(name = "id")
    @JdbcTypeCode(SqlTypes.UUID)
    @UUIDGenerator
    private UUID id;

    @Size(min = 1, max = 5 * 1024)
    @NotBlank
    @NotEmpty
    @Column(name = "quote")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @NotNull
    private String quote;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.DETACH, optional = false)
    @JoinColumn(name = "source_id", nullable = false)
    private Source source;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "author_id")
    private User author;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Quote quote = (Quote) o;
        return getId() != null && Objects.equals(getId(), quote.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
