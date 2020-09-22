def call (Map config = [:]) {
	sh "${config.command}"
}
