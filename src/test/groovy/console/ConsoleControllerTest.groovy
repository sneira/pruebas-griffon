package console

import griffon.core.artifact.ArtifactManager
import griffon.core.injection.Module
import griffon.core.test.GriffonUnitRule
import griffon.core.test.TestFor
import griffon.inject.DependsOn
import org.codehaus.griffon.runtime.core.injection.AbstractTestingModule
import org.junit.Rule
import org.junit.Test

import javax.annotation.Nonnull
import javax.inject.Inject

import static com.jayway.awaitility.Awaitility.await
import static com.jayway.awaitility.Awaitility.fieldIn
import static java.util.concurrent.TimeUnit.SECONDS
import static org.hamcrest.Matchers.notNullValue

// 2.2.4. Testing

@TestFor(ConsoleController)                                                   
class ConsoleControllerTest {
    private ConsoleController controller                                      

    @Inject
    private ArtifactManager artifactManager                                   

    @Rule
    public final GriffonUnitRule griffon = new GriffonUnitRule()              

    @Test
    void testExecuteScriptAction() {
        // given:                                                             
        ConsoleModel model = artifactManager.newInstance(ConsoleModel.class)
        controller.model = model

        // when:                                                              
        String input = 'var = "Griffon"'
        model.scriptSource = input
        controller.invokeAction('executeScript')

        // then:                                                              
        await().atMost(2, SECONDS)
            .until(fieldIn(model)
            .ofType(Object)
            .andWithName('scriptResult'),
            notNullValue())
        assert input == model.scriptResult
    }

    private static class EchoEvaluator implements Evaluator {                 
        @Override
        Object evaluate(String input) {
            input
        }
    }

    @DependsOn('application')
    private static class TestModule extends AbstractTestingModule {
        @Override
        protected void doConfigure() {
            bind(Evaluator)
                .to(EchoEvaluator)
                .asSingleton()
        }
    }

    @Nonnull
    private List<Module> moduleOverrides() {
        [new TestModule()]
    }
}