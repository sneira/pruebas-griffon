package console

import griffon.core.artifact.GriffonView
import griffon.metadata.ArtifactProviderFor

@ArtifactProviderFor(GriffonView)
class ConsoleView {
    def builder                                                              
    def model                                                                

    void initUI() {
        builder.with {
            actions {
                action(executeScriptAction,                                  
                    enabled: bind { model.enabled })
            }

            application(title: application.configuration['application.title'],
                pack: true, locationByPlatform: true, id: 'mainWindow',
                iconImage:   imageIcon('/griffon-icon-48x48.png').image,
                iconImages: [imageIcon('/griffon-icon-48x48.png').image,
                             imageIcon('/griffon-icon-32x32.png').image,
                             imageIcon('/griffon-icon-16x16.png').image]) {
                panel(border: emptyBorder(6)) {
                    borderLayout()

                    scrollPane(constraints: CENTER) {
                        textArea(text: bind(target: model, 'scriptSource'),  
                            enabled: bind { model.enabled },                 
                            columns: 40, rows: 10)
                    }

                    hbox(constraints: SOUTH) {
                        button(executeScriptAction)                          
                        hstrut(5)
                        label('Result:')
                        hstrut(5)
                        textField(editable: false,
                                  text: bind { model.scriptResult })         
                    }
                }
            }
        }
    }
}