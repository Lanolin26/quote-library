package ru.lanolin.quote.repo;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lanolin.domain.sourcetype.entity.SourceType;

import java.util.UUID;

@Repository
public interface SourceTypeRepository extends JpaRepository<SourceType, UUID> {

    boolean existsBySourceType(String sourceType);

    boolean existsById(@NotNull UUID id);

}
