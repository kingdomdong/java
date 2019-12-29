package tacos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JDBCRawTest {

    private Ingredient ingredient;

    @InjectMocks
    DataSource dataSource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ingredient = new Ingredient("1", "cake", Ingredient.Type.CHEESE);
    }

    @Test
    void connect173() {
        JDBCRaw jdbcRaw = new JDBCRaw(dataSource);
        assertEquals(ingredient, jdbcRaw.findOne("1"));
    }


}