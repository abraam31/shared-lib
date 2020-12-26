def call(String name, String last) {
    sh "echo Hello world, ${name}"
    sh "echo My roots are ${last}"
}
