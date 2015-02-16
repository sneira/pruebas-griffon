application {
    title = 'console'
    startupGroups = ['console']
    autoShutdown = true
}
mvcGroups {
    // MVC Group for "console"
    'console' {
        model      = 'console.ConsoleModel'
        view       = 'console.ConsoleView'
        controller = 'console.ConsoleController'
    }
}