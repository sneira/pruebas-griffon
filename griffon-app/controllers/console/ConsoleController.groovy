package console

import griffon.core.artifact.GriffonController
import griffon.metadata.ArtifactProviderFor

import javax.inject.Inject

@ArtifactProviderFor(GriffonController)
class ConsoleController {
    def model                                                

    @Inject
    Evaluator evaluator                                      

    void executeScript() {                                   
        model.enabled = false
        def result
        try {
            result = evaluator.evaluate(model.scriptSource)  
        } finally {
            model.enabled = true
            model.scriptResult = result                      
        }
    }
}