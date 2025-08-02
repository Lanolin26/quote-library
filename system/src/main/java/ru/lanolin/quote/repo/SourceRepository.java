package ru.lanolin.quote.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lanolin.domain.source.entity.Source;

import java.util.UUID;

@Repository
public interface SourceRepository extends JpaRepository<Source, UUID> {
}