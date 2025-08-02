package ru.lanolin.quote.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import ru.lanolin.quote.repo.SourceTypeRepository;
import utils.faker.QuoteSystemFaker;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.*;

class SourceTypeServiceUnitTest {

    private static QuoteSystemFaker faker;

    @BeforeAll
    static void beforeAll() {
        faker = new QuoteSystemFaker();
    }

    private SourceTypeRepository repository;
    private SourceTypeService service;

    @BeforeEach
    void setUp() {
        repository = mock(SourceTypeRepository.class);
        service = new SourceTypeService(repository);
    }

    @AfterEach
    void tearDown() {
        clearInvocations(repository);
    }

    @Test
    @DisplayName("deleteById(UUID): correct")
    void delete1() {
        // Arrange
        UUID uuid = UUID.randomUUID();
        doNothing().when(repository).deleteById(eq(uuid));
        // Act
        Executable executable = () -> service.delete(uuid);
        // Assert
        assertDoesNotThrow(executable);
        verify(repository, times(1))
                .deleteById(eq(uuid));
    }

    @Test
    @DisplayName("deleteById(null): incorect")
    void delete2() {
        // Arrange
        doThrow(IllegalArgumentException.class).when(repository).deleteById(isNull());
        // Act
        Executable executable = () -> service.delete((UUID) null);
        // Assert
        assertDoesNotThrow(executable);
        verify(repository, times(1))
                .deleteById(isNull());
    }

    @Test
    void getALl() {
        // Arrange
        // Act
        // Assert
        fail();
    }

    @Test
    void getOne() {
        // Arrange
        // Act
        // Assert
        fail();
    }

    @Test
    void create() {
        // Arrange
        // Act
        // Assert
        fail();
    }

    @Test
    void update() {
        // Arrange
        // Act
        // Assert
        fail();
    }
}