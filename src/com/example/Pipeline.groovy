@Grab('org.yaml:snakeyaml:1.17')
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.DumperOptions
import static org.yaml.snakeyaml.DumperOptions.FlowStyle.BLOCK

package com.example

class Pipeline {
    def script
    def configurationFile

    Pipeline(script, configurationFile) {
        this.script = script
        this.configurationFile = configurationFile
    }

    def execute() {
//    ===================== Your Code Starts Here =====================
//    Note : use "script" to access objects from jenkins pipeline run (WorkflowScript passed from Jenkinsfile)
//           for example: script.node(), script.stage() etc
		datas = readYaml (file: 'config.yml') 
		
		// notifications vars 
		notificationRecipient = datas.notifications.email.recipients.toString()
		notificationOnStart = datas.notifications.email.on_start.toString()
		notificationOnFailure = datas.notifications.email.on_failure.toString()
		notificationOnSuccess = datas.notifications.email.on_success.toString()

		// test vars 
		testFolder = datas.test[0].testFolder.toString()

		performanceTestCommand = datas.test[0].testCommand.toString()
		regressionTestCommand = datas.test[1].testCommand.toString()
		integrationTestCommand = datas.test[2].testCommand.toString()

		// build vars 
		buildCommand = datas.build.buildCommand.toString()
		buildProjectFolder = datas.build.projectFolder.toString()
		
		// Database vars 
		databaseCommand = datas.database.databaseCommand.toString()
		databaseProjectFolder = datas.database.databaseFolder.toString()

		// deploy vars 
		deployProjectFolder = datas.build.projectFolder.toString()
		deployCommand = datas.deploy.deployCommand.toString()
//    ===================== Parse configuration file ==================

//    ===================== Run pipeline stages =======================

//    ===================== End pipeline ==============================
    }
}
