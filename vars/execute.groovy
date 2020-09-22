def call (map config) {
	sh ''' ${config.command} '''
}
