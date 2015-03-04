package console

import griffon.core.artifact.GriffonModel
import griffon.metadata.ArtifactProviderFor
import griffon.transform.Observable

@ArtifactProviderFor(GriffonModel)
class ConsoleModel {
    String scriptSource                                  
    @Observable Object scriptResult                      
    @Observable boolean enabled = true                   
}