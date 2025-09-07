package ru.lanolin.quote.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.lanolin.quote.domain.sourcetype.entity.SourceType;
import ru.lanolin.quote.repo.SourceTypeRepository;
import utils.faker.QuoteSystemFaker;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;
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

    @Nested
    class Delete {

        private UUID expectedId;

        @BeforeEach
        void setUp() {
            SourceType expectedSourceType = faker.sourceType().object();
            expectedId = expectedSourceType.getId();

            doThrow(IllegalArgumentException.class)
                    .when(repository)
                    .deleteById(isNull());

            doNothing()
                    .when(repository)
                    .deleteById(eq(expectedId));
        }

        @Test
        @DisplayName("deleteById(UUID): correct")
        void delete1() {
            // Arrange
            // Act
            Executable executable = () -> service.delete(expectedId);
            // Assert
            assertDoesNotThrow(executable);
            verify(repository, times(1))
                    .deleteById(eq(expectedId));
        }

        @Test
        @DisplayName("deleteById(null): incorect")
        @SuppressWarnings("ConstantConditions")
        void delete2() {
            // Arrange
            // Act
            Executable executable = () -> service.delete((UUID) null);
            // Assert
            assertThrows(IllegalArgumentException.class, executable);
            verify(repository, times(1))
                    .deleteById(isNull());
        }
    }

    @Nested
    class GetAll {

        static Stream<Arguments> getAllList() {
            Stream.Builder<Arguments> builder = Stream.builder();
            builder.accept(of(PageRequest.of(0, 10), Page.empty()));
            builder.accept(of(PageRequest.of(0, 10), new PageImpl<>(List.of(faker.sourceType().object()))));
            return builder.build();
        }

        @ParameterizedTest(name = "getALl({index}): correct")
        @MethodSource("getAllList")
        void getALl(Pageable pageable, Page<SourceType> page) {
            // Arrange
            when(repository.findAll(eq(pageable)))
                    .thenReturn(page);
            // Act
            ThrowingSupplier<Page<SourceType>> exec = () -> service.getAll(pageable);
            // Assert
            Page<SourceType> sourceTypes = assertDoesNotThrow(exec);
            assertEquals(page.getSize(), sourceTypes.getSize());
        }

        @Test
        @DisplayName("getALl(null): incorect")
        @SuppressWarnings("ConstantConditions")
        void getALl_incorrect() {
            // Arrange
            doThrow(NullPointerException.class)
                    .when(repository)
                    .findAll(isNull(Pageable.class));
            // Act
            Executable exec = () -> service.getAll(null);
            // Assert
            assertThrows(NullPointerException.class, exec);
        }

    }

    @Nested
    class GetOne {

        private SourceType expectedSourceType;
        private UUID expectedId;

        @BeforeEach
        @SuppressWarnings("ConstantConditions")
        void setUp() {
            expectedSourceType = faker.sourceType().object();
            expectedId = expectedSourceType.getId();

            when(repository.findById(isA(UUID.class)))
                    .thenReturn(Optional.empty());
            when(repository.findById(eq(expectedId)))
                    .thenReturn(Optional.of(expectedSourceType));
            doThrow(IllegalArgumentException.class)
                    .when(repository)
                    .findById(isNull(UUID.class));
        }

        @Test
        void getOne() {
            // Arrange
            // Act
            ThrowingSupplier<Optional<SourceType>> exec = () -> service.getOne(expectedId);
            // Assert
            Optional<SourceType> sourceType = assertDoesNotThrow(exec);
            assertTrue(sourceType.isPresent());
            assertEquals(expectedSourceType, sourceType.get());
        }

        @Test
        void getOne_empty() {
            // Arrange
            UUID uuid = UUID.randomUUID();
            // Act
            ThrowingSupplier<Optional<SourceType>> exec = () -> service.getOne(uuid);
            // Assert
            Optional<SourceType> sourceType = assertDoesNotThrow(exec);
            assertTrue(sourceType.isEmpty());
            verify(repository, times(1))
                    .findById(isA(UUID.class));
        }

        @Test
        @SuppressWarnings("ConstantConditions")
        void getOne_incorrect() {
            // Arrange
            // Act
            Executable executable = () -> service.getOne(null);
            // Assert
            assertThrows(IllegalArgumentException.class, executable);
            verify(repository, times(1))
                    .findById(isNull(UUID.class));
        }
    }

    @Nested
    class Create {
        @Test
        void create() {
            // Arrange
            // Act
            // Assert
            fail();
        }
    }

    @Nested
    class Update {
        @Test
        void update() {
            // Arrange
            // Act
            // Assert
            fail();
        }
    }


}