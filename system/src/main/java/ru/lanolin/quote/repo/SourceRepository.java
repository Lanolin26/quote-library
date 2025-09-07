package ru.lanolin.quote.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lanolin.quote.domain.source.entity.Source;

import java.util.UUID;

@Repository
public interface SourceRepository extends JpaRepository<Source, UUID> {

    boolean existsBySourceNameAndSourceTypeId(String sourceName, UUID sourceTypeId);

}