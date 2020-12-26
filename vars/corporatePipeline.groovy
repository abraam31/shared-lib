def call(body) {
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    def JenkinsFile = libraryResource 'scripts/Jenkinsfile'
    writeFile file: "Jenkinsfile", text: Jenkinsfile

