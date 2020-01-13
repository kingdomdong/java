package tacos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

class JDBCRawTest {

    private Ingredient ingredient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ingredient = new Ingredient("1", "cake", Ingredient.Type.CHEESE);
    }

    @Test
    void connect173() {
    }

}