package ru.lanolin.quote.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.lanolin.domain.quote.entity.Quote;
import ru.lanolin.domain.quote.entity.QuoteFullInfo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, UUID> {


    @Query("""
            select q.id, q.quote
            from Quote q
            inner join Source s on q.source = s.id
            inner join SourceType st on s.sourceType = st.id
            inner join User u on q.author = u.id
            where q.id = :id
            """)
    Optional<QuoteFullInfo> findFullInfoById(UUID id);

    @Query("""
            select q.id, q.quote
            from Quote q
            inner join Source s on q.source = s.id
            inner join SourceType st on s.sourceType = st.id
            inner join User u on q.author = u.id
            """)
    List<QuoteFullInfo> findFullInfoAllById(UUID id);

}
