package console

import griffon.core.artifact.GriffonController
import griffon.metadata.ArtifactProviderFor

@ArtifactProviderFor(GriffonController)
class ConsoleController {
    ConsoleModel model

    void click() {
        model.clickCount++
    }
}