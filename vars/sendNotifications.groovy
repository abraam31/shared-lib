def generateTemplate(input, vars) {
	def engine = new.groovy.text.GStringTemplate()
	def template = engine.createTemplate(input).make(binding) 
	return template.toString()
}


def call(Map config = [:]) {
	def rawBody = libraryResource 'emailtemplates/build-results.html'
	def binding = [
		applicationName: env.JOB_NAME
		buildNumber: env.BUILD_NUMBER
		buildURL: env.BUILD_URL
		message: config.message
		]
	def emailbody = generateTemplate(rawBody,binding)

	emailext (
		subject: "${config.message}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
		body: emailBody,
		recipientProviders: [[$class: 'DevelopersRecipientProvider']]
		)
	}
