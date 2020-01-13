package tacos.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import tacos.Order;

import static org.junit.jupiter.api.Assertions.*;

/**
 * test for {@link JdbcOrderRepository}
 *
 * @author kingdomdong
 * @version 1.0
 * @since 2019-12-31
 */
class JdbcOrderRepositoryTest {

    @InjectMocks
    private JdbcOrderRepository jdbcOrderRepository;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveOrder() {
        assertEquals(new Order(), jdbcOrderRepository.save(new Order()));
    }

}