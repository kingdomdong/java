package tacos.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import tacos.Taco;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * test for {@link JdbcTacoRepository}
 */
public class JdbcTacoRepositoryTest {

    @InjectMocks
    JdbcTacoRepository jdbcTacoRepository;

    @Mock
    JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveTaco() {
        assertEquals(new Taco(), jdbcTacoRepository.save(new Taco()));
    }

}
