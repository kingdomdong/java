package tacos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TacoCloudApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void outOfBound() {
        new ArrayList<String>().get(1);
    }

}
