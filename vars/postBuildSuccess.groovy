def call(Map Config) {
	archiveArtifacts 'target/*.jar'
	stash(name: "${config.stashName}", includes: 'target/**')
}
