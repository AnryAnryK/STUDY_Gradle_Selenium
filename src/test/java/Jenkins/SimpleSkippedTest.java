package Jenkins;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("Simple")
public class SimpleSkippedTest {
    @Test
    @Disabled ("специально пропускаем тест, чтобы понять, как это работает с Jenkins")
    void SkippedTest1 () {

        assertTrue(true);
    }

    @Test
    @Disabled ("специально пропускаем тест, чтобы понять, как это работает с Jenkins")
    void SkippedTest2 () {

        assertTrue(true);
    }

    @Test
    @Disabled ("специально пропускаем тест, чтобы понять, как это работает с Jenkins")
    void SkippedTest3 () {

        assertTrue(true);
    }
}
