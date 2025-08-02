package ru.lanolin.quote.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.lanolin.quote.repo.SourceTypeRepository;

@DataJpaTest
class SourceTypeServiceIntegrateTest {

    @Autowired
    private SourceTypeRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    private SourceTypeService service;

    @BeforeEach
    void setUp() {
        service = new SourceTypeService(repository);
    }

    @Test
    void delete() {
        // Arrange
        // Act
        // Assert
        Assertions.fail();
    }

    @Test
    void getALl() {
        // Arrange
        // Act
        // Assert
        Assertions.fail();
    }

    @Test
    void getOne() {
        // Arrange
        // Act
        // Assert
        Assertions.fail();
    }

    @Test
    void create() {
        // Arrange
        // Act
        // Assert
        Assertions.fail();
    }

    @Test
    void update() {
        // Arrange
        // Act
        // Assert
        Assertions.fail();
    }
}