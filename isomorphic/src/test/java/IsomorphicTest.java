import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsomorphicTest {

    private Isomorphic isomorphic;

    @BeforeEach
    void setUp() {
        isomorphic = new Isomorphic();
    }

    @Test
    void isEggAndAddIsomorphic() {
        assertEquals(true, isomorphic.judge("egg", "add"));
    }

    @Test
    void isNullAndGoodIsomorphic() {
        assertEquals(false, isomorphic.judge(null, "good"));
    }

    @Test
    void isBothNullIsomorphic() {
        assertEquals(false, isomorphic.judge(null, null));
    }

    @Test
    void isFoodAndGoodnessIsomorphic() {
        assertEquals(false, isomorphic.judge("food", "goodness"));
    }

    @Test
    void isFoodAndGoodIsomorphic() {
        assertEquals(false, isomorphic.judge("food", "goOd"));
    }

}
