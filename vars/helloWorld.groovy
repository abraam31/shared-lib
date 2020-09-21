def call(Map config) {
    sh "echo Hello world, ${config.name}"
  sh "echo My roots are ${config.last}"
}
