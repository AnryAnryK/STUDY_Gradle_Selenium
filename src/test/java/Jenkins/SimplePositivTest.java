package Jenkins;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
//тесты в Jenkins

@Tag("Simple")
public class SimplePositivTest {
    @Test
    void PositivTest1 () {

        assertTrue(true);
    }

    @Test
    void PositivTest2 () {

        assertTrue(true);
    }

    @Test
    void PositivTest3 () {

        assertTrue(true);
    }
}
