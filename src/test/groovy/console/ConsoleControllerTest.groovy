package console

import griffon.core.test.GriffonUnitRule
import griffon.core.test.TestFor
import org.junit.Rule
import org.junit.Test

import static org.junit.Assert.fail

@TestFor(ConsoleController)
class ConsoleControllerTest {
    private ConsoleController controller

    @Rule
    public final GriffonUnitRule griffon = new GriffonUnitRule()

    @Test
    void testClickAction() {
        fail('Not yet implemented!')
    }
}